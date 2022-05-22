package com.calculadora.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class CalculadoraControllerTest {

	private static final Logger log = LoggerFactory.getLogger(CalculadoraControllerTest.class);

	//private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sumaEnteraTest() throws Exception {

		String operando = "SUMA";
		Integer ope1 = 2;
		Integer ope2 = 23;
		Double EXPECTED = 25.0;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isOk()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// ACTUAL EXPECTED
				.andExpect(jsonPath("$.resultado", is(EXPECTED)));
		
	}


	@Test
	public void sumaDecimalTest() throws Exception {

		String operando = "SUMA";
		Double ope1 = 3.4;
		Double ope2 = 4.4;
		Double EXPECTED = 7.8;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isOk()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// ACTUAL EXPECTED
				.andExpect(jsonPath("$.resultado", is(EXPECTED)));
		
	}

	@Test
	public void restaEnteraTest() throws Exception {

		String operando = "RESTA";
		Integer ope1 = 2;
		Integer ope2 = 23;
		Double EXPECTED = -21.0;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isOk()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// ACTUAL EXPECTED
				.andExpect(jsonPath("$.resultado", is(EXPECTED)));
		
	}


	@Test
	public void restaDecimalTest() throws Exception {

		String operando = "RESTA";
		Double ope1 = 3.4;
		Double ope2 = 4.4;
		Double EXPECTED = -1.0;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isOk()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// ACTUAL EXPECTED
				.andExpect(jsonPath("$.resultado", is(EXPECTED)));
		
	}

	
	@Test
	public void operadoresNoPermitidosTest() throws Exception {

		String operando = "MULTI";
		Integer ope1 = 3;
		String ope2 = "A";
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isBadRequest()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void operacionNoPermitidaTest() throws Exception {

		String operando = "MULTI";
		Double ope1 = 3.4;
		Double ope2 = 4.4;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isInternalServerError()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void numerosNoValidosTest() throws Exception {

		String operando = "SUMA";
		Integer ope1 = 1000000;
		Integer ope2 = 4;
		
		this.mockMvc.perform(get("/api/calcular/"+operando+"/"+ ope1+"/"+ope2))
				.andExpect(status().isInternalServerError()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
