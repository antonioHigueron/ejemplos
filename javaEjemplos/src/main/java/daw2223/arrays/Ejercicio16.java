package main.java.daw2223.arrays;

/**
 * 16.- Realiza una aplicación que cree un array bidimensional llamado MAT [5][3].
 * Luego, muestra la suma de cada una de sus filas y la suma de cada una de sus columnas.
 */
public class Ejercicio16 {


    public static void main(String[] args) {

        int MAT[][] = new int[5][3];
        int valor = 1;
        int sumaFila = 0;
        int sumaColumna = 0;
        for (int i = 0; i < MAT.length; i++) {
            for (int j = 0; j < MAT[i].length; j++) {
                MAT[i][j] = valor;
                System.out.print(MAT[i][j]+"\t");
                valor++;
                sumaFila += MAT[i][j];
            }
            System.out.print("\t sumaFila= "+sumaFila);
            //reinicio la variable de sumaFila
            sumaFila=0;
            System.out.println();
        }

        ////////////////////////////////////////////// columnas
        for (int i = 0; i < 3; i++) {  //columnas
            sumaColumna = 0;
            for (int j = 0; j < 5; j++) { //filas
                sumaColumna += MAT[j][i];
            }
            System.out.print("sumaColumna= "+i+" "+sumaColumna+" ");
        }
        System.out.println();




















    }
}
