package main.java.daw2223.relacion_3_creo;

import java.util.Scanner;

/**
 * 17.- Realiza un programa en Java que juegue a “adivina el
 * número” de la siguiente manera:
 * El programa elige el número a adivinar seleccionando un entero
 * aleatorio en el rango de 1 a 1000. El programa muestra el
 * mensaje “Adivina un número entre 1 y 1000”.
 * El jugador introduce una primera respuesta. Si la respuesta es
 * incorrecta, el programa debería mostrar “Demasiado alto.
 * Inténtelo de nuevo” o “Demasiado bajo. Inténtelo de nuevo”,
 * para ayudar al jugador a acertar.
 * El programa debe solicitar al usuario la siguiente respuesta.
 * Cuando el usuario introduzca la respuesta correcta, mostrará el
 * mensaje “¡Enhorabuena! ¡Adivinaste el número!” y deberá
 * preguntar al usuario si quiere volver a jugar.
 */
public class Ejercicio17 {


    public static void main(String[] args) {
        int numeroMinimo=1, numeroMaximo=1000;

        int numeroJugador;
        boolean reintentar = false, retry = false;
        Scanner input = new Scanner(System.in);


        do{
            int numberGenerate = (int)(Math.random()* numeroMaximo + numeroMinimo);
            System.out.println("SOLUCION: "+numberGenerate);

            retry = jugar(numberGenerate, input,retry);
        }while(retry);


    }

    private static boolean jugar(int numberGenerate, Scanner input, boolean retry) {
        boolean reintentar;
        retry = false;
        int numeroJugador;
        do {
            System.out.println("Adivina un número entre 1 y 1000");
            numeroJugador = input.nextInt();

            if (numeroJugador == numberGenerate) {
                System.out.println("¡Enhorabuena! ¡Adivinaste el número!");
                reintentar = false;
                System.out.println("¿Quieres volver a jugar (S/N)?");
                String response = input.next();
                if (response.equalsIgnoreCase("S")){
                    retry = true;
                }
            } else if (numeroJugador > numberGenerate) {
                System.out.println("Demasiado alto. Inténtelo de nuevo");
                reintentar = true;
            } else {
                System.out.println("Demasiado bajo. Inténtelo de nuevo");
                reintentar = true;
            }

        }while (reintentar);

        return retry;

    }

}
