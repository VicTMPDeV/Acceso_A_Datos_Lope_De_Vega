package ficherostexto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTexto {
	
	public static void main(String[] args) {
		try {
			//LO PRIMERO ES DECIRLE A JAVA DONDE ESTA EL FICHERO QUE QUEREMOS LEER
			String ruta = "C:\\Users\\msi\\Desktop\\leeme.txt";
			//DESPUÉS, CREAR UN OBJETO DE TIPO FILE QUE MODELE EL FICHERO COMO UN OBJETO
			File ficheroTexto = new File(ruta);
			//AHORA VAMOS A USAR LA CLASE QUE NOS PROPORCIONA UN STREAM O CANAL DE COMUNICACION ENTRE EL FICHERO Y EL PROGRAMA
			FileReader flujoLector = new FileReader(ficheroTexto);
			//BUSCAMOS EN LA API DE JAVA LOS METODOS DE FILE READER Y VEMOS QUE HAY UN METODO PARA LEER CARACTERES
			//read() , QUE DEVUELVE UN ENTERO EQUIVALENTE AL CARACTER UNICODE ENCONTRADO, O -1 SI NO HAY MAS QUE LEER
			int numeroReader = flujoLector.read();
			char letra = '0';
			while(numeroReader != -1) {
				letra = (char)numeroReader;
				System.out.print(letra);
				numeroReader = flujoLector.read();
			}
			flujoLector.close();
		} catch (IOException e) {
			System.out.println("TODO PUEDE FALLAR EN ESTA VIDA, NO PUEDO LEER EL FICHERO");
			e.printStackTrace();
		}
	}
}
