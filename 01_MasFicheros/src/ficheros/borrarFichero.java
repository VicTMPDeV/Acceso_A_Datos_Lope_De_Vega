package ficheros;

import java.io.File;

import entradatos.Teclado;

public class borrarFichero {

	public static void main(String[] args) {

		String ruta = Teclado.leerCadena("INTRODUCE UNA RUTA");

		File f = new File(ruta);

		if (f.exists()) {
			System.out.println("EL FICHERO EXISTE");
			if (f.canWrite()) {
				System.out.println("EL FICHERO SE PUEDE ESCRIBIR");
				File[] lista = f.listFiles();
				int i = 0;
				for (i = 0; i < lista.length; i++) {
					System.out.println(lista[i].getName());
				}
				System.out.println("HAY " + i + " FICHEROS");
				int borrar = -1;
				borrar = Teclado.leerEntero("¿DESEA BORRAR EL FICHERO?");
				if (borrar == 0) {
					int contador = 0;
					for (int j = 0; j < lista.length; j++) {
						if (lista[j].isDirectory()) {
							lista[j].delete();
							System.out.println("DIRECTORIO BORRADO");
							contador++;
						}	
					}
					System.out.println("SE HAN BORRADO " + contador + " DIRECTORIOS");
				}
			} else {
				System.out.println("EL FICHERO NO SE PUEDE ESCRIBIR");
			}
		} else {
			System.out.println("EL FICHERO NO EXISTE");
		}
	}
}
