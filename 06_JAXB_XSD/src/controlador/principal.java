package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelo.DatosArtic;
import modelo.ObjectFactory;
import modelo.Ventas;
import modelo.VentasType;

public class principal {

	public static void main(String[] args) {

		//METODO PARA VER TODO EL XML POR CONSOLA CON SU ESTRUCTURA EN ARBOL
		//visualizarXml();
		//METODO PARA OBTENER DATOS DE LA LECTURA DEL XML EN FORMA DE OBJETOS
		//leerXml();
		// M�todo para a�adir una venta, recibe el n�mero de venta, las unidades, el nombre cliente, la fecha
		// Comprobar que el n�mero de venta no exista
		insertarVenta(10, "JOSE LUIS", 100000, "16-12-2020");

	}

	public static void visualizarXml() {

		try {
			// COMO VOY A LEER UN XML QUE TENGO EN MI EQUIPO, HACEMOS, COMO SIEMPRE, LO
			// MISMO DE SIEMPRE, DECIRLE DONDE ESTA Y QUE ME CREE UN OBJETO QUE LO
			// REPRESENTE
			File miFichero = new File("./ventasarticulos.xml");

			// PRIMERO FIJO EL CONTEXTO DE LA APLICACION
			JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			// Crear un objeto de tipo Unmarshaller para convertir datos XML en un �rbol de
			// objetos Java
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML en este
			// caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(miFichero);

			// Visualizo el documento
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			File miFichero2 = new File("./resultado.xml");
			FileWriter fw = new FileWriter(miFichero2,true);
			marshaller.marshal(jaxbElement, System.out); // PORQUE SOLO QUIERO MOSTRARLO POR PANTALLA

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leerXml() {

		try {
			// COMO VOY A LEER UN XML QUE TENGO EN MI EQUIPO, HACEMOS, COMO SIEMPRE, LO
			// MISMO DE SIEMPRE, DECIRLE DONDE ESTA Y QUE ME CREE UN OBJETO QUE LO
			// REPRESENTE
			File miFichero = new File("./ventasarticulos.xml");
			// PRIMERO FIJO EL CONTEXTO DE LA APLICACION
			JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			// Crear un objeto de tipo Unmarshaller para convertir datos XML en objetos Java
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML en este
			// caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(miFichero);

			// Si queremos operar con el documento obtenemos los objetos del jaxbElement
			// El m�todo getValue() retorna el modelo de contenido (content model) y el
			// valor de los atributos del elemento
			VentasType miventa = (VentasType) jaxbElement.getValue();
			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// ALMACENAMOS LAS VENTAS EN LA LISTA
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();
			
			// Datos del art�culo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();

			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Stock art: " + miartic.getCodigo());
			System.out.println("Ventas  del art�culo , hay: " + listaVentas.size());

			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);
				System.out.println("N�mero de venta: " + ve.getNumventa() + ". Nombre cliente: " + ve.getNombrecliente()
						+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
				
			}
			System.out.println("HAY UN TOTAL DE: "+listaVentas.size()+" VENTAS");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertarVenta(int numVenta, String nomCli, int uni, String fecha) {

		try {

			// COMO VOY A LEER UN XML QUE TENGO EN MI EQUIPO, HACEMOS, COMO SIEMPRE, LO
			// MISMO DE SIEMPRE, DECIRLE DONDE ESTA Y QUE ME CREE UN OBJETO QUE LO
			// REPRESENTE
			File miFichero = new File("./ventasarticulos.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(miFichero);

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el n�mero de venta, reccorriendo el arraylist
			boolean existe = false; // false si no existe, true si existe
			
			int i = 0;
			
			
			while(!existe && i < listaVentas.size()) {
				Ventas.Venta venta = (Ventas.Venta) listaVentas.get(i);
				System.out.println(listaVentas.size());
				System.out.println(i);
				System.out.println(venta.getNumventa().intValue());
				if (venta.getNumventa().intValue() == numVenta) { // Si el n�mero de venta existe...
					existe = true;
				}else {
					i++;
				}
				
			}
		

			if (!existe) {
				// Crear el objeto Ventas.Venta, y si no existe se a�ade a la lista
				Ventas.Venta ve = new Ventas.Venta();
				ve.setNombrecliente(nomCli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numVenta);
				ve.setNumventa(nume);

				// a�adimos la venta a la lista
				listaVentas.add(ve);

				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));

				System.out.println("Venta a�adida: " + numVenta);

			} else {
				System.out.println("En n�mero de venta ya existe: " + numVenta);
			}

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}
