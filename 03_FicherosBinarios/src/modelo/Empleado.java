package modelo;

import java.io.Serializable;

/**
 * CLASE EMPLEADO
 * 
 * Es una Clase POJO (Plain Old Java Object), que en cristiano quiere decir 
 * Clase simple que sólo define modelos de datos y el acceso a los mismos 
 * (atributos, constructores, getters y setters)
 * Implementa la interfaz Serializable, que permite hacer ....
 * 
 * @author Victor
 *
 */

public class Empleado implements Serializable {
	
	/**
	 * ATRIBUTOS
	 */
	
	private String nombre;
	private String apellidos;
	private int edad;
	private double salario;
	
	/**
	 * FUNCIONALIDAD - CONSTRUCTORES
	 */
	
	public Empleado() {
		/*ESTE CONSTRUCTOR POR DEFECTO INICIALIZA LOS 
		 * ATRIBUTOS A LOS VALORES POR DEFECTO QUE USA JAVA 
		 * MÁS INFO --> http://www.softwero.com/2012/12/valores-por-defecto-y-rango-de.html*/
	}
	
	public Empleado(String nombre, String apellidos, int edad, double salario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.salario = salario;
	}
	
	/**
	 * FUNCIONALIDAD - GETTERS Y SETTERS
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * FUNCIONALIDAD - TO STRING
	 */

	@Override
	public String toString() {
		return "NOMBRE : " + nombre + "\t|\tAPELLIDOS : " + apellidos + "\t|\tEDAD : " + edad + "\t|\tSALARIO : " + salario + " €\n";
	}

}
