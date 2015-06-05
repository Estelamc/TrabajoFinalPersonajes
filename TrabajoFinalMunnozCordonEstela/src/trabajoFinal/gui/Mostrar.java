package trabajoFinal.gui;

import java.awt.Toolkit;

import javax.swing.JButton;

import trabajoFinal.personajes.Arquero;
import trabajoFinal.personajes.Dios;
import trabajoFinal.personajes.Dragon;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Guerrero;
import trabajoFinal.personajes.Mago;
import trabajoFinal.personajes.Personaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Muestra todos los personajes del listado.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Mostrar extends VentanaPadre {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -5342906477901337296L;
	
	/**
	 * Bot&oacute;n para ver el personaje anterior del listado.
	 */
	private JButton botonAnterior = new JButton("<");
	
	/**
	 * Bot&oacute;n para ver el personaje siguiente del listado.
	 */
	private JButton botonSiguiente = new JButton(">");

	/**
	 * &Iacute;ndice identificador del personaje para 
	 * tener una referencia para saber si podemos
	 * seguir adelante o para atr&aacute;s o ya no hay m&aacute;s
	 * personajes que mostrar. 
	 * (hace referencia a la posici&oacute;n del personaje en el listado)
	 * (-1 es que no lo contiene)
	 */
	private int indice = 0;
	
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Crea la ventana de di&acute;logo.
	 */
	public Mostrar() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mostrar.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		setTitle("Mostrar");
		setBounds(100, 100, 604, 496);
		botonOK.setVisible(false);
		
		botonAnterior.setEnabled(false);		
		botonesPanel.add(botonAnterior);
		botonesPanel.add(botonSiguiente);
		
		General.personajes.ordenarAlfabeticamente(); // Los ordenamos alfabéticamente
		
		// Empezando desde 0 (ya después le daremos a los botones)
		
		mostrar(General.personajes.getPersonajePorPosicion(indice));		
		
		botonAnterior.addActionListener(new ActionListener() { // Muestra el anterior
			public void actionPerformed(ActionEvent e) {	
				recorrerListado(--indice);
			}
		});
				
		botonSiguiente.addActionListener(new ActionListener() {	// Muestra el siguiente
			public void actionPerformed(ActionEvent e) {				
				recorrerListado(++indice);
			}
		});			
	}
	
	/**
	 * Recorre el listado de personajes mostr&aacute;ndolos.
	 * 
	 * @param posicion Posici&oacute;n del personaje en el listado (&iacute;ndice).
	 */
	private void recorrerListado(int posicion){
		mostrar(General.personajes.getPersonajePorPosicion(posicion));
		comprobarBotones(); // Comprobamos si hay que deshabilitar algún botón
	}
	
	/**
	 * Se asegura de que los botones para avanzar o retroceder 
	 * deban estar habilitados o no, seg&uacute;n se haya llegado 
	 * al final del recorrido del listado o no.
	 */
	private void comprobarBotones() {
		if (General.personajes.getPersonajePorPosicion(indice + 1) == null) // Si ya no se puede avanzar más
			botonSiguiente.setEnabled(false); // Se inhabilita (no hay más que ver)
		else if(General.personajes.getPersonajePorPosicion(indice - 1) == null) // Si ya no se puede retroceder más
			botonAnterior.setEnabled(false); // Se inhabilita (no hay más que ver)
		else{
			botonSiguiente.setEnabled(true); // Sino, permanece habilitado
			botonAnterior.setEnabled(true); // Sino, permanece habilitado			
		}
	}
	
	/**
	 * Muestra el personaje del listado.
	 *  
	 * @param personaje Personaje del listado.
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
		if(personaje instanceof Dios){
			diosRB.setSelected(true);
			razaComboBox.setVisible(false);
			iconoRaza.setVisible(false);
			razaEtiqueta.setVisible(false);
		}
		else if(personaje instanceof Dragon){
			dragonRB.setSelected(true);
			razaComboBox.setVisible(false);
			iconoRaza.setVisible(false);
			razaEtiqueta.setVisible(false);
		}
		else if(personaje instanceof Mago){
			magoRB.setSelected(true);
			razaComboBox.setSelectedItem(((Mago) personaje).getRaza());
		}
		else if(personaje instanceof Arquero){
			arqueroRB.setSelected(true);
			razaComboBox.setSelectedItem(((Arquero) personaje).getRaza());
		}	
		else if(personaje instanceof Guerrero){
			guerreroRB.setSelected(true);
			razaComboBox.setSelectedItem(((Guerrero) personaje).getRaza());
		}
		panelContenedor.setLayout(null);
	}
}
