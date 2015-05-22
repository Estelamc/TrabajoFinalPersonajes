package trabajoFinal.gui;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import trabajoFinal.personajes.General;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PersonajeNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarPorNombre extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7187269644725782668L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarPorNombre dialog = new BuscarPorNombre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarPorNombre() {
		apellidoCampo.setEditable(false);
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	getCoche(matriculaCampo, panelContenedor, marcaComboBox, modeloComboBox, colorAzul, colorPlata, colorRojo);
				getPersonaje();*/
			}
		});
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
		edadCampo.setEditable(false);
		descripcionCampo.setEditable(false);
		pesoCampo.setEditable(false);
		alturaCampo.setEditable(false);
		pesoCampo.setEnabled(false);
		alturaCampo.setEnabled(false);
		razaComboBox.setEnabled(false);
		regionComboBox.setEnabled(false);
		zodiacoComboBox.setEnabled(false);
		sexoComboBox.setEnabled(false);
		diosRB.setEnabled(false);
		dragonRB.setEnabled(false);
		guerreroRB.setEnabled(false);
		arqueroRB.setEnabled(false);
		magoRB.setEnabled(false);
		edadCampo.setEnabled(false);
		setTitle("Buscar por nombre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarPorNombre.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		setBounds(100, 100, 604, 504);
	}

	private static void getPersonaje(JTextField nombreCampo, JTextField apellidoCampo, JTextField edadCampo, 
			JTextField alturaCampo, JTextField pesoCampo, JPanel panelContenedor, JComboBox sexoComboBox, 
			JComboBox zodiacoComboBox, JComboBox regionComboBox, JRadioButton colorAzul, 
			JRadioButton colorPlata, JRadioButton colorRojo) {
		Personaje personaje = null;
		// Obtiene un personaje del listado por su nombre y de él obtiene el resto de campos
		try {
			personaje = General.personajes.getPersonaje(nombreCampo.getText());
			nombreCampo.setText(personaje.getNombre());
			apellidoCampo.setText(personaje.getApellido());
			edadCampo.setText(Integer.toString(personaje.getEdad()));
			alturaCampo.setText(Float.toString(personaje.getAltura()));
			pesoCampo.setText(Float.toString(personaje.getPeso()));
			sexoComboBox.setSelectedItem(personaje.getSexo());
			zodiacoComboBox.setSelectedItem(personaje.getZodiaco());
			regionComboBox.setSelectedItem(personaje.getRegion());
			// raza ?? --> según hijo (no dragón ni dios)
			/*switch (coche.getColor()) {
				case AZUL:
					colorAzul.setSelected(true);
					break;
				case PLATA:
					colorPlata.setSelected(true);
					break;
				case ROJO:
					colorRojo.setSelected(true);
			}*/
			JOptionPane.showMessageDialog(panelContenedor, "Coche encontrado con éxito.", "Acción realizada", 
					JOptionPane.INFORMATION_MESSAGE);
		} catch (PersonajeNoExisteException | NombreNoValidoException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
