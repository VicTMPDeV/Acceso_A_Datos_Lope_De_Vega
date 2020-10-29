package usosfile;

import java.io.File;
import java.util.Scanner;

public class EditaYBorraFichero {
	public static void main(String[] args) {
		File directorio = new File("C:/Users/msi/Desktop/CarpetaCreadaConJava");
		if (!directorio.exists()) {
			System.out.println("EL DIRECTORIO INDICADO NO EXISTE EN EL SISTEMA");
		}else {
			if(directorio.canWrite()) {
				File directorio2 = new File("C:/Users/msi/Desktop/CarpetaRENOMBRADAConJava");
				directorio.renameTo(directorio2);
				System.out.println("DIRECTORIO RENOMBRADO CORRECTAMENTE");
				File fichero = new File(directorio2, "FicheroCreadoConJava.txt");
				Scanner sca = new Scanner(System.in);
				System.out.print("¿DESEA AHORA BORRAR EL FICHERO MODIFICADO? Pulse S o N");
				String respuesta = sca.nextLine();
				if (respuesta.equalsIgnoreCase("S")) {
					System.out.println("vas a borrar "+fichero.getName());
					fichero.delete();
					System.out.println("Fichero Borrado");
				}else if(respuesta.equalsIgnoreCase("N")) {
					System.out.println("Sabia elección");
				}else {
					System.out.println("A VACILAR A CASA CHAVAL");
				}
			}else {
				System.out.println("NO TIENE PERMISOS DE ESCRITURA");
			}
		}
	}
}
