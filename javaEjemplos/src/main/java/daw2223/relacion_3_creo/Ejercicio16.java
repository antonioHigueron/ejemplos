package main.java.daw2223.relacion_3_creo;

import java.util.Scanner;

/**
 * 16.- Los ordenadores juegan un papel cada vez más importante
 * en la educación. Realiza un programa en Java que ayudará a un
 * alumno de escuela primaria a aprender a multiplicar. Usa un
 * objeto aleatorio para generar 2 números enteros positivos. A
 * continuación, el programa debe realizar al usuario una pregunta,
 * como: ¿Cuánto es 6 por 7? Luego, el alumno, introduce la
 * respuesta. Después, el programa comprueba la respuesta del
 * alumno. Si es correcta, muestra el mensaje “Muy bien!” y hace
 * otra pregunta de multiplicación. Si la respuesta es incorrecta,
 * muestra el mensaje “Inténtelo de nuevo” y permite que el
 * alumno intente responder la misma pregunta hasta que
 * finalmente la conteste de forma correcta. Se debe utilizar un
 * método para generar cada nueva pregunta. Este método debe
 * llamarse una vez cuando el programa comience a ejecutarse y
 * cada vez que el usuario responda la pregunta correctamente
 */
class Ejercicio16{

    public static void main(String[] args) {
        //entrada de datos
        Scanner input = new Scanner(System.in);
        //objeto aleatorio
        Ejercicio16Random object = new Ejercicio16Random();
        //condición para generar una nueva operacion
        boolean updateQuestion = false;
        do {
           updateQuestion= generateQuestion(input, object);
        }while (updateQuestion);



    }

    private static boolean generateQuestion(Scanner input, Ejercicio16Random object) {
        //generar los numeros aleatorios
        object.generateRandom();

        boolean updateQuestion;
        do {
            System.out.printf("¿Cuánto es %d por %d?\n", object.randomOne, object.randomTwo);
            int resultStudent = input.nextInt();
            int resultMultiply = object.randomOne * object.randomTwo;

            if (resultStudent == resultMultiply) {
                System.out.println("Muy bien!");
                updateQuestion = true;
            } else {
                System.out.println("Inténtelo de nuevo");
                updateQuestion = false;
            }

        }while(!updateQuestion);

        return true;
    }


}