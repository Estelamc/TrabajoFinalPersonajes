package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no quedar man&aacute;.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ManaInsuficienteException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -149960913603364281L;
	
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por man&aacute; agotado.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public ManaInsuficienteException(String mensaje) {
		super(mensaje);
	}
}
