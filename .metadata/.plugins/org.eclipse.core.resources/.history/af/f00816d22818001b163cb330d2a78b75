package transform;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformAlumnos {

	public static void main(String[] args) {

		try {
			File miXml = new File("C:\\Users\\msi\\Desktop\\PROGRAMACION_CLASES_ACCESO_A_DATOS\\ACCESO_A_DATOS\\WORKSPACE_CLASE\\07_Transform_Html_Example\\src\\data\\alumnos.xml");
			File miXsl = new File("C:\\Users\\msi\\Desktop\\PROGRAMACION_CLASES_ACCESO_A_DATOS\\ACCESO_A_DATOS\\WORKSPACE_CLASE\\07_Transform_Html_Example\\src\\data\\alumnosPlantilla.xsl");
			File miHtml = new File("C:\\Users\\msi\\Desktop\\PROGRAMACION_CLASES_ACCESO_A_DATOS\\ACCESO_A_DATOS\\WORKSPACE_CLASE\\07_Transform_Html_Example\\src\\data\\alumnos.html");

			StreamSource ssXml = new StreamSource(miXml);
			StreamSource ssXsl = new StreamSource(miXsl);
			StreamResult srHtml = new StreamResult(miHtml);

			TransformerFactory tfF = TransformerFactory.newInstance();
			Transformer tf = tfF.newTransformer(ssXsl);
			tf.transform(ssXml, srHtml);
			
			System.out.println("Transformación Completada");
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
