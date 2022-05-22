package com.calculadora.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.calculadora.exceptions.NumeroFueraDeRangoException;
import com.calculadora.exceptions.OperationNotSupportException;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	// Define la cantidad de decimales de aproximacion
	int NRO_DECIMALES = 2;
	
	private static final Logger log 
				= LoggerFactory.getLogger(CalculadoraServiceImpl.class);

	private static final Double LIMITE_INFERIOR = -320000.0;

	private static final Double LIMITE_SUPERIOR = 320000.0;

	/**
	 * Ejecuta la operacion
	 * 
	 */
	@Override
	public Double ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) throws Exception {

		log.debug("Calling ejecutar()...!");
		
		
		if (!estaEnRango(ope1))
			throw new NumeroFueraDeRangoException("Numero '" + ope1+ "' fuera de rango permitido");
			
		if (!estaEnRango(ope2))
			throw new NumeroFueraDeRangoException("Numero '" + ope2+ "' fuera de rango permitido");
		
		
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

	private boolean estaEnRango(BigDecimal ope) {
		// TODO Auto-generated method stub
		
		if (LIMITE_INFERIOR < ope.doubleValue() && 
				ope.doubleValue() < LIMITE_SUPERIOR )
			return true ;
		else
			return false;
	}

}
