package com.prueba.sanitas.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.utils.TypeOperation;

class DTOEntradaTests {
	
	private static String resultadoEntrada;


	@Test
	public static void testDTOEntradaSuma() {
		EntradaDTO entrada = new EntradaDTO();
		resultadoEntrada = new EntradaDTO(entrada.getOperacion().SUMA, new BigDecimal(3.4), new BigDecimal(1.3)).toString();
		entrada.setOperacion(TypeOperation.SUMA);
		entrada.setNumero1(new BigDecimal(3.4));
		entrada.setNumero2(new BigDecimal(1.3));
		assertEquals(entrada.toString(), resultadoEntrada);
	}
	
	@Test
	public static void testDTOEntradaResta() {
		EntradaDTO entrada = new EntradaDTO();
		resultadoEntrada = new EntradaDTO(entrada.getOperacion().RESTA, new BigDecimal(3.4), new BigDecimal(1.3)).toString();
		entrada.setOperacion(TypeOperation.RESTA);
		entrada.setNumero1(new BigDecimal(3.4));
		entrada.setNumero2(new BigDecimal(1.3));
		assertEquals(entrada.toString(), resultadoEntrada);
	}
}
