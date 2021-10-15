package fr.training.samples.spring.shop.controller.order;

/**
 * @author bnasslahsen
 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import fr.training.samples.spring.shop.controller.item.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderController {


	@Autowired
	private RestTemplate restTemplate;

	@Value("${spring.shop.showItems.url}")
	private String showItemsUrl;

	@Value("${spring.shop.addOrder.url}")
	private String addOrderUrl;


	@GetMapping("/addOrder")
	public String showOrders(Model model) {
		OrderDTO orderDTO = new OrderDTO();
		ItemDTO[] itemDTOS = restTemplate.getForObject(showItemsUrl, ItemDTO[].class);
		orderDTO.setItems( Arrays.stream(itemDTOS).collect(Collectors.toSet()));
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