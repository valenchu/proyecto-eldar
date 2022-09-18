package com.eldar.start.service.validate;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class CardValidate {

	public boolean validateDate(int ano, int mes, int day) {
		try {
			LocalDate rsu = LocalDate.of(ano, mes, day);
			return true;
		} catch (DateTimeException e) {
			return false;
		}

	}

	public  boolean vencimiento(String yearCard, String mothCard){
		LocalDate local = LocalDate.now();
		boolean isValid = false;	
		int mont = local.getMonthValue();
		int year = local.getYear();
		int montClase = Integer.parseInt(mothCard);
		int yearClase = Integer.parseInt(yearCard);
		if(year < yearClase) {
			isValid = true;
		}else if(year == yearClase) {
			if(mont < montClase) {
				isValid = true;
			}else if(mont == montClase) {
				isValid = true;
			}
		}
		return isValid;
	}

}
