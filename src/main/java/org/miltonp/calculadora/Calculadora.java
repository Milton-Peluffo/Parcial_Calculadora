package org.miltonp.calculadora;

public class Calculadora {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return dividendo / divisor;
    }

    public double porcentaje(double valor, double porcentaje) {
        return (valor * porcentaje) / 100.0;
    }
}
