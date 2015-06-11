package trabajoFinal.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

import trabajoFinal.personajes.AlturaNoValidaException;
import trabajoFinal.personajes.ApellidoNoValidoException;
import trabajoFinal.personajes.EdadNoValidaException;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Gestion;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PersonajeYaExisteException;
import trabajoFinal.personajes.PesoNoValidoException;
import trabajoFinal.personajes.Raza;
import trabajoFinal.personajes.Region;
import trabajoFinal.personajes.Sexo;
import trabajoFinal.personajes.Tipo;
import trabajoFinal.personajes.Zodiaco;

/**
 * Ventana que a&ntilde;ade un personaje al listado.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0 
 *
 */

public class Annadir extends VentanaPadre {

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -6537750238897758360L;

	/**
	 * Crea la ventana de di&aacute;logo.
	 */
	public Annadir() {
		botonOK.setText("A\u00F1adir");
		setBounds(100, 100, 604, 496);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Annadir.class.getResource("/trabajoFinal/gui/imagenes/Add_1_Icon_16.png")));
		setTitle("A\u00F1adir");
		
		nombreCampo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nombreCampo.setForeground(java.awt.Color.BLACK);
			}
			@Override // El campo del nombre se pone en rojo si está mal al perder el foco
			public void focusLost(FocusEvent e) {
				if(!Personaje.esValido(Personaje.getPatronNombre() ,nombreCampo.getText()))
					nombreCampo.setForeground(java.awt.Color.RED);
			}
		});
		
		// Añade una acción al botón Añadir
		
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir();
			}
		});
	}

	/**
	 * A&ntilde;ade un personaje al listado.
	 */
	private void annadir() {
		try {
			General.personajes.annadir(getTipoPersonaje(), nombreCampo.getText(), apellidoCampo.getText(), 
					(Sexo)sexoComboBox.getSelectedItem(), (Zodiaco)zodiacoComboBox.getSelectedItem(),
					Integer.parseInt(edadCampo.getText()), Double.parseDouble(alturaCampo.getText()), 
					Double.parseDouble(pesoCampo.getText()), (Region)regionComboBox.getSelectedItem(), 
					(Raza) razaComboBox.getSelectedItem(), descripcionCampo.getText());
			Gestion.setModificado(true);
			JOptionPane.showMessageDialog(panelContenedor, "Personaje añadido con éxito.", "Acción realizada", 
				JOptionPane.INFORMATION_MESSAGE);
		} catch (ApellidoNoValidoException | PersonajeYaExisteException
				| NombreNoValidoException | AlturaNoValidaException
				| PesoNoValidoException | EdadNoValidaException   e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(panelContenedor, "Error numérico", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(panelContenedor, "Valor nulo", "Error", JOptionPane.ERROR_MESSAGE);
		}
						
	}
	
	/**
	 * Devuelve un tipo de personaje seg&uacute;n 
	 * lo que hemos seleccionado.
	 * 
	 * @return El tipo de personaje.
	 */
	private Tipo getTipoPersonaje() {
		if (magoRB.isSelected())
			return Tipo.MAGO;
		else if (arqueroRB.isSelected())
			return Tipo.ARQUERO;
		else if (guerreroRB.isSelected())
			return Tipo.GUERRERO;
		else if (dragonRB.isSelected())
			return Tipo.DRAGÓN;
		else if (diosRB.isSelected())
			return Tipo.DIOS;
		else
			return null;
	}
}
