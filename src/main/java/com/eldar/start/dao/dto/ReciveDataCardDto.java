package com.eldar.start.dao.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ReciveDataCardDto {
	
	private Long idCard;
	private BigDecimal montoOperation;
	private Integer dia;
	private Integer mes;
	private Integer ano;
	
	public Long getIdCard() {
		return idCard;
	}
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	public BigDecimal getMontoOperation() {
		return montoOperation;
	}
	public void setMontoOperation(BigDecimal montoOperation) {
		this.montoOperation = montoOperation;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public ReciveDataCardDto(Long idCard, BigDecimal montoOperation, Integer dia, Integer mes, Integer ano) {
		super();
		this.idCard = idCard;
		this.montoOperation = montoOperation;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	public ReciveDataCardDto() {
		super();
	}
	 
	 

}
