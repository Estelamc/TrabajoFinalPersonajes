package trabajoFinal.gui;

import java.awt.Toolkit;

import trabajoFinal.personajes.Arquero;
import trabajoFinal.personajes.Dios;
import trabajoFinal.personajes.Dragon;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Guerrero;
import trabajoFinal.personajes.Mago;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PersonajeNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 * Busca un personaje por su nombre.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Buscar extends VentanaPadre {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -8843267002026858130L;

		
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Crea la ventana de di&acute;logo.
	 */
	public Buscar() {		
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
		descripcionCampo.setEditable(false);
		diosRB.setEnabled(false);
		dragonRB.setEnabled(false);
		guerreroRB.setEnabled(false);
		arqueroRB.setEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		setTitle("Buscar");
		setBounds(100, 100, 604, 496);
				
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrar(General.personajes.getPersonaje(nombreCampo.getText()));
					JOptionPane.showMessageDialog(panelContenedor, "Personaje encontrado con éxito.", "Encontrado", JOptionPane.INFORMATION_MESSAGE);
				} catch (NullPointerException | PersonajeNoExisteException
						| NombreNoValidoException e1) {			
					JOptionPane.showMessageDialog(panelContenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
		
	}
			
	/**
	 * Muestra el personaje del listado.
	 *  
	 * @param personaje Personaje del listado.
	 */
	private void mostrar(Personaje personaje) {
		nombreCampo.setText(personaje.getNombre());
		apellidoCampo.setText("Buscar");
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
