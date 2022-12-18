package kr.bs.spring.item.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.bs.spring.item.dto.ItemFormDto;
import kr.bs.spring.item.service.ItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService;

	@GetMapping("/admin/item/new")
	public String itemForm(Model model) {
		model.addAttribute("itemFormDto", new ItemFormDto());
		return "/item/itemForm";
	}
	
	@PostMapping("/admin/item/new")
	public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
			Model model, @RequestParam("itemImgFile")List<MultipartFile> itemImgFileList) {
		
		if (bindingResult.hasErrors()) {
			return "item/itemForm";
		}
		
		if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
			model.addAttribute("errorMessage", "첫번째 상품이미지는 필수입니다.");
			return "item/itemForm";
		}
		
		try {
			itemService.saveItem(itemFormDto, itemImgFileList);
		} catch (IOException e) {
			model.addAttribute("errorMessage", "상품 등록 중 오류발생");
			return "item/itemForm";
		}
		
		return "redirect:/";
	}
}
