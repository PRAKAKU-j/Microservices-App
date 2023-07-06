package com.nit.repositry;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.StockPrice;

public interface StockPriceRepositry extends JpaRepository<StockPrice, Serializable> {
	
	public StockPrice findByCompanyName(String companyName);

}
