package com.calculadora.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public BigDecimal ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) {
		
		return new BigDecimal(-1);
	
	}

}
