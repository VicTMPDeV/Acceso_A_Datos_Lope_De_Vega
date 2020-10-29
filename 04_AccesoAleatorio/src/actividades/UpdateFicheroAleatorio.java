/** CRUD DE FICHERO DE ACCESO ALEATORIO - UPDATE -> ACTUALIZAR UN REGISTRO CONCRETO EXISTENTE. 
 * 
 * Crea un programa java que reciba desde la línea de comandos un identificador de empleado y un importe.
 * Se debe realizar la modificación del salario. 
 * La modificación consistirá en sumar el salario del empleado al importe introducido. 
 * El programa debe visualizar el nombre, el salario antiguo y el nuevo. 
 * Si el identificador no existe se visualizarámensaje indicándolo.
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

public class UpdateFicheroAleatorio {

	public static void modificar() throws IOException {
		// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
		File fichero = new File("AleatorioEmple.dat");
		System.out.println("LEYENDO DESDE: " + fichero.getAbsolutePath() + "\n");
		// DECLARA EL FICHERO DE ACCESO ALEATORIO, SOLO CON PERMISO DE LECTURA
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		// VARIABLES
		double salario; // SALARIO ORIGINAL
		double incremento; // INCREMENTO DE SALARIO
		double salarioNuevo; // NUEVO SALARIO
		char nombreChars[] = new char[10];
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
		// ESCRIBIMOS EN LOS CAMPOS DEL REGISTRO, POSICIONANDO EL PUNTERO EN EL LUGAR ESPECIFICO
		puntero += 4; //LO POSICIONO PARA ALMACENAR EL NOMBRE
		file.seek(puntero);
		for (int i = 0; i < nombreChars.length; i++) {
			nombreChars[i] = file.readChar();// RECORRO CADA CARACTER Y LO ALMACENO EN UN ARRAY DE CHAR
		}
		String apeString = new String(nombreChars);// ALMACENO EN UN STRING EL ARRAY DE CHAR
		puntero += (20+4); //LO POSICIONO AL COMIENZO DEL CAMPO SALARIO
		file.seek(puntero);
		// RECUPERO EL DATO SALARIO ANTIGUO
		salario = file.readDouble();
		// LEO POR TECLADO EL AUMENTO DE SALARIO
		incremento = Teclado.leerDouble("INTRODUCE EL AUMENTO DE SALARIO: ");
		salarioNuevo = salario + incremento;
		file.seek(puntero);
		file.writeDouble(salarioNuevo); // SOBREESCRIBO EL DATO EXISTENTE
		file.seek(0);
		// VISUALIZO POR CONSOLA LOS DATOS MODIFICADOS Y EL ANTIGUO
		System.out.println("Nombre: " + apeString.trim() + ", Salario Antiguo: " + salario+", Salario Nuevo: "+salarioNuevo);
		// CIERRO EL FICHERO DE ACCESO ALEATORIO
		file.close();
	}

	public static void main(String[] args) {
		try {
			System.out.println("OPCION MODIFICAR REGISTRO: \n");
			modificar();
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
