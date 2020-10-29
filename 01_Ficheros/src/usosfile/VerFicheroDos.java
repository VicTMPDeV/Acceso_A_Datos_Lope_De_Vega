package usosfile;
/*
 * Realiza un programa Java que utilice el método listFiles para mostrar la lista de ficheros en un directorio
 * cualquiera, o en el directorio actual.
 */
import java.io.File;

public class VerFicheroDos {
	public static void main(String[] args) {
		// ME VOY A POSICIONAR EN LA CARPETA DEL PROYECTO
		String dir = ".";
		File directorio = new File(dir);
		if (directorio.exists()) {
			// VOY A CREAR UN OBJETO FILE POR CADA UNO DE LOS FICHEROS CONTENIDOS DENTRO
			File[] listaficheros= directorio.listFiles();		
			System.out.println("Estás en el fichero: "+directorio.getAbsolutePath());
			System.out.println("Hay :"+listaficheros.length+" ficheros en el directorio actual");
			System.out.println("Ahora vamos a ver todos los ficheros que contiene");
			for (int i = 0; i < listaficheros.length; i++) {
				System.out.println("-------------------------------------------------------------------------------------------------");
				System.out.println(listaficheros[i].getName());
				System.out.println("-------------------------------------------------------------------------------------------------");
				if(!listaficheros[i].isDirectory()) {
					System.out.println(" --> Es un Fichero");
					System.out.println("Nombre del Fichero  : "+listaficheros[i].getName());
			        System.out.println("Ruta                : "+listaficheros[i].getPath());
			        System.out.println("Ruta absoluta       : "+listaficheros[i].getAbsolutePath());
			        System.out.println("Se puede leer       : "+listaficheros[i].canRead());
			        System.out.println("Se puede escribir   : "+listaficheros[i].canWrite());
			        System.out.println("Tamaño              : "+listaficheros[i].length());
					System.out.println("Es un directorio    : "+listaficheros[i].isDirectory()); 
					System.out.println("Es un fichero       : "+listaficheros[i].isFile());
					System.out.println("Nombre del directorio padre: "+listaficheros[i].getParent());
				}else {
					System.out.println(" --> Es un Directorio");
					System.out.println("Nombre del Fichero  : "+listaficheros[i].getName());
			        System.out.println("Ruta                : "+listaficheros[i].getPath());
			        System.out.println("Ruta absoluta       : "+listaficheros[i].getAbsolutePath());
			        System.out.println("Se puede leer       : "+listaficheros[i].canRead());
			        System.out.println("Se puede escribir   : "+listaficheros[i].canWrite());
			        System.out.println("Tamaño              : "+listaficheros[i].length());
					System.out.println("Es un directorio    : "+listaficheros[i].isDirectory()); 
					System.out.println("Es un fichero       : "+listaficheros[i].isFile());
					System.out.println("Nombre del directorio padre: "+listaficheros[i].getParent());
				}
			}
		}else {
			System.out.println("EL DIRECTORIO INDICADO NO EXISTE EN EL SISTEMA");
		}

	}	
}
