package com.eldar.start.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eldar.start.dao.dto.CardDto;
import com.eldar.start.dao.dto.CardDtoWithOutId;
import com.eldar.start.dao.dto.ReciveDataCardDto;
import com.eldar.start.entity.CardEntity;
import com.eldar.start.service.CardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@CrossOrigin("*")
@RequestMapping("card")
public class CardController {
	@Autowired
	CardService cardService;
	
	@GetMapping("/getAllCards")
	public ResponseEntity<?> getCards(){
		List<CardEntity> card = cardService.getAllCards();
		return new ResponseEntity<>(card, HttpStatus.OK);
	}
	
	@PostMapping("insertCard")
	public ResponseEntity<?> insertCard(@RequestBody CardDtoWithOutId card){
		if(card != null){
			cardService.insertCard(card);
			return new ResponseEntity<>(card, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(card, HttpStatus.BAD_REQUEST);
			}
	}
	
	@Operation(summary = "Calcula la tasa de la tarjeta en base a la fecha pasada y devuelve el valor con la tasa puesta sobre el, junto con la marca")
	@PostMapping("calculateTasa")
	public ResponseEntity<?> calculateTasa( @RequestBody ReciveDataCardDto cardForCalculate) throws Exception{
		try {
		CardDto card =cardService.getTasaCalculated(cardForCalculate);
			return new ResponseEntity<>(card, HttpStatus.OK);
		}catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
