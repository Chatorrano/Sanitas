package com.prueba.sanitas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

@SpringBootTest
class DTOTestEntradaSalida {

	private String resultadoEntrada;
	private String resultadoSalida;

	@BeforeEach
	public void setCarga() {
		resultadoEntrada = new EntradaDTO(3.4, 1.3).toString();
		resultadoSalida = new SalidaDTO(4.6).toString();
	}

	@Test
	public void testDTOEntrada() {
		EntradaDTO entrada = new EntradaDTO();
		entrada.setNumero1(3.4);
		entrada.setNumero2(1.3);
		assertEquals(entrada.toString(), resultadoEntrada);
	}
	
	@Test
	public void testDTOSalida() {
		SalidaDTO salida = new SalidaDTO();
		salida.setSalida(4.6);
		salida.toString();
		assertEquals(salida.toString(), resultadoSalida);
	}
}
