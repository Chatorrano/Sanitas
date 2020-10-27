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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sanitas.calculadora.dto.entrada.EntradaDTO;
import com.prueba.sanitas.calculadora.service.ICalculadoraService;
import com.prueba.sanitas.calculadora.utils.TypeOperation;
import com.prueba.sanitas.calculdadora.dto.salida.SalidaDTO;

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
public class SanitasCalculadoraControllerImpl implements ISanitasCalculadoraController {
	private final ICalculadoraService calculadoraService;

	@Autowired
	public SanitasCalculadoraControllerImpl(ICalculadoraService calculadoraService) {
		this.calculadoraService = calculadoraService;
	}

	/**
	 * Opera con los dos numeros pasados por parametro
	 *
	 * @return Resultado de la operacion
	 */
	@ExceptionHandler(UnsupportedOperationException.class)
	@GetMapping("/operacion")
	public @ResponseBody ResponseEntity<SalidaDTO> operacion(@NotNull @RequestParam TypeOperation operacion,
			@NotNull @RequestParam BigDecimal numero1, @NotNull @RequestParam BigDecimal numero2) {
		SalidaDTO salida = null;
		EntradaDTO entrada = new EntradaDTO(operacion, numero1, numero2);
		salida = calculadoraService.operacion(entrada);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}

}
