package ro.ase.acs.cts.main;

import ro.ase.acs.cts.builder.ProductDirector;
import ro.ase.acs.cts.builder.Product;
import ro.ase.acs.cts.builder.ProductBuilderV2;

public class Main {
	
	public static void main(String[] args) {
//		Product product = new Product("Milk", 5, 500, null, 0, true, false);
//		Product product2 = new Product("Chocolate", 7);
//		product2.setExpireDate(new Date());
//		//...
//		product2.setQuantity(10);
		
		Product product3 = new Product.ProductBuilder()
				.addName("Milk")
				.addPrice(5)
				.addQuantity(500)
				.addIsVeganFriendly(true)
				.build();
		
		ProductBuilderV2 productBuilder = new ProductBuilderV2();
		productBuilder.addName("Chocolate");
		productBuilder.addPrice(7);
		Product product4 = productBuilder.build();
		
		System.out.println(product3);
		System.out.println(product4);
		
		ProductDirector director = new ProductDirector();
		Product product5 = director.createVeganChocolate(10);
		System.out.println(product5);
	}

}