package usosfile;
//CON EL ATAJO CTRL+SHIFT+O IMPORTAMOS DE GOLPE TODOS LOS PAQUETES NECESARIOS
import java.io.File;
import java.io.IOException;

public class CreaFichero {
	public static void main(String[] args) {
		File directorio = new File("C:/Users/msi/Desktop/CarpetaCreadaConJava");
		if (!directorio.exists()) {
			directorio.mkdir();
			String ruta = "C:/Users/msi/Desktop/CarpetaCreadaConJava";
			File fichero = new File(ruta, "FicheroCreadoConJava.txt");
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				System.out.println("HA OCURRIDO UN PROBLEMA Y NO SE HA PODIDO CREAR");
			}
		}else {
			System.out.println("EL DIRECTORIO YA EXISTE EN EL SISTEMA");
		}
	}
}
