package com.eldar.start.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldar.start.dao.CardDao;
import com.eldar.start.dao.dto.CardDto;
import com.eldar.start.dao.dto.CardDtoWithOutId;
import com.eldar.start.dao.dto.ReciveDataCardDto;
import com.eldar.start.entity.CardEntity;
import com.eldar.start.service.CardService;
import com.eldar.start.service.validate.CardValidate;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	CardDao cardDao;
	ModelMapper mapper = new ModelMapper();
	@Autowired
	CardValidate cardValidate;

	@Override
	public List<CardEntity> getAllCards() {
		return (List<CardEntity>) cardDao.findAll();
	}

	@Override
	public CardEntity insertCard(CardDtoWithOutId card) {
		// TODO Auto-generated method stub
		CardEntity carding = mapper.map(card, CardEntity.class);
		return cardDao.save(carding);
	}

	@Override
	public CardDto getTasaCalculated(ReciveDataCardDto cardCalculateTasa) throws RuntimeException {
		boolean validateDate = cardValidate.validateDate(cardCalculateTasa.getAno(), cardCalculateTasa.getMes(), cardCalculateTasa.getDia());
		if(validateDate) {
		CardEntity card = cardDao.findById(cardCalculateTasa.getIdCard()).get();
		if(card != null) {
		boolean validateVencimiento = cardValidate.vencimiento(card.getYear(), card.getMonth());
		if(validateVencimiento) {
			
			return this.calculateTasa(card, cardCalculateTasa.getAno(), cardCalculateTasa.getMes(), cardCalculateTasa.getDia(), cardCalculateTasa.getMontoOperation());
			
		}else {
			throw new RuntimeException("La tarjeta encontrada esta vencida");
		}
		}else {
			throw new RuntimeException("El id pasado no encontro datos");
		}
		}else {
			throw new RuntimeException("Los datos de la fecha para calcular tasa es incorrecta");
		}
	}
	
	
	public CardDto calculateTasa(CardEntity card, int ano, int mes, int dia, BigDecimal montoOperation ) {
		String marca = card.getMarca().toLowerCase();
		String marcaData[] = {"visa","naranja","amex"};
		CardDto result = new CardDto();
		BigDecimal calculoImporteConTasa = new BigDecimal(0);
		BigDecimal tasa ;
		
		//Transform bigdecimal, calculated,  more precise
		String t = String.valueOf(ano%100);
		BigDecimal anoBig = new BigDecimal(t);
		t = String.valueOf(mes);
		BigDecimal mesBig = new BigDecimal(t);
		t = String.valueOf(dia);
		BigDecimal diaBig = new BigDecimal(t);
		
		if(marca.equals(marcaData[0])) {
			
			tasa = anoBig.divide(mesBig).setScale(9);
			tasa = tasa.divide(new BigDecimal(100)).multiply(montoOperation).setScale(9);
			calculoImporteConTasa = tasa.add(montoOperation).setScale(9);
			result.setImporteTasa(calculoImporteConTasa);
			result.setMarca(card.getMarca());
			
		}else if(marca.equals(marcaData[1])) {
			
			tasa = diaBig.multiply(new BigDecimal(0.5));
			tasa = tasa.divide(new BigDecimal(100)).multiply(montoOperation).setScale(9);
			calculoImporteConTasa = tasa.add(montoOperation).setScale(9);
			result.setImporteTasa(calculoImporteConTasa);
			result.setMarca(card.getMarca());
			
		}else if(marca.equals(marcaData[2])) {
			
			tasa = mesBig.multiply(new BigDecimal(0.1));
			tasa = tasa.divide(new BigDecimal(100)).multiply(montoOperation).setScale(9);
			calculoImporteConTasa = tasa.add(montoOperation).setScale(9);
			result.setImporteTasa(calculoImporteConTasa);
			result.setMarca(card.getMarca());
			
		}
		
		
		return result; 
		
	}


}
