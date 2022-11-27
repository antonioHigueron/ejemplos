package main.java.daw2223.relacion_3_creo;

public class Ejercicio16Random {

    public static final int NUMERO_MAXIMO_INCLUIDO = 10;
    public static final int NUMERO_MINIMO_INCLUIDO = 1;
    public static int randomOne,randomTwo;


    public static void generateRandom(){
        randomOne = (int)(Math.random()* NUMERO_MAXIMO_INCLUIDO + NUMERO_MINIMO_INCLUIDO);
        randomTwo = (int)(Math.random()* NUMERO_MAXIMO_INCLUIDO + NUMERO_MINIMO_INCLUIDO);

    }

}
