package com.flipdeal;

import org.springframework.boot.SpringBootConfiguration;

import com.flipdeal.controller.FlipDealApplication;

@SpringBootConfiguration
public class FlipDealAppApplication {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Please specify the promotion set.");
			return;
		}

		String promotionSet = args[0];

		FlipDealApplication application = new FlipDealApplication();
		application.calculateDiscounts(promotionSet);

	}

}
