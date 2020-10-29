/* CONSULTA II. 
 * 
 * Haz otro programa Java que muestre los identificadores de los empleados borrados.
 * 
 * @author VICTOR MORALES PEREZ
 *
 */ 

package actividades;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ZFindBorrados { // LEE COMPLETO EL FICHERO ALEATORIO
	// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
	public static File fichero = new File("AleatorioEmple.dat");

	public static void leerBorrados() throws IOException {
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		// VARIABLES
		int id, departamento, posicion;
		double salario;
		char apellidoChars[] = new char[10];
		String apellido;
		posicion = 0; // INDICE PARA EL PUNTERO, VOY A COMENZAR A LEER DESDE EL PRINCIPIO HASTA EL FINAL
		//RECORRO LOS REGISTROS POSICIONANDO EL PUNTERO DE REGISTRO EN REGISTRO
		while (file.getFilePointer() != file.length()) { // SI HE RECORRIDO TODOS LOS BYTES DEL FICHERO, SALGO (SI MI PUNTERO APUNTA AL ULTIMO BYTE)
			file.seek(posicion); // POSICIONAMOS EL PUNTERO EN posicion
			id = file.readInt(); // LEO EL PRIMER RESGISTRO DE TIPO ENTERO Y LO ASIGNO A LA VARIABLE ID
			// RECORRO UNO A UNO LOS CARACTERES DEL APELLIDO
			for (int i = 0; i < apellidoChars.length; i++) {
				apellidoChars[i] = file.readChar(); // LOS VOY ALMACENANDO EN EL ARRAY
			}
			apellido = new String(apellidoChars); // CONVIERTO EL ARRAY DE CHAR A OBJETO STRING
			departamento = file.readInt(); // OBTENGO DEPARTAMENTO
			salario = file.readDouble(); // OBTENGO SALARIO

			// ESCRIBO POR PANTALLA EL REGISTRO LEIDO
			if (id < 0) {
				System.out.println("ID: "+id+" Apellido: "+apellido.trim()+" \tDepartamento: "+departamento+" \tSalario: "+salario);
			}
			// POSICIONO EL PUNTERO AL INICIO DEL SIGUIENTE REGISTRO (cada registro ocupa 36bytes)
			posicion = posicion + 36;
		} // FIN DE WHILE
		file.close(); // CIERRO FICHERO
	}

	public static void main(String[] args) {
		try {
			System.out.println("LEYENDO FICHERO DESDE: "+fichero.getAbsolutePath()+"\n");
			System.out.println("OPCION LEER BORRADOS: \n");
			leerBorrados();
		} catch (IOException e) {
			System.out.println("NO SE PUDO LEER BORRADOS");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}
}


