package com.flipdeal.utils.dicountrule;

import com.flipdeal.model.Discount;
import com.flipdeal.model.Product;

public class DiscountCategoryA implements DiscountCategory {

	private Product product;

	public DiscountCategoryA(Product product) {
		this.product = product;
	}

	@Override
	public Discount getDiscount() {

		double discountAmount = 0;
		String discountTag = "";

		// Rule 1
		if (product.getOrigin().equalsIgnoreCase("Africa")) {
			double currDiscountAmount = product.getPrice() * 0.07;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get 7% off";
			}
		}

		// Rule 2
		if (product.getRating() == 2) {
			double currDiscountAmount = product.getPrice() * 0.04;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get 4% off";
			}
		} else if (product.getRating() < 2) {
			double currDiscountAmount = product.getPrice() * 0.08;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get 8% off";
			}
		}

		// Rule 3
		if (("electronics".equalsIgnoreCase(product.getCategory())
				|| "furnishing".equalsIgnoreCase(product.getCategory())) && product.getPrice() >= 500) {
			double currDiscountAmount = 100;
			if (currDiscountAmount > discountAmount) {
				discountAmount = currDiscountAmount;
				discountTag = "get Rs 100 off";
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
