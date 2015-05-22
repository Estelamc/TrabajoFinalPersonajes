package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina cuando la raza no es correcta.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class RazaNoValidaException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 7570551739360434658L;

	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por raza incorrecta.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public RazaNoValidaException(String mensaje) {
		super(mensaje);
	}
}
