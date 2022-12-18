package kr.bs.spring.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.bs.spring.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
