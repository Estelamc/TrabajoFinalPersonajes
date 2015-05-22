package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no ser v&aacute;lida la edad del personaje.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class EdadNoValidaException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -5297862521368602005L;

	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por edad incorrecta.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public EdadNoValidaException(String mensaje) {
		super(mensaje);
	}
}
