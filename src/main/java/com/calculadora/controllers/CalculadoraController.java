package com.calculadora.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.services.CalculadoraService;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

	@Autowired
	CalculadoraService calculadoraService;

	/**
	 * Realiza operacion de calculo
	 * 
	 * @param operador
	 * @param ope1
	 * @param ope2
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/calcular/{operador}/{ope1}/{ope2}")
	public ResponseEntity<?> calcular(@PathVariable String operador, @PathVariable BigDecimal ope1,
			@PathVariable BigDecimal ope2) throws Exception {

		Double resultado 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		return new ResponseEntity<Double>(resultado,HttpStatus.ACCEPTED);
		
	}

}
