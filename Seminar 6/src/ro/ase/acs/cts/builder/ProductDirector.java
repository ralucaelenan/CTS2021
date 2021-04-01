package ro.ase.acs.cts.builder;

public class ProductDirector {
	private ProductBuilderV2 productBuilder = new ProductBuilderV2();
	
	public ProductDirector() {
		
	}
	
	public Product createVeganChocolate(float price) {
		return productBuilder
		.addName("Chocolate")
		.addPrice(price)
		.addQuantity(5)
		.addIsVeganFriendly(true)
		.build();
	}
	
	//...
}
