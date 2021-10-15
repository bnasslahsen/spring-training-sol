package fr.training.samples.spring.shop.controller.order;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import fr.training.samples.spring.shop.controller.item.ItemDTO;

/**
 * @author Badr NASS
 *
 */
class OrderDTO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;

    /**
     * orderID of type String
     */
    private String orderID;

    /**
     * customerID of type String
     */
    private String customerID;

    /**
	 * items of type Set of ItemDTO
	 */
	private Set<String> itemIDs;

	/**
	 * items of type Set of ItemDTO
	 */
	private Set<ItemDTO> items;
    /**
     * 
     */
    public OrderDTO() {
    }

    /**
     * @param orderID
     * @param customerID
     */
    public OrderDTO(final String orderID, final String customerID) {
        this.orderID = orderID;
        this.customerID = customerID;
		itemIDs = new HashSet<>();
    }



    /**
     * @return
     */
    public String getCustomerID() {
        return customerID;
    }



    /**
     * @return
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param customerID
     */
    public void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }

	public Set<String> getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(Set<String> itemIDs) {
		this.itemIDs = itemIDs;
	}

	/**
     * @param orderID
     */
    public void setOrderID(final String orderID) {
        this.orderID = orderID;
    }

	public Set<ItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<ItemDTO> items) {
		this.items = items;
	}

	/*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("OrderDTO [orderID=");
        builder.append(orderID);
        builder.append(", customerID=");
        builder.append(customerID);
        builder.append(", items=");
        builder.append(itemIDs);
        builder.append("]");
        return builder.toString();
    }

}
