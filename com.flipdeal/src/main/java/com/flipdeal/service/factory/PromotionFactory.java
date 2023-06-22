package com.flipdeal.service.factory;

import com.flipdeal.service.PromotionTypeA;
import com.flipdeal.service.PromotionTypeB;

public abstract class PromotionFactory {

	public static Promotion getPromotionType(String promotionSet) {
		if (promotionSet.equalsIgnoreCase("promotionSetA")) {
            return new PromotionTypeA();
        }

		if (promotionSet.equalsIgnoreCase("promotionSetB")) {
			return new PromotionTypeB();
        }

		System.out.println("Invalid promotion set specified.");
		return null;
	}

}
