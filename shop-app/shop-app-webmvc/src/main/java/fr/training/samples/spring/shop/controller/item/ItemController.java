package fr.training.samples.spring.shop.controller.item;

/**
 * @author bnasslahsen
 */

import java.util.List;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.domain.item.ItemEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

	private ItemManagement itemManagement;
	private final ItemMapper itemMapper;

	public ItemController(ItemManagement itemManagement, ItemMapper itemMapper) {
		this.itemManagement = itemManagement;
		this.itemMapper = itemMapper;
	}

	@GetMapping("/items")
	public String showItems(Model model) {
		List<ItemEntity> itemEntities = itemManagement.getAllItems();
		model.addAttribute("items", itemMapper.mapToDtoList(itemEntities));
		return "items";
	}

}