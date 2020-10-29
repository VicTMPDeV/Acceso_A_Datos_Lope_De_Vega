/** CRUD DE FICHERO DE ACCESO ALEATORIO - DELETE -> BORRADO DE UN REGISTRO (CUIDADO, VAMOS A HACER UN "BORRADO LÓGICO" PARA NO PERDER DEFINITIVAMENTE LOS DATOS").
 * 
 * Crea un programa Java que reciba un identificador de empleado y lo borre. 
 * Se hará un borrado lógico marcando el registro con la siguiente información: 
 * el identificador será igual a -1, el apellido será igual al identificador que se borra 
 * y el departamento y salario serán 0.
 * 
 * @author VICTOR MORALES PEREZ
 *
 */

package actividades;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteFicheroAleatorio {

	public static void borrar() throws IOException {
		// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
		File fichero = new File("AleatorioEmple.dat");
		System.out.println("LEYENDO DESDE: " + fichero.getAbsolutePath() + "\n");
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		// VARIABLES
		int departamento;
		double salario;
		String apellido;
		int id = -1;
		long puntero = -1;
		long numRegistros = (file.length() / 36);
		// CONDICIONES DE LOGICA FUNCIONAL
		while (puntero < 0) {
			while (id <= 0) {
				id = Teclado.leerEntero("INTRODUCE EL ID A BUSCAR: ");
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
		// ALMACENO EL DATO DEL ANTIGUO ID
		int antiguoID = file.readInt();
		file.seek(puntero);
		id = -1;
		departamento = 0;
		salario = 0;
		// REESCRIBO EL REGISTRO CON LOS DATOS INDICADOS PARA EL BORRADO LOGICO
		file.writeInt(id);
		apellido = Integer.toString(antiguoID);
		file.writeChars(apellido);;
		file.writeInt(departamento);
		file.writeDouble(salario);
		System.out.println("\nREGISTRO CON ID: "+antiguoID+" BORRADO CORRECTAMENTE");
		// RETORNO EL PUNTERO AL INICIO (POR LO QUE PUEDA PASAR)
		file.seek(0);
		// CIERRO EL FLUJO
		file.close();
	}
	public static void main(String[] args) {
		try {
			System.out.println("OPCION BORRAR REGISTRO: \n");
			borrar();
		} catch (Exception e) {
			System.out.println("NO SE PUDO ACCEDER AL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}

	// CLASE INTERNA: FUNCIONALIDAD LECTURA DE DATOS POR TECLADO
	static class Teclado {

		public static Scanner cadena = new Scanner(System.in);
		public static Scanner numero = new Scanner(System.in);

		public static int leerEntero(String mensaje) {
			int numeroLeido = 0;
			boolean exito = false;
			while (!exito) {
				System.out.print(mensaje);
				try {
					numeroLeido = numero.nextInt();
					exito = true;
				} catch (InputMismatchException error) {
					System.out.println("NO HAS INTRODUCIDO UN NUMERO");
					System.out.println("PRUEBA DE NUEVO");
					numero.nextLine(); // VACIAR EL BUFFER
				}
			}
			return numeroLeido;
		}

		public static double leerDouble(String mensaje) {
			double numeroLeido = 0;
			boolean exito = false;
			while (!exito) {
				System.out.print(mensaje);
				try {
					numeroLeido = numero.nextDouble();
					exito = true;
				} catch (InputMismatchException error) {
					System.out.println("NO HAS INTRODUCIDO UN NUMERO");
					System.out.println("PRUEBA DE NUEVO");
					numero.nextLine(); // VACIAR EL BUFFER
				}
			}
			return numeroLeido;
		}

		public static String leerCadena(String mensaje) {
			System.out.print(mensaje);
			String cadenaLeida = cadena.nextLine();
			return cadenaLeida;
		}

	}

}
