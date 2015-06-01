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
	private int indice = -1;
	
	
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
		
		botonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		
		actualizar();
	}


	private void mostrarSiguiente() {
		// TODO Auto-generated method stub
		mostrar(General.personajes.getPersonajePorPosicion(++indice));
		comprobarBotones();
	}


	private void mostrarAnterior() {
		// TODO Auto-generated method stub
		mostrar(General.personajes.getPersonajePorPosicion(--indice));
		comprobarBotones();
	}
	
	private void actualizar() {
		// TODO Auto-generated method stub
		if (General.personajes.cantidadPersonajes() == 0) {
			return;
		}
		indice = 0;
		mostrar(General.personajes.getPersonajePorPosicion(indice));
		comprobarBotones();	
	}
	
	private void comprobarBotones() {
		if (General.personajes.getPersonajePorPosicion(indice + 1) == null)
			botonSiguiente.setEnabled(false);
		else
			botonSiguiente.setEnabled(true);

		if (General.personajes.getPersonajePorPosicion(indice - 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonAnterior.setEnabled(true);
	}
	
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
		}
		else if(personaje instanceof Dragon){
			dragonRB.setSelected(true);
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
