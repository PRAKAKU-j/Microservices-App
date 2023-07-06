package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.StockPrice;
import com.nit.exception.CompanyNotFoundException;
import com.nit.repositry.StockPriceRepositry;

@Service
public class StockPriceServiceimpl implements StockPriceService {

	@Autowired
	private StockPriceRepositry stockPriceRepo;
	
	@Override
	public Double getStockPrice(String companyName) {
		
	 StockPrice  stockPrice = stockPriceRepo.findByCompanyName(companyName);
	 
	 if(stockPrice==null) {
		 throw new CompanyNotFoundException("Company Not Avalable");
	 }
		return stockPrice.getCompanyPrice();
	}

}
