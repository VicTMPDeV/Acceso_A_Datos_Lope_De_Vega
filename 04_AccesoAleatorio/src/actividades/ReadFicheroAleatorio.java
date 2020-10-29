/** 
 * CRUD DE FICHERO DE ACCESO ALEATORIO - READ -> LECTURA SECUENCIAL DEL FICHERO. 
 * 
 * Leemos el fichero completo de principio a fin. Lectura secuencial.
 * 
 * @author VICTOR MORALES PEREZ
 */

package actividades;

import java.io.*;

/**
 * CLASE QUE LEE COMPLETO EL FICHERO ALEATORIO GENERADO POR LA CLASE CreateFicheroAleatorio
 * @author Victor
 *
 */
public class ReadFicheroAleatorio {
	
	// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
	public static File fichero = new File("AleatorioEmple.dat");

	public static void readRAF() throws IOException {
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		long tamanyoMaximoFile = file.length();
		// VARIABLES
		int id, departamento, posicion;
		double salario;
		char nombreChars[] = new char[10];
		String nombre;
		posicion = 0; // INDICE PARA EL PUNTERO, VOY A COMENZAR A LEER DESDE EL PRINCIPIO HASTA EL FINAL
		//RECORRO LOS REGISTROS POSICIONANDO EL PUNTERO DE REGISTRO EN REGISTRO
		while (file.getFilePointer() != tamanyoMaximoFile) { // SI HE RECORRIDO TODOS LOS BYTES DEL FICHERO, SALGO (SI MI PUNTERO APUNTA AL ULTIMO BYTE)
			file.seek(posicion); // POSICIONAMOS EL PUNTERO EN LA POSICIÓN 0
			System.out.print("EL PUNTERO APUNTA AL BYTE NUMERO: "+file.getFilePointer()+" ----->\t");
			id = file.readInt(); // LEO EL PRIMER RESGISTRO DE TIPO ENTERO Y LO ASIGNO A LA VARIABLE ID
			// RECORRO UNO A UNO LOS CARACTERES DEL NOMBRE
			for (int i = 0; i < nombreChars.length; i++) {
				nombreChars[i] = file.readChar(); // LOS VOY ALMACENANDO EN EL ARRAY
			}
			nombre = new String(nombreChars); // CONVIERTO EL ARRAY DE CHAR A OBJETO STRING
			departamento = file.readInt(); // OBTENGO DEPARTAMENTO
			salario = file.readDouble(); // OBTENGO SALARIO

			// ESCRIBO POR PANTALLA EL REGISTRO LEIDO
			if (id > 0) { //ESTA ES UNA CONDICIÓN PARA QUE MÁS ADELANTE, NO ME LEA LOS BORRADOS LÓGICOS (LES PONDREMOS COMO ID -1)
				System.out.println("ID: "+id+" \t Nombre: "+nombre.trim()+" \t Departamento: "+departamento+" \t Salario: "+salario);
			}else {
				System.out.println("APUNTANDO A UN REGISTRO BORRADO...\n"); //RETOQUE ESTÉTICO PARA QUE CUANDO EL PUNTERO APUNTE A UN BORRADO, EN CONSOLA SALTE DE LINEA
			}
			// POSICIONO EL PUNTERO AL FINAL DEL REGISTRO LEIDO (CADA REGISTRO OCUPA 36 BYTES) PARA QUE LEA EL SIGUIENTE REGISTRO
			posicion = posicion + 36;
		} // FIN DE WHILE
		System.out.println("EL PUNTERO APUNTA AL BYTE NUMERO: "+file.getFilePointer()+" PARA RECIBIR EL SIGUIENTE REGISTRO \n(Si te fijas en el tamaño del fichero pulsando con el botón derecho en propiedades del fichero, verás que Windows o Linux te dice que su tamaño total es donde se ha quedado el puntero");
		file.close(); // CIERRO FICHERO
	}

	public static void main(String[] args) {
		try {
			System.out.println("LEYENDO FICHERO DESDE: "+fichero.getAbsolutePath()+"\n");
			System.out.println("OPCION LEER FICHERO: \n");
			readRAF(); //LLAMADA AL MÉTODO
		} catch (IOException e) {
			System.out.println("NO SE PUDO LEER EL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}
}