package trabajoFinal.personajes;


/**
 * Crea y controla a un arquero.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Arquero extends Personaje implements Razable {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Raza del arquero.
	 */
	private Raza raza;
	
	/**
	 * Vida del arquero.
	 */
	private int vida = 18;
	
	/**
	 * Velocidad del arquero.
	 */
	private int velocidad = 7;
	
	/**
	 * Habilidad del arquero.
	 */
	private int habilidad = 8;
	
	/**
	 * Flechas de las que dispone el arquero 
	 * en su carcaj para disparar con su arco.
	 */
	private int carcaj = 10;
	
	
	// -------------------------------------- MÉTODOS -------------------------------------- \\
	
	/**
	 * Crea un arquero.
	 * 
	 * @param nombre Nombre del arquero.
	 * @param apellido Apellido del arquero.
	 * @param sexo Sexo del arquero.
	 * @param zodiaco Signo del zodiaco del arquero.
	 * @param edad Edad del arquero.
	 * @param altura Altura del arquero.
	 * @param peso Peso del arquero.
	 * @param region Regi&oacute;n donde vive el arquero.
	 * @param raza Raza del arquero.
	 * @param String descripcion Informaci&oacute;n del arquero.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto. 
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	protected Arquero(String nombre, String apellido, Sexo sexo,
			Zodiaco zodiaco, int edad, float altura, float peso, Region region, Raza raza, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, 
			RazaNoValidaException {
		
		super(nombre, apellido, sexo, zodiaco, edad, altura, peso, region, descripcion);
		setRaza(raza);
		
	}
		
	@Override
	protected void setVida(int vida) {
		super.setVida(vida);
		if(this.vida<10){
			velocidad -= 4;
			habilidad -= 4;
		}	
	}

	/**
	 * Devuelve la velocidad del personaje.
	 * 
	 * @return La velocidad.
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Devuelve la habilidad del personaje.
	 * 
	 * @return La habilidad.
	 */
	public int getHabilidad() {
		return habilidad;
	}
	
	/**
	 * Devuelve la raza del arquero.
	 * 
	 * @return La raza.
	 */
	public Raza getRaza(){
		return raza;
	}
		
	/**
	 * Modifica la raza del arquero.
	 * 
	 * @param raza Raza del arquero.
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	private void setRaza(Raza raza) throws RazaNoValidaException {
		if(raza!=null)
			this.raza = raza;
		else
			throw new RazaNoValidaException("La raza no es válida.");
	}

	/**
	 * Modifica la edad del arquero.
	 * 
	 * @param edad Edad del arquero.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	@Override
	protected void setEdad(int edad) throws EdadNoValidaException {
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
	 * Modifica la cantidad de flechas que hay en el carcaj.
	 * 
	 * @param carcaj Cantidad de flechas del carcaj.
	 */
	private void setCarcaj(int carcaj) {
		this.carcaj = carcaj;		
	}

	/**
	 * Devuelve la cantidad de flechas que hay en el carcaj.
	 * 
	 * @return Cantidad de flechas existentes en el carcaj.
	 */
	public int getCarcaj() {
		return carcaj;
	}
	
	/**
	 * Recarga el carcaj con m&aacute;s flechas hasta que 
	 * se alcance el espacio m&aacute;ximo de munici&oacute;n.
	 * 
	 * @param flechas Flechas a a&ntilde;adir al carcaj.
	 * @throws CarcajLlenoException Erro al estar el carcaj lleno.
	 */
	public void recargarFlechas(int flechas) throws CarcajLlenoException {
		if(getCarcaj()+flechas < 10)
			setCarcaj(carcaj + flechas);
		else
			throw new CarcajLlenoException("El carcaj de flechas ya está lleno, "
					+ "no se pueden añadir más.");
	}

	/**
	 * Lanza una flecha con el arco.
	 *
	 * @throws CarcajVacioException Error al lanzar una flecha con el carcaj vac&iacute;o.
	 */
	public void tirarfecha() throws CarcajVacioException {
		if(carcaj!=0){ // Si no está vacío
			carcaj -= 1; // gasta una flecha
			danno = 5*velocidad*habilidad/2;
		}
		else // Si está vacío
			throw new CarcajVacioException("El carcaj está vacío. Llénalo.");
	}
	
	/**
	 * Actualiza los valores del arquero seg&uacute;n su raza.
	 */
	@Override
	public void actualizarValores() {
		if(raza == Raza.ELFO) {
			velocidad += 5;
			habilidad += 5;
		}
		else if(raza == Raza.NO_MUERTO) {
			velocidad -= 5;
			habilidad -= 4;
			vida += 9;
		}
	}

	/**
	 * Ataque b&aacute;sico del arquero.
	 */
	@Override
	public void ataqueBasico() {
		danno = 3;
	}
	
	

}
