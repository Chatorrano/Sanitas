/**
 * 
 */
package com.prueba.sanitas.calculadora.service;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

/**
 * @author Jose
 *
 */
public interface ICalculadoraService {
	
	public SalidaDTO operacion(EntradaDTO entrada);
}
