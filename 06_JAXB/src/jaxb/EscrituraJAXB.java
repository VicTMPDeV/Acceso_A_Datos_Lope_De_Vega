package jaxb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EscrituraJAXB {
	
	public static void main(String[] args) throws JAXBException, IOException {
		
		// COMO VOY A ESCRIBIR EN UN XML QUE TENGO EN MI EQUIPO, HACEMOS, COMO SIEMPRE, LO MISMO DE SIEMPRE, DECIRLE DONDE ESTA Y QUE ME CREE UN OBJETO QUE LO REPRESENTE
    	String sep = File.separator;
		File miFichero = new File("C:"+sep+"Users"+sep+"msi"+sep+"Desktop"+sep+"libreria.xml");
		// TAMBI�N NECESITAR� UN OBJETO PARA ESCRIBIR
		FileWriter fw = new FileWriter(miFichero,true);
		
		// PRIMERO FIJO EL CONTEXTO DE LA APLICACION
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        
        // OBJETO JAVA SOBRE EL QUE QUIERO MAPEAR EL XML
        // AHORA LA DIFERENCIA ES QUE INSTANCIO EL OBJETO JAVA CON LOS DATOS QUE YO QUIERA
        // USANDO EL CONSTRUCTOR Y POSTERIORMENTE LO ESCRIBIR� EN EL FICHERO
        Libreria libreria = new Libreria();
        libreria.setNombre("LIBRERIA EROTICA");
        ArrayList<Libro> libros = new ArrayList<Libro>();
        Libro l1 = new Libro();
        l1.setIsbn("69696969696969");
        l1.setAutor("Nacho Vidal");
        l1.setTitulo("Si no soy Curro Jimenez, por que tengo este trabuco?");
        libros.add(l1);
        libreria.setLibros(libros);
        // OBJETO QUE ME PERMITA ESRIBIR EL DOCUMENTO XML (PARA PASAR DE XML A JAVA)
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(l1, fw);
        System.out.println("FICHERO SOBREESCRITO");
        
	}

}
