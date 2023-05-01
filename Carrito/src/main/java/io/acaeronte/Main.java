package io.acaeronte;

import java.util.Scanner;

public class Main {
    /**
     * Entrada de datos
     */
    private static Scanner entrada = new Scanner(System.in);

    /**
     * Opcion elegida en el menu
     */
    private static int option;

    /**
     * Instancia que implementa la lógica de negocio
     */
    private static Metodos metodos = new Metodos();



    public static void main(String[] args) {
        Metodos.conexion();
        menu();
    }

    private static void menu() {
        do {
            System.out.println("\nCARRITO DE COMPRAS");
            System.out.println( "1. Listado de libros\n"
                            +   "2. Añadir al carrito\n"
                            +   "3. Mostrar carrito\n"
                            +   "4. Comprar ahora\n"
                            +   "5. Salir\n");
            System.out.println("Elige una opción");
            option = entrada.nextInt();
            entrada.nextLine();

            switch (option) {
                case 1:
                    metodos.opcion1();
                    break;
                case 2:
                    metodos.opcion2();
                    break;
                case 3:
                    metodos.opcion3();
                    break;
                case 4:
                    metodos.opcion4();
                    break;
                case 5:
                    metodos.opcion5();
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (option != 5);

    }

}