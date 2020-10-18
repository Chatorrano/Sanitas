/**
 * 
 */
package com.prueba.sanitas.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.CalculadoraService;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jose
 **
 * Hay mucha documentación tanto del controlador como de la clase principal en:
 * https://www.paradigmadigital.com/dev/documenta-tus-microservicios-springboot-springfox/
 * y en Baeldung 
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
	@ApiOperation(value = "Suma aritmetica de dos numeros", notes = "Devuelve la suma de dos elementos aritmeticos no nulos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SalidaDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	@PostMapping("/suma")
	public @ResponseBody ResponseEntity<SalidaDTO> suma(
			@ApiParam(value = "JSON con los numeros", required = true) @RequestBody EntradaDTO entrada) {
		SalidaDTO salida = calculadoraService.suma(entrada);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}

	/**
	 * Resta dos numeros, el segundo al primero encapsulados en el objeto
	 * EntradaSumaDTO compuesto por dos Double que se pasa en un JSON como un
	 * String
	 *
	 * @return Resultado de la resta
	 */
	@ApiOperation(value = "Resta aritmetica de dos numeros", notes = "Devuelve la resta de dos elementos aritmeticos no nulos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SalidaDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	@PostMapping("/resta")
	public @ResponseBody ResponseEntity<SalidaDTO> resta(
			@ApiParam(value = "JSON con los numeros", required = true) @RequestBody EntradaDTO entrada) {
		SalidaDTO salida = calculadoraService.resta(entrada);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}
}
