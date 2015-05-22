package trabajoFinal.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import trabajoFinal.personajes.AlturaNoValidaException;
import trabajoFinal.personajes.ApellidoNoValidoException;
import trabajoFinal.personajes.EdadNoValidaException;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Gestion;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PesoNoValidoException;
import trabajoFinal.personajes.Raza;
import trabajoFinal.personajes.RazaNoValidaException;
import trabajoFinal.personajes.Region;
import trabajoFinal.personajes.RegionNoValidaException;
import trabajoFinal.personajes.Sexo;
import trabajoFinal.personajes.SexoNoValidoException;
import trabajoFinal.personajes.Zodiaco;
import trabajoFinal.personajes.ZodiacoNoValidoException;

public class Annadir extends VentanaPadre {

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -6537750238897758360L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Annadir dialog = new Annadir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Annadir() {
		botonOK.setText("A\u00F1adir");
		setBounds(100, 100, 604, 496);
	
		nombreCampo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nombreCampo.setForeground(java.awt.Color.BLACK);
			}
			@Override // El campo del nombre se pone en rojo si está mal al perder el foco
			public void focusLost(FocusEvent e) {
				if(!Personaje.esValido(Personaje.getPatronNombre() ,nombreCampo.getText()));
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
	 * A&ntilde;ade un coche al concesionario.
	 */
	private void annadir() {
		try {
			General.personajes.annadir(getTipoPersonaje(), nombreCampo.getText(), apellidoCampo.getText(), 
					(Sexo)sexoComboBox.getSelectedItem(), (Zodiaco)zodiacoComboBox.getSelectedItem(),
					Integer.parseInt(edadCampo.getText()), Float.parseFloat(alturaCampo.getText()), 
					Float.parseFloat(pesoCampo.getText()), (Region)regionComboBox.getSelectedItem(), 
					(Raza) razaComboBox.getSelectedItem(), descripcionCampo.getText());
			Gestion.setModificado(true);
			JOptionPane.showMessageDialog(panelContenedor, "Personaje añadido con éxito.", "Acción realizada", 
				JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException | ApellidoNoValidoException
				| NombreNoValidoException | RegionNoValidaException
				| SexoNoValidoException | AlturaNoValidaException
				| PesoNoValidoException | ZodiacoNoValidoException
				| EdadNoValidaException | RazaNoValidaException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	/**
	 * Devuelve un entero seg&uacute;n el tipo de
	 * personaje seleccionado.
	 * 
	 * @return Un entero.
	 */
	private int getTipoPersonaje() {
		if (magoRB.isSelected())
			return 0;
		else if (arqueroRB.isSelected())
			return 1;
		else if (guerreroRB.isSelected())
			return 2;
		else if (dragonRB.isSelected())
			return 3;
		else if (diosRB.isSelected())
			return 4;
		else
			return 5;
	}
}
