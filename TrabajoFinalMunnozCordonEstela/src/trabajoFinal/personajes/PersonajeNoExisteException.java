package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no existir un personaje a la hora de 
 * eliminarlo del listado de personajes.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class PersonajeNoExisteException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -4398345547271032725L;

	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por no existir el personaje.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public PersonajeNoExisteException(String mensaje) {
		super(mensaje);
	}
}
