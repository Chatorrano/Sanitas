/**
 * 
 */
package com.prueba.sanitas.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

/**
 * @author Jose
 *
 */
class DTOSalidaTests {
	
	private String resultadoSalida;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		resultadoSalida = new SalidaDTO(4.6).toString();
	}

	@Test
	public void testDTOSalida() {
		SalidaDTO salida = new SalidaDTO();
		salida.setSalida(4.6);
		assertEquals(salida.toString(), resultadoSalida);
	}
}
