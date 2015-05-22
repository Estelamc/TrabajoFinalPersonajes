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
	
	public Personaje annadir(int opcion, String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			float altura, float peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, RazaNoValidaException {
		
		Personaje personaje = null;
		
		switch(opcion){
			case 0:
				return personaje= (Personaje) new Mago(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 1:
				return personaje= (Personaje) new Arquero(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 2:
				return personaje= (Personaje) new Guerrero(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						raza, descripcion);
			case 3:
				return personaje= (Personaje) new Dragon(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						descripcion);
			case 4:
				return personaje= (Personaje) new Dios(nombre, apellido, sexo, zodiaco, edad, altura, peso, region,
						descripcion);
			default:
				return personaje;
		}		
	}
	
	/**
	 * A&ntilde;ade un personaje al listado.
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
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 */
	public boolean annadirPersonaje(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			int altura, int peso, Region region, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException {
		
		Personaje personaje = new Personaje(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, descripcion); // Se crea un personaje
		if (listado.contains(personaje)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El personaje ya existe.");
		else{ // Si no lo contiene
			return listado.add(personaje); // Devuelve el personaje añadido al listado
		}	
	}
	
	/**
	 * A&ntilde;ade un mago al listado.
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
	 * @param descripcion Informaci&oacute;n del mago.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	public boolean annadirMago(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			int altura, int peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException, 
			RazaNoValidaException {
		
		Mago mago = new Mago(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, raza, descripcion); // Se crea un mago
		if (listado.contains(mago)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El mago ya existe.");
		else{ // Si no lo contiene
			return listado.add((Personaje)mago); // Devuelve el mago añadido al listado
		}	
	}
	
	/**
	 * A&ntilde;ade un arquero al listado.
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
	 * @param descripcion Informaci&oacute;n del arquero.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	public boolean annadirArquero(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			int altura, int peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException, 
			RazaNoValidaException {
		
		Arquero arquero = new Arquero(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, raza, descripcion); // Se crea un arquero
		if (listado.contains(arquero)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El arquero ya existe.");
		else{ // Si no lo contiene
			return listado.add((Personaje)arquero); // Devuelve el arquero añadido al listado
		}	
	}
	
	/**
	 * A&ntilde;ade un guerrero al listado.
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
	 * @param descripcion Informaci&oacute;n del guerrero.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 * @throws RazaNoValidaException Error por raza incorrecta.
	 */
	public boolean annadirGuerrero(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			int altura, int peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException, 
			RazaNoValidaException {
		
		Guerrero guerrero = new Guerrero(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, raza, descripcion); // Se crea un guerrero
		if (listado.contains(guerrero)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El guerrero ya existe.");
		else{ // Si no lo contiene
			return listado.add((Personaje)guerrero); // Devuelve el guerrero añadido al listado
		}	
	}
	
	/**
	 * A&ntilde;ade un drag&oacute;n al listado.
	 * 
	 * @param nombre Nombre del drag&oacute;n.
	 * @param apellido Apellido del drag&oacute;n.
	 * @param sexo Sexo del drag&oacute;n.
	 * @param zodiaco Signo del zodiaco del drag&oacute;n.
	 * @param edad Edad del drag&oacute;n.
	 * @param altura Altura del drag&oacute;n.
	 * @param peso Peso del drag&oacute;n.
	 * @param region Regi&oacute;n donde vive el drag&oacute;n.
	 * @param descripcion Informaci&oacute;n del drag&oacute;n.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 */
	public boolean annadirDragon(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			int altura, int peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException {
		
		Dragon dragon = new Dragon(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, descripcion); // Se crea un dragón
		if (listado.contains(dragon)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El dragón ya existe.");
		else{ // Si no lo contiene
			return listado.add((Personaje)dragon); // Devuelve el dragón añadido al listado
		}	
	}
		
	/**
	 * A&ntilde;ade un dios al listado.
	 * 
	 * @param nombre Nombre del dios.
	 * @param apellido Apellido del dios.
	 * @param sexo Sexo del dios.
	 * @param zodiaco Signo del zodiaco del dios.
	 * @param edad Edad del dios.
	 * @param altura Altura del dios.
	 * @param peso Peso del dios.
	 * @param region Regi&oacute;n donde vive el dios.
	 * @param descripcion Informaci&oacute;n del dios.
	 * 
	 * @throws ApellidoNoValidoException Error por apellido incorrecto.
	 * @throws NombreNoValidoException Error por nombre incorrecto.
	 * @throws RegionNoValidaException Error por regi&oacute;n incorrecta.
	 * @throws SexoNoValidoException Error por sexo incorrecto.
	 * @throws AlturaNoValidaException Error por altura incorrecta.
	 * @throws PesoNoValidoException Error por peso incorrecto.
	 * @throws ZodiacoNoValidoException Error por signo del zodiaco incorrecto.
	 * @throws EdadNoValidaException Error por edad incorrecta.
	 * @throws PersonajeYaExisteException Erro al existir el personaje.
	 */
	public boolean annadirDios(String nombre, String apellido, Sexo sexo, Zodiaco zodiaco, int edad, 
			float altura, float peso, Region region, Raza raza, String descripcion) throws ApellidoNoValidoException, 
			NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, 
			PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, PersonajeYaExisteException {
		
		Dios dios = new Dios(nombre, apellido, sexo, zodiaco, edad, altura, 
				peso, region, descripcion); // Se crea un dios
		if (listado.contains(dios)) // Si ya lo contiene, crea la excepción
			throw new PersonajeYaExisteException("El dios ya existe.");
		else{ // Si no lo contiene
			return listado.add((Personaje)dios); // Devuelve el dios añadido al listado
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
