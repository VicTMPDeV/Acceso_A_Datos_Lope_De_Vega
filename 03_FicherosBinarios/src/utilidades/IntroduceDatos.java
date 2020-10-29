package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntroduceDatos {
	
	//ATRIBUTOS
	public static Scanner cadena = new Scanner(System.in);
	public static Scanner numero = new Scanner(System.in);

	//FUNCIONALIDADES
	public static int leerEntero (String mensaje) {
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
				numero.nextLine(); //DEJA EL BUFFER VAC�O
			}
		}
		return numeroLeido;
	}
	
	public static long leerLong(String mensaje) {
        long numeroLeido = 0L;
        boolean exito = false;
        while (!exito) {
            System.out.print(mensaje);
            try {
                numeroLeido = numero.nextLong();
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
            System.out.print(mensaje);
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
	
	 public static char leerChar(String mensaje) {
	        char caracterLeido;
	        String cadenaLeida = "";
	        boolean exito = false;
	        while (!exito) {
	            System.out.print(mensaje);
	            cadenaLeida = cadena.nextLine().toUpperCase();
	            if (cadenaLeida.length() != 1) {
	                System.out.println("INTRODUCE UN SOLO CARACTER");
	            } else {
	                exito = true;
	            }
	        }
	        char parseaChar [] = cadenaLeida.toCharArray();
	        caracterLeido = parseaChar[0];
	        return caracterLeido;
	    }
	
	public static String leerCadena(String mensaje) {
        String cadenaLeida = "";
        System.out.print(mensaje);
        cadenaLeida = cadena.nextLine();
        return cadenaLeida;
    }

}
