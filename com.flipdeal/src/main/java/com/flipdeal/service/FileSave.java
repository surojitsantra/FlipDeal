package com.flipdeal.service;

import java.util.List;

import com.flipdeal.model.Product;

public interface FileSave {
	
	boolean saveFile(List<Product> products, String outputFilePath);

}
