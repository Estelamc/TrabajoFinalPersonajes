package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al ya existir un personaje a la hora de 
 * crear uno nuevo.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class PersonajeYaExisteException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -8754397550923366518L;
	
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por existir el personaje.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public PersonajeYaExisteException(String mensaje) {
		super(mensaje);
	}
}
