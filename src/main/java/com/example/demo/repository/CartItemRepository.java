package com.example.demo.repository;

import com.example.demo.entity.CartItem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findById(Long id);
}
