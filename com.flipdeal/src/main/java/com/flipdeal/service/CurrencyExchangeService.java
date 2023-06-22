package com.flipdeal.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal.constants.URLConstants;
import com.flipdeal.model.ExchangeRate;

public class CurrencyExchangeService {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private HttpApiCallService httpApiCallService;

	public CurrencyExchangeService() {
		this.httpApiCallService = new HttpApiCallService(URLConstants.EXCHANGE_RATES_API_URL);
	}

	public ExchangeRate retrieveExchangeRates() throws ClientProtocolException, IOException {
		HttpResponse response = httpApiCallService.getResponse();
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity);

		ExchangeRate exchangeRate = objectMapper.readValue(responseString, ExchangeRate.class);
		return exchangeRate;
	}

}
