package com.flipdeal.model;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private String category;
    private int inventory;
    private double rating;
    private String currency;
    private double price;
    private String origin;
    private String product;
    private JsonNode discount;
    private String arrival;

}
