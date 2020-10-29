package saludador;
public class Saludator {
	public static void main(String[] args) {
		int i;
		System.out.print("Hola ");
		for (i = 0; i < args.length; i++) {
			System.out.print(args[i]+" ");
		}
		System.out.println("\n");
		System.out.println("Has pasado, en el momento de la invocación al programa "+i+" ARGUMENTOS");
		System.out.println("La variable args tiene "+args.length+" ARGUMENTOS");
	}
}