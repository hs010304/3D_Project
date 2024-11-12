package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.PortOneDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public PortOneDto.KakaoPayResponse firstPayment(Long memberId, OrderDto.PaymentRequest request) {

        // 회원 정보 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다"));

        // 주문 생성
        Order order = new Order(member, request);
        orderRepository.save(order);

        // 주문 상세 정보 저장
        for (OrderDto.OrderPageItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다"));
            OrderDetail orderDetail = new OrderDetail(order, product, itemRequest.getCount());
            orderDetailRepository.save(orderDetail);
        }

        // 결제 관련 DTO 생성
        return new PortOneDto.KakaoPayResponse(order);
    }
}
