package org.miltonp.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testSumar() {
        // Casos positivos
        assertEquals(5.0, calculadora.sumar(2.0, 3.0), 0.0001);
        assertEquals(0.0, calculadora.sumar(0.0, 0.0), 0.0001);
        assertEquals(-1.0, calculadora.sumar(2.0, -3.0), 0.0001);
        
        // Casos con decimales
        assertEquals(5.5, calculadora.sumar(2.2, 3.3), 0.0001);
    }

    @Test
    void testRestar() {
        // Casos positivos
        assertEquals(1.0, calculadora.restar(4.0, 3.0), 0.0001);
        assertEquals(0.0, calculadora.restar(3.0, 3.0), 0.0001);
        assertEquals(5.0, calculadora.restar(2.0, -3.0), 0.0001);
        
        // Casos con decimales
        assertEquals(1.1, calculadora.restar(3.3, 2.2), 0.0001);
    }

    @Test
    void testMultiplicar() {
        // Casos básicos
        assertEquals(6.0, calculadora.multiplicar(2.0, 3.0), 0.0001);
        assertEquals(0.0, calculadora.multiplicar(5.0, 0.0), 0.0001);
        assertEquals(-6.0, calculadora.multiplicar(2.0, -3.0), 0.0001);
        
        // Casos con decimales
        assertEquals(7.26, calculadora.multiplicar(2.2, 3.3), 0.0001);
    }

    @Test
    void testDividir() {
        // Casos de división normal
        assertEquals(2.0, calculadora.dividir(6.0, 3.0), 0.0001);
        assertEquals(0.5, calculadora.dividir(1.0, 2.0), 0.0001);
        assertEquals(-2.0, calculadora.dividir(6.0, -3.0), 0.0001);
        
        // Casos con decimales
        assertEquals(1.5, calculadora.dividir(3.3, 2.2), 0.0001);
    }

    @Test
    void testDividirPorCero() {
        // Verificar que se lance la excepción al dividir por cero
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(5.0, 0.0);
        }, "Se esperaba una excepción al dividir por cero");
        
        // Verificar el mensaje de la excepción
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(5.0, 0.0);
        });
        assertEquals("No se puede dividir entre cero", exception.getMessage());
    }

    @Test
    void testPorcentaje() {
        // Casos básicos
        assertEquals(10.0, calculadora.porcentaje(100.0, 10.0), 0.0001);
        assertEquals(0.0, calculadora.porcentaje(0.0, 50.0), 0.0001);
        assertEquals(25.0, calculadora.porcentaje(50.0, 50.0), 0.0001);
        
        // Casos con decimales
        assertEquals(22.0, calculadora.porcentaje(200.0, 11.0), 0.0001);
        assertEquals(0.15, calculadora.porcentaje(1.0, 15.0), 0.0001);
    }
}
