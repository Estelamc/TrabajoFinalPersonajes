package trabajoFinal.personajes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Clase para crear y usar ficheros.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Fichero {
		
	// Nota: aqu� abrir() y guardar() se limitan a leer y escribir fichero, a secas
	// En abrir() se crea la excepci�n FicheroCorruptoException
	
	 /**
     * Abre el listado de personajes desde un archivo (lo lee).
     *
     * @param archivo Fichero que contiene el listado
     * 
     * @return El listado de personajes contenido en el archivo.
     * 
     * @throws FileNotFoundException Error al no encontrar el archivo.
     * @throws ClassNotFoundException Error al no encontrarse la clase.
     * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
     * @throws FicheroCorruptoException Error por archivo da&ntilde;ado.
     */
    public static ListadoPersonajes abrir(File archivo) throws FileNotFoundException, 
    	ClassNotFoundException, IOException, FicheroCorruptoException {
    	// A�adimos la extensi�n al archivo, por si acaso, antes de hacer nada
    	archivo = annadirExtension(archivo);
    	// Abrimos el archivo
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(
        		new BufferedInputStream(new FileInputStream(archivo)))) {
            return (ListadoPersonajes) objetoEntrada.readObject();
        // Si no puede abrirlo (por fallos de consistencia interna del archivo)
        } catch (StreamCorruptedException e) { // Crea la excepci�n
            throw new FicheroCorruptoException("Fichero corrupto.");
        }
    }
	
    /**
     * Guarda el listado de personajes dentro de un archivo.
     *
     * @param archivo Fichero donde se guarda el listado.
     * @param listado Listado de personajes que se quiere guardar.
     * 
     * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
     */
    public static void guardar(File archivo, ListadoPersonajes listado) throws IOException {
        // A�adimos la extensi�n al archivo, por si acaso, antes de hacer nada
    	archivo = annadirExtension(archivo);
    	// Guardamos el archivo
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        		new BufferedOutputStream(new FileOutputStream(archivo, false)))) { 
            objectOutputStream.writeObject(listado); // Sobreescribe el archivo
        }
    }
	
	/**
	 * A&ntilde;ade una extensi&oacute;n espec&iacute;fica al archivo.
	 * 
	 * @param archivo Fichero al que se le a&ntilde;ade la extensi&oacute;n.
	 * 
	 * @return Archivo con la extensi&oacute;n a&ntilde;adida.
	 */
	private static File annadirExtension(File archivo) {
		String extension = archivo.getPath(); 
		if (!extension.endsWith(".obj")) // Si no termina con .obj, lo a�ade
			return new File(archivo + ".obj");
		return archivo;
	}
	
	/**
	 * Comprueba si el archivo existe ya o no.
	 * 
	 * @param archivo Fichero a comprobar.
	 * 
	 * @return True si el archivo existe o False sino.
	 */
	public static boolean siArchivoExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}

}
