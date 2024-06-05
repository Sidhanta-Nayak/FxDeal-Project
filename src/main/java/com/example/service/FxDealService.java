package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.FxDeal;
import com.example.repository.FxDealRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FxDealService {

	@Autowired
	private FxDealRepository dealRepository;
	
	public FxDeal saveDeal(FxDeal deal) {
		log.info("Entry :: saveDeal() ::: FxDealService.java");
        Optional<FxDeal> existingDeal = dealRepository.findById(deal.getDealId());
        if (existingDeal.isPresent()) {
        	log.info("Deal with this ID already exists :: ", deal.getDealId());
            throw new IllegalArgumentException("Deal with this ID already exists");
        }
        log.info("Exit :: saveDeal() ::: FxDealService.java");
        return dealRepository.save(deal);
    }
}
