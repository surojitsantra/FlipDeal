package com.flipdeal.service.factory;

import com.flipdeal.model.Discount;
import com.flipdeal.model.DiscountType;
import com.flipdeal.model.Product;
import com.flipdeal.utils.dicountrule.DiscountCategoryA;
import com.flipdeal.utils.dicountrule.DiscountCategoryB;

public abstract class DiscountFactory {

	public static Discount getDiscount(Product product, DiscountType promotionType) {
		if (promotionType == DiscountType.PROMOTION_SET_A) {
			return new DiscountCategoryA(product).getDiscount();
		} else if (promotionType == DiscountType.PROMOTION_SET_B) {
			return new DiscountCategoryB(product).getDiscount();
		}
		return new Discount(0, "");
	}

}
