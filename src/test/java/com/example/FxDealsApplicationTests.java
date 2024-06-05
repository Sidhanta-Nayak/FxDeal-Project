package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.FxDeal;
import com.example.service.FxDealService;

@SpringBootTest
class FxDealsApplicationTests {
	
	@Autowired
	private FxDealService service;
	

	@Test
	void contextLoads() {
	}

	 @Test
	    void testSaveDeal() {
	        FxDeal deal = new FxDeal();
	        deal.setDealId("123");
	        deal.setFromCurrency("USD");
	        deal.setToCurrency("EUR");
	        deal.setDealTimestamp(LocalDateTime.now());
	        deal.setDealAmount(1000);

	        service.saveDeal(deal);
	        
	        assertThrows(IllegalArgumentException.class, () -> service.saveDeal(deal));
	 }
	 
}
