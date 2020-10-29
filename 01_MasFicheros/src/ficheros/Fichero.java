package ficheros;

import java.io.File;
import java.io.IOException;

import entradatos.*;

public class Fichero {

	// ATRIBUTOS
	public static int contador = 0;

	// NO NECESITO CONSTRUCTORES PORQUE NO VOY A INSTANCIAR OBJETOS
	// SE TRATA DE UNA CLASE ESTATICA QUE SOLO OFRECE FUNCIONALIDAD

	/************************** METODOS ***************************/

	// INICIALIZA DIRECTORIO
	public static File dimeDir() {
		File directorio = new File(Teclado.leerCadena("INDIQUE LA RUTA DONDE SE DESEA POSICIONAR: "));
		if (!directorio.exists()) {
			System.out.println("EL DIRECTORIO INDICADO NO EXISTE EN EL SISTEMA");
		}
		return directorio;
	}

	// LISTAR FICHEROS/DIRECTORIOS EXISTENTES EN UNA RUTA INDICADA
	public static File[] listarDir(File directorio) {
		File[] lista = directorio.listFiles();
		return lista;
	}
	// ***********************************************************************
	// ********************SOLO PARA LOS MÁS PROS*****************************
	// ***********************************************************************
	// LISTAR TODOS LOS FICHEROS, DIRECTORIOS Y SUBDIRECTORIOS DESDE UNA RUTA
	// EMPLEANDO RECURSIVIDAD
	// ***********************************************************************
	public static File[] listarTodo(File directorio) {
		File[] archivos = directorio.listFiles();
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].isDirectory()) { //Los que sean directorios, miro mas abajo que tienen...
				System.out.println(archivos[i].getName());
				listarTodo(archivos[i].getAbsoluteFile()); //RECURSIVIDAD
			} else { //Si no es directorio , es fichero
				System.out.println(archivos[i].getName());
			}
		}
		return archivos;
	}
	
	// MOSTRAR POR PANTALLA ELEMENTOS DE LA LISTA
	public static void printLista(File[] lista) {
		System.out.println("\nFICHEROS ENCONTRADOS: \n");
		// WHILE
		int j = 0;
		while (j < lista.length) {
			System.out.println(lista[j].getName());
			j++;
			contador++;
		}
		System.out.println("\n" + Fichero.contador + " ELEMENTOS\n");

		// FOR EACH

		/*
		 * for (File elemento : lista) { System.out.println(elemento.getName());
		 * contador++; } System.out.println("\n"+Fichero.contador + " ELEMENTOS\n");
		 */

		// FOR CONVENCIONAL

		/*
		 * for(int i=0 ; i<lista.length ; i++) { System.out.println(lista[i].getName());
		 * contador++; } System.out.println("\n"+Fichero.contador + " ELEMENTOS\n");
		 */

	}

	// CREAR DIRECTORIO
	public static void crearDir(File directorio, String nombreDir) {
		File resultado = new File(directorio, nombreDir);
		if (!resultado.exists()) {
			resultado.mkdir();
		} else {
			System.out.println("EL DIRECTORIO YA EXISTE");
		}
	}

	// CREAR ARCHIVO/FICHERO
	public static void crearFichero(File directorio, String nombreDir) throws IOException {
		File resultado = new File(directorio, nombreDir);
		if (!resultado.exists()) {
			resultado.createNewFile();
		} else {
			System.out.println("EL NOMBRE DEL ARCHIVO YA EXISTE DENTRO DE ESTE DIRECTORIO");
		}
	}

	// RENOMBRAR
	public static void renombrar(File directorio, String nombreDir, String nuevoNombre) {
		File resultado = new File(directorio, nombreDir);
		if (resultado.exists()) {
			if (resultado.canWrite()) {
				resultado.renameTo(new File(directorio, nuevoNombre));
				System.out.println("RENOMBRADO CON EXITO");
			} else {
				System.out.println("NO TIENE PERMISOS DE ESCRITURA");
			}
		} else {
			System.out.println("NO SE PUEDE BORRAR LO QUE NO EXISTE");
		}
	}

	// ELIMINAR
	public static void eliminar(File directorio, String nombreDir) {
		File resultado = new File(directorio, nombreDir);
		if (resultado.exists()) {
			if (resultado.canWrite()) {
				resultado.delete();
				System.out.println("BORRADO CON EXITO");
			} else {
				System.out.println("NO TIENE PERMISOS DE ESCRITURA");
			}
		} else {
			System.out.println("NO SE PUEDE BORRAR LO QUE NO EXISTE");
		}
	}

	/************************** MAIN PRUEBAS ***************************/
	public static void main(String[] args) {	
		// File [] lista = Fichero.listarDir(Fichero.dimeDir());
		// Fichero.printLista(lista);
		// Fichero.crearDir(dimeDir(),EntradaControlada.leerCadena("NOMBRE DEL DIRECTORIO A CREAR: "));
		// Fichero.renombrar(dimeDir(), EntradaControlada.leerCadena("NOMBRE A CAMBIAR: "), EntradaControlada.leerCadena("NUEVO NOMBRE: "));
		// Fichero.eliminar(dimeDir(), EntradaControlada.leerCadena("DIME A QUIEN ME
		// CARGO: "));
		Fichero.listarTodo(dimeDir());
	}
	/********************************************************************/
	
	
}
