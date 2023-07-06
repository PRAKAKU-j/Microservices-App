package com.nit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUIService {

	public String getTotalStockPrice(String companyName,Integer quantity) {
		String END_POINTURL="http://localhost:2222/calculate/{companyName}/{quantity}";
		
		WebClient webClient = WebClient.create();
		String response = webClient.get().uri(END_POINTURL,companyName,quantity)
													 .retrieve()
													 .bodyToMono(String.class)
													 .block();
		
		return response;
		
	}
}
