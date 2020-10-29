package usosfile;

import java.io.File;

public class VerFichero {
	public static void main(String[] args) {
		String dir = "."; //ME POSICIONO EN EL DIRECTORIO ACTUAL DONDE ESTÁ EL PROYECTO
		File f = new File(dir); //CREO EL OBJETO FILE ASOCIANDO EL DIRECTORIO
		String[] archivos = f.list();
		System.out.println("Estás en el fichero: "+f.getAbsolutePath());
		System.out.println("Hay :"+archivos.length+" ficheros en el directorio actual");
		System.out.println("Ahora vamos a ver todos los ficheros que contiene");
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.print(f2.getName());
			if(!f2.isDirectory()) {
				System.out.println(" --> Es un Fichero");
			}else {
				System.out.println(" --> Es un Directorio");
			}
		}
	}
}