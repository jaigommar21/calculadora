package com.calculadora.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public BigDecimal ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) throws Exception {
		
		BigDecimal res = null;
		
		if ("SUMA".equals(operador))
			res = ope1.add(ope2);
		else if ("RESTA".equals(operador))
			res = ope1.subtract(ope2);
		else
			throw new Exception("No soportado");
		
		return res;	
	}

}
