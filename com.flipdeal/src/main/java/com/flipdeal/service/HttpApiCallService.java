package com.flipdeal.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpApiCallService {
	
	private final String URL;

	public HttpApiCallService(final String URL) {
		this.URL = URL;
	}

	public HttpResponse getResponse() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		HttpResponse response = httpClient.execute(request);
		
		return response;
	}

}
