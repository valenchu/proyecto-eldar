package com.eldar.start.service;

import java.math.BigDecimal;
import java.util.List;

import com.eldar.start.dao.dto.CardDto;
import com.eldar.start.dao.dto.CardDtoWithOutId;
import com.eldar.start.dao.dto.ReciveDataCardDto;
import com.eldar.start.entity.CardEntity;

public interface CardService {
	
	public List<CardEntity> getAllCards();
	
	public CardEntity insertCard(CardDtoWithOutId card);
	
	public CardDto getTasaCalculated(ReciveDataCardDto cardCalculateTasa);

}
