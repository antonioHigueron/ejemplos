package main.java.daw2223;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Realiza un programa que muestre la cantidad que será
 * atribuida a cada ganador de la Bonoloto. Tienes que
 * introducir la siguiente información: la cantidad a ser
 * distribuida y el número de ganadores en cada categoría (3,
 * 4, 5 y 6 aciertos). Cada categoría representa el 10%, 20%,
 * 30% y 40% del importe total a ser distribuido.
 * Programación
 */
public class Ejercicio14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce cantidad: ");
        double cantidad = scanner.nextDouble();
        System.out.println("Introduce el número de ganadores 3 aciertos: ");
        int ganadoresTres = scanner.nextInt();
        System.out.println("Introduce el número de ganadores 4 aciertos: ");
        int ganadoresCuatro = scanner.nextInt();
        System.out.println("Introduce el número de ganadores 5 aciertos: ");
        int ganadoresCinco = scanner.nextInt();
        System.out.println("Introduce el número de ganadores 6 aciertos: ");
        int ganadoresSeis = scanner.nextInt();

        System.out.println("Cada ganador de 3 aciertos, obtiene: "+ ((cantidad/100)*10)/ganadoresTres +" €");
        System.out.println("Cada ganador de 4 aciertos, obtiene: "+ ((cantidad/100)*20)/ganadoresCuatro +" €");
        System.out.println("Cada ganador de 5 aciertos, obtiene: "+ ((cantidad/100)*30)/ganadoresCinco +" €");
        System.out.println("Cada ganador de 6 aciertos, obtiene: "+ ((cantidad/100)*40)/ganadoresSeis +" €");
    }
}
