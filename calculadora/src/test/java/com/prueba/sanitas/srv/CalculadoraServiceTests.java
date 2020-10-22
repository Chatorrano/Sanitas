package com.prueba.sanitas.srv;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraServiceImpl;
import com.prueba.sanitas.calculadora.utils.Redondear;
import com.prueba.sanitas.calculadora.utils.TypeOperation;

class CalculadoraServiceTests {

	private CalculadoraServiceImpl calculadoraService = new CalculadoraServiceImpl();
	Redondear claseByRound = new Redondear();
	
	@Test
	public void testSuma() {
		EntradaDTO entrada = new EntradaDTO(TypeOperation.SUMA ,new BigDecimal(3.4), new BigDecimal(2.0));
		assertEquals(calculadoraService.operacion(entrada).getSalida(), claseByRound.redondearBigDecimal(new BigDecimal(5.40)));
	}

	@Test
	public void testResta() {
		EntradaDTO entrada = new EntradaDTO(TypeOperation.RESTA,new BigDecimal(3.4), new BigDecimal(2.0));
		assertEquals(calculadoraService.operacion(entrada).getSalida(), claseByRound.redondearBigDecimal(new BigDecimal(1.40)));
	}
}
