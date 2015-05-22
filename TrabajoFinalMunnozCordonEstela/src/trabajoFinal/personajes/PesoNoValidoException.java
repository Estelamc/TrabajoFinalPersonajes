package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al no ser v&aacute;lido el peso del personaje.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class PesoNoValidoException extends Exception {
	
	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -3556915687709371697L;
	
		
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por peso incorrecto.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public PesoNoValidoException(String mensaje) {
		super(mensaje);
	}
}
