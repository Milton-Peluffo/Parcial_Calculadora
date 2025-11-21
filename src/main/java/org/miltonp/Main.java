package org.miltonp;

import org.miltonp.calculadora.Calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Calculadora Básica ---");
            System.out.println("1) Sumar");
            System.out.println("2) Restar");
            System.out.println("3) Multiplicar");
            System.out.println("4) Dividir");
            System.out.println("5) Porcentaje");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            double a, b, resultado;

            switch (opcion) {
                case 1:
                    System.out.print("Primer número: ");
                    a = sc.nextDouble();
                    System.out.print("Segundo número: ");
                    b = sc.nextDouble();
                    resultado = calc.sumar(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    System.out.print("Primer número: ");
                    a = sc.nextDouble();
                    System.out.print("Segundo número: ");
                    b = sc.nextDouble();
                    resultado = calc.restar(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 3:
                    System.out.print("Primer número: ");
                    a = sc.nextDouble();
                    System.out.print("Segundo número: ");
                    b = sc.nextDouble();
                    resultado = calc.multiplicar(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 4:
                    System.out.print("Dividendo: ");
                    a = sc.nextDouble();
                    System.out.print("Divisor: ");
                    b = sc.nextDouble();
                    try {
                        resultado = calc.dividir(a, b);
                        System.out.println("Resultado: " + resultado);
                    } catch (ArithmeticException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Valor: ");
                    a = sc.nextDouble();
                    System.out.print("Porcentaje (%): ");
                    b = sc.nextDouble();
                    resultado = calc.porcentaje(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 0:
                    salir = true;
                    System.out.println("### Finalizado ###");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
