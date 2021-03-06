package trabajoFinal.personajes;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Crea y controla un personaje.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Personaje implements Serializable, Comparable<Personaje> {

	// -------------------------------------- CAMPOS -------------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -7180488114932920741L;

	// ********** Datos Generales ********** \\
	/**
	 * Nombre del personaje.
	 */
	protected String nombre;
	
	/**
	 * Apellido del personaje.
	 */
	protected String apellido;
	
	/**
	 * Sexo del personaje.
	 */
	protected Sexo sexo;
	
	/**
	 * Edad del personaje.
	 */
	protected int edad;
	
	/**
	 * Altura del personaje en metros.
	 */
	protected double altura;
	
	/**
	 * Peso del personaje en Kilos.
	 */
	protected double peso;
	
	/**
	 * Regi&oacute;n donde vive el personaje.
	 */
	protected Region region;
	
	/**
	 * Signo del zodiaco del personaje.
	 */
	protected Zodiaco zodiaco;
	
	/**
	 * Descripci&oacute;n informativa del personaje.
	 */
	protected String descripcion;
	
	/**
	 * Vida del personaje.
	 */
	protected int vida=5;
	
	/**
	 * Cantidad de da&ntilde;o que 
	 * puede provocar el personaje.
	 */
	protected int danno;
	
	/**
	 * Patr&oacute;n para comparar el nombre y saber si es v&aacute;lido.
	 * La primera letra debe ser en may&uacute;scula, puede ir seguida de otra letra min&uacute;scula o m&aacute;s
	 * y un gui&oacute;n seguido de una letra may&uacute;scula (en caso de que fueran nombres compuestos tipo Iz-Kod),
	 * a esto seguir&aacute;n como m&iacute;nimo dos letras min&uacute;sculas.<br><br>
	 * Ejemplos permitidos:
	 * <ul>
	 * 	<li> Rock-Naut.</li>
	 * 	<li> Von-Set.</li>
	 * 	<li> Z&iacute;an.</li>
	 * 	<li> Nora.</li>
	 * 	<li> Nel.</li>
	 * </ul>
	 * <br>
	 * Ejemplos no permitidos:
	 * <ul>
	 * 	<li> A.</li>
	 * 	<li> alan.</li>
	 * 	<li> Al.</li>
	 * 	<li> Liun-mul.</li>
	 * 	<li> AAl</li>
	 *  <li> Ali4 </li>
	 *  <li> 4Ana </li> 
	 *  <li> 
	 * </ul>
	 * 
	 */
	private static Pattern patronNombre = Pattern.compile("^[A-Z������]([a-z������]+[-][A-Z������])?[a-z������]{2,}$");
	
	/**
	 * Patr&oacute;n para comparar el apellido y saber si es v&aacute;lido.
	 * A diferencia con el nombre, no se permiten guiones.
	 */
	private static Pattern patronApellido = Pattern.compile("^[A-Z������][a-z������]{2,}$");
	
		
	// -------------------------------------- M�TODOS -------------------------------------- \\
	
	/**
	 * 
	 * @param nombre Nombre del personaje.
	 * @param apellido Apellido del personaje.
	 * @param sexo Sexo del personaje.
	 * @param zodiaco Signo del zodiaco del personaje.
	 * @param edad Edad del personaje.
	 * @param altura Altura del personaje.
	 * @param peso Peso del personaje.
	 * @param region Regi&oacute;n donde vive el personaje.
	 * @param descripcion Informaci&oacute;n del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws NullPointerException Error por dato nulo.
	 */
	protected Personaje(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, 
			int edad, double altura, double peso, Region region, String descripcion) 
			throws ApellidoNoValidoException, NombreNoValidoException,  
			AlturaNoValidaException, PesoNoValidoException,  
			NullPointerException, EdadNoValidaException {
		setNombre(nombre);
		setApellido(apellido);
		setSexo(sexo);
		setZodiaco(zodiaco);
		setEdad(edad);
		setAltura(altura);
		setPeso(peso);
		setRegion(region);
		setDescripcion(descripcion);
	}
	
	/**
	 * Crea un personaje s&oacute;lo con el nombre.
	 * 
	 * @param nombre Nombre del personaje.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws NullPointerException Error por nombre nulo.
	 */
	protected Personaje(String nombre) throws NombreNoValidoException, NullPointerException {
		setNombre(nombre);
	}
	
	/**
	 * Devuelve el da&ntilde;o que 
	 * puede causar un personaje.
	 * 
	 * @return El da&ntilde;o causado.
	 */
	protected int danno() {
		return danno;
	}
	
	/**
	 * Modifica el da&ntilde;o que 
	 * puede causar un personaje.
	 *  
	 * @param danno El da&ntilde;o causado.
	 */
	protected void setDanno(int danno) {
		this.danno = danno;
	}
	
	/**
	 * Devuelve la vida del personaje.
	 * 
	 * @return La vida del personaje.
	 */
	protected int getVida() {
		return vida;
	}
	
	/**
	 * Modifica la vida del personaje.
	 * 
	 * @param vida Vida del personaje.
	 */
	protected void setVida(int vida){
		this.vida = vida;
	}
		
	/**
	 * Devuelve la regi&oacute;n.
	 * 
	 * @return La regi&oacute;n donde vive el personaje.
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Modifica la regi&oacute;n donde habita el personaje.
	 * 
	 * @param region Regi&oacute;n donde vive el personaje.
	 */
	protected void setRegion(Region region) { // SE CONTROLA EN CONSTRUCTOR, NO AQU�
		this.region = region;
	}

	/**
	 * Devuelve la informaci&oacute;n del personaje.
	 * 
	 * @return La descripci&oacute;n del personaje.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Modifica la descripci&oacute;n del personaje.
	 * 
	 * @param descripcion La informaci&oacute;n del personaje.
	 */
	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Modifica el nombre del personaje. 
	 * 
	 * @param nombre Nombre del personaje.
	 * 
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws NullPointerException Error por nombre nulo.
	 */
	protected void setNombre(String nombre) throws NombreNoValidoException, NullPointerException {
		if(esValido(patronNombre, nombre) && nombre.length()<15)
			this.nombre = nombre;
		else if(nombre==null)
			throw new NullPointerException("El nombre es nulo.");
		else
			throw new NombreNoValidoException("El nombre no es v�lido.");
		
	}
	
	/**
	 * Devuelve el patr&oacute;n del nombre.
	 * 
	 * @return Patr&oacute;n para validar el nombre.
	 */
	public static Pattern getPatronNombre() {
		return patronNombre;
	}

	/**
	 * Modifica el apellido del personaje.
	 * 
	 * @param apellido Apellido del personaje.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NullPointerException Error por nombre nulo.
	 */
	protected void setApellido(String apellido) throws ApellidoNoValidoException, NullPointerException {
		if(esValido(patronApellido, apellido) && nombre.length()<15)
			this.apellido = apellido;
		else if(apellido==null)
			throw new NullPointerException("El apellido es nulo.");
		else
			throw new ApellidoNoValidoException("El apellido no es v�lido.");
	}
	
	/**
	 * Devuelve el sexo.
	 * 
	 * @return El sexo del personaje.
	 */
	public Sexo getSexo() {
		return sexo;
	}
	
	/**
	 * Modifica el sexo del personaje.
	 * 
	 * @param sexo G&eacute;nero del personaje.
	 */
	protected void setSexo(Sexo sexo) { // SE CONTROLA EN CONSTRUCTOR, NO AQU�
		this.sexo = sexo;
	}
	
	/**
	 * Devuelve el signo del zodiaco del personaje.
	 * 
	 * @return El signo del zodiaco.
	 */
	public Zodiaco getZodiaco() {
		return zodiaco;
	}
	
	/**
	 * Modifica el signo del zodiaco del personaje.
	 * 
	 * @param zodiaco Signo del zodiaco.
	 */
	protected void setZodiaco(Zodiaco zodiaco) {
		this.zodiaco = zodiaco;
	}
	
	/**
	 * Devuelve la edad del personaje.
	 * 
	 * @return La edad del personaje.
	 */
	public int getEdad() {
		return edad;
		
	}
	
	/**
	 * Modifica la edad del personaje.
	 * 
	 * @param edad Edad del personaje.
	 * 
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 */
	protected void setEdad(int edad) throws EdadNoValidaException {
		if(edad>16 && edad<100)
			this.edad = edad;
		else
			throw new EdadNoValidaException("La edad no es v�lida.");
	}

	/**
	 * Modifica la altura del personaje.
	 * 
	 * @param altura Altura del personaje en metros.
	 * 
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 */
	protected void setAltura(double altura) throws AlturaNoValidaException {
		if(altura>1.300 && altura<2.0)
			this.altura = altura;
		else
			throw new AlturaNoValidaException("La altura no es v�lida.");
	}
	
	/**
	 * Modifica el peso del personaje.
	 * 
	 * @param peso Peso del personaje.
	 * 
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 */
	protected void setPeso(double peso) throws PesoNoValidoException {
		if(peso>40.0 && peso<200.0)
			this.peso = peso;
		else
			throw new PesoNoValidoException("El peso no es v�lido.");
	}
	
	/**
	 * Devuelve el nombre del pesonaje.
	 * 
	 * @return El nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve el apellido del personaje.
	 * 
	 * @return El apellido.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Devuelve la altura del personaje.
	 * 
	 * @return La altura.
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Devuelve el peso del personaje.
	 * 
	 * @return El peso.
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Comprueba si un dato es v&aacute;lido, 
	 * compar&aacute;ndolo con un patr&oacute;n.
	 * 
	 * @param patron Patr&oacute;n con el que se compara.
	 * @param dato Dato a comparar.
	 * 
	 * @return True si el dato es correcto o false sino.
	 */
	public static boolean esValido(Pattern patron, String dato) {
		return patron.matcher(dato).matches();
	}
	
	/**
	 * Ataque b&aacute;sico de un personaje.
	 */
	protected void ataqueBasico() {
		danno = 1; 
	}

	/**
	 * Calcula un valor num&eacute;rico &uacute;nico 
	 * que define a un personaje en base a su nombre.
	 * 
	 * @return Valor n&uacute;merico &uacute;nico para un personaje 
	 * de nombre concreto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	/**
	 * Compara si dos personajes tienen el mismo nombre.
	 * 
	 * @param obj Objeto a comparar.
	 * 
	 * @return True si los personajes coinciden en el nombre o false sino.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

	/**
	 * Compara dos personajes para 
	 * ordenarlos por el nombre.
	 * 
	 * @param p Personaje a comparar.
	 * 
	 * @return 0 si son iguales, -1 si es mayor y 1 si es menor 
	 * que el personaje con el que comparamos.
	 */
	@Override
	public int compareTo(Personaje p) {
		// Se puede hacer esto porque String implementa comparable
		return nombre.compareTo(p.getNombre());
	// Si quisi�ramos ordenar personajes por la edad, por ejemplo, se usar�a Comparator
	}
}
