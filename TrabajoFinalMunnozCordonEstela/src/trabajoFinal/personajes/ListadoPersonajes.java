package trabajoFinal.personajes;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Gestiona el listado de personajes.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ListadoPersonajes {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
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
	
	
	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	// -------------------- Añadir -------------------- \\
	
	/**
	 * A&ntilde;ade un personaje.
	 * 
	 * @param opcion Opci&oacute;n por la que se a&ntilde;ade un personaje u otro.
	 * @param nombre Nombre del personaje.
	 * @param apellido Apellido del personaje.
	 * @param sexo Sexo del pesonaje.
	 * @param zodiaco Signo del zodiaco del personaje.
	 * @param edad Edad del personaje.
	 * @param altura Altura del personaje.
	 * @param peso Peso del personaje.
	 * @param region Regi&oacute;n donde vive el personaje.
	 * @param raza Raza del personaje.
	 * @param descripcion Descripci&oacute;n informativa sobre el personaje.
	 * 
	 * @return El personaje a&ntilde;adido.
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
	 * @throws PersonajeYaExisteException Error al existir el personaje.
	 */
	public boolean annadir(int opcion, String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			double altura, double peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException,
			RazaNoValidaException {
		
		Personaje personaje = null;
		
		switch(opcion){
			case 0:
				 personaje= new Mago(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 1:
				 personaje= new Arquero(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 2:
				 personaje= new Guerrero(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 3:
				 personaje= new Dragon(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						descripcion);
			case 4:
				 personaje= new Dios(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						descripcion);
		}
		
		if (listado.contains(personaje)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El personaje ya existe en el listado");
		else{ // Si no lo contiene
			return listado.add(personaje); 
		}	
		
	}
		
	
	// -------------------- Eliminar -------------------- \\
	
	/**
	 * Elimina un personaje del listado.
	 * 
	 * @param nombre Nombre del personaje.
	 * 
	 * @return El personaje eliminado. 
	 * 
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws PersonajeNoExisteException Error por no existir el personaje.
	 */
	public boolean eliminar(String nombre) throws NombreNoValidoException, PersonajeNoExisteException {
		Personaje personaje = new Personaje(nombre); // Crea un personaje con sólo el nombre
		return listado.remove(personaje); // Borra el personaje
	}
	
	
	// -------------------- Búsquedas -------------------- \\
	
	/**
	 * Devuelve un personaje del listado.
	 * 
	 * @param nombre Nombre del personaje.
	 * 
	 * @return El personaje.
	 * 
	 * @throws PersonajeNoExisteException Error al no existir el personaje.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 */
	public Personaje getPersonaje(String nombre) throws PersonajeNoExisteException, NombreNoValidoException {
		Personaje personaje = new Personaje(nombre); // Crea un personaje sólo con la nombre
		int posicion = listado.indexOf(personaje); // Posición del personaje en el listado
		if (posicion != -1) // Cuando no es -1, desvuelve el personaje que corresponde a esa posición
			return listado.get(posicion);
		else // Cuando el índice es igual a -1 (no existe), crea la excepción
			throw new PersonajeNoExisteException("El personaje no existe.");
	}
	
	/**
	 * Devuelve un personaje del listado 
	 * busc&aacute;ndolo por su posici&oacute;n.
	 * 
	 * @param posicion Posici&oacute;n del personaje.
	 * 
	 * @return El personaje.
	 */
	public Personaje getPersonajePorPosicion(int posicion) {
		// Si el listado está vacío 
		if(listado.isEmpty()) 
			return null;
		// Si es menor que 0 (-1 es que no lo contiene) o mayor que el tamaño del listado
		if(posicion < 0 | posicion > listado.size()-1) 
			return null;
		return listado.get(posicion); // Si no ocurre nada de lo anterior, devuelve el personaje
	}	
	
	/**
	 * Devuelve todos los personajes que viven en la misma regi&oacute;n.
	 * 
	 * @param region Regi&oacute;n donde vive el personaje.
	 * 
	 * @return Todos los personajes de la misma regi&oacute;n.
	 */
	public ArrayList<Personaje> getPersonajesRegion(Region region) {
		// Creamos nuestra lista de personajes de la misma región
		ArrayList<Personaje> personajesMismaRegion = new ArrayList<Personaje>(); 
		for (Personaje personaje : listado) {
			if (personaje.getRegion() == region) // Cuando la región coincide, lo agrega
				personajesMismaRegion.add(personaje);
		}
		return personajesMismaRegion;
	}
	
	/**
	 * Devuelve todos los personajes del mismo sexo.
	 * 
	 * @param sexo Sexo del personaje.
	 * 
	 * @return Todos los personajes del mismo sexo.
	 */
	public ArrayList<Personaje> getPersonajesSexo(Sexo sexo) {
		// Creamos nuestra lista de personajes del mismo sexo
		ArrayList<Personaje> personajesMismoSexo = new ArrayList<Personaje>(); 
		for (Personaje personaje : listado) {
			if (personaje.getSexo() == sexo) // Cuando el sexo coincide, lo agrega 
				personajesMismoSexo.add(personaje);
		}
		return personajesMismoSexo;
	}
	
	/**
	 * Devuelve todos los personajes del mismo signo del zodiaco.
	 * 
	 * @param zodiaco Signo del zodiaco.
	 * 
	 * @return Todos los personajes del mismo signo del zodiaco.
	 */
	public ArrayList<Personaje> getPersonajesZodiaco(Zodiaco zodiaco) {
		// Creamos nuestra lista de personajes del mismo zodiaco
		ArrayList<Personaje> personajesMismoZodiaco = new ArrayList<Personaje>(); 
		for (Personaje personaje : listado) {
			if (personaje.getZodiaco() == zodiaco) // Cuando el zodiaco coincide, lo agrega 
				personajesMismoZodiaco.add(personaje);
		}
		return personajesMismoZodiaco;
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
	 * Devuelve la fecha actual, que ser&aacute;
	 * la de la &uacute;ltima modificaci&oacute;n.
	 * 
	 * @return fecha actual.
	 */
	public static String getFechaDeModifiacion(){
		Calendar fechaActual = Calendar.getInstance();
		String dia=Integer.toString(fechaActual.get(Calendar.DATE));
		String mes= Integer.toString(fechaActual.get(Calendar.MONTH));
		String anno= Integer.toString(fechaActual.get(Calendar.YEAR));
		return  dia + "/" + mes +"/"+ anno;
	}

	/**
	 * Modifica el listado de personajes.
	 * 
	 * @param listado Listado de personajes.
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
	
}
