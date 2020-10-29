package usosfile;

import java.io.File;

public class BorraFichero {
	public static void main(String[] args) {
		// AHORA EL DIRECTORIO A VER ES PASADO POR ARGUMENTOS 
		File directorio = new File(args[0]);
		if (!directorio.exists()) {
			System.out.println("EL DIRECTORIO INDICADO NO EXISTE EN EL SISTEMA");
		}else {
			// VOY A CREAR UN OBJETO FILE POR CADA UNO DE LOS FICHEROS CONTENIDOS DENTRO
			File[] listaficheros= directorio.listFiles();		
			System.out.println("Estás en el fichero: "+directorio.getAbsolutePath());
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hay: "+listaficheros.length+" ficheros en el directorio actual");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("AHORA VAMOS A VER TODOS LOS FICHEROS QUE CONTIENE:");
			for (File fileElement : listaficheros) {
				System.out.print(fileElement.getName());
				if(!fileElement.isDirectory()) {
					System.out.println(" --> ES UN FICHERO... Y LO VAMOS A BORRAR");
					fileElement.delete();
				}else {
					System.out.println(" --> ES UN DIRECTORIO");
				}
			}
		}
	}
}
