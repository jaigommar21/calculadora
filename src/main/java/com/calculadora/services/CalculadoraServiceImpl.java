package com.calculadora.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	
	private static final Logger log 
				= LoggerFactory.getLogger(CalculadoraServiceImpl.class);
	
	@Override
	public Double ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) throws Exception {
		
		BigDecimal res = null;

		if ("SUMA".equals(operador))
			res = ope1.add(ope2);
		else if ("RESTA".equals(operador))
			res = ope1.subtract(ope2);
		else
			throw new Exception("No soportado");
		
		res.setScale(2, RoundingMode.HALF_UP);
		
		log.info(res.toString());
		log.info(""+res.doubleValue());	
		
		return res.doubleValue();	
	}

}
