package fr.training.samples.spring.shop.controller.order;

/**
 * @author bnasslahsen
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.training.samples.spring.shop.controller.item.ItemDTO;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OrderController {

	@Autowired
	private WebClient webClient;

	@GetMapping("/addOrder")
	public ModelAndView showAddOrder(@ModelAttribute("orderModel") OrderModel orderModel) {
		List<ItemDTO> items = webClient.get()
				.uri("/api/items")
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<ItemDTO>>() {})
				.block();

		orderModel.setItems(items);
		return new ModelAndView("addOrder", "orderModel", orderModel);
	}

	@PostMapping("/addOrder")
	public ModelAndView addOrders(@ModelAttribute("orderModel") OrderModel orderModel,  BindingResult bindingResult) {
		Set<String> itemIDs = orderModel.getItemIDs();

		if (itemIDs == null || itemIDs.isEmpty()) {
			bindingResult.rejectValue("itemIDs", null, "no items selected!");
		}
		if (StringUtils.isBlank(orderModel.getCustomerID())) {
			bindingResult.rejectValue("customerID", null, "no customerID has been set!");
		}

		if (bindingResult.hasErrors()) {
			return showAddOrder(orderModel);
		}

		OrderLightDTO orderLightDTO = new OrderLightDTO(orderModel.getCustomerID());
		HashSet<String> itemIdSet = new HashSet<>();
		itemIDs.forEach(i -> itemIdSet.add(i));
		orderLightDTO.setItems(itemIdSet);

		webClient.post()
				.uri("/api/orders")
				.body(BodyInserters.fromValue(orderLightDTO))
				.retrieve()
				.bodyToMono(String.class)
				.block();

		return new ModelAndView(new RedirectView("addOrder"));
	}

}