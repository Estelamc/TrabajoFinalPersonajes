package trabajoFinal.personajes;

/**
 * Crea y controla a un arquero.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Dios extends Personaje {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -2707092945740696468L;

	/**
	 * Vida del dios.
	 */
	private int  vida = 9999;
	
	/**
	 * Magia del dios.
	 */
	private int mana = 9999;
	
	/**
	 * Fuerza del dios.
	 */
	private int fuerza = 200;
	
	/**
	 * Defensa f&iacute;sica del dios.
	 */
	private int defensa = 100;
	
	/**
	 * Resistencia a la magia del dios.
	 */
	private int resistencia = 100;

	/**
	 * Velocidad del dios.
	 */
	private int velocidad = 100;
	
	/**
	 * Habilidad del dios.
	 */
	private int habilidad = 300;
	
	/**
	 * Inteligencia del dios.
	 */
	private int inteligencia=300;
		
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\
	
	/**
	 * Crea el dios.
	 * 	
	 * @param nombre Nombre del dios.
	 * @param apellido Apellido del dios.
	 * @param sexo Sexo del dios.
	 * @param zodiaco Signo del zodiaco del dios.
	 * @param edad Edad del dios.
	 * @param altura Altura del dios.
	 * @param peso Peso del dios.
	 * @param region Region donde habita el dios.
	 * @param descripcion Informaci&oacute;n del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	public Dios(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco,
			int edad, double altura, double peso, Region region, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			AlturaNoValidaException, PesoNoValidoException,
			EdadNoValidaException {
		super(nombre, apellido, sexo, zodiaco, edad, altura, peso, region, descripcion);
	}
	
	/**
	 * Devuelve la fuerza del dios.
	 * 
	 * @return La fuerza.
	 */
	public int getFuerza(){
		return fuerza;
	}
	
	/**
	 * Devuelve la inteligencia del dios.
	 * 
	 * @return La inteligencia.
	 */
	public int getInteligencia(){
		return inteligencia;
	}
	
	/**
	 * Devuelve el man&aacute; del dios.
	 * 
	 * @return El man&aacute;.
	 */
	public int getMana(){
		return mana;
	}
	
	/**
	 * Devuelve la habilidad del dios.
	 * 
	 * @return La habilidad.
	 */
	public int getHabilidad(){
		return habilidad;
	}
	
	/**
	 * Devuelve la velocidad del dios.
	 * 
	 * @return La velocidad.
	 */
	public int getVelocidad(){
		return velocidad;
	}
	
	/**
	 * Devuelve la defensa del dios.
	 * 
	 * @return La defensa.
	 */
	public int getDefensa(){
		return defensa;
	}
	
	/**
	 * Devuelve la resistencia del dios.
	 * 
	 * @return La resistencia.
	 */
	public int getResistencia(){
		return resistencia;
	}
		
	/**
	 * Modifica la edad del dios.
	 * 
	 * @param edad Edad del dios.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	@Override
	public void setEdad(int edad) throws EdadNoValidaException {
		if(edad>16)
			this.edad = edad;
		/*else
			throw new EdadNoValidaException("La edad no es válida.");*/
	}
			
	@Override
	protected void setVida(int vida) {
		super.setVida(vida);
		if(this.vida<50){
			fuerza += 8;
			inteligencia += 8;
		}
			
	}

	/**
	 * Ataque b&aacute;sico de un dios.
	 */
	@Override
	public void ataqueBasico() {
		danno = 20;
	}

	/**
	 * Ataca con todo su poder.
	 * 
	 * @throws ManaInsuficienteException Error por man&aacute;a agotado.
	 */
	public void juicioFinal() throws ManaInsuficienteException {
		mana -= 50;
		if(mana<=0)
			throw new ManaInsuficienteException("Ya no queda man&aacute; para "
					+ "lanzar el ataque.");
		else
			danno = (fuerza+inteligencia+habilidad+velocidad)/3;
	}

}
