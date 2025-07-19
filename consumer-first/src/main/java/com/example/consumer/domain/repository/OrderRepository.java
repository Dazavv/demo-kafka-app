package com.example.consumer.domain.repository;

import com.example.consumer.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
