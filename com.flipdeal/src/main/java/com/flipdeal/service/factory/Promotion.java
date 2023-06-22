package com.flipdeal.service.factory;

import com.flipdeal.model.ExchangeRate;
import com.flipdeal.model.Product;

public interface Promotion {
	void applyPromotion(Product product, ExchangeRate exchangeRate);
}
