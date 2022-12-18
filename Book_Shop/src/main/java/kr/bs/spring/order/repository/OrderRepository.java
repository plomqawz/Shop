package kr.bs.spring.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.bs.spring.order.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
