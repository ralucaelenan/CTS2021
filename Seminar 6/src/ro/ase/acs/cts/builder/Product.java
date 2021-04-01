package ro.ase.acs.cts.builder;

import java.util.Date;

public class Product {
	private String name;
	private float price;
	private int quantity;
	private Date expireDate;
	private float discount;
	private boolean isVegetarianFriendly;
	private boolean isVeganFriendly;
	
	Product(String name, float price, int quantity, Date expireDate, 
			float discount, boolean isVegetarianFriendly, boolean isVeganFriendly) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expireDate = expireDate;
		this.discount = discount;
		this.isVegetarianFriendly = isVegetarianFriendly;
		this.isVeganFriendly = isVeganFriendly;
	}
	
	private Product(String name, float price) {
		this.name=name;
		this.price=price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public float getDiscount() {
		return discount;
	}

	public boolean isVegetarianFriendly() {
		return isVegetarianFriendly;
	}

	public boolean isVeganFriendly() {
		return isVeganFriendly;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public void setExpireDate(Date expireDate) {
//		this.expireDate = expireDate;
//	}
//
//	public void setDiscount(float discount) {
//		this.discount = discount;
//	}
//
//	public void setVegetarianFriendly(boolean isVegetarianFriendly) {
//		this.isVegetarianFriendly = isVegetarianFriendly;
//	}
//
//	public void setVeganFriendly(boolean isVeganFriendly) {
//		this.isVeganFriendly = isVeganFriendly;
//	}
	
	public static class ProductBuilder{
		private Product product;
		public ProductBuilder() {
			product = new Product(null,0);
		}
		
		public ProductBuilder addName(String name) {
			product.name=name;
			return this;
		}
		
		public ProductBuilder addPrice(float price) {
			product.price=price;
			return this;
		}
		
		public ProductBuilder addQuantity(int quantity) {
			product.quantity=quantity;
			return this;
		}
		
		public ProductBuilder addExpireDate(Date expireDate) {
			product.expireDate=expireDate;
			return this;
		}
		
		public ProductBuilder addIsVegetarianFriendly(boolean isVegetarianFriendly) {
			product.isVeganFriendly=isVegetarianFriendly;
			return this;
		}
		
		public ProductBuilder addIsVeganFriendly(boolean isVeganFriendly) {
			product.isVeganFriendly=isVeganFriendly;
			return this;
		}

		public Product build() {
			return product;
		}
	}

}
