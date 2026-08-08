package Tarea2;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int tamanoArreglo = 5;
        double limiteMaximo = 100.0;
        char simboloSeparador = '=';
        boolean ejecucionExitosa = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 1. ARREGLO UNIDIMENSIONAL ---");
        int[] arregloUnidimensional = new int[tamanoArreglo];

        for (int i = 0; i < arregloUnidimensional.length; i++) {
            arregloUnidimensional[i] = leerEnteroValidado(scanner, "Ingrese entero #" + (i + 1) + " (1-100): ", 1, 100);
        }

        procesarArregloUnidimensional(arregloUnidimensional);
    }

    // Leer y validar entero en rango
    public static int leerEnteroValidado(Scanner scanner, String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println(" Error: El numero debe estar entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println(" Error: Debe ingresar un numero entero valido.");
                scanner.next();
            }
        }
        return numero;
    }

    // Procesar arreglo 1D 
    public static void procesarArregloUnidimensional(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) return;

        int max = arreglo[0];
        int min = arreglo[0];
        int suma = 0;

        for (int valor : arreglo) {
            if (valor > max) max = valor;
            if (valor < min) min = valor;
            suma += valor;
        }

        double promedio = (double) suma / arreglo.length;

        System.out.println("\n--- RESULTADOS ARREGLO UNIDIMENSIONAL ---");
        System.out.print("Elementos: [ ");
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println("]");
        System.out.println("Maximo: " + max);
        System.out.println("Minimo: " + min);
        System.out.printf("Promedio: %.2f\n", promedio);
    }
}
