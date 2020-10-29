package lomismousandobuffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFicheroTextoBuffer {
	
	public static void main(String[] args) throws IOException {
		//LO PRIMERO ES DECIRLE A JAVA DONDE ESTA EL FICHERO QUE QUEREMOS LEER
		File directorio = new File("C:\\Users\\msi\\Desktop");
		//SI NO EXISTE EL FICHERO QUE QUEREMOS ESCRIBIR, LO CREAMOS
		if (directorio.exists()) {
			String nombreFichero = "FicheroCreadoConJava.txt";
			File fichero = new File(directorio, nombreFichero);
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				System.out.println("HA OCURRIDO UN PROBLEMA Y NO SE HA PODIDO CREAR");
			}
		}else {
			System.out.println("EL DIRECTORIO NO EXISTE EN EL SISTEMA");
		}
		//DESPUÉS, CREAR UN OBJETO DE TIPO FILE QUE MODELE EL FICHERO COMO UN OBJETO
		File ficheroTexto = new File("C:\\Users\\msi\\Desktop"+File.separator+"FicheroCreadoConJava.txt");
		FileWriter flujoDeEscritura = new FileWriter(ficheroTexto, true); //crear el flujo de salida       
		BufferedWriter camion = new BufferedWriter(flujoDeEscritura);
		// VAMOS A ESCRIBIR UNA SECUENCIA DE LINEAS		
		for (int i=1; i<=25; i++){
			camion.write("Fila numero: "+i); //escribe una línea
			camion.newLine(); //escribe un salto de línea
		}

		camion.close();
		flujoDeEscritura.close();    //cerrar fichero
	}

}
