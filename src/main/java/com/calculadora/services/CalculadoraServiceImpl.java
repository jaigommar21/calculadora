package com.calculadora.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.calculadora.exceptions.OperationNotSupportException;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	// Define la cantidad de decimales de aproximacion
	int NRO_DECIMALES = 2;
	
	private static final Logger log 
				= LoggerFactory.getLogger(CalculadoraServiceImpl.class);

	/**
	 * Ejecuta la operacion
	 * 
	 */
	@Override
	public Double ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) throws Exception {

		log.debug("Calling ejecutar()...!");
		
		BigDecimal res = null;
		
		if ("SUMA".equals(operador))
			res = ope1.add(ope2);
		else if ("RESTA".equals(operador))
			res = ope1.subtract(ope2);
		else
			throw new OperationNotSupportException("Operacion '" + operador + "' no soportada");

		res = res.setScale(NRO_DECIMALES, RoundingMode.HALF_UP);
		
		return res.doubleValue();
	}

}
