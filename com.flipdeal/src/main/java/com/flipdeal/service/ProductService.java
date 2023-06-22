package com.flipdeal.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal.constants.URLConstants;
import com.flipdeal.model.Product;

public class ProductService {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	private HttpApiCallService httpApiCallService;
	
	public ProductService() {
		this.httpApiCallService = new HttpApiCallService(URLConstants.PRODUCTS_API_URL);
	}

	public List<Product> retrieveProductDetails() throws ClientProtocolException, IOException {
		HttpResponse response = httpApiCallService.getResponse();
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);
        
        return objectMapper.readValue(responseString, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
		
	}

}
