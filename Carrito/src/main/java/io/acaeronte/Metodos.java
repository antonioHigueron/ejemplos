package io.acaeronte;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Metodos {

    private static Connection myCon = null;
    private static Statement mySta = null;
    private static PreparedStatement myPrepSta = null;
    private static ResultSet rs = null;
    private static ResultSet rs2 = null;
    private static ResultSetMetaData metaDatos = null;

    private static Map<String, Integer> carrito = new HashMap<>();

    public static void conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            myCon = DriverManager.getConnection("jdbc:sqlite:D:\\programas\\dbeaver\\addbooks.db");
            mySta = myCon.createStatement();
            //prueba
            /*rs = mySta.executeQuery("select * from Titles");
            while (rs.next()) {
                System.out.println("isbn: " + rs.getString("ISBN"));
            }*/

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Se mostrarán todos los libros almacenados en la tabla titles. El programa solo
     * mostrará las columnas ISBN, título y cantidad. La columna de cantidad
     * representa el número de copias de cada libro en la tienda (stock).
     */
    public void opcion1() {
        try {
            rs = mySta.executeQuery("select * from Titles");
            System.out.println("ISBN\t\tTitle\t\t\t\t\t\t\t\t\t\tQuantity");
            while (rs.next()) {
                //System.out.format("%-4s\t%-8s\t%-8s\n",rs.getString("ISBN"),rs.getString("Title"),rs.getString("Quantity"));
                System.out.format("%s  %-43s %s",rs.getString("ISBN"),rs.getString("Title"),rs.getString("Quantity"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Los usuarios pueden agregar al carrito un libro para comprarlo más tarde. El
     * programa pedirá a los usuarios el ISBN del libro y el número de copias de ese
     * libro. Posteriormente, esta información se agregará a un carrito
     * Map<String,Integer>. “Carrito” es el nombre del objeto del mapa.
     * Gestiona las siguientes indicaciones de forma adecuada:<br/>
     * • System.out.println("La cantidad de copias debe ser superior a 0");<br/>
     * • System.out.println("No hay tantas copias en stock");<br/>
     * • System.out.println("El carrito ha sido actualizado");<br/>
     */
    public void opcion2() {
        Scanner entrada = new Scanner(System.in);
        int copiasDisponibles = getBook(entrada);
        int copiasAComprar = -1;
        while(copiasAComprar <=0){
            System.out.println("Introduce el numero de copias que deseas comprar");
            copiasAComprar = entrada.nextInt();
            entrada.nextLine();
            if (copiasAComprar <=0){
                System.out.println("La cantidad de copias debe ser superior a 0");
            }else if(copiasAComprar > copiasDisponibles){
                System.out.println("No hay tantas copias en stock");
            }
        }
        actualizarCarrito(copiasAComprar);

    }

    private void actualizarCarrito(int copiasAComprar) {
        try {
            carrito.put(rs.getString("ISBN"),rs.getInt("Quantity")-copiasAComprar);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El carrito ha sido actualizado");
    }

    private static int getBook(Scanner entrada) {
        int stock=0;
        System.out.println("Introduce isbn del libro");
        String isbnBook = entrada.next();
        entrada.nextLine();
        try {
            rs = mySta.executeQuery("select * from Titles where ISBN = '"+isbnBook+"'");
            if(rs.next()){
                stock = rs.getInt("Quantity");
            }else{
                System.out.println("Libro inexistente");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stock;
    }

    /**
     * Lista de libros en el carrito (ISBN y cantidad).
     */
    public void opcion3() {
    }

    /**
     * Modifica adecuadamente la base de datos para actualizar el stock (número de
     * copias de un libro) según el contenido del carrito de la compra. El programa
     * tendrá que restar la cantidad en el mapa de la columna de cantidad.
     * Carrito de compras
     * JDBC and Collection exercise
     * Elimina el carrito cuando el proceso finalice.
     * Codifica esta opción solo usando el objeto resultSet. No utilices métodos de
     * ejecución.
     * Gestiona las siguientes indicaciones de forma adecuada:<br/>
     * • System.out.println("El carrito está vacío");<br/>
     * • System.out.println("La compra se ha realizado correctamente");<br/>
     */
    public void opcion4() {
    }

    /**
     * Antes de salir, en el caso de que el carrito no estuviera vacío, la aplicación
     * debe solicitar guardar el carrito antes de perderlo. Como opción 4, se realizarán
     * todos los cambios necesarios si la respuesta es afirmativa. Para esta opción el
     * programador no puede usar el objeto ResultSet. Usa sentencias preparadas
     * para actualizar la base de datos.
     * Gestiona las siguientes indicaciones de forma adecuada:<br/>
     * • System.out.println("El carrito de compras no está vacío");<br/>
     * • System.out.println("¿Quieres comprar los libros antes de salir S/N?");<br/>
     * • System.out.println("La compra se ha realizado correctamente");<br/>
     * • System.out.println("Has perdido todos los libros del carrito de compras");<br/>
     */
    public void opcion5() {
    }
}
