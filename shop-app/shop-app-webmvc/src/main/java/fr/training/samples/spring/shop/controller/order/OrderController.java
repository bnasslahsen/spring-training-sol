package fr.training.samples.spring.shop.controller.order;

/**
 * @author bnasslahsen
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.training.samples.spring.shop.controller.item.ItemDTO;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class OrderController {

	@Value("${spring.shop.showItems.url}")
	private String showItemsUrl;

	@Value("${spring.shop.addOrder.url}")
	private String addOrderUrl;

	@Autowired
	private WebClient webClient;

	@GetMapping("/addOrder")
	public String showOrders(Model model) {
		OrderDTO orderDTO = new OrderDTO();
		Set<ItemDTO> itemDTOS = webClient.get()
				.uri("/api/items")
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Set<ItemDTO>>() {})
				.block();

		orderDTO.setItems(itemDTOS);
		orderDTO.setItemIDs(new HashSet<>());
		model.addAttribute("orderModel", orderDTO);
		return "addOrder";
	}

	@PostMapping("/addOrder")
	public String addOrders(@ModelAttribute("orderModel") OrderDTO orderDTO) {
		Set<String> itemIDs = orderDTO.getItemIDs();
		//Set<ItemEntity> itemEntitySet = itemManagement.getAllItems(itemIDs);
		//Set<ItemDTO> itemDTOS = itemMapper.mapToDtoSet(itemEntitySet);
		//orderDTO.setItems(itemDTOS);

		//final OrderEntity orderEntity = orderMapper.mapToEntity(orderDTO);
		//orderManagement.addOrder(orderEntity);
		return "addOrder";
	}

}