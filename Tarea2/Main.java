package Tarea2;

import java.util.Scanner;

public class Main {
  

    public static void main(String[] args) {
        int tamanoArreglo = 5;
        double limiteMaximo = 100.0;
        char simboloSeparador = '=';
        boolean ejecucionExitosa = true;

        Scanner scanner = new Scanner(System.in);

        int numeroPrueba = leerEnteroValidado(scanner, "Ingrese un numero entero (1-100): ", 1, 100);
        System.out.println("Numero ingresado: " + numeroPrueba);
    }

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
}
