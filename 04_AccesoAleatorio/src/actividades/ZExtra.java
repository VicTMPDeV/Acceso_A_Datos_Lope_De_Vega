/* EXTRA. 
 * 
 * Modifica el ejemplo LeerFichAleatorioUnreg.java 
 * para que nos muestre “x número de empleados”.
 * 
 * @author VICTOR MORALES PEREZ
 *
 */

package actividades;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ZExtra {

	public static void buscarVarios() throws IOException {
		// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
		File fichero = new File("AleatorioEmple.dat");
		System.out.println("LEYENDO DESDE: " + fichero.getAbsolutePath() + "\n");
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		// VARIABLES
		int departamento;
		double salario;
		char apellidoChars[] = new char[10];
		int id;
		long puntero;
		long numRegistros = (file.length() / 36);
		int numEmpleados = 0;
		// CONDICIONES DE LOGICA FUNCIONAL
		do {
			numEmpleados = utilidades.IntroduceDatos.leerEntero("SELECCIONA EL NUMERO DE EMPLEADOS A MOSTRAR: ");
		} while (numEmpleados <= 0 || numEmpleados > numRegistros);
		for (int i = 1 ; i <= numEmpleados ; i++) {
			puntero = -1;
			id = -1;
			while (puntero < 0) {
				while (id <= 0) {
					id = utilidades.IntroduceDatos.leerEntero("\nINTRODUCE EL ID A BUSCAR: ");
					System.out.println();
					if (id <= 0) { // SI NO INTRODUZCO ERRORES FORZADOS...
						System.out.println("INTRODUCE UN NUMERO MAYOR QUE 0");
					}
				}
				puntero = (id - 1) * 36; // INDICE PARA EL PUNTERO (-1 Porque indica posiciones en el Array)
				if (puntero < file.length()) { // SI NO ME SALGO DEL RANGO...
					file.seek(puntero); // POSICIONO EL PUNTERO EN EL INDICE
					int aux = file.readInt();
					if (aux != id) { // COMPRUEBA QUE ID NO ES MAYOR QUE EL ULTIMO NI QUE HA SIDO BORRADO
						System.out.println("EL EMPLEADO CON ID: " + id + " NO EXISTE...");
						puntero = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
						id = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
					}
				} else {
					System.out.println("EL MAXIMO REGISTRO QUE EXISTE ES " + numRegistros);
					puntero = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
					id = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
				}

			}
			// POSICIONO EL PUNTERO AL COMIENZO DEL REGISTRO ENCONTRADO
			file.seek(puntero);
			// COMENZAMOS A LEER EL FICHERO
			id = file.readInt(); // OBTENGO EL ID DEL EMPLEADO
			for (int j = 0; j < apellidoChars.length; j++) {
				apellidoChars[j] = file.readChar();// RECORRO CADA CARACTER Y LO ALMACENO EN UN ARRAY DE CHAR
			}
			String apeString = new String(apellidoChars);// CONVIERTO A STRING EL ARRAY DE CHAR
			departamento = file.readInt();// RECUPERO EL DATO DEPARTAMENTO
			salario = file.readDouble(); // RECUPERO EL DATO SALARIO
			// SALIDA POR CONSOLA
			System.out.println("ID: " + id + ", Apellido: " + apeString.trim() + ", Departamento: " + departamento + ", Salario: " + salario);
		}
		// CERRAR FLUJO
		file.close();
	}

	public static void main(String[] args) {
		try {
			System.out.println("OPCION BUSCAR REGISTRO POR ID: \n");
			buscarVarios();
		} catch (IOException e) {
			System.out.println("NO SE PUDO LEER EL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}// FIN DEL MAIN

}
