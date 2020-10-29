package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerProcesos {

	public static void main(String[] args) {
		// LEER FICHERO DE PROCESOS Y MOSTRAR LAS 10 PRIMERAS LINEAS
		try {
			File f = new File("C:\\Users\\victo\\Desktop\\procesos.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(f));
			String linea;
			int contador = 0;
			while ((linea = fichero.readLine()) != null && contador <= 10) {	//MIENTRAS EXISTA CONTENIDO A LEER...
				System.out.println(linea);
				contador++;
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S");
		}
	}
}
