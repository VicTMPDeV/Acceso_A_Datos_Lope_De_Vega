package controlador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;

public class MiObjectInputStream extends ObjectInputStream{
    /** Constructor que recibe InputStream */
    public MiObjectInputStream(InputStream out) throws IOException{
        super(out);
    }

    /** Constructor sin parámetros */
    protected MiObjectInputStream() throws IOException, SecurityException{
        super();
    }

    /** Redefinición del método de escribir la cabecera para que no haga nada. */
    protected void readStreamHeader() throws IOException{
    }

}
