package main.java.io.acaeronte;

import java.util.Scanner;

public class Ejercicio13 {

    /** variables de entrada al sistema para tener el
     * nombre del partido y
     * también el número de votos
     * obtenidos*/
    public Scanner entrada = new Scanner(System.in);


    /**
     * metodo a ejecutar.
     * {@link Ejercicio13#entrada}
     */
    public void partidosPoliticos() {
        String siglas;
        int votos;

        /* VARIABLES AUXILIARES */
        int tmp;
        int votosMayor = 0;
        int votosMenor =1000; // Inicializo con valor alto para que haya un dato con el que comparar
        boolean vacio = false;

        /* VARIABLES DE SALIDA */
        String partidoMasVotado = "";
        String partidoMenosVotado = "";

        /* PROCESAMIENTO */
        do {

            System.out.println("Introduzca siglas");
            System.out.println("El programa finaliza cuando pulse enter sin introducir siglas");
            System.out.println("-------------------------------------------------------------");
            siglas = entrada.nextLine();

            if (siglas.isEmpty()) {
                vacio = true;

            } else {

                System.out.println("Introduzca votos obtenidos por dicho partido");
                votos = entrada.nextInt();
                entrada.nextLine(); //limpiar buffer

                if (votos > votosMayor) {
                    votosMayor = votos;
                    partidoMasVotado = siglas;
                } else if (votos<votosMenor) {
                    votosMenor = votos;
                    partidoMenosVotado = siglas;
                }

            }
        } while (vacio == false);

        System.out.println("El partido más votado ha sido: " + partidoMasVotado);
        System.out.println("El partido menos votado ha sido: " + partidoMenosVotado);

    }

}