package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private HttpSession session;

    // 장바구니에 상품 추가
    @PostMapping("/add") 
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        
        cartService.addToCart(memberId, productId, quantity);
        
        return "redirect:/shoptest"; // 상품 리스트로 리다이렉트
    }

    // 장바구니 조회
    @GetMapping("/view") // /cart/view로 요청
    public String viewCart(Model model) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        
        Cart cart = cartService.getCart(memberId);
        model.addAttribute("cart", cart);
        
        return "carttest"; // templates/carttest.html로 리턴
    }

    // 장바구니에서 상품 제거
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long cartItemId) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new RuntimeException("로그인이 필요합니다."); // 로그인 필요 에러
        }
        cartService.removeFromCart(memberId, cartItemId);
        
        return "redirect:/cart/view"; // 장바구니 페이지로 리다이렉트
    }

    // 장바구니에서 수량 변경
    @PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam Long cartItemId, @RequestParam int quantity) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new RuntimeException("로그인이 필요합니다."); // 로그인 필요 에러
        }

        cartService.updateCartItemQuantity(cartItemId, quantity);
        return "redirect:/cart/view"; // 장바구니 페이지로 리다이렉트
    }

    // 상품 결제 처리 (결제하기 버튼 클릭 시)
    @PostMapping("/checkoutItem")
    public String checkoutItem(@RequestParam Long cartItemId) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }

        try {
            // 결제 처리 로직 실행 (예: 결제 완료 처리)
            cartService.checkoutItem(memberId, cartItemId);

            // 장바구니에서 상품 제거
            cartService.removeFromCart(memberId, cartItemId);  // 결제 후 장바구니에서 해당 상품을 제거

            // 결제 페이지로 리다이렉트
            return "redirect:/payment/{orderUid}";
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 에러 페이지로 리다이렉트
            return "error";
        
        }
    }
    // 장바구니에서 상품 업데이트
    @PostMapping("/cart/update")
    public String updateCartItem(@RequestParam Long cartItemId, @RequestParam int quantity) {
        cartService.updateCartItemQuantity(cartItemId, quantity);
        return "redirect:/cart/view"; // 장바구니 페이지로 리다이렉트
    }
}
