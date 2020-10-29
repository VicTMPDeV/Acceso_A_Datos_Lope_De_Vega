package empleados;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//PRIMERO TENDRE QUE SABER DONDE ESTA EL XML QUE QUIERO LEER
		File ficheroXML = new File("C:/Users/msi/Desktop/empleados.xml");
		//Y TENGO QUE TENER UN OBJETO QUE ME REPRESENTE A UN XML
		Document miXML;
		//Y AHORA MONTO TODA LA PARAFERNALIA
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //INSTANCIAMOS UNA FABRICA DE CONSTRUCTORES DE DOCUMENTOS
		DocumentBuilder builder = factory.newDocumentBuilder(); //INSTANCIAMOS UN CONSTRUCTOR DE DOCUMENTOS
		miXML = builder.parse(ficheroXML); //Y LE DECIMOS AL BUILDER QUE NOS TRADUZCA EL XML PARA QUE NOS GENERE UN DOM.
		miXML.getDocumentElement().normalize(); //NORMALIZAMOS EL DOCUMENTO
		
		System.out.println("LA RAIZ DE MI XML ES: "+miXML.getDocumentElement().getNodeName());
		
		NodeList empleados = miXML.getElementsByTagName("Empleado");
		System.out.println("TENEMOS "+empleados.getLength()+ " EMPLEADOS EN EL XML\n");
		//***********************************************************************************************************************************
		System.out.println(empleados.item(1).getChildNodes().item(1).getChildNodes().item(0).getNodeValue()); //CON ESTO SE QUEDAN BOCAS
		//***********************************************************************************************************************************
		for (int i = 0; i < empleados.getLength(); i++) {
			Node empleado = empleados.item(i); //PESCAMOS UN EMPLEADO DEL XML
			if (empleado.getNodeType() == Node.ELEMENT_NODE) {//TIPO DE NODO       
				Element elemento = (Element) empleado; // OBTENEMOS LOS ELEMENTS DEL NODO
				System.out.print(elemento.getElementsByTagName("Nombre").item(0).getNodeName().toUpperCase()+" : "+elemento.getElementsByTagName("Nombre").item(0).getTextContent());
				System.out.print("\t");
				System.out.print(elemento.getElementsByTagName("Apellidos").item(0).getNodeName().toUpperCase()+" : "+elemento.getElementsByTagName("Apellidos").item(0).getTextContent());
				System.out.print("\t");
				System.out.print(elemento.getElementsByTagName("Telefono").item(0).getNodeName().toUpperCase()+" FIJO : "+elemento.getElementsByTagName("Telefono").item(0).getChildNodes().item(1).getTextContent());
				System.out.print("\t");
				System.out.println(elemento.getElementsByTagName("Telefono").item(0).getNodeName().toUpperCase()+" MOVIL : "+elemento.getElementsByTagName("Telefono").item(0).getChildNodes().item(3).getTextContent());
			}
			

		}

	}
	
}
