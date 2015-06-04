package trabajoFinal.personajes;

/**
 * Crea y controla a un mago.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Mago extends Personaje implements Razable {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 4356716828296440895L;

	/**
	 * Raza del mago.
	 */
	private Raza raza;
	
	/**
	 * Vida del mago.
	 */
	private int vida = 16;
	
	/**
	 * Inteligencia del mago.
	 */
	private int inteligencia=5;
	
	/**
	 * Magia del mago.
	 */
	private int mana = 20; 
	
	/**
	 * Resistencia a la magia del mago.
	 */
	private int resistencia = 6;
	

	// -------------------------------------- MÉTODOS -------------------------------------- \\
	
	/**
	 * Crea un mago.
	 * 
	 * @param nombre Nombre del mago.
	 * @param apellido Apellido del mago.
	 * @param sexo Sexo del mago.
	 * @param zodiaco Signo del zodiaco del mago.
	 * @param edad Edad del mago.
	 * @param altura Altura del mago.
	 * @param peso Peso del mago.
	 * @param region Regi&oacute;n donde vive el mago.
	 * @param raza Raza del mago.
	 * @param descripcion Informaci&oacute;n del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto. 
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws NullPointerException Error por dato nulo.
	 */
	protected Mago(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco,
			int edad, double altura, double peso, Region region, Raza raza, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			AlturaNoValidaException, PesoNoValidoException, 
			NullPointerException, EdadNoValidaException {
		super(nombre, apellido, sexo, zodiaco, edad, altura, peso, region, descripcion);
		setRaza(raza);
	}

	/**
	 * Devuelve el man&aacute; del mago.
	 * 
	 * @return El man&aacute;.
	 */
	public int getMana(){
		return mana;
	}
	
	/**
	 * Devuelve la inteligencia del mago.
	 * 
	 * @return La inteligencia.
	 */
	public int getInteligencia(){
		return inteligencia;
	}
	
	/**
	 * Devuelve la resistencia del mago.
	 * 
	 * @return La resistencia.
	 */
	public int getResistencia(){
		return resistencia;
	}
	
	/**
	 * Devuelve la raza del mago.
	 * 
	 * @return La raza.
	 */
	public Raza getRaza(){
		return raza;
	}
		
	@Override
	protected void setVida(int vida) {
		super.setVida(vida);
		if(this.vida<10){
			resistencia -= 4;
		}
	}

	/**
	 * Modifica la raza del mago.
	 * 
	 * @param raza Raza del mago.
	 * 
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	private void setRaza(Raza raza) {
		this.raza = raza;
	}	
	
	/**
	 * Modifica la edad del mago.
	 * 
	 * @param edad Edad del mago.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	public void setEdad(int edad) throws EdadNoValidaException {
		if(raza == Raza.HUMANO)
			super.setEdad(edad);
		else {
			if(edad>16)
				this.edad = edad;
			/*else
				throw new EdadNoValidaException("La edad no es válida.");*/
		}
	}
	
	/**
	 * Actualiza los valores del mago seg&uacute;n su raza.
	 */
	@Override
	public void actualizarValores() { // Como humano es lo que tiene stándar.
		if(raza == Raza.ELFO) {
			inteligencia += 3;
			resistencia += 2;
			mana += 7;
		}
		else if(raza == Raza.NO_MUERTO) {
			inteligencia -= 4;
			resistencia -=2;
			mana += 6;
			vida += 9;
		}
	}

	/**
	 * Lanza una bola de fuego, reduciendo man&aacute;a
	 * y provocando una cantidad de da&ntilde;o.
	 *  
	 */
	public void bolaDeFuego() {
		mana -= 2;
		danno = inteligencia+2;
	}

	/**
	 * Ataca con una lanza de hielo, reduciendo man&aacute;a
	 * y provocando una cantidad de da&ntilde;o.
	 */
	public void lanzaDeHielo() {
		mana -= 3;
		danno = inteligencia+3;		
	}

	/**
	 * Ataca con un rayo, reduciendo man&aacute;a
	 * y provocando una cantidad de da&ntilde;o.
	 */
	public void rayo() {
		mana -= 4;
		danno = inteligencia+4;		
	}

}
