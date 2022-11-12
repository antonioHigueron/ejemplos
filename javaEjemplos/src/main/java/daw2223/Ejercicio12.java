package main.java.daw2223;

/**
 * Pepito está descontento con su actuación en SPL. En su
 * primer programa cometió un error, en el segundo programa
 * cometió 2 errores, en el tercero cometió 4 y así
 * sucesivamente. En cada programa, siempre comete el
 * doble de errores que en el anterior. El curso dura 13
 * semanas y debe realizar 2 problemas por semana. Tienes
 * que diseñar el algoritmo para calcular el número de errores
 * que se espera que cometa Pepito al final del curso.
 */
public class Ejercicio12 {
    public static final int SEMANAS_DURACION_CURSO = 13;
    public static final int TOTAL_PROGRAMAS_DURACION_CURSO = 26;

    public static void main(String[] args) {
        int numeroErrores = 1;
        for (int i = 1; i < TOTAL_PROGRAMAS_DURACION_CURSO; i++) {
            numeroErrores = (numeroErrores * 2);
        }
        System.out.println("Número de errores de Pepito al final del curso: "+numeroErrores);
    }

    private static void metodo3() {
        int numeroErrores = 1;
        for (int i = 1; i < 3; i++) {
            numeroErrores = numeroErrores*2;
        }
        System.out.println("Número de errores de Pepito al final del curso: "+numeroErrores);
    }
}
