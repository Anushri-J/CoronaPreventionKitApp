package com.wellsfargo.fsd.cpk.entity;



public class Item {

	private Integer icode;
	private String title;
	private String unit;
	private Double price;
	private Integer quantity;
	
	public Item() {
		
	}

	public Item(Integer icode, String title, String unit, Double price) {
		
		super();
		this.icode = icode;
		this.title = title;
		this.unit = unit;
		this.price = price;
		
	}

	public Integer getIcode() {
		return icode;
	}

	public void setIcode(Integer icode) {
		this.icode = icode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [icode=" + icode + ", title=" + title + ",  unit=" + unit + ", Price=" + price + "]";
	}
}
