package trabajoFinal.gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Gestion;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PersonajeNoExisteException;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Borra un personaje del listado.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Eliminar extends VentanaPadre {

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = -2667649875092977832L;

	/**
	 * Create the dialog.
	 */
	public Eliminar() {
		botonOK.setText("Eliminar");
		descripcionCampo.setEnabled(false);
		descripcionCampo.setEditable(false);
		pesoCampo.setEnabled(false);
		alturaCampo.setEnabled(false);
		edadCampo.setEnabled(false);
		regionComboBox.setEnabled(false);
		razaComboBox.setEnabled(false);
		zodiacoComboBox.setEnabled(false);
		sexoComboBox.setEnabled(false);
		diosRB.setEnabled(false);
		dragonRB.setEnabled(false);
		guerreroRB.setEnabled(false);
		arqueroRB.setEnabled(false);
		magoRB.setEnabled(false);
		apellidoCampo.setEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eliminar.class.getResource("/trabajoFinal/gui/imagenes/Math_minus_Icon_16.png")));
		setTitle("Eliminar");
		setBounds(100, 100, 604, 496);
		
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
		
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // elimina
				eliminar();
			}
		});
	}

	/**
	 * Elimina un personaje del listado.
	 */
	private void eliminar() {
		
		try {
			General.personajes.eliminar(nombreCampo.getText());
			Gestion.setModificado(true);
			JOptionPane.showMessageDialog(panelContenedor, "Personaje eliminado con éxito.", "Acción realizada", JOptionPane.INFORMATION_MESSAGE);
		} catch (NombreNoValidoException | PersonajeNoExisteException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
