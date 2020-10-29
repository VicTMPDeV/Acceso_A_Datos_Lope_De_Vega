package xmldom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class JavaDOM {

	public Document doc; // ESTE OBJETO REPRESENTA TODO EL DOCUMENTO XML
	
	// FUNCIONALIDADES

		public void CrearNodo(Node padre, String nombreNodo, String valor) {

			Node nuevoNodo = padre.getOwnerDocument().createElement(nombreNodo);
			Node valorNodo = padre.getOwnerDocument().createTextNode(valor);

			nuevoNodo.appendChild(valorNodo);
			padre.appendChild(nuevoNodo);

		}

		public void guardarDOMcomoFILE(Document xmlDocument) { // Le pasamos la instancia de la variable doc

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer;
			try {
				transformer = tf.newTransformer();
				FileOutputStream outStream = new FileOutputStream(new File("D:\\ECLIPSE\\WORKSPACE\\Java+DOM\\src\\empleados.xml"));
				transformer.transform(new DOMSource(xmlDocument), new StreamResult(outStream));
			} catch (TransformerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public int abrir_XML_DOM(File fichero) {

			doc = null;

			try {
				// Se crea un objeto DocumentBuilderFactory
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				// Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML
				factory.setIgnoringComments(true);

				// Ignora los espacios en blanco que tenga el documento
				factory.setIgnoringElementContentWhitespace(true);

				// Se crea un objeto DocumentBuilder para cargar en él la estructura del árbol
				// DOM a partir del XML seleccionado
				DocumentBuilder builder = factory.newDocumentBuilder();

				// Interpreta (parsea) el documento XML (file) y genera el DOM equivalente
				doc = builder.parse(fichero);

				return 1;

			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}

		}
	
	

	public static void main(String args[]) {

		JavaDOM fichero = new JavaDOM();

		if (fichero.abrir_XML_DOM(new File(".")) == 1) {

			NodeList lista = fichero.doc.getElementsByTagName("EMPLEADO");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("ME POSICIONO EN EL PRIMER NODO DEL ELEMENTO COGIDO POR NOMBRE DE ETIQUETA EMPLEADO:");
			System.out.println("PRIMER NODO EMPLEADO: " + lista.item(0));
			System.out.println("NOMBRE DEL NODO: " + lista.item(0).getNodeName());
			System.out.println("VALOR DEL NODO: " + lista.item(0).getNodeValue());
			System.out.println("TIPO DE NODO: " + lista.item(0).getNodeType());
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("ME POSICIONO EN EL PRIMER HIJO DEL PRIMER NODO EMPLEADO EN EL QUE ESTABA ANTES:");
			System.out.println("NOMBRE DEL NODO HIJO 1: " + lista.item(0).getChildNodes().item(0).getNodeName());
			System.out.println("VALOR DEL NODO HIJO 1: " + lista.item(0).getChildNodes().item(0).getNodeValue()+ "...COMO VEMOS ES UN RETORNO DE CARRO");
			System.out.println("EL TIPO DE UN RETORNO DE CARRO ES... " + lista.item(0).getChildNodes().item(0).getNodeType());
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("ME POSICIONO EN EL SEGUNDO HIJO DEL PRIMER NODO EMPLEADO EN EL QUE ESTABA ANTES:");
			System.out.println("NOMBRE DEL NODO HIJO 2: " + lista.item(0).getChildNodes().item(3).getNodeName());
			System.out.println("VALOR DEL NODO HIJO 2: " + lista.item(0).getChildNodes().item(1).getNodeValue());
			System.out.println("TIPO DE NODO HIJO 2: " + lista.item(1).getChildNodes().item(1).getNodeType());
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("ME POSICIONO EN EL HIJO, DEL SEGUNDO HIJO DEL PRIMER NODO EMPLEADO EN EL QUE ESTABA AL COMIENZO:");
			System.out.println("NOMBRE DEL NODO HIJO DEL HIJO 2: "+ lista.item(0).getChildNodes().item(1).getChildNodes().item(0).getNodeName());
			System.out.println("VALOR DEL NODO HIJO DEL HIJO 2: "+ lista.item(0).getChildNodes().item(1).getChildNodes().item(0).getNodeValue());
			System.out.println("TIPO DE NODO HIJO DEL HIJO 2: "+ lista.item(1).getChildNodes().item(1).getChildNodes().item(0).getNodeType());
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("PUEDO AHORRAR LÍNEAS DE CÓDIGO (pero gastar memoria) CREANDO UN OBJETO NODO QUE ME SIRVA PARA REFERENCIAR lista.item(0) Y OTRA LISTA CON SUS NODOS HIJO");
			Node primerEmpleado = lista.item(0);
			NodeList datos = primerEmpleado.getChildNodes();

			for (int i = 0; i < datos.getLength(); i++) {

				if (datos.item(i).getNodeType() == Node.ELEMENT_NODE) {

					System.out.println(datos.item(i).getNodeName());
					System.out.println(datos.item(i).getChildNodes().item(0).getNodeValue() + "\n"); // Cuidado con el item(0)

					if (datos.item(i).getNodeName() == "SALARIO") {
						int salario = Integer.parseInt(datos.item(i).getChildNodes().item(0).getNodeValue());
						salario = salario + 500;
						datos.item(i).getChildNodes().item(0).setNodeValue(Integer.toString(salario)); 
					}

				}

				// aqui añadimos un nuevo nodo al primer empleado.
				// fichero.CrearNodo(primerEmpleado, "SALARIO", "1000");
				fichero.guardarDOMcomoFILE(fichero.doc);
			}
		}
	}

	

}