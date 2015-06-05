package trabajoFinal.personajes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Gestiona el uso de los ficheros.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Gestion {
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Indica si el listado de personajes ha sido modificado o no. 
	 */
	private static boolean modificado;
	
	/**
	 * Archivo que contendr&aacute; el concesionario.
	 */
	private static File archivo = new File("Sin_Titulo");
	
	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	/**
	 * Devuelve si el listado de personajes ha sido modificado o no.
	 * 
	 * @return Si el listado de personajes ha sido modificado o no.
	 */
	public static boolean getModificado() { // Corresponde a isModificado()
		return modificado; 
	}

	/**
	 * Modifica si el listado de personajes est&aacute; modificado o no.
	 * 
	 * @param modificado Indica si el listado de personajes ha sido modificado o no.
	 */
	public static void setModificado(boolean modificado) {
		Gestion.modificado = modificado; 
	}
	
	/**
	 * Devuelve el archivo.
	 * 
	 * @return El archivo.
	 */
	public static File getArchivo() {
		return archivo;
	}
	
	/**
	 * Modifica el archivo.
	 * 
	 * @param archivo Fichero donde se guarda un objeto (listado de personajes).
	 */
	public static void setArchivo(File archivo) {
		Gestion.archivo = archivo;
		
	}
	
	/**
	 * Crea un archivo nuevo vac&iacute;o.
	 * 
	 * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
	 * 
	 */
	public static void nuevo() throws IOException {
		setArchivo(null); // Un archivo nuevo no contiene nada, es nulo
		Gestion.setArchivo(new File ("Sin_titulo.obj")); // Nuevo archivo
		General.personajes = new ListadoPersonajes(); // Nuevo listado
		setModificado(false); // Cambiamos su estado a no modificado
	}
	
	/**
	 * Abre un archivo, 
	 * cambia su estado a no modificado y
	 * reemplaza el archivo actual por el abierto.
	 * 
	 * @param archivo Archivo a abrir.
	 * 
	 * @return El archivo abierto.
	 * 
	 * @throws FileNotFoundException Error al no encontrar el archivo.
	 * @throws ClassNotFoundException Error al no encontrar la clase.
	 * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
	 * @throws FicheroCorruptoException Error al estar el archivo da&ntilde;ado.
	 */
	public static ListadoPersonajes abrir(File archivo) 
			throws FileNotFoundException, ClassNotFoundException, IOException, 
			FicheroCorruptoException {
		setModificado(false); // Cambiamos su estado a no modificado
		setArchivo(archivo);
		return Fichero.abrir(archivo);
	}
	
	/**
	 * Guarda un archivo, 
	 * cambia su estado a no modificado y 
	 * reemplaza el archivo actual por el guardado.
	 * 
	 * @param archivo Fichero donde se guarda.
	 * @param listado Listado de personajes.
	 * 
	 * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
	 */
	public static void guardar(File archivo, ListadoPersonajes listado) throws IOException {
		Fichero.guardar(archivo, General.personajes);
		setModificado(false); // Cambiamos su estado a no modificado
		//setArchivo(archivo);
	}

	

}
