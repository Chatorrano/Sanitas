package com.prueba.sanitas.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.sanitas.calculadora.controller.SanitasCalculadoraController;
import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraServiceImpl;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

import org.mockito.InjectMocks;
import org.mockito.Mockito;

@SpringBootTest
class SanitasCalculadoraControllerTest {
	
	
	private SanitasCalculadoraController sanitasCalculadoraController;
	
	@InjectMocks
	private CalculadoraServiceImpl calculadoraService;
	private EntradaDTO entrada;
	private SalidaDTO salidaResta;
	private SalidaDTO salidaSuma;

	@BeforeEach
	void setUp() throws Exception {
		sanitasCalculadoraController = new SanitasCalculadoraController(calculadoraService);
		entrada = new EntradaDTO(6.0, 4.0);
		salidaResta = new SalidaDTO(2.0);
		salidaSuma = new SalidaDTO(10.0);
	}

	@Test
	void testSuma() {
		Mockito.when(calculadoraService.suma(entrada)).thenReturn(salidaSuma);
		assertEquals(sanitasCalculadoraController.suma(entrada).getBody().getSalida(), new Double(10.0));
	}

	@Test
	void testResta() {
		Mockito.when(calculadoraService.resta(entrada)).thenReturn(salidaResta);
		assertEquals(sanitasCalculadoraController.resta(entrada).getBody().getSalida(), new Double(2.0));
	}

}
