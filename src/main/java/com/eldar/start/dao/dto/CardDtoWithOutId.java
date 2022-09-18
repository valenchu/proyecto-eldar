package com.eldar.start.dao.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDtoWithOutId {
	
	private String marca;
	private String number;
	private String name;
	private String lastName;
	private String month;
	private String year;
	private BigDecimal importeCard;

}
