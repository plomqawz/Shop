package kr.bs.spring.item.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import kr.bs.spring.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	private Long id; // 상품 코드

	@NotBlank(message = "상품명은 필수항목입니다.")
	private String itemNm; // 상품명

	@NotNull(message = "가격은 필수항목입니다.")
	private int price; // 상품가격

	@NotNull(message = "재고는 필수항목입니다.")	
	private int stockNumber;// 재고수량

	private String itemDetail; // 상품 상세설명

	@NotBlank(message = "상품설명은 필수항목입니다.")
	private String itemSellStatus; // 상품 판매 상태

	private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
	
	private List<Long> itemImgIds = new ArrayList<>();
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	
	public static ItemFormDto of(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}
}
