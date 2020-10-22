package com.prueba.sanitas.calculadora.utils;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class Redondear {

	@NotNull
	public BigDecimal redondearBigDecimal (BigDecimal numero) {
		return numero.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
