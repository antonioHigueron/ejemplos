package main.java.daw2223.arrays;

import java.util.Scanner;

/**
 * 19.- Tienes el array PROV [8] = {"Almería", "CADIZ", "CORDOBA", "GRANADA", "Huelva", "JAEN" ,"MALAGA", "SEVILLA"}.
 * Y los arrays P1[8] y P2[8] con los votos obtenidos por el partido político en las elecciones en Andalucía.
 * Haz un programa que permita:
 * a) Crear los arrays P1 y P2.
 * b) Introducir el nombre de la provincia y el programa debe mostrar los votos de P1 y P2 en esa provincia.
 * c) El nombre del partido político ganador.
 */
public class Ejercicio19 {
    public static void main(String[] args) {
        int opcion = -1;
        String PROV [] = {"Almería", "CADIZ", "CORDOBA", "GRANADA", "Huelva", "JAEN" ,"MALAGA", "SEVILLA"};
        int[] P1 = {-1};
        int[] P2 = {-1};
        Scanner input = new Scanner(System.in);
        
        
        while (opcion != 0){
            System.out.println("Elije una opción: \n" +
                    "1. Crear arrays\n" +
                    "2. Introduce nombre provincia para ver los votos\n" +
                    "3. Nombre del partido ganador en Andalucía\n" +
                    "0. Salir\n");
            opcion = input.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    P1=crearArrays();
                    P2=crearArrays();
                    break;
                case 2:
                    if (P1[0] == -1 || P2[0] == -1){
                        System.out.println("Debe crear los arrays, antes de ejecutar esta opcion");
                    }else {
                        mostrarVotosProvincia(input, PROV, P1,P2);
                    }

                    break;
                case 3:
                    partidoGanador(P1,P2);
                    break;
                default:
                    System.out.println("Opcion no permitida");
                    break;
            }

        }
        
    }

    private static void partidoGanador(int[] p1, int[] p2) {
        int sumaP1 = 0, sumaP2 = 0;
        for (int i = 0; i < p1.length; i++) {
            sumaP1+= p1[i];
            sumaP2+= p2[i];

        }
        if (sumaP1 > sumaP2){
            System.out.println("Partido ganador P1\n");
        }else if (sumaP1 < sumaP2){
            System.out.println("Partido ganador P2\n");
        }else {
            System.out.println("Han empatado\n");

        }
    }

    private static void mostrarVotosProvincia(Scanner input, String[] PROV, int[] p1, int[] p2) {
        boolean bandera = false;
        while(!bandera) {
            System.out.println("Introduce nombre de provincia, para mostrar los votos");
            String province = input.next();
            System.out.println();
            for (int prov=0;prov < PROV.length;prov++) {
                if(province.equals( PROV[prov])){
                    bandera = true;
                    System.out.println("Votos de P1: "+p1[prov]);
                    System.out.println("Votos de P2: "+p2[prov]);
                }
            }
        }

    }


    private static int[] crearArrays(){
        int[] votos = new int[8];
        for (int i = 0; i < 8; i++) {
            votos[i]= (int) (Math.random()* 100 + 0);
        }
        System.out.println("Arrays creados con sus valores\n");
        return votos;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
