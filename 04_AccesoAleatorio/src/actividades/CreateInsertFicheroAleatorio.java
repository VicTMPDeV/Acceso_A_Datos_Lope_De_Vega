/** CRUD DE FICHERO DE ACCESO ALEATORIO - CREATE -> INSERCION. 
 * 
 * Crea un programa Java que inserte datos en el fichero aleatorio. 
 * El programa se ejecutará desde la línea de comandos y debe recibir 4 parámetros:  
 * identificador de empleado, nombre, departamento y salario. 
 * Antes de insertar se comprobará si el identificador existe, 
 * en ese caso se debe visualizar un mensaje indicándolo y 
 * si no existe se deberá insertar.
 * 
 * @author VICTOR MORALES PEREZ
 *
 */

package actividades;

import java.io.*;
import utilidades.IntroduceDatos;

public class CreateInsertFicheroAleatorio {

	public static void insertar() throws IOException {
		// DIRECTORIO EN EL QUE SE ENCUENTRA EL FICHERO DE REGISTROS
		File fichero = new File("AleatorioEmple.dat");
		System.out.println("ESCRIBIENDO HACIA: " + fichero.getAbsolutePath() + "\n");
		// DECLARACION DEL FICHERO DE ACCESO ALEATORIO
		RandomAccessFile file = new RandomAccessFile(fichero, "rw"); // CON PERMISO DE LECTURA Y ESCRITURA
		// COMPROBACIONES
		long puntero = 0; 	//CUENTA LOS BYTES DE LA POSICION DEL PUNTERO (0 - 36 - 72 ...)
		int modulo = 36;	//TAMAÑO EN BYTES DE CADA REGISTRO
		int id = 0;	   	//CAMPO ID DEL REGISTRO
		int posicion = 0; 	//CUENTA LA POSICION EN EL REGISTRO (1,2,3...) , NO COMENZANDO DESDE CERO
		
		// SALDRA DEL BUCLE CUANDO ENCUENTRE EL PRIMER REGISTRO BORRADO (id = -1) O CUANDO LLEGUE AL FINAL
		while (id != -1 && id < (file.length() / modulo)) {
			posicion++;
			file.seek(puntero);
			id = file.readInt();
			puntero += modulo;
		}
		
		if (id == -1) {
			puntero -= modulo;	//RETROCEDO AL COMIENZO DEL REGISTRO QUE ME HA DEVUELTO -1 PARA SOBREESCRIBIRLO
			id = posicion; 		//LE ASIGNO EL ID QUE COINCIDE CON LA POSICION, SINO SERÍA ID = -1 , QUE ES SU VALOR ACTUAL
			System.out.println("SE HA ENCONTRADO UN REGISTRO BORRADO EN LA POSICION " + posicion + ", SE SOBREESCRIBIRA\n");
		} else {
			id++;
			System.out.println("SE ESCRIBIRA UN REGISTRO AL FINAL DEL FICHERO, CON ID: " + id + "\n");
		}
		// POSICIONO EL PUNTERO AL COMIENZO DEL REGISTRO INDICADO
		file.seek(puntero);
		// CAMPOS A INSERTAR
		file.writeInt(id);
		String nombre = IntroduceDatos.leerCadena("INTRODUCE EL NOMBRE: ");
		int departamento = IntroduceDatos.leerEntero("INTRODUCE EL NUMERO DE DEPARTAMENTO:");
		double salario = IntroduceDatos.leerDouble("INTRODUCE EL SALARIO: ");
		// ESCRITURA EN FICHERO DEL REGISTRO
		StringBuffer buffer = new StringBuffer(nombre); // RECOJO EL NOMBRE EN EL BUFFER
		buffer.setLength(10); // LO TRUNCO A 10 CARACTERES
		file.writeChars(buffer.toString()); // Y LO PASO A STRING
		file.writeInt(departamento);
		file.writeDouble(salario);
		// RETORNO EL PUNTERO AL INICIO (POR LO QUE PUEDA PASAR)
		file.seek(0);
		// ALMACENO EL VALOR MAXIMO DEL ID EN CASO QUE HAYA AUMENTADO, SI NO AUMENTA
		// SIGUE SIENDO EL MISMO
		System.out.println("REGISTRO: \nID: " + id + " Nombre: " + nombre.trim() + " \tDepartamento: "+ departamento + " \tSalario: " + salario + "\nREGISTRO INSERTADOCORRECTAMENTE");
		// CIERRO EL FICHERO
		file.close();
	}

	public static void main(String[] args) {
		try {
			System.out.println("OPCION INSERTAR REGISTRO: \n");
			insertar();
		} catch (IOException e) {
			System.out.println("NO SE PUDO ACCEDER AL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("\nPROCESO TERMINADO");
		}
	}

}
