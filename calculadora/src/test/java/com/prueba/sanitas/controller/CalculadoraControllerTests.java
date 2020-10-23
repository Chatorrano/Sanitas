/**
 * 
 */
package com.prueba.sanitas.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.prueba.sanitas.calculadora.controller.SanitasCalculadoraControllerImpl;
import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraServiceImpl;
import com.prueba.sanitas.calculadora.utils.Redondear;
import com.prueba.sanitas.calculadora.utils.TypeOperation;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

/**
 * @author Jose
 *
 */
class CalculadoraControllerTests {

	/**
	 * @throws java.lang.Exception
	 */
	private SanitasCalculadoraControllerImpl controller;
	private CalculadoraServiceImpl calculadoraService;
	private EntradaDTO auxiliarPrueba;
	private SalidaDTO salida;
	Redondear claseByRound;	
	
	@BeforeEach
	public void setUp() {
		claseByRound = new Redondear();
		calculadoraService = Mockito.mock(CalculadoraServiceImpl.class);
		controller = new SanitasCalculadoraControllerImpl(calculadoraService);	
	}

	@Test
	public void testSumaController() {
		auxiliarPrueba = new EntradaDTO(TypeOperation.SUMA, claseByRound.redondearBigDecimal(new BigDecimal(6.0)),claseByRound.redondearBigDecimal(new BigDecimal(4.0)));
		salida = new SalidaDTO(claseByRound.redondearBigDecimal(new BigDecimal(10.0)));
		Mockito.when(calculadoraService.operacion(Mockito.any())).thenReturn(salida);
		assertEquals(controller.operacion(
				auxiliarPrueba.getOperacion(), 
				auxiliarPrueba.getNumero1(), 
				auxiliarPrueba.getNumero2()).getBody().getSalida(), claseByRound.redondearBigDecimal(new BigDecimal(10.0)));
	}

	@Test
	public void testRestaController() {
		auxiliarPrueba = new EntradaDTO(TypeOperation.RESTA, claseByRound.redondearBigDecimal(new BigDecimal(6.0)),claseByRound.redondearBigDecimal(new BigDecimal(4.0)));
		salida = new SalidaDTO(claseByRound.redondearBigDecimal(new BigDecimal(2.0)));
		Mockito.when(calculadoraService.operacion(Mockito.any())).thenReturn(salida);
		assertEquals(controller.operacion(
				auxiliarPrueba.getOperacion(), 
				auxiliarPrueba.getNumero1(), 
				auxiliarPrueba.getNumero2()).getBody().getSalida(), claseByRound.redondearBigDecimal(new BigDecimal(2.0)));
	}

}
