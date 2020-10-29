package jaxb;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * CLASE POJO (PLAIN OLD JAVA OBJECT -> Sólo Atributos, Constructores, Getters&Setters...)
 * Es una Clase que genera una ABSTRACCIÓN de la estructura del DOCUMENTO XML para poder 
 * MAPEAR el documento de ESTRUCTURA ARBORESCENTE en OBJETOS.
 * Como la etiqueta <cervezas> genera una sub-estructura de datos, esto en lenguaje de programación
 * apesta a COLECCIÓN (y en Java conocemos varias, entre ellas ArrayList).
 * 
 * @author Victor
 *
 */

@XmlRootElement(name="libreria") //IMPORTANTE QUE name SE LLAME IGUAL QUE EN EL XML
@XmlType(propOrder={"nombre","libros"}) //IMPORTANTE QUE name SE LLAME IGUAL QUE EN EL XML
public class Libreria {
	
	/**
	 * ATRIBUTOS
	 */
    private String nombre;
    private ArrayList<Libro> libros;
    
    /**
	 * FUNCIONALIDADES
	 */
	
	/**
	 * CONSTRUCTOR
	 */

    public Libreria() {
    	this.nombre = "";
    	this.libros = new ArrayList<Libro>();
    }
    
    /**
	 * GETTERS
	 * @return
	 */

    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElementWrapper(name="libros")
    @XmlElement(name="libro")
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    
    /**
	 * SETTERS
	 * @param titulo
	 */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    
}
