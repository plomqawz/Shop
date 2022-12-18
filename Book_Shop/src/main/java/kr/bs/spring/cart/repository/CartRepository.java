package kr.bs.spring.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.bs.spring.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
