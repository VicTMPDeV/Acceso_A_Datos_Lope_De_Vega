package jaxb;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LecturaJAXB {

    public static void main(String[] args) throws JAXBException {
    	
    	// COMO VOY A LEER UN XML QUE TENGO EN MI EQUIPO, HACEMOS, COMO SIEMPRE, LO MISMO DE SIEMPRE, DECIRLE DONDE ESTA Y QUE ME CREE UN OBJETO QUE LO REPRESENTE
    	String sep = File.separator;
		File miFichero = new File("C:"+sep+"Users"+sep+"msi"+sep+"Desktop"+sep+"libreria.xml");
		
		// PRIMERO FIJO EL CONTEXTO DE LA APLICACION
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        
        // OBJETO JAVA SOBRE EL QUE QUIERO MAPEAR EL XML
        Libreria libreria = null;
        
        // OBJETO QUE ME PERMITA LEER EL DOCUMENTO XML (PARA PASAR DE XML A JAVA)
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        // ESTO YA ES EL OBJETO POJO CON TODA LA INFORMACIÓN MAPEADA DESDE EL XML 
        libreria = (Libreria) unmarshaller.unmarshal(miFichero);
        
        /*
         * PRUEBAS VARIAS
         */
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(libreria.getNombre().toUpperCase());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        
        ArrayList<Libro> libros = libreria.getLibros();
        
        for(Libro l: libros){
            System.out.println("ISBN: "+l.getIsbn()+"\t|\tTITULO: "+l.getTitulo()+"\t|\tAUTOR: "+l.getAutor());
        }
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }
    
}
