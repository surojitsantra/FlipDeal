package com.flipdeal.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal.model.Product;

public class FileSaveInFolder implements FileSave {

	@Override
	public boolean saveFile(List<Product> products, String outputFilePath) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
        	File outputFile = new File(outputFilePath);
			objectMapper.writeValue(outputFile, products);
		} catch (IOException e) {
			System.out.println("Failed to save file - " +e.getMessage());
			return false;
		}
		return true;
	}


}
