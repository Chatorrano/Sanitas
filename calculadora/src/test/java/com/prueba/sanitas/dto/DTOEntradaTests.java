package com.prueba.sanitas.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;

class DTOEntradaTests {
	
	private String resultadoEntrada;

	@BeforeEach
	void setUp() throws Exception {
		resultadoEntrada = new EntradaDTO(3.4, 1.3).toString();
	}

	@Test
	public void testDTOEntrada() {
		EntradaDTO entrada = new EntradaDTO();
		entrada.setNumero1(3.4);
		entrada.setNumero2(1.3);
		assertEquals(entrada.toString(), resultadoEntrada);
	}
}
