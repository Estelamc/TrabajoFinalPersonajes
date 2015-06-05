package trabajoFinal.personajes;

/**
 * Crea un guerrero.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Guerrero extends Personaje implements Razable {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -4211167310773511237L;

	/**
	 * Raza del guerrero.
	 */
	private Raza raza;
	
	/**
	 * Vida del guerrero.	
	 */
	private int vida = 20;
	
	/**
	 * Fuerza f&iacute;sica del guerrero.
	 */
	private int fuerza = 6;
	
	/**
	 * Defensa f&iacute;sica del guerrero.
	 */
	private int defensa = 4;
	
	/**
	 * Constituci&oacute;n f&iacute;sica del guerrero.
	 */
	private int constitucion = 7; 
		
	/**
	 * Estado de ira en el que puede entrar el guerrero.
	 */
	private boolean ira;
	
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\
	
	/**
	 * Crea un guerrero.
	 * 
	 * @param nombre Nombre del guerrero.
	 * @param apellido Apellido del guerrero.
	 * @param sexo Sexo del guerrero.
	 * @param zodiaco Signo del zodiaco del guerrero.
	 * @param edad Edad del guerrero.
	 * @param altura Altura del guerrero.
	 * @param peso Peso del guerrero.
	 * @param region Regi&oacute;n donde vive el guerrero.
	 * @param raza Raza del guerrero.
	 * @param descripcion Informaci&oacute;n del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto. 
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws NullPointerException Error por dato nulo.
	 */
	public Guerrero(String nombre, String apellido, Sexo sexo,
			Zodiaco zodiaco, int edad, double altura, double peso, Region region, Raza raza, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			AlturaNoValidaException, PesoNoValidoException,
			EdadNoValidaException, NullPointerException {
		super(nombre, apellido, sexo, zodiaco, edad, altura, peso, region, descripcion);
		setRaza(raza);
	}
	
	/**
	 * Devuelve la defensa del guerrero.
	 * 
	 * @return La defensa.
	 */
	public int getDefensa(){
		return defensa;
	}
	
	/**
	 * Devuelve la raza del guerrero.
	 * 
	 * @return La raza.
	 */
	public Raza getRaza(){
		return raza;
	}
	
	/**
	 * Modifica la raza del guerrero.
	 * 
	 * @param raza Raza del guerrero.
	 */
	private void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	/**
	 * Modifica la edad del guerrero.
	 * 
	 * @param edad Edad del guerrero.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	protected void setEdad(int edad) throws EdadNoValidaException {
		if(raza == Raza.HUMANO)
			super.setEdad(edad);
		else {
			if(edad>16)
				this.edad = edad;
			else
				throw new EdadNoValidaException("La edad no es válida.");
		}
	}

	/**
	 * Devuelve la fuerza del guerrero.
	 * 
	 * @return La fuerza.
	 */
	public int getFuerza(){
		return fuerza;
	}
	
	/**
	 * Modifica la fuerza del guerrero.
	 * Cuando est&aacute; en estado de
	 * ira, aumenta 4 puntos.
	 * 
	 * @param fuerza Fuerza del guerrero.
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
		if(isIra())
			this.fuerza += 4;
	}
	
	/**
	 * Modifica la vida del guerrero.
	 * 
	 * @param vida Vida del guerrero.
	 */
	public void setVida(int vida) {
		super.setVida(vida);
		if(this.vida<10) {
			defensa -= 3;
			if(!isIra()) // Si no tiene ira activada de antes, la activa
				setIra(true);
		}	
	}
	
	/**
	 * Modifica la ira del guerrero.
	 * 
	 * @param ira Ira del guerrero.
	 */
	private void setIra(boolean ira) {
		this.ira = ira;
	}
	
	/**
	 * Devuelve si ira est&aacute; activada o no.
	 * 
	 * @return True si la ira est&aacute; activada y False sino.
	 */
	private boolean isIra() {
		return ira;
	}

	/**
	 * Actualiza los valores del guerrero 
	 * seg&uacute;n su raza.
	 */
	@Override
	public void actualizarValores() { // Para humano son los valores stándar
		if(raza == Raza.ELFO) {
			vida += 4;
			fuerza -= 1;
			defensa -= 1;
			constitucion -= 2;
		}
		else if(raza == Raza.NO_MUERTO) {
			defensa -= 3;
			constitucion -= 3;
			vida += 9;	
		}	
	}
	
	/**
	 * Hace un ataque doble, golpeando con sus pu&ntilde;os.
	 */
	public void doblePunnetazo() {
		danno = (constitucion+fuerza)*2;
	}
	
	/**
	 * Da un tajo con la espada.
	 */
	public void tajo() {
		danno = 5+fuerza;
	}
	
	/**
	 * Embiste con su cuerpo.
	 */
	public void embestida() {
		danno = 3+constitucion;
	}
	
	/**
	 * Ataque b&aacute;sico del guerrero.
	 */
	@Override
	public void ataqueBasico() {
		danno = 4;
	}
	
}
