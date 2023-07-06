package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.client.StockPriceClient;

@RestController
public class StockCalculationRestController {
	
	@Autowired
	private StockPriceClient stockPriceClient;

	@GetMapping(value = "/calculate/{companyName}/{quantity}")
	public ResponseEntity<String> calculate(@PathVariable("companyName") String companyName,@PathVariable("quantity") Integer quantity){
		
		Double totalPrice=null;
		
		ResponseEntity<Double> resEntity = stockPriceClient.getStockPrice(companyName);
		 int statusCode = resEntity.getStatusCode().value();
		if(statusCode==200) {
			Double companyStockPrice = resEntity.getBody();
			totalPrice=quantity*companyStockPrice;
			String response="Total Price:::"+ totalPrice;
			return new ResponseEntity<String>( response,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Company Name Not Found ",HttpStatus.BAD_REQUEST);
		
	}
}
