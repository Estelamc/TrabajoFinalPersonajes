package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina cuando la regi&oacute;n no es correcta.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class RegionNoValidaException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -3017714480470409528L;
	
		
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por regi&oacute; incorrecta.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public RegionNoValidaException(String mensaje) {
		super(mensaje);
	}
}
