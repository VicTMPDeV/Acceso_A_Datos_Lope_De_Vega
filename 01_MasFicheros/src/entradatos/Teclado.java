package entradatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

    public static Scanner cadena = new Scanner(System.in);
    public static Scanner numero = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        int numeroLeido = 0;
        boolean exito = false;
        while (!exito) {
            System.out.println(mensaje);
            try {
                numeroLeido = numero.nextInt();
                exito = true;
            } catch (InputMismatchException error) {
                System.out.println("NO HAS INTRODUCIDO UN NUMERO");
                System.out.println("PRUEBA DE NUEVO");
                numero.nextLine(); //VACIAR EL BUFFER
            }
        }
        return numeroLeido;
    }

    public static double leerDouble(String mensaje) {
        double numeroLeido = 0;
        boolean exito = false;
        while (!exito) {
            System.out.println(mensaje);
            try {
                numeroLeido = numero.nextDouble();
                exito = true;
            } catch (InputMismatchException error) {
                System.out.println("NO HAS INTRODUCIDO UN NUMERO");
                System.out.println("PRUEBA DE NUEVO");
                numero.nextLine(); //VACIAR EL BUFFER
            }
        }
        return numeroLeido;
    }

    public static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        String cadenaLeida = cadena.nextLine();
        return cadenaLeida;
    }

}
