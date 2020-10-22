/**
 * 
 */
package com.prueba.sanitas.calculadora.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraService;
import com.prueba.sanitas.calculadora.utils.TypeOperation;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jose
 **
 *         Hay mucha documentación tanto del controlador como de la clase
 *         principal en:
 *         https://www.paradigmadigital.com/dev/documenta-tus-microservicios-springboot-springfox/
 *         y en Baeldung
 *
 */
@RestController
@RequestMapping("/calculadora")
public class SanitasCalculadoraController {
	private final CalculadoraService calculadoraService;

	@Autowired
	public SanitasCalculadoraController(CalculadoraService calculadoraService) {
		this.calculadoraService = calculadoraService;
	}

	/**
	 * Suma dos numeros encapsulados en el objeto EntradaSumaDTO compuesto por dos
	 * Double que se pasa en un JSON como un String
	 *
	 * @return Resultado de la suma
	 */
	@ApiOperation(value = "Operación aritmetica de dos numeros", notes = "Devuelve la operación elegida de dos elementos aritmeticos no nulos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SalidaDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied", response = UnsupportedOperationException.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	@ExceptionHandler(UnsupportedOperationException.class)
	@PostMapping("/operacion")
	public @ResponseBody ResponseEntity<SalidaDTO> operacion(
			@ApiParam(value = "JSON con la operación a realizar y los numeros correspondientes", required = true) @NotNull @RequestParam TypeOperation operacion,
			@NotNull @RequestParam BigDecimal numero1, @NotNull @RequestParam BigDecimal numero2) {
		SalidaDTO salida = null;
		EntradaDTO entrada = new EntradaDTO(operacion, numero1, numero2);
		salida = calculadoraService.operacion(entrada);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}

}
