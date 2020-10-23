/**
 * 
 */
package com.prueba.sanitas.calculadora.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prueba.sanitas.calculadora.utils.TypeOperation;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jose
 *
 */
public interface ISanitasCalculadoraController {

	@ApiOperation(value = "Operación aritmetica de dos numeros", notes = "Devuelve la operación elegida de dos elementos aritmeticos no nulos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SalidaDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied", response = UnsupportedOperationException.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	@ExceptionHandler(UnsupportedOperationException.class)
	@GetMapping("/operacion")
	public @ResponseBody ResponseEntity<SalidaDTO> operacion(
			@ApiParam(value = "JSON con la operación a realizar y los numeros correspondientes", required = true) @NotNull @RequestParam TypeOperation operacion,
			@NotNull @RequestParam BigDecimal numero1, @NotNull @RequestParam BigDecimal numero2);
}
