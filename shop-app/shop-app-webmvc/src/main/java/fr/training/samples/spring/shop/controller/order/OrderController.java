package fr.training.samples.spring.shop.controller.order;

/**
 * @author bnasslahsen
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.application.order.OrderManagement;
import fr.training.samples.spring.shop.controller.item.ItemDTO;
import fr.training.samples.spring.shop.controller.item.ItemMapper;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

	/**
	 * orderManagement of type OrderManagement
	 */
	private final OrderManagement orderManagement;

	private final ItemManagement itemManagement;

	/**
	 * orderMapper of type OrderMapper
	 */
	private final OrderMapper orderMapper;

	private final ItemMapper itemMapper;

	public OrderController(OrderManagement orderManagement, ItemManagement itemManagement, OrderMapper orderMapper, ItemMapper itemMapper) {
		this.orderManagement = orderManagement;
		this.itemManagement = itemManagement;
		this.orderMapper = orderMapper;
		this.itemMapper = itemMapper;
	}


	@GetMapping("/addOrder")
	public String showOrders(Model model) {
		OrderDTO orderDTO = new OrderDTO();
		//Remplir les iterms
		List<ItemEntity> itemEntities = itemManagement.getAllItems();
		HashSet itemSet = new HashSet();
		itemSet.addAll(itemEntities);
		orderDTO.setItems(itemMapper.mapToDtoSet(itemSet));
		model.addAttribute("orderModel", orderDTO);
		return "addOrder";
	}

	@PostMapping("/addOrder")
	public String addOrders(@ModelAttribute("orderModel") OrderDTO orderDTO) {
		Set<String> itemIDs = orderDTO.getItemIDs();
		Set<ItemEntity> itemEntitySet = itemManagement.getAllItems(itemIDs);
		Set<ItemDTO> itemDTOS = itemMapper.mapToDtoSet(itemEntitySet);
		orderDTO.setItems(itemDTOS);

		final OrderEntity orderEntity = orderMapper.mapToEntity(orderDTO);
		orderManagement.addOrder(orderEntity);
		return "addOrder";
	}

}