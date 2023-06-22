package com.flipdeal.controller;

import java.util.List;

import com.flipdeal.constants.URLConstants;
import com.flipdeal.model.ExchangeRate;
import com.flipdeal.model.Product;
import com.flipdeal.service.CurrencyExchangeService;
import com.flipdeal.service.FileSave;
import com.flipdeal.service.FileSaveInFolder;
import com.flipdeal.service.ProductService;
import com.flipdeal.service.factory.Promotion;
import com.flipdeal.service.factory.PromotionFactory;

public class FlipDealApplication {
	private Promotion promotionService;
	private ProductService productService;
	private CurrencyExchangeService currencyExchangeService;
	private FileSave fileSaveService;
	
	public FlipDealApplication() {
		this.productService = new ProductService();
		this.currencyExchangeService = new CurrencyExchangeService();
		this.fileSaveService = new FileSaveInFolder();
	}

	public void calculateDiscounts(String promotionSet) {
		promotionService = PromotionFactory.getPromotionType(promotionSet);
		if(promotionService == null) return;
		
		try {
			List<Product> products = productService.retrieveProductDetails();
			ExchangeRate exchangeRate = currencyExchangeService.retrieveExchangeRates();
			
			for (Product product : products) {
				promotionService.applyPromotion(product, exchangeRate);
	        }
			
			boolean saveFile = fileSaveService.saveFile(products, URLConstants.OUTPUT_FILE_PATH);
			
			if(saveFile) {
				System.out.println("Successfully saved the file");
			} else {
				System.out.println("Saving file is failed");
			}
			
		} catch (Exception e) {
			System.out.println("An error occurred while running Promotion: " + e.getMessage());
		}
		
	}
}
