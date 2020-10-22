/**
 * 
 */
package com.prueba.sanitas.calculdadora.dto.salida;

import java.math.BigDecimal;

import com.prueba.sanitas.calculadora.utils.Redondear;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jose
 *
 */
public class SalidaDTO {
	
	@ApiModelProperty(value = "Salida", required = true, example = "1", position = 1)
	BigDecimal salida;

	public SalidaDTO(BigDecimal salida) {
		this.salida = salida;
	}

	public SalidaDTO() {
	}

	public BigDecimal getSalida() {
		Redondear claseByRound = new Redondear();
		return claseByRound.redondearBigDecimal(salida);
	}

	public void setSalida(BigDecimal salida) {
		this.salida = salida;
	}

	@Override
	public String toString() {
		return "SalidaDTO [salida=" + getSalida() + "]";
	}

}
