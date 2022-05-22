package com.calculadora.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculadoraServiceTest {

	@Autowired
	CalculadoraService  calculadoraService;
	
	@Test
	void sumaEnterosTest() throws Exception {

		Double EXPECTED = (double)7;
		
		String operador = "SUMA";
		BigDecimal ope1 = new BigDecimal(3);
		BigDecimal ope2 = new BigDecimal(4);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}

	@Test
	void sumaDecimaleTest() throws Exception {

		Double EXPECTED = 7.5;
		
		String operador = "SUMA";
		BigDecimal ope1 = new BigDecimal(3.2);
		BigDecimal ope2 = new BigDecimal(4.3);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}
	
}
