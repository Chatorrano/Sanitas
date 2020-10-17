/**
 * 
 */
package com.prueba.sanitas.calculdadora.dto.salida;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jose
 *
 */
public class SalidaDTO {
	
	@ApiModelProperty(value = "Salida", required = true, example = "1", position = 1)
	Double salida;

	public SalidaDTO(Double salida) {
		this.salida = salida;
	}

	public SalidaDTO() {
	}

	public Double getSalida() {
		return salida;
	}

	public void setSalida(Double salida) {
		this.salida = salida;
	}

	@Override
	public String toString() {
		return "SalidaDTO [salida=" + getSalida() + "]";
	}

}
