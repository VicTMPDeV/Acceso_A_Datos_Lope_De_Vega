package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * CLASE POJO (PLAIN OLD JAVA OBJECT -> S�lo Atributos, Constructores,
 * Getters&Setters...) Es una Clase que genera una ABSTRACCI�N de la
 * sub-estructura generada en el DOCUMENTO XML a partir de la etiqueta
 * <cervezas>. Como la etiqueta genera una sub-estructura de datos, esto en
 * lenguaje de programaci�n apesta a COLECCI�N (y en Java conocemos varias,
 * entre ellas ArrayList).
 * 
 * Por tanto, esta clase, mapea esta sub-estructura, tratando cada etiqueta
 * <cervezas> como otro OBJETO distinto, que estar� almacenado dentro de la
 * colecci�n de la otra Clase POJO (CerveceriaPOJO).
 * 
 * @author Victor
 *
 */

@XmlRootElement(name = "libro")
@XmlType(propOrder = { "isbn", "titulo", "autor" })
public class Libro {

	/**
	 * ATRIBUTOS
	 */
	private String isbn;
	private String titulo;
	private String autor;

	/**
	 * FUNCIONALIDADES
	 */

	/**
	 * CONSTRUCTOR
	 */
	public Libro() {}

	/**
	 * GETTERS
	 * @return
	 */

	@XmlAttribute(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	@XmlElement(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	@XmlElement(name = "autor")
	public String getAutor() {
		return autor;
	}

	/**
	 * SETTERS
	 * @return
	 */
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
