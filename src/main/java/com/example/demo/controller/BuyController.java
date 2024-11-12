package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.PortOneDto;
import com.example.demo.dto.PortOneDto.KakaoPayResponse;
import com.example.demo.service.OrderService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BuyController {

    private final OrderService orderService;

    @PostMapping("/payment/first")
    public PortOneDto.KakaoPayResponse firstPayment(
            @RequestBody OrderDto.PaymentRequest request, HttpSession session) {
        
        // 세션에서 memberId를 가져옴
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            throw new IllegalArgumentException("로그인된 사용자가 아닙니다.");
        }

        // OrderService에 memberId와 결제 요청 정보 전달
        return orderService.firstPayment(memberId, request);
    }
}
