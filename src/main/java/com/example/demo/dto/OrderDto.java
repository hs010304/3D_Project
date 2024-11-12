package com.example.demo.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class PaymentRequest {
        private String productName;
        private int totalAmount; // 결제 총액
        private List<OrderPageItemRequest> items;

        // getTotalPrice() 메서드 추가 (totalAmount 반환)
        public int getTotalPrice() {
            return totalAmount;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class OrderPageItemRequest {
        private Long productId; // 상품 ID
        private int count; // 주문 수량

        // 상품 ID를 가져오는 메소드
        public Long getProductId() {
            return productId;
        }
    }
}
