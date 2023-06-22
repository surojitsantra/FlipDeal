package com.flipdeal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipdeal.model.Discount;
import com.flipdeal.model.DiscountType;
import com.flipdeal.model.ExchangeRate;
import com.flipdeal.model.Product;
import com.flipdeal.service.factory.DiscountFactory;
import com.flipdeal.service.factory.Promotion;

public class PromotionTypeA implements Promotion {
	@Override
	public void applyPromotion(Product product, ExchangeRate exchangeRate) {
		if (!product.getCurrency().equalsIgnoreCase("INR")) {
			double priceInINR = product.getPrice() * exchangeRate.getRates().getOrDefault(product.getCurrency(), 1.0);
			product.setPrice(priceInINR);
			product.setCurrency("INR");
		}
		
		Discount discount = DiscountFactory.getDiscount(product, DiscountType.PROMOTION_SET_A);
		
		ObjectNode discountNode = new ObjectMapper().createObjectNode();
		discountNode.put("amount", discount.getDiscountAmount());
		discountNode.put("discountTag", discount.getDiscountTag());
		product.setDiscount(discountNode);

	}

}
