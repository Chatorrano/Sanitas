/**
 * 
 */
package com.prueba.sanitas.calculadora.service;

import org.springframework.stereotype.Service;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

/**
 * @author Jose
 *
 */
@Service
public class CalculadoraServiceImpl implements CalculadoraService {
	

	public SalidaDTO suma(EntradaDTO entrada) {
		SalidaDTO result = new SalidaDTO(0.0);
		if ( null != entrada.getNumero1() && 
				null != entrada.getNumero2() ) {
			result = new SalidaDTO(entrada.getNumero1() + entrada.getNumero2());
		}
		return result;
	}

	public SalidaDTO resta(EntradaDTO entrada) {
		SalidaDTO result = new SalidaDTO(0.0);
		if ( null != entrada.getNumero1() && 
				null != entrada.getNumero2() ) {
			result = new SalidaDTO(entrada.getNumero1() - entrada.getNumero2());
		}
		return result;
	}

}
