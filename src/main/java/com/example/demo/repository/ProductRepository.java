package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 상품 이름으로 상품을 찾는 메서드 (예시)
    Optional<Product> findByName(String name);

    List<Product> findByCategory(Product.Category category);
    
    // 상품 이름이 존재하는지 확인하는 메서드
    boolean existsByName(String name);
}
