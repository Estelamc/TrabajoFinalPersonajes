package trabajoFinal.personajes;

/**
 * Dependiendo de la raza del personaje, tendr&aacute; 
 * unas habilidades distintas; por ejemplo, un elfo 
 * tiene mayor velocidad que un humano.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public interface Razable {
	
	/**
	 * Actualiza las estad&iacute;sticas del 
	 * personaje seg&uacute;n la raza que sea
	 * (fuerza, inteligencia, resistencia...).
	 */
	abstract void actualizarValores();
		
}
