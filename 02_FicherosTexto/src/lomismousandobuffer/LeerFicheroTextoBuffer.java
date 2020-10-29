package lomismousandobuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTextoBuffer {
	
	public static void main(String[] args) {
		try {
			//LO PRIMERO ES DECIRLE A JAVA DONDE ESTA EL FICHERO QUE QUEREMOS LEER
			String ruta = "C:\\Users\\msi\\Desktop\\leemeMucho.txt";
			//DESPUÉS, CREAR UN OBJETO DE TIPO FILE QUE MODELE EL FICHERO COMO UN OBJETO
			File ficheroTexto = new File(ruta);
			//AHORA VAMOS A USAR LA CLASE QUE NOS PROPORCIONA UN STREAM O CANAL DE COMUNICACION ENTRE EL FICHERO Y EL PROGRAMA
			FileReader flujoLector = new FileReader(ficheroTexto);
			//AHORA LE PONEMOS EL CAMIÓN A FERMÍN
			BufferedReader camion = new BufferedReader(flujoLector);
			String linea = camion.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = camion.readLine();
			}
			camion.close();
			flujoLector.close();
		} catch (IOException e) {
			System.out.println("TODO PUEDE FALLAR EN ESTA VIDA, NO PUEDO LEER EL FICHERO");
			e.printStackTrace();
		}
	}
}
