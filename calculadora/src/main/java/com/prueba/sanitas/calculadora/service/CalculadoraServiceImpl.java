/**
 * 
 */
package com.prueba.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

import io.corp.calculator.TracerImpl;

/**
 * @author Jose
 *
 */
@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
	
	TracerImpl trazador = new TracerImpl();
	
	public SalidaDTO operacion(EntradaDTO entrada) {
		SalidaDTO result = new SalidaDTO(new BigDecimal(0.0));
		switch (entrada.getOperacion()) {
			case SUMA:{
				result = new SalidaDTO(entrada.getNumero1().add(entrada.getNumero2()));
				trazador.trace("SUMA realizada resultado: " + result);
				break;
			}
			case RESTA:{
				result = new SalidaDTO(entrada.getNumero1().subtract(entrada.getNumero2()));
				trazador.trace("Resta realizada resultado: " +result);
				break;
			}
			default:
				trazador.trace("Operación no definida");
		}
		return result;
	}
}
