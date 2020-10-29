package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leer4primerosCaracteres {

	public static void main(String[] args) throws IOException {
		try {
			FileReader fr = new FileReader("C:\\Users\\victo\\Desktop\\procesos.txt");
			int i;
			int contador = 0;
			while ((i = fr.read()) != -1) {
				if ((char) i != ' ') {
					contador++;
					if (contador < 12) { //12 ES SACADO AL PUTO AZAR...
						System.out.print((char) i);
					}
					if ((char) i == '\n') {
						contador = 0;
						System.out.println("\n");
					}
				}
			}
			fr.close(); // cerrar fichero
		} catch (FileNotFoundException e) {
			System.out.println("NO SE PUDO ENCONTRAR EL ARCHIVO EN LA UBICACION INDICADA");
		}
	}
}
