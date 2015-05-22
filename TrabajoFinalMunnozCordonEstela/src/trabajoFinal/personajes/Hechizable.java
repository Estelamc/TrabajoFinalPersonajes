package trabajoFinal.personajes;

/**
 * Los magos lanzan estos hechizos.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public interface Hechizable {
	
	/**
	 * Lanza una bola de fuego.
	 * 
	 * @throws ManaInsuficienteException 
	 */
	abstract void bolaDeFuego() throws ManaInsuficienteException;
	
	/**
	 * Crea una lanza de hielo y la lanza.
	 */
	abstract void lanzaDeHielo() throws ManaInsuficienteException;
	
	/**
	 * Lanza un rayo.
	 */
	abstract void rayo() throws ManaInsuficienteException;
}
