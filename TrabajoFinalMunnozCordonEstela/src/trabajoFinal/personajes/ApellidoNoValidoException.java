package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no ser v&aacute;lido el apellido del personaje.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ApellidoNoValidoException extends Exception {
	
	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -8115831472747648548L;
	
		
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por apellido incorrecto.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public ApellidoNoValidoException(String mensaje) {
		super(mensaje);
	}

}
