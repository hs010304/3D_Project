package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ProductRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.example.demo.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private CartItemRepository cartItemRepository;

    // 장바구니에 상품 추가
    public void addToCart(Long memberId, Long productId, int quantity) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        // 재고 확인
        if (product.getStock() < quantity) {
            throw new RuntimeException("재고가 부족합니다.");
        }

        Cart cart = member.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setMember(member);
        }

        Optional<CartItem> existingCartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            if (cartItem.getQuantity() + quantity > product.getStock()) {
                throw new RuntimeException("재고가 부족합니다.");
            }
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.getItems().add(cartItem);
        }

        cartRepository.save(cart);
    }

    // 장바구니에서 상품 제거
    public void removeFromCart(Long memberId, Long cartItemId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Cart cart = member.getCart();

        if (cart != null) {
            cart.getItems().removeIf(item -> item.getId().equals(cartItemId));
            cartRepository.save(cart);
        }
    }

    // 장바구니 조회
    public Cart getCart(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        return member.getCart();
    }

    // 장바구니에서 수량 변경
    public void updateCartItemQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        if (quantity <= 0) {
            throw new RuntimeException("수량은 1 이상이어야 합니다.");
        }

        Product product = cartItem.getProduct();

        if (product.getStock() < quantity) {
            throw new RuntimeException("재고가 부족합니다.");
        }

        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    // 상품 결제 처리
    public RedirectView checkoutItem(Long memberId, Long cartItemId) throws Exception {
        // 회원 및 장바구니 확인
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Cart cart = member.getCart();
        if (cart == null) {
            throw new RuntimeException("장바구니가 비어 있습니다.");
        }

        // 장바구니 아이템 확인
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        Product product = cartItem.getProduct();

        // 재고 확인
        if (product.getStock() < cartItem.getQuantity()) {
            throw new RuntimeException("재고가 부족합니다.");
        }

        // 결제 처리 (카카오페이 API 호출)
        String redirectUrl = processPayment(cartItem);

        // 결제 후 주문 생성
        createOrder(cartItem);

        // 결제한 아이템 장바구니에서 제거
        cart.getItems().remove(cartItem);
        cartRepository.save(cart);

        // 재고 업데이트
        product.setStock(product.getStock() - cartItem.getQuantity());
        productRepository.save(product);

        // 결제 페이지로 리다이렉트
        return new RedirectView(redirectUrl);
    }

    // 결제 처리 (카카오페이 결제 준비)
    private String processPayment(CartItem cartItem) {
        // 상품 정보
        String productName = cartItem.getProduct().getName();
        int amount = cartItem.getProduct().getPrice() * cartItem.getQuantity(); // 결제 금액

        // 카카오페이 결제 준비를 위한 파라미터
        String merchantUid = "merchant-" + UUID.randomUUID().toString(); // 가맹점 주문 번호
        String itemName = productName; // 상품 이름

        // 카카오페이 결제 요청을 위한 파라미터
        Map<String, Object> params = new HashMap<>();
        params.put("cid", "TC0ONETIME"); // 카카오페이 가맹점 코드 (테스트용)
        params.put("partner_order_id", merchantUid); // 가맹점 주문 번호
        params.put("partner_user_id", "testuser"); // 사용자 ID
        params.put("item_name", itemName); // 상품 이름
        params.put("quantity", cartItem.getQuantity()); // 상품 수량
        params.put("total_amount", amount); // 총 결제 금액
        params.put("tax_free_amount", 0); // 면세 금액 (없으면 0)
        params.put("approval_url", "http://yourdomain.com/payment/success"); // 결제 성공 시 리다이렉트 URL
        params.put("fail_url", "http://yourdomain.com/payment/fail"); // 결제 실패 시 리다이렉트 URL
        params.put("cancel_url", "http://yourdomain.com/payment/cancel"); // 결제 취소 시 리다이렉트 URL

        // 카카오페이 API 호출
        String apiUrl = "https://kapi.kakao.com/v1/payment/ready"; // 카카오페이 결제 준비 API URL
        String accessToken = "YOUR_KAKAO_ACCESS_TOKEN"; // 카카오 API 액세스 토큰

        // HTTP 요청 보내기 (POST 방식)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken); // Authorization 헤더에 액세스 토큰 추가
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class).getBody();

        // 결제 준비 응답 처리
        String redirectUrl = parseRedirectUrl(response);
        return redirectUrl;
    }

    // 결제 응답에서 리다이렉트 URL 파싱
    private String parseRedirectUrl(String responseBody) {
        // JSON 파싱 (예시로, JSON에서 URL을 추출하는 방법을 설명)
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        return jsonResponse.get("next_redirect_pc_url").getAsString(); // 결제 페이지 URL
    }

    // 결제 후 주문 생성
    private void createOrder(CartItem cartItem) {
        // 주문 생성 로직 구현
        System.out.println("주문 생성: " + cartItem.getProduct().getName());
    }
}
