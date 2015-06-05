package trabajoFinal.personajes;

/**
 * Crea un drag&oacute;n.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Dragon extends Personaje {

	// -------------------------------------- CAMPOS -------------------------------------- \\

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 4763195006103293652L;

	/**
	 * Vida del drag&oacute;n.
	 */
	private int vida = 30;
	
	/**
	 * Fuerza del drag&oacute;n.
	 */
	private int fuerza = 8;
	
	/**
	 * Defensa f&iacute;sica del drag&oacute;n.
	 */
	private int defensa = 6;
	
	/**
	 * Resistencia a la magia del drag&oacute;n.
	 */
	private int resistencia = 5;
	
	/**
	 * Coraza del drag&oacute;n.
	 * Cuando el drag&oacute;n est&aacute; en estado 
	 * acorazado aumenta su resistencia y defensa.
	 */
	private boolean coraza; 
	
	/**
	 * El drag&oacute;n puede volar o no.
	 */
	private boolean volar;
	
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\

	/**
	 * Crea un drag&oacute;n.
	 * 
	 * @param nombre Nombre del drag&oacute;n.
	 * @param apellido Apellido del drag&oacute;n.
	 * @param sexo Sexo del drag&oacute;n.
	 * @param zodiaco Zodiaco del drag&oacute;n.
	 * @param edad Edad del drag&oacute;n.
	 * @param altura Altura del drag&oacute;n.
	 * @param peso Peso del drag&oacute;n.
	 * @param region Regi&oacute;n donde vive el drag&oacute;n.
	 * @param descripcion Informaci&oacute;n del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws NullPointerException Error por dato nulo.
	 */
	public Dragon(String nombre, String apellido, Sexo sexo,
			Zodiaco zodiaco, int edad, double altura, double peso, Region region, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			AlturaNoValidaException, PesoNoValidoException,
			EdadNoValidaException, NullPointerException {
		super(nombre, apellido, sexo, zodiaco, edad, altura, peso, region, descripcion);
	}

	/**
	 * Devuelve la fuerza del personaje.
	 * 
	 * @return La fuerza.
	 */
	public int getFuerza(){
		return fuerza;
	}
	
	/**
	 * Devuelve la defensa del drag&oacute;n.
	 * 
	 * @return La defensa.
	 */
	public int getDefensa(){
		return defensa;
	}
	
	/**
	 * Modifica la defensa f&iacute;sica del drag&oacute;n.
	 * 
	 * @param defensa Defensa f&iacute;sica.
	 */
	public void setDefensa(int defensa) {
		if(!isCoraza()) // No tiene coraza
			this.defensa = defensa;
		else // Si tiene coraza
			this.defensa +=  20;
	}
	
	/**
	 * Devuelve la resistencia del drag&oacute;n.
	 * 
	 * @return La resistencia.
	 */
	public int getResistencia(){
		return resistencia;
	}
	
	/**
	 * Modifica la resistencia a la magia del drag&oacute;n.
	 * 
	 * @param resistencia Resistencia f&iacute;sica.
	 */
	public void setResistencia(int resistencia) {
		if(!isCoraza()) // No tiene coraza
			this.resistencia = resistencia;
		else // Si tiene coraza
			this.resistencia +=  20;
	}
	
	/**
	 * Modifica la edad del drag&oacute;n.
	 * 
	 * @param edad Edad del drag&oacute;n.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	@Override
	public void setEdad(int edad) throws EdadNoValidaException {
		if(edad>16 && edad<500)
			this.edad = edad;
		/*else
			throw new EdadNoValidaException("La edad no es válida.");*/
	}
	
	/**
	 * Modifica la vida del drag&oacute;n.
	 * 
	 * @param vida Vida del drag&oacute;n.
	 */
	public void setVida(int vida) {
		super.setVida(vida);
		if(this.vida<10) { // Si la vida es menor de 5
			fuerza -= 4;
			if(isCoraza()) // Si tiene ya coraza no hace nada
				return;
			else // Si no tiene coraza de antes, la activa
				setCoraza(true);
		}	
	}
		
	/**
	 * Devuelve que el drag&oacute;n 
	 * tiene la coraza activada.
	 * 
	 * @return True si la coraza est&aacute; activada o False sino.
	 */
	private boolean isCoraza() { // corresponge al get
		return coraza;
	}
	
	/**
	 * Modifica la coraza del drag&oacute;n.
	 * 
	 * @param coraza Coraza del drag&oacute;n.
	 */
	private void setCoraza(boolean coraza) {
		this.coraza = coraza;
	}
	
	/**
	 * Devuelve si el drag&oacute;n vuela o no.
	 * 
	 * @return True si el drag&oacute;n y False sino.
	 */
	private boolean isVolar() {
		return volar;
	}

	/**
	 * Hace volar o no al drag&oacute;n.
	 * 
	 * @param volar Propiedad volar del drag&oacute;n.
	 */
	public void setVolar(boolean volar) {
		this.volar = volar;
		if(isVolar()){
			resistencia += 4;
			defensa += 4;
			fuerza -= 2;
		}			
	}
	
	/**
	 * Ataque b&aacute;sico de un personaje..
	 */
	@Override
	public void ataqueBasico() {
		danno = 4; 
	}

	/**
	 * El drag&oacute;n escupe fuego.
	 */
	public void alientoDeFuego() {
		danno = 5;
	}
	
	/**
	 * El drag&oacute;n ataca con sus garras.
	 */
	public void zarpazo() {
		danno = 4+fuerza/2;
	}
	
}
