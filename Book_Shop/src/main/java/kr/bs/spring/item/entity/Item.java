package kr.bs.spring.item.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import kr.bs.spring.item.constant.ItemSellStatus;
import kr.bs.spring.utils.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id; 		// 상품 코드
	
	@Column(nullable = false, length = 50)
	private String itemNm; 	// 상품명
	
	@Column(nullable = false)
	private int price; 		// 상품가격
	
	@Column(nullable = false, name = "stock")
	private int stockNumber;// 재고수량
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus; //상품 판매 상태
	
	@Lob
	@Column(nullable = false)
	private String itemDetail; 		// 상품 상세설명
	
}
