/**
 * 
 */
package com.prueba.sanitas.calculadora.dto.entrada;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

import com.prueba.sanitas.calculadora.utils.TypeOperation;

/**
 * @author Jose
 *
 */
public class EntradaDTO {


	

	@ApiModelProperty(value = "Tipo de operación", required = true, example = "SUMA", position = 1)
	TypeOperation operacion;

	@ApiModelProperty(value = "Elemento aritmetico 1", required = true, example = "1", position = 2)
	BigDecimal numero1;
	
	@ApiModelProperty(value = "Elemento aritmetico 2", required = true, example = "1", position = 3)
	BigDecimal numero2;

	public EntradaDTO(TypeOperation operacion ,BigDecimal numero1, BigDecimal numero2) {
		this.operacion = operacion;
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public EntradaDTO() {
	}

	/**
	 * @return the operacion
	 */
	public TypeOperation getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(TypeOperation operacion) {
		this.operacion = operacion;
	}

	public BigDecimal getNumero1() {
		return numero1;
	}

	public void setNumero1(BigDecimal numero1) {
		this.numero1 = numero1;
	}

	public BigDecimal getNumero2() {
		return numero2;
	}

	public void setNumero2(BigDecimal numero2) {
		this.numero2 = numero2;
	}

	@Override
	public String toString() {
		return "EntradaDTO [Tipo de operación: "+ getOperacion().toString() + ", numero1=" + getNumero1() + ", numero2=" + getNumero2() + "]";
	}
}
