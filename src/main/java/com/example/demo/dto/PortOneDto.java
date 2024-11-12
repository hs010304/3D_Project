package com.example.demo.dto;

import com.example.demo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PortOneDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class KakaoPayResponse {

        private String merchantUid; // 주문 번호
        private String itemName; // 상품 이름
        private int paymentPrice; // 결제 금액
        private String buyerName; // 구매자 이름
        private String buyerEmail; // 구매자 이메일

        public KakaoPayResponse(Order order) {
            this.merchantUid = order.getMerchantUid();
            this.itemName = "상품명"; // 예시로 "상품명"
            this.paymentPrice = order.getTotalPrice();
            this.buyerName = order.getMember().getUsername(); // 회원 이름
            this.buyerEmail = order.getMember().getEmail(); // 회원 이메일
        }
    }
}
