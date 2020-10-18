/**
 * 
 */
package com.prueba.sanitas.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.prueba.sanitas.calculadora.controller.SanitasCalculadoraController;
import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraServiceImpl;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

/**
 * @author Jose
 *
 */
class CalculadoraControllerTests {

	/**
	 * @throws java.lang.Exception
	 */
	private SanitasCalculadoraController controller;
	private CalculadoraServiceImpl calculadoraService;
	private EntradaDTO auxiliarPrueba;
	private SalidaDTO salidaSuma;
	private SalidaDTO salidaResta;
	
	@BeforeEach
	public void setUp() {
		calculadoraService = Mockito.mock(CalculadoraServiceImpl.class);
		controller = new SanitasCalculadoraController(calculadoraService);
		auxiliarPrueba = new EntradaDTO(6.0, 4.0);
		salidaSuma = new SalidaDTO(10.0);
		salidaResta = new SalidaDTO(2.0);
		
	}

	@Test
	public void testSuma() {
		Mockito.when(calculadoraService.suma(auxiliarPrueba)).thenReturn(salidaSuma);
		assertEquals(controller.suma(auxiliarPrueba).getBody().getSalida(), new Double(10.0));
	}

	@Test
	public void testResta() {
		Mockito.when(calculadoraService.resta(auxiliarPrueba)).thenReturn(salidaResta);
		assertEquals(controller.resta(auxiliarPrueba).getBody().getSalida(), new Double(2.0));
	}

}
