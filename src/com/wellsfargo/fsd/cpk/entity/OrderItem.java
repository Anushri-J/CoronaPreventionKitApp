package com.wellsfargo.fsd.cpk.entity;

public class OrderItem {
	private Item item;
	private int quantity;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
