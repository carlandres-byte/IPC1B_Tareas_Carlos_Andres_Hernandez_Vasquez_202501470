package Tarea2;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //  Tipos de datos primitivos
        int tamanoArreglo = 5;
        double limiteMaximo = 100.0;
        char simboloSeparador = '=';
        boolean ejecucionExitosa = true;

        Scanner scanner = new Scanner(System.in);

        imprimirEncabezado(simboloSeparador, "SISTEMA DE PROCESAMIENTO DE DATOS - TAREA 2");

        System.out.println("\n--- 1. ARREGLO UNIDIMENSIONAL ---");
        int[] arregloUnidimensional = new int[tamanoArreglo];

        for (int i = 0; i < arregloUnidimensional.length; i++) {
            // Lee y valida la entrada en el rango de 1 a 100
            arregloUnidimensional[i] = leerEnteroValidado(scanner, "Ingrese entero #" + (i + 1) + " (1-100): ", 1, 100);
        }

        procesarArregloUnidimensional(arregloUnidimensional);

        System.out.println("\n--- 2. MATRIZ BIDIMENSIONAL (3x3) ---");
        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = leerEnteroValidado(scanner, "Posicion [" + i + "][" + j + "] (1-100): ", 1, 100);
            }
        }

        procesarMatrizBidimensional(matriz);

        imprimirEncabezado(simboloSeparador, "PROCESO FINALIZADO CON EXITO: " + ejecucionExitosa);
        scanner.close();
    }

    // Leer y validar enteros en rango determinado
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

    //  Procesar arreglo 1D 
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

    // Procesar y desplegar matriz bidimensional
    public static void procesarMatrizBidimensional(int[][] matriz) {
        System.out.println("\n--- CONTENIDO DE LA MATRIZ (3x3) ---");
        int sumaTotal = 0;

        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            System.out.print("Fila " + i + ": | ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d | ", matriz[i][j]);
                sumaFila += matriz[i][j];
                sumaTotal += matriz[i][j];
            }
            System.out.println(" -> Suma Fila " + i + " = " + sumaFila);
        }
        System.out.println("Suma total de la matriz: " + sumaTotal);
    }

    // Imprimir encabezados con bordes
    public static void imprimirEncabezado(char caracter, String titulo) {
        System.out.println();
        for (int i = 0; i < 45; i++) System.out.print(caracter);
        System.out.println("\n" + titulo);
        for (int i = 0; i < 45; i++) System.out.print(caracter);
        System.out.println();
    }
}
