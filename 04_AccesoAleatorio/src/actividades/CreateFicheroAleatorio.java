/** 
 * CRUD DE FICHERO DE ACCESO ALEATORIO - CREATE -> CREACIÓN DEL FICHERO. 
 * 
 * Generamos el fichero de acceso aleatorio para comenzar a trabajar con el, introduciendo datos de prueba.
 * 
 * @author VICTOR MORALES PEREZ
 */

package actividades;

import java.io.*;

public class CreateFicheroAleatorio { // ESCRIBE TODO EL FICHERO ALEATORIO
	
	/*DECLARO UN OBJETO DE TIPO FILE
	 * ESTE OBJETO REPRESENTA LA RUTA DONDE EL FICHERO SERÁ CREADO (SI NO ESPECIFICO RUTA CONCRETA
	 * COGE LA DE LA CARPETA DE PROYECTO) ASÍ COMO EL NOMBRE DEL PROPIO FICHERO EN SÍ
	 */
	public static File fichero = new File("AleatorioEmple.dat"); //AL FINAL VEREMOS POR QUÉ LO DECLARAMOS Y LO INSTANCIAMOS AQUÍ FUERA

	/**
	 * METODO PARA CREAR (ESCRIBIR) EL FICHERO DE ACCESO ALEATORIO
	 * NO DEVUELVE NINGÚN OBJETO NI NINGUN VALOR PRIMITIVO, SOLO CREA EL FICHERO
	 * @throws IOException
	 */
	public static void writeRAF() throws IOException {
		// DECLARACION DEL FICHERO DE ACCESO ALEATORIO
		RandomAccessFile miFicheroAleatorio = new RandomAccessFile(fichero, "rw"); // CON PERMISO DE LECTURA Y ESCRITURA
		// ARRAYS DE DATOS
		int id[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String nombre[]= {"IGNACIO","VICTOR","FERMIN","FELIPE JUAN FROILAN","BORJA MARI","ALVARO","JUANJO","BENEDICTO","FRANCISCA","DOLORES"};
		int departamento[]= {10, 20, 10, 20, 10, 30, 20, 30, 30, 30};
		double salario[] = {1000.45, 2400.60, 600, 500, 300, 1050.15, 2000.0, 1250.25, 1875.30, 1100.50};
		int registros = id.length; //VARIABLE CONTADORA DE REGISTROS (NO ES NECESARIA REALMENTE, PERO ASÍ EN LOS BUCLES ME AHORRO PONER id.lenght, o nombre.lenght...)
		
		StringBuffer buffer = null;// BUFFER PARA ALMACENAR EL NOMBRE CARACTER A CARACTER Y POSTERIORMENTE TRUNCARLO A 10
		
		// RECORRO LOS ARRAYS DE DATOS Y LOS VOY ESCRIBIENDO EN EL FICHERO
		for (int i = 0; i < registros; i++) {
			//ESCRIBO EL ID
			miFicheroAleatorio.writeInt(id[i]); //32 bits = 4 BYTES (CADA 8 bits ES 1 BYTE)
			//PREPARO EL STRING PARA ESCRIBIRLO COMO CADENA DE CARACTERES
			buffer = new StringBuffer(nombre[i]); // RECOJO EL NOMBRE EN EL BUFFER
			buffer.setLength(10); // Y LO TRUNCO A 10 CARACTERES PARA QUE NO ME PASE DE 36 BYTES EN TOTAL DE REGISTRO (CADA CARACTER SON 2 BYTES PORQUE LA CLASE STRING UTILIZA POR DEFECTO CODIFICACIÓN UTF-16)
			miFicheroAleatorio.writeChars(buffer.toString());// AHORA QUE YA SE SEGURO QUE SON 10 CARACTERES (20 BYTES), LO PASO A STRING Y LO ALMACENO
			//ESCRIBO EL NUMERO DE DEPARTAMENTO
			miFicheroAleatorio.writeInt(departamento[i]); // INSERTO SU DEPARTAMENTO, OTROS 4 BYTES
			//ESCRIBO EL SALARIO, OJO QUE ES UN DOUBLE
			miFicheroAleatorio.writeDouble(salario[i]);// INSERTO SU SALARIO, UN DOUBLE SON 8 BYTES
		}
		miFicheroAleatorio.close(); // CIERRO EL STREAM DE ESCRITURA QUE AUTOMATICAMENTE ABRE LA CLASE RandomAccessFile (USANDO OTRAS CLASES TENEMOS QUE MANEJAR NOSOTROS LOS STREAMS, RECORDAD QUE YA LO VIMOS).
	}

	public static void main(String[] args) {
		try {
			System.out.println("GENERANDO FICHERO... \n");
			writeRAF(); //LLAMADA AL MÉTODO
			System.out.println("FICHERO CREADO CORRECTAMENTE EN " + fichero.getAbsolutePath()+"\n"); //ESTO ES DECORATIVO, SI NO LO HUBIERAMOS ISNTANCIADO FUERA DEL MÉTODO, NO TENDRÍAMOS AQUÍ LA VISIBILIDAD DE ESTE ATRIBUTO.
		} catch (IOException e) {
			System.out.println("NO SE PUDO ESCRIBIR EL FICHERO");
			e.printStackTrace();
		} finally {
			System.out.println("PROCESO TERMINADO");
		}
	}
}