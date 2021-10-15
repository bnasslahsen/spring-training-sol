package fr.training.samples.spring.shop.controller.order;

import java.util.List;
import java.util.Set;

import fr.training.samples.spring.shop.controller.item.ItemDTO;

public class OrderModel {

	private String customerID;

	private Set<String> itemIDs;

	private List<ItemDTO> items;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Set<String> getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(Set<String> itemIDs) {
		this.itemIDs = itemIDs;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
