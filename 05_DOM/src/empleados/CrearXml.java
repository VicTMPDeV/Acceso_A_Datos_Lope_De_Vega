package empleados;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearXml {
	
	public static void main(String args[]) throws IOException, TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException{

		Document document; //OBJETO QUE REPRESENTA TODO EL XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //INSTANCIAMOS UNA FABRICA DE CONSTRUCTORES DE DOCUMENTOS
		DocumentBuilder builder = factory.newDocumentBuilder(); //INSTANCIAMOS UN CONSTRUCTOR DE DOCUMENTOS
		document = builder.newDocument(); 
		//CREO EL NODO RAIZ
		Element alumnos = document.createElement("listadealumnos"); 
		document.appendChild(alumnos); 
		
		//CREO EL PRIMER NODO HIJO
		Element alumno = document.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("id", "1");
		//CREO EL PRIMER NODO NIETO
		Element nombre = document.createElement("nombre");
		nombre.appendChild(document.createTextNode("Victor"));
		alumno.appendChild(nombre);
		//CREO EL SEGUNDO NODO NIETO (SIBLING (HERMANO) DEL PRIMER NODO NIETO)
		Element edad = document.createElement("edad");
		edad.appendChild(document.createTextNode("34"));
		alumno.appendChild(edad);
	
		//CREO EL SEGUNDO NODO HIJO
		alumno = document.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("id", "2");
		//CREO EL PRIMER NODO NIETO DEL SEGUNDO NODO HIJO
		nombre = document.createElement("nombre");
		nombre.appendChild(document.createTextNode("Fermin"));
		alumno.appendChild(nombre);
		//CREO EL SEGUNDO NODO NIETO (SIBLING (HERMANO) DEL PRIMER NODO NIETO)
		edad = document.createElement("edad");
		edad.appendChild(document.createTextNode("25"));
		alumno.appendChild(edad);
		
		//GENERAR EL XML
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transformer = factoria.newTransformer(); // OBJETO QUE ME TRANSFORMA UN DOM A UN XML
		Source source = new DOMSource(document); // FUENTE DE DATOS DONDE ESTA EL DOM
		File fichero = new File("C:/Users/msi/Desktop/alumnos.xml"); //LE DIGO AL PROGRAMA EN QUÉ RUTA QUIERO ESCRIBIR EL XML
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter pw = new BufferedWriter(fw);
		//PrintWriter pw = new PrintWriter(fw);
		Result result = new StreamResult(fw); // OBJETO QUE DA COMO RESULTADO UN FICHERO XML
		transformer.transform(source, result); // VOLCAMOS TODO EL DOM A UN ARCHIVO XML
		
		System.out.println("ARCHIVO XML CREADO");
		
	}// FIN DEL MAIN

}// FIN DE LA CLASE
