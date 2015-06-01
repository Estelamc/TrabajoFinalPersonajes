package trabajoFinal.gui;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import trabajoFinal.personajes.Arquero;
import trabajoFinal.personajes.Dios;
import trabajoFinal.personajes.Dragon;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Guerrero;
import trabajoFinal.personajes.Mago;
import trabajoFinal.personajes.NombreNoValidoException;
import trabajoFinal.personajes.Personaje;
import trabajoFinal.personajes.PersonajeNoExisteException;
import trabajoFinal.personajes.Raza;
import trabajoFinal.personajes.Region;
import trabajoFinal.personajes.Sexo;
import trabajoFinal.personajes.Zodiaco;
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
	 * Create the dialog.
	 */
	public BuscarPorNombre() {
		
		botonOK.setText("Buscar");
		apellidoCampo.setEditable(false);
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
		
		// Acción del botón Buscar: Muestra el personaje
		
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getPersonaje(nombreCampo, apellidoCampo, edadCampo, 
				alturaCampo, pesoCampo,panelContenedor, sexoComboBox, 
				zodiacoComboBox, regionComboBox, razaComboBox, magoRB, 
				arqueroRB, guerreroRB, dragonRB, diosRB, descripcionCampo);
			}
		});
		
		// Acciones según se gane o pierda el foco en el campo Nombre
		
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
				
	}

	/**
	 * Obtiene un personje busc&aacute;ndolo por el nombre.
	 * 
	 * @param nombreCampo Nombre del personaje.
	 * @param apellidoCampo Apellido del personaje.
	 * @param edadCampo Edad del personaje.
	 * @param alturaCampo Altura del personaje.
	 * @param pesoCampo Peso del personaje.
	 * @param panelContenedor Panel contenedor que contiene los elementos de la ventana.
	 * @param sexoComboBox Sexo del personaje.
	 * @param zodiacoComboBox Zodiaco del personaje.
	 * @param regionComboBox Regi&oacute;n del personaje.
	 * @param razaComboBox Raza del personaje.
	 * @param magoRB Mago.
	 * @param arqueroRB Arquero.
	 * @param guerreroRB Guerrero.
	 * @param dragonRB Drag&oacute;n.
	 * @param diosRB Dios.
	 * @param descripcionCampo Descripci&oacute;n del personaje.
	 */
	private static void getPersonaje(JTextField nombreCampo, JTextField apellidoCampo, JTextField edadCampo, 
			JTextField alturaCampo, JTextField pesoCampo, JPanel panelContenedor, JComboBox<Sexo> sexoComboBox, 
			JComboBox<Zodiaco> zodiacoComboBox, JComboBox<Region> regionComboBox, JComboBox<Raza> razaComboBox, JRadioButton magoRB, 
			JRadioButton arqueroRB, JRadioButton guerreroRB, JRadioButton dragonRB, JRadioButton diosRB, JTextPane descripcionCampo) {
		Personaje personaje = null;
		// Obtiene un personaje del listado por su nombre y de él obtiene el resto de campos
		try {
			personaje = General.personajes.getPersonaje(nombreCampo.getText());
			
			nombreCampo.setText(personaje.getNombre());
			apellidoCampo.setText(personaje.getApellido());
			edadCampo.setText(Integer.toString(personaje.getEdad()));
			alturaCampo.setText(Double.toString(personaje.getAltura()));
			pesoCampo.setText(Double.toString(personaje.getPeso()));
			sexoComboBox.setSelectedItem(personaje.getSexo());
			zodiacoComboBox.setSelectedItem(personaje.getZodiaco());
			regionComboBox.setSelectedItem(personaje.getRegion());
			descripcionCampo.setText(personaje.getDescripcion());
			if(personaje instanceof Dios){
				diosRB.setSelected(true);
				razaComboBox.setVisible(false);
			}
			else if(personaje instanceof Dragon){
				dragonRB.setSelected(true);
				razaComboBox.setVisible(false);
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
			
			JOptionPane.showMessageDialog(panelContenedor, "Personaje encontrado con éxito.", "Acción realizada", 
					JOptionPane.INFORMATION_MESSAGE);
		} catch (PersonajeNoExisteException | NombreNoValidoException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
