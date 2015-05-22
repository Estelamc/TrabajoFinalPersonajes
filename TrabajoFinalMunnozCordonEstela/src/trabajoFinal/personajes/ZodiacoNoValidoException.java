package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no ser v&aacute;lido el signo del 
 * zodiaco del personaje.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ZodiacoNoValidoException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 8574904038686264273L;

	
	// -------------------------------------- MÉTODOS -------------------------------------- \\
	
	/**
	 * Crea la excepci&oacute;n por signo del zodiaco incorrecto.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public ZodiacoNoValidoException(String mensaje) {
		super(mensaje);
	}
}
