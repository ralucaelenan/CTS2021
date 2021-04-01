package ro.ase.acs.cts.builder;

import java.util.Date;

public class ProductBuilderV2 {
	private String name;
	private float price;
	private int quantity;
	private Date expireDate;
	private float discount;
	private boolean isVegetarianFriendly;
	private boolean isVeganFriendly;
	
	public ProductBuilderV2() {
		
	}
	
	public ProductBuilderV2 addName(String name) {
		this.name=name;
		return this;
	}
	
	public ProductBuilderV2 addPrice(float price) {
		this.price=price;
		return this;
	}
	
	public ProductBuilderV2 addQuantity(int quantity) {
		this.quantity=quantity;
		return this;
	}
	
	public ProductBuilderV2 addExpireDate(Date expireDate) {
		this.expireDate=expireDate;
		return this;
	}
	
	public ProductBuilderV2 addIsVegetarianFriendly(boolean isVegetarianFriendly) {
		this.isVeganFriendly=isVegetarianFriendly;
		return this;
	}
	
	public ProductBuilderV2 addIsVeganFriendly(boolean isVeganFriendly) {
		this.isVeganFriendly=isVeganFriendly;
		return this;
	}
	
	public Product build() {
		Product product = new Product(name, price, quantity, expireDate, discount, isVegetarianFriendly, isVeganFriendly);
		return product;
	}
}
