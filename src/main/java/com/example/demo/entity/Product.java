package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함한 생성자 추가
@Builder // 빌더 추가
public class Product {

    public enum Category {  // Category enum 정의
        OUTER,
        TOP,
        PANTS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 상품번호

    private String name;  // 상품이름
    private int price;    // 가격
    private int stock;    // 재고
    private String description;  // 설명
    private String imageFile;  // 이미지 링크
    private String size;   // 사이즈 추가

    @Enumerated(EnumType.STRING)
    private Category category;  // 카테고리
}

