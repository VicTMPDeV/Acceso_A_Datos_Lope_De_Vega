package ficherostexto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFicheroTexto {

	public static void main(String[] args) throws IOException {
		//LO PRIMERO ES DECIRLE A JAVA DONDE ESTA EL FICHERO QUE QUEREMOS LEER
		String ruta = "C:\\Users\\msi\\Desktop\\leeme.txt";
		//DESPUÉS, CREAR UN OBJETO DE TIPO FILE QUE MODELE EL FICHERO COMO UN OBJETO
		File ficheroTexto = new File(ruta);
		FileWriter flujoDeEscritura = new FileWriter(ficheroTexto, true); //CREAMOS EL FLUJO DE SALIDA DESDE EL PROGRAMA JAVA HACIA LA RUTA INDICADA DE ALMACENAMIENTO (DISCO DURO)   

		//AHORA VOY A PONER UNA ENTRADA DE TECLADO PARA ESCRIBIR EL MENSAJE A CONTINUACION
		Scanner sca = new Scanner(System.in);
		System.out.print("ESCRIBE LO QUE QUIERAS AÑADIR AL FICHERO DE TEXTO: ");
		String mensaje = sca.nextLine();
		
		flujoDeEscritura.write(mensaje); //ESCRIBIMOS EL MENSAJE USANDO EL FLUJO DE SALIDA HACIA EL FICHERO QUE ESTÁ EN EL DISCO DURO
		
		flujoDeEscritura.close();    //CERRAMOS EL FLUJO DE SALIDA DESDE EL PROGRAMA HACIA EL DISCO DURO
	}

}