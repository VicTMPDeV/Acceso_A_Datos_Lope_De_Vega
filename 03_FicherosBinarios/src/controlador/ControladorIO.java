package controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Empleado;

public class ControladorIO {
	
	/**
	 * ATRIBUTOS
	 */
	public static File fichero = new File("Empleados.dat");//	DECLARAMOS DONDE VA A ESTAR EL FICHERO, EN ESTE CASO, EN MI CARPETA DE PROYECTO, Y DE NOMBRE Empleados.dat
	
	/**
	 * FUNCIONALIDADES
	 * @throws IOException 
	 */
	public static void escribeFicheroObjetos(ArrayList<Empleado> listado) throws IOException {
		//PROGRAMANDO BIEN NO HACE FALTA CUAJAR EL C�DIGO CON TRY-CATCH
		if(!fichero.exists()) {
			System.out.println("EL FICHERO "+fichero.getAbsolutePath()+" NO EXISTE, ��VAMOS A CREARLO HOMBRE!!");
			fichero.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(fichero,true); //CREAMOS UN STREAM (FLUJO) DE SALIDA PARA ESCRIBIR DEL PROGRAMA AL FICHERO DE ALMACENAMIENTO
		MiObjectOutputStream oos = new MiObjectOutputStream(fos); //CONECTAMOS EL FLUJO DE BYTES (fos) AL FLUJO DE OBJETOS (oos) PARA CONVERTIR LOS DATOS EN BYTES
		System.out.println("SE VA A PROCEDER A GRABAR LOS OBJETOS EN EL DISCO");
		for (Empleado e : listado) {
			oos.writeObject(e); //ESCRIBO EL OBJETO DE LA LISTA PASADA POR PAR�METROS EN EL FICHERO
		}
		System.out.println("DATOS GRABADOS CORRECTAMENTE");
		oos.close(); //CERRAMOS EL STREAM DE ESCRITURA
		fos.close(); //CERRAMOS EL STREAM DE LECTURA

	}

	public static ArrayList<Empleado> leerFicheroObjetos() throws IOException, ClassNotFoundException{

		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>(); //ARRAYLIST DONDE GUARDAREMOS LOS DATOS LEIDOS DEL FICHERO
		
		if(!fichero.exists()) {
			System.out.println("EL FICHERO "+fichero.getAbsolutePath()+" NO EXISTE");
		}else if(!fichero.canRead()) {
			System.out.println("EL FICHERO "+fichero.getName()+" NO TIENE PERMISOS DE LECTURA");
		}else {
			FileInputStream fis = new FileInputStream(fichero); //CREAMOS UN STREAM (FLUJO) DE ENTRADA PARA LEER DESDE EL FICHERO DE ALMACENAMIENTO HACIA EL PROGRAMA
			MiObjectInputStream ois  = new MiObjectInputStream(fis); //CONECTAMOS EL FLUJO DE BYTES (fis) AL FLUJO DE OBJETOS (ois) PARA CONVERTIR LOS DATOS EN BYTES
			System.out.println("SE VA A PROCEDER A LEER LOS OBJETOS DEL DISCO");
			try{
				while(true) { //LEYENDO EL FICHERO
					Empleado empleado = (Empleado) ois.readObject(); //LEO UN OBJETO GEN�RICO (Clase Object) Y LO CASTEO A MI TIPO PARTICULAR DE OBJETO
					listaEmpleados.add(empleado);
				}
			}catch (EOFException eo) {
				System.out.println("FIN DEL FICHERO ALCANZADO");
			}
			ois.close(); //CERRAMOS EL STREAM DE LECTURA
			fis.close(); //CERRAMOS EL STREAM DE BYTES	
		}
		return listaEmpleados;
	}


}
