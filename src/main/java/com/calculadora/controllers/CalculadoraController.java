package com.calculadora.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.services.CalculadoraService;
import com.calculadora.services.dtos.ResultadoOperacion;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

	private static final Logger log 
				= LoggerFactory.getLogger(CalculadoraController.class);
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

		// Invocamos a la capa de servicios
		Double resultado 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		log.info(">>..." + resultado);
		
		// Creamos resultado de operacion
		ResultadoOperacion res = new ResultadoOperacion();
		
		res.setOperacion(operador);
		res.setOperando1(ope1);
		res.setOperando2(ope2);
		res.setResultado(resultado);
		
		// Respuesta JSON
		return new ResponseEntity<ResultadoOperacion>(res,HttpStatus.ACCEPTED);
		
	}

}
