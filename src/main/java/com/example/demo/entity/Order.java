package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.example.demo.dto.OrderDto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 회원 정보

    private int totalPrice; // 결제 금액
    private PaymentStatus status; // 결제 상태

    private String merchantUid; // 주문 고유 번호
    private String impUid; // 결제 고유 번호 (이니시스에서 제공)

    // 주문 생성 시 호출되는 생성자
    public Order(Member member, OrderDto.PaymentRequest request) {
        this.member = member;
        this.totalPrice = request.getTotalPrice();
        this.status = PaymentStatus.PAYMENT_READY;
        this.merchantUid = UUID.randomUUID().toString(); // 랜덤 주문 번호 생성
    }

    // 결제 성공 후 업데이트
    public void updateBySuccess(String impUid) {
        this.status = PaymentStatus.PAYMENT_DONE;
        this.impUid = impUid;
    }
}
