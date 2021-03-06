package fr.training.samples.spring.shop.controller.item;

/**
 * @author bnasslahsen
 */

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ItemController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${spring.shop.api.url}")
	private String apiUrl;

	private static final String ITEMS_URI =  "/api/items";


	@GetMapping("/items")
	public String showItems(Model model) {
		ItemDTO[] response = restTemplate.getForObject(apiUrl + ITEMS_URI, ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(response);
		model.addAttribute("items", items);
		return "items";
	}

}