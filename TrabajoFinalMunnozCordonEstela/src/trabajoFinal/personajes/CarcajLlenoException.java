package trabajoFinal.personajes;

/**
 * Crea la excepci&oacute;n que controla el error que 
 * se origina al querer a&ntilde;adir m&aacute;s flechas
 * al carcaj cuando ya est&aacute; lleno.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class CarcajLlenoException extends Exception {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Indentificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 1879384622600021839L;
	
		
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea la excepci&oacute;n por estar el carcaj lleno.
	 * 
	 * @param mensaje Mensaje informativo que devuelve la excepci&oacute;.
	 */
	public CarcajLlenoException(String mensaje) {
		super(mensaje);
	}
}
