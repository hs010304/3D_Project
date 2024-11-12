package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product; // 상품

    private int quantity; // 수량

    public double getPrice() {
        return product.getPrice(); // Product 엔티티에서 가격을 가져온다고 가정
    }

    // 수량을 증가시키는 메소드
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
}
