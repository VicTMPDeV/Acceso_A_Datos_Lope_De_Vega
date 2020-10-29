package utilidades;

import java.util.ArrayList;
import java.util.Random;

import modelo.Empleado;

public class DatosPrueba {
	
	/**
	 * ATRIBUTOS
	 */
	String nombres[] = {"Antonio","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Jerónimo","María Jesús","Víctor","Fermín","Álvaro","Benedicto"};
	String apellidos[] = {"García","Expósito","Lebrón","Morales","Pedrosa","Ibañez","Romero","Benamejí","Fernández","Borbón","Sánchez","Iglesias"};
	double salarios[] = {900.75,1000,1250.50,1500.50,2000.25,2500.01};
	Random aleatorio = new Random();
	
	/**
	 * FUNCIONALIDAD PARA GENERAR EMPLEADOS COMO CHURROS
	 * @return
	 */
	public Empleado creaEmpleado() {
		Empleado e = new Empleado();
		e.setNombre(nombres[aleatorio.nextInt(nombres.length)]);
		e.setApellidos(apellidos[aleatorio.nextInt(apellidos.length)]+" "+apellidos[aleatorio.nextInt(apellidos.length)]);
		e.setEdad(18 + aleatorio.nextInt(50));
		e.setSalario(salarios[aleatorio.nextInt(salarios.length)]);
		return e;
	}
	
	public ArrayList<Empleado> crearListaEmpleados(int numEmpleados){
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		for (int i = 0; i < numEmpleados; i++) {
			Empleado e = this.creaEmpleado();
			listaEmpleados.add(e);
		}
		return listaEmpleados;
		
	}


}
