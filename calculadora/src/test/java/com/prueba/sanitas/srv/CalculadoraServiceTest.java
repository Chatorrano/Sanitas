package com.prueba.sanitas.srv;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraServiceImpl;


@SpringBootTest
class CalculadoraServiceTest {

	private CalculadoraServiceImpl calculadoraService = new CalculadoraServiceImpl();

	@Test
	public void testSuma() {
		EntradaDTO entrada = new EntradaDTO(3.4, 2.0);
		assertEquals(calculadoraService.suma(entrada).getSalida(), new Double(5.4));
	}
	
	@Test
	public void testSumaConNull() {
		EntradaDTO entrada = new EntradaDTO(3.4, null);
		assertEquals(calculadoraService.suma(entrada).getSalida(), new Double(0.0));
		entrada = new EntradaDTO(null, 2.0);
		assertEquals(calculadoraService.suma(entrada).getSalida(), new Double(0.0));
	}

	@Test
	public void testResta() {
		EntradaDTO entrada = new EntradaDTO(3.4, 2.0);
		assertEquals(calculadoraService.resta(entrada).getSalida(), new Double(1.4));
	}
	
	@Test
	public void testRestaConNull() {
		EntradaDTO entrada = new EntradaDTO(3.4, null);
		assertEquals(calculadoraService.resta(entrada).getSalida(), new Double(0.0));
		entrada = new EntradaDTO(null, 2.0);
		assertEquals(calculadoraService.resta(entrada).getSalida(), new Double(0.0));
	}

}
