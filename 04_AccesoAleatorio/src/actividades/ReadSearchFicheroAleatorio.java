/** CRUD DE FICHERO DE ACCESO ALEATORIO - READ -> CONSULTA CONCRETA - ACCESO ALEATORIO AL FICHERO.  
 * 
 * Crea un programa Java que consulte los datos de un empleado del fichero aleatorio. 
 * El programa se ejecutará desde la línea de comandos y debe recibir un identificador 
 * de empleado Si el empleado existe se visualizarán sus datos, si no existe se visualizará 
 * un mensaje indicándolo
 * 
 * 
 * @author VICTOR MORALES PEREZ
 */

package actividades;

import java.io.*;
import utilidades.IntroduceDatos; //IMPORTAMOS NUESTRA CLASE DE UTILIDADES

public class ReadSearchFicheroAleatorio {
	
	public static void buscarPorId() throws IOException {
		// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
		File fichero = new File("AleatorioEmple.dat");
		System.out.println("LEYENDO DESDE: "+fichero.getAbsolutePath()+"\n");
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		// VARIABLES
		int departamento;
		double salario;
		char nombreChars[] = new char[10];
		int id = -1;
		long puntero = -1;
		long numRegistros = (file.length()/36);
		// CONDICIONES DE LOGICA FUNCIONAL
		while (puntero < 0) {
			while (id <= 0) {
				id = IntroduceDatos.leerEntero("INTRODUCE EL ID A BUSCAR: "); //HACEMOS USO DE NUESTRA CLASE DE UTILIDADES
				System.out.println();
				if (id <= 0) { //SI NO INTRODUZCO ERRORES FORZADOS...
					System.out.println("INTRODUCE UN NUMERO MAYOR QUE 0");
				}
			}
			puntero = (id - 1) * 36; // INDICE PARA EL PUNTERO (-1 PORQUE INDICA POSICIONES EN UN ARRAY Y SIEMPRE ES UNO MENOS PORQUE EMPIEZA POR CERO, SI NO LO RESTARAMOS LEERÍA EL SIGUIENTE REGISTRO, NO EL QUE QUEREMOS)
			if(puntero < file.length()) { //SI NO ME SALGO DEL TOTAL DEL FICHERO QUE HE ALMACENADO ANTES...
				file.seek(puntero); // POSICIONO EL PUNTERO EN EL INDICE
				int aux = file.readInt();
				if (aux != id) { // COMPRUEBA QUE ID NO ES MAYOR QUE EL ULTIMO NI QUE HA SIDO BORRADO
						System.out.println("EL EMPLEADO CON ID: " + id + " NO EXISTE...");
						puntero = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
						id = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
				}
			}else {
				System.out.println("EL MAXIMO REGISTRO QUE EXISTE ES "+numRegistros);
				puntero = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
				id = -1; // LE FUERZO PARA QUE VUELVA A PEDIR LOS DATOS
			}
		}
		// POSICIONO EL PUNTERO AL COMIENZO DEL REGISTRO ENCONTRADO
		file.seek(puntero);
		// COMENZAMOS A LEER EL FICHERO
		id = file.readInt(); // OBTENGO EL ID DEL EMPLEADO
		for (int i = 0; i < nombreChars.length; i++) {
			nombreChars[i] = file.readChar();// RECORRO CADA CARACTER Y LO ALMACENO EN UN ARRAY DE CHAR
		}
		String apeString = new String(nombreChars);// CONVIERTO A STRING EL ARRAY DE CHAR
		departamento = file.readInt();// RECUPERO EL DATO DEPARTAMENTO
		salario = file.readDouble(); // RECUPERO EL DATO SALARIO
		// SALIDA POR CONSOLA
		System.out.println("ID: " + id + " | Nombre: " + apeString + " | Departamento: " + departamento + " | Salario: " + salario);
		// CERRAR FLUJO
		file.close();
	}

	public static void main(String[] args) {
		try {
			System.out.println("OPCION BUSCAR REGISTRO POR ID: \n");
			buscarPorId();
		} catch (IOException e) {
			System.out.println("NO SE PUDO LEER EL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}// FIN DEL MAIN

}