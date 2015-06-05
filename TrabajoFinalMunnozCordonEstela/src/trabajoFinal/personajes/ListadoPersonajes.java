package trabajoFinal.personajes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Gestiona el listado de personajes.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ListadoPersonajes implements Serializable {

	// ----------------------------------- NUESTROS CAMPOS
	// ----------------------------------- \\

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -4842656387191895734L;

	/**
	 * Lista de personajes almacenados.
	 */
	private ArrayList<Personaje> listado = new ArrayList<Personaje>();

	/**
	 * Nombre del listado de personajes.
	 */
	private final String nombre = "PnjCreator";

	/**
	 * &Uacute;ltima fecha de modificaci&oacute;n del listado.
	 */
	private String fechaDeModificacion;

	// ----------------------------------- NUESTROS MÉTODOS
	// ----------------------------------- \\

	// -------------------- Añadir -------------------- \\

	/**
	 * A&ntilde;ade un personaje.
	 * 
	 * @param tipo
	 *            Tipo de personaje a a&ntilde;adir.
	 * @param nombre
	 *            Nombre del personaje.
	 * @param apellido
	 *            Apellido del personaje.
	 * @param sexo
	 *            Sexo del pesonaje.
	 * @param zodiaco
	 *            Signo del zodiaco del personaje.
	 * @param edad
	 *            Edad del personaje.
	 * @param altura
	 *            Altura del personaje.
	 * @param peso
	 *            Peso del personaje.
	 * @param region
	 *            Regi&oacute;n donde vive el personaje.
	 * @param raza
	 *            Raza del personaje.
	 * @param descripcion
	 *            Descripci&oacute;n informativa sobre el personaje.
	 * 
	 * @return El personaje a&ntilde;adido.
	 * 
	 * @throws ApellidoNoValidoException
	 *             Error por apellido incorrecto.
	 * @throws NombreNoValidoException
	 *             Error por nombre incorrecto.
	 * @throws AlturaNoValidaException
	 *             Error por altura incorrecta.
	 * @throws PesoNoValidoException
	 *             Error por peso incorrecto.
	 * @throws EdadNoValidaException
	 *             Error por edad incorrecta.
	 * @throws PersonajeYaExisteException
	 *             Error al existir el personaje.
	 * @throws NullPointerException Error por dato nulo.             
	 */
	public boolean annadir(Tipo tipo, String nombre, String apellido,
			Sexo sexo, Zodiaco zodiaco, int edad, double altura, double peso,
			Region region, Raza raza, String descripcion)
			throws ApellidoNoValidoException, NombreNoValidoException,
			AlturaNoValidaException, PesoNoValidoException,
			EdadNoValidaException, PersonajeYaExisteException, NullPointerException {

		Personaje personaje = null;

		switch (tipo) {
			case MAGO:
				personaje = new Mago(nombre, apellido, sexo, zodiaco, edad, altura,
						peso, region, raza, descripcion);
				break;
			case ARQUERO:
				personaje = new Arquero(nombre, apellido, sexo, zodiaco, edad,
						altura, peso, region, raza, descripcion);
				break;
			case GUERRERO:
				personaje = new Guerrero(nombre, apellido, sexo, zodiaco, edad,
						altura, peso, region, raza, descripcion);
				break;
			case DRAGÓN:
				personaje = new Dragon(nombre, apellido, sexo, zodiaco, edad,
						altura, peso, region, descripcion);
				break;
			case DIOS:
				personaje = new Dios(nombre, apellido, sexo, zodiaco, edad, altura,
						peso, region, descripcion);
				break;
		}

		if (listado.contains(personaje)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException(
					"El personaje ya existe en el listado");
		// Si no lo contiene
		return listado.add(personaje);

	}

	// -------------------- Eliminar -------------------- \\

	/**
	 * Elimina un personaje del listado.
	 * 
	 * @param nombre
	 *            Nombre del personaje.
	 * 
	 * @return El personaje eliminado.
	 * 
	 * @throws NombreNoValidoException
	 *             Error por nombre incorrecto.
	 * @throws PersonajeNoExisteException
	 *             Error por no existir el personaje.
	 * @throws NullPointerException Error por nombre nulo.
	 */
	public boolean eliminar(String nombre) throws NombreNoValidoException,
			PersonajeNoExisteException, NullPointerException {		
		Personaje personaje = new Personaje(nombre); // Crea un personaje con el nombre solo
		return listado.remove(personaje); 				
	}

	// -------------------- Búsquedas -------------------- \\

	/**
	 * Devuelve un personaje del listado.
	 * 
	 * @param nombre
	 *            Nombre del personaje.
	 * 
	 * @return El personaje.
	 * 
	 * @throws PersonajeNoExisteException
	 *             Error al no existir el personaje.
	 * @throws NombreNoValidoException
	 *             Error por nombre incorrecto.
	 * @throws NullPointerException Error por nombre nulo.
	 */
	public Personaje getPersonaje(String nombre)
			throws PersonajeNoExisteException, NombreNoValidoException, NullPointerException {
		
		Personaje personaje = new Personaje(nombre); // Crea un personaje sólo
														// con el nombre
		int posicion = listado.indexOf(personaje); // Posición del personaje en
													// el listado
		if (posicion != -1) // Cuando no es -1, desvuelve el personaje que
							// corresponde a esa posición
			return listado.get(posicion);
		else
			// Cuando el índice es igual a -1 (no existe), crea la excepción
			throw new PersonajeNoExisteException("El personaje no existe.");
	}

	/**
	 * Devuelve un personaje del listado busc&aacute;ndolo por su
	 * posici&oacute;n.
	 * 
	 * @param posicion
	 *            Posici&oacute;n del personaje.
	 * 
	 * @return El personaje.
	 */
	public Personaje getPersonajePorPosicion(int posicion) {
		// Si el listado está vacío
		if (listado.isEmpty())
			return null;
		// Si es menor que 0 (-1 es que no lo contiene) o mayor que el tamaño
		// del listado
		if (posicion < 0 | posicion > listado.size() - 1)
			return null;
		return listado.get(posicion); // Si no ocurre nada de lo anterior,
										// devuelve el personaje
	}

	/**
	 * Devuelve todos los personajes de tipo Mago.
	 * 
	 * @return Todos los magos.
	 */
	public ArrayList<Personaje> getMagos() {
		// Creamos nuestra lista de magos
		ArrayList<Personaje> magos = new ArrayList<Personaje>();
		for (Personaje personaje : listado) {
			if (personaje instanceof Mago) 
				magos.add(personaje);
		}
		return magos;
	}

	/**
	 * Devuelve todos los personajes de tipo Arquero.
	 * 
	 * @return Todos los arqueros.
	 */
	public ArrayList<Personaje> getArqueros() {
		// Creamos nuestra lista de arqueros
		ArrayList<Personaje> arqueros = new ArrayList<Personaje>();
		for (Personaje personaje : listado) {
			if (personaje instanceof Arquero) 
				arqueros.add(personaje);
		}
		return arqueros;
	}
	
	/**
	 * Devuelve todos los personajes de tipo Guerrero.
	 * 
	 * @return Todos los guerreros.
	 */
	public ArrayList<Personaje> getGuerreros() {
		// Creamos nuestra lista de guerreros
		ArrayList<Personaje> guerreros = new ArrayList<Personaje>();
		for (Personaje personaje : listado) {
			if (personaje instanceof Guerrero) 
				guerreros.add(personaje);
		}
		return guerreros;
	}
	
	/**
	 * Devuelve todos los personajes de tipo Drag&oacute;n.
	 * 
	 * @return Todos los dragones.
	 */
	public ArrayList<Personaje> getDragones() {
		// Creamos nuestra lista de dragones
		ArrayList<Personaje> dragones = new ArrayList<Personaje>();
		for (Personaje personaje : listado) {
			if (personaje instanceof Dragon) 
				dragones.add(personaje);
		}
		return dragones;
	}
	
	/**
	 * Devuelve todos los personajes de tipo Dios.
	 * 
	 * @return Todos los dioses.
	 */
	public ArrayList<Personaje> getDioses() {
		// Creamos nuestra lista de dioses
		ArrayList<Personaje> dioses = new ArrayList<Personaje>();
		for (Personaje personaje : listado) {
			if (personaje instanceof Dios) 
				dioses.add(personaje);
		}
		return dioses;
	}
	

	// -------------------- Otros -------------------- \\

	/**
	 * Nombre del listado de personajes.
	 * 
	 * @return Nombre del listado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cantidad de personajes que hay en el listado.
	 * 
	 * @return Cantidad de personajes del listado.
	 */
	public int cantidadPersonajes() {
		return listado.size();
	}

	/**
	 * Devuelve la fecha actual, que ser&aacute; la de la &uacute;ltima
	 * modificaci&oacute;n.
	 * 
	 * @return fecha actual.
	 */
	public static String getFechaDeModifiacion() {
		Calendar fechaActual = Calendar.getInstance();
		String dia = Integer.toString(fechaActual.get(Calendar.DATE));
		String mes = Integer.toString(fechaActual.get(Calendar.MONTH));
		String anno = Integer.toString(fechaActual.get(Calendar.YEAR));
		return dia + "/" + mes + "/" + anno;
	}

	/**
	 * Modifica el listado de personajes.
	 * 
	 * @param listado
	 *            Listado de personajes.
	 */
	public void setListado(ArrayList<Personaje> listado) {
		this.listado = listado;
	}

	/**
	 * Muestra el listado de personajes.
	 * 
	 * return Listado de personajes.
	 */
	@Override
	public String toString() {
		return "ListadoPersonajes [listado=" + listado
				+ ", fechaDeModificacion=" + fechaDeModificacion + "]";
	}
	
	/**
	 * Ordena alfab&eacute;ticamente el listado de personajes.
	 */
	public void ordenarAlfabeticamente() {
		Collections.sort(listado);
	}
}
