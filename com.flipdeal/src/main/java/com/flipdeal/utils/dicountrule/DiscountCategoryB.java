package com.flipdeal.utils.dicountrule;

import com.flipdeal.model.Discount;
import com.flipdeal.model.Product;

public class DiscountCategoryB implements DiscountCategory {

	private Product product;

	public DiscountCategoryB(Product product) {
		this.product = product;
	}

	@Override
	public Discount getDiscount() {

		double discountAmount = 0;
		String discountTag = "";

		// Rule 1
		if (product.getInventory() > 20) {
			double currDiscountAmount = product.getPrice() * 0.12;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get 12% off";
			}
		}

		// Rule 2
		if ("new".equalsIgnoreCase(product.getArrival())) {
			double currDiscountAmount = product.getPrice() * 0.07;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get 7% off";
			}
		}

		// Default discount
		if (discountAmount == 0 && product.getPrice() > 1000) {
			discountAmount = product.getPrice() * 0.02;
			discountTag = "get 2% off";
		}

		return new Discount(discountAmount, discountTag);
	}

}
