package com.example.demo.repository;

import com.example.demo.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
    // 추가적인 쿼리 메서드가 필요하다면 정의 가능
}
