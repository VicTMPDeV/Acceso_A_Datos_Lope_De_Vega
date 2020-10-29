/**
 * @author VICTOR MORALES PEREZ
 */

package actividades;

import java.io.UnsupportedEncodingException;

public class ContadorDeBytes {

	/**
	 * ESTA CLASE ES UN EJEMPLITO A TITULO INFORMATIVO PARA QUE VEÁIS A QUE NOS REFERIMOS CUANDO HABLAMOS DE 
	 * TIPOS DE CODIFICACION DE CARACTERES, QUE NO SON MÁS QUE ESTÁNDARES RECONOCIDOS POR DIVERSOS ORGANISMOS
	 * DE CONTROL A NIVEL NACIONAL/INTERNACIONAL QUE ESTABLECE FORMAS DE ALMACENAR LOS CARACTERES A NIVEL COMPUTACIONAL
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// The input string for this test
			String texto = "Hello World";
			// Check length, in characters
			System.out.println("La cadena de texto tiene "+texto.length()+" caracteres"); // prints "11"
			// Check encoded sizes
			final byte[] utf8Bytes = texto.getBytes("UTF-8");
			System.out.println(texto+", en codificación UTF-8 tiene "+utf8Bytes.length+" Bytes"); // prints "11"

			final byte[] utf16Bytes= texto.getBytes("UTF-16");
			System.out.println(texto+", en codificación UTF-16 tiene "+utf16Bytes.length+" Bytes"); // prints "24"

			final byte[] utf32Bytes = texto.getBytes("UTF-32");
			System.out.println(texto+", en codificación UTF-32 tiene "+utf32Bytes.length+" Bytes"); // prints "44"

			final byte[] isoBytes = texto.getBytes("ISO-8859-1");
			System.out.println(texto+", en codificación UTF-32 tiene "+isoBytes.length+" Bytes"); // prints "11"

			final byte[] winBytes = texto.getBytes("CP1252");
			System.out.println(texto+", en codificación UTF-32 tiene "+winBytes.length+" Bytes"); // prints "11"
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
