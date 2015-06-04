package trabajoFinal.gui;

import java.awt.Toolkit;
import javax.swing.JButton;
import trabajoFinal.personajes.Arquero;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.ListadoPersonajes;
import trabajoFinal.personajes.Personaje;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Muestra todos los arqueros del listado.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class BuscarArqueros extends VentanaPadre {

	// ----------------------------------- NUESTROS CAMPOS
	// ----------------------------------- \\

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -4966103532386248395L;

	/**
	 * Bot&oacute;n para ver el personaje anterior del listado.
	 */
	private JButton botonAnterior = new JButton("<");

	/**
	 * Bot&oacute;n para ver el personaje siguiente del listado.
	 */
	private JButton botonSiguiente = new JButton(">");

	/**
	 * &Iacute;ndice identificador del personaje para tener una referencia para
	 * saber si podemos seguir adelante o para atr&aacute;s o ya no hay
	 * m&aacute;s personajes que mostrar. (hace referencia a la posici&oacute;n
	 * del personaje en el listado) (-1 es que no lo contiene)
	 */
	private int indice = 0;

	/**
	 * Listado de personajes de tipo arquero.
	 */
	private ListadoPersonajes arqueros = new ListadoPersonajes();

	// ----------------------------------- NUESTRA APLICACIÓN
	// ----------------------------------- \\

	/**
	 * Crea la ventana de di&acute;logo.
	 */
	public BuscarArqueros() {
		botonOK.setText("Buscar");
		regionComboBox.setEnabled(false);
		razaComboBox.setEnabled(false);
		zodiacoComboBox.setEnabled(false);
		sexoComboBox.setEnabled(false);
		magoRB.setEnabled(false);
		edadCampo.setEditable(false);
		pesoCampo.setEditable(false);
		alturaCampo.setEditable(false);
		apellidoCampo.setEditable(false);
		nombreCampo.setEditable(false);
		descripcionCampo.setEditable(false);
		diosRB.setEnabled(false);
		dragonRB.setEnabled(false);
		guerreroRB.setEnabled(false);
		arqueroRB.setEnabled(false);
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						BuscarArqueros.class
								.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Scout_1_Icon_16.png")));
		setTitle("Buscar Arqueros");
		setBounds(100, 100, 604, 496);

		botonAnterior.setEnabled(false);
		botonesPanel.add(botonAnterior);
		botonSiguiente.setEnabled(false);
		botonesPanel.add(botonSiguiente);

		// Empezando desde 0 (ya después le daremos a los botones)

		// mostrar(magos.getPersonajePorPosicion(indice));

		botonAnterior.addActionListener(new ActionListener() { // Muestra el
																// anterior
					public void actionPerformed(ActionEvent e) {
						recorrerListado(--indice);
					}
				});

		botonSiguiente.addActionListener(new ActionListener() { // Muestra el
																// siguiente
					public void actionPerformed(ActionEvent e) {
						recorrerListado(++indice);
					}
				});

		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarArqueros();
			}
		});
	}

	/**
	 * Recorre el listado de personajes mostr&aacute;ndolos.
	 * 
	 * @param posicion
	 *            Posici&oacute;n del personaje en el listado (&iacute;ndice).
	 */
	private void recorrerListado(int posicion) {
		mostrar(arqueros.getPersonajePorPosicion(posicion));
		comprobarBotones(); // Comprobamos si hay que deshabilitar algún botón
	}

	/**
	 * Se asegura de que los botones para avanzar o retroceder deban estar
	 * habilitados o no, seg&uacute;n se haya llegado al final del recorrido del
	 * listado o no.
	 */
	private void comprobarBotones() {
		if (arqueros.getPersonajePorPosicion(indice + 1) == null) // Si ya no se
																	// puede
																	// avanzar
																	// más
			botonSiguiente.setEnabled(false); // Se inhabilita (no hay más que
												// ver)
		else if (arqueros.getPersonajePorPosicion(indice - 1) == null) // Si ya
																		// no se
																		// puede
																		// retroceder
																		// más
			botonAnterior.setEnabled(false); // Se inhabilita (no hay más que
												// ver)
		else {
			botonSiguiente.setEnabled(true); // Sino, permanece habilitado
			botonAnterior.setEnabled(true); // Sino, permanece habilitado
		}
	}

	/**
	 * Muestra el personaje del listado.
	 * 
	 * @param personaje
	 *            Personaje del listado.
	 */
	private void mostrar(Personaje personaje) {
		nombreCampo.setText(personaje.getNombre());
		apellidoCampo.setText(personaje.getApellido());
		descripcionCampo.setText(personaje.getDescripcion());
		edadCampo.setText(Integer.toString(personaje.getEdad()));
		pesoCampo.setText(Double.toString(personaje.getPeso()));
		alturaCampo.setText(Double.toString(personaje.getAltura()));
		sexoComboBox.setSelectedItem(personaje.getSexo());
		zodiacoComboBox.setSelectedItem(personaje.getZodiaco());
		regionComboBox.setSelectedItem(personaje.getRegion());
		arqueroRB.setSelected(true);
		razaComboBox.setSelectedItem(((Arquero) personaje).getRaza());
		panelContenedor.setLayout(null);
	}

	/**
	 * Busca los arqueros del listado.
	 */
	private void buscarArqueros() {
		arqueros.setListado(General.personajes.getArqueros());
		mostrar(arqueros.getPersonajePorPosicion(indice));
		comprobarBotones();
		botonOK.setEnabled(false);
	}

}
