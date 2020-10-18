package com.prueba.sanitas.calculadora;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.classmate.TypeResolver;

@SpringBootTest
class CalculadoraApplicationTests {

	CalculadoraApplication calculadoraApplication;

	@BeforeEach
	public void setUp() {
		TypeResolver typeResolver = new TypeResolver();
		calculadoraApplication = new CalculadoraApplication(typeResolver, "0.0.1");
	}

	@Test
	public void testApplication() {
		assertNotNull(calculadoraApplication.swaggerApi());
	}

}
