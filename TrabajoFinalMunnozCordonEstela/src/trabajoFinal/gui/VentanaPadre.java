package trabajoFinal.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import trabajoFinal.personajes.Raza;
import trabajoFinal.personajes.Region;
import trabajoFinal.personajes.Sexo;
import trabajoFinal.personajes.Zodiaco;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

/**
 * Ventana de di&aacute;logo con la que gestionamos el listado de personajes.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class VentanaPadre extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n de serie predeterminado.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel que contiene los elementos de la ventana.
	 */
	protected final JPanel panelContenedor = new JPanel();
	
	// --------- Nombre, Edad, Altura y Peso --------- \\
	/**
	 * Etiqueta para el nombre del personaje.
	 */
	protected JLabel nombreEtiqueta = new JLabel("Nombre");
	/**
	 * Etiqueta para el apellido del personaje.
	 */
	protected final JLabel apellidoEtiqueta = new JLabel("Apellido");
	/**
	 * Etiqueta para la edad del personaje.
	 */
	protected JLabel edadEtiqueta = new JLabel("Edad");
	/**
	 * Etiqueta para la altura del personaje.
	 */
	protected JLabel alturaEtiqueta = new JLabel("Altura");
	/**
	 * Etiqueta para el peso del personaje.
	 */
	protected JLabel pesoEtiqueta = new JLabel("Peso");
	/**
	 * Campo para escribir el nombre del personaje.
	 */
	protected JTextField nombreCampo = new JTextField();
	/**
	 * Campo para escribir el apellido del personaje.
	 */
	protected final JTextField apellidoCampo = new JTextField();
	/**
	 * Campo para escribir la edad del personaje.
	 */
	protected JTextField edadCampo = new JTextField();
	/**
	 * Campo para escribir la altura del personaje.
	 */
	protected JTextField alturaCampo = new JTextField();
	/**
	 * Campo para escribir el peso del personaje.
	 */
	protected JTextField pesoCampo = new JTextField();
	
	// --------- Descripción --------- \\
	/**
	 * Campo de texto para la descripci&oacute;n del personaje.
	 */
	protected final JTextPane descripcionCampo = new JTextPane();
	/**
	 * Etiqueta para la descripción del personaje.
	 */
	protected final JLabel descripcionEtiqueta = new JLabel("Descripci\u00F3n");
	
	// --------- Botones Salir y OK --------- \\
	/**
	 * Panel que contiene los botones para realizar las acciones.
	 */
	protected JPanel botonesPanel = new JPanel();
	/**
	 * Bot&oacute;n de OK (para realizar la acci&oacute;n).
	 */
	protected JButton botonOK = new JButton("OK");
	/**
	 * Bot&oacute;n de Salir para cerrar la ventana.
	 */
	protected JButton botonSalir = new JButton("Salir");
	
	// --------- Tipos --------- \\
	/**
	 * Panel que contiene los tipos disponibles para un personaje.
	 */
	protected JPanel tipoPanel = new JPanel();
	/**
	 * Grupo de botones que recoge los diferentes tipos de personajes.
	 */
	protected ButtonGroup tipoGrupo = new ButtonGroup();
	/**
	 * Mago.
	 */
	protected JRadioButton magoRB = new JRadioButton("Mago");
	/**
	 * Arquero.
	 */
	protected JRadioButton arqueroRB = new JRadioButton("Arquero");
	/**
	 * Guerrero.
	 */
	protected JRadioButton guerreroRB = new JRadioButton("Guerrero");
	/**
	 * Drag&oacute;n.
	 */
	protected JRadioButton dragonRB = new JRadioButton("Drag\u00F3n");
	/**
	 * Dios. 
	 */
	protected JRadioButton diosRB = new JRadioButton("Dios");
	
	// ---------- ComboBox sexo, signo del zodiaco, región y raza --------- \\
	/**
	 * Etiqueta para el sexo del personaje.
	 */
	protected JLabel sexoEtiqueta = new JLabel("Sexo");
	/**
	 * Etiqueta para el signo del zodiaco del personaje.
	 */
	protected JLabel zodiacoEtiqueta = new JLabel("Zodiaco");
	/**
	 * Etiqueta para la regi&oacute;n del personaje.
	 */
	protected final JLabel regionEtiqueta = new JLabel("Regi\u00F3n");
	/**
	 * Etiqueta para la raza del personaje.
	 */
	protected final JLabel razaEtiqueta = new JLabel("Raza");
	/**
	 * Etiqueta para el icono del mago.
	 */
	protected final JLabel iconoM = new JLabel("");
	/**
	 * Etiqueta para el icono del arquero.
	 */
	protected final JLabel iconoA = new JLabel("");
	/**
	 * Etiqueta para el icono del guerrero.
	 */
	protected final JLabel iconoG = new JLabel("");
	/**
	 * Etiqueta para el icono del dios.
	 */
	protected final JLabel iconoI = new JLabel("");
	/**
	 * Etiqueta para el icono del drag&oacute;n.
	 */
	protected final JLabel iconoD = new JLabel("");
	/**
	 * Etiqueta para el icono del del apellido.
	 */
	private final JLabel iconoApellido = new JLabel("");
	/**
	 * Etiqueta para el icono de la edad.
	 */
	private final JLabel iconoEdad = new JLabel("");
	/**
	 * Etiqueta para el icono de la altura.
	 */
	private final JLabel iconoAltura = new JLabel("");
	/**
	 * Etiqueta para el icono del peso.
	 */
	private final JLabel iconoPeso = new JLabel("");
	/**
	 * Lista de g&eacute;neros disponibles para elegir.
	 */
	protected JComboBox<Sexo> sexoComboBox = new JComboBox<Sexo>();
	/**
	 * Lista de signos del zodiaco disponibles para elegir.
	 */
	protected JComboBox<Zodiaco> zodiacoComboBox = new JComboBox<Zodiaco>();
	/**
	 * Lista de regiones disponibles para elegir.
	 */
	protected JComboBox<Region> regionComboBox = new JComboBox<Region>();
	/**
	 * Lista de razas disponibles para elegir.
	 */
	protected JComboBox<Raza> razaComboBox = new JComboBox<Raza>();	
				
		
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Crea el di&aacute;logo.
	 */
	public VentanaPadre() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 604, 496);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		
		// Campo nombre
		nombreCampo.setColumns(10);
		nombreCampo.setBounds(113, 23, 165, 20);
		panelContenedor.add(nombreCampo);
		
		// Etiqueta nombre
		nombreEtiqueta.setBounds(42, 26, 68, 13);
		panelContenedor.add(nombreEtiqueta);
		
		// Panel de tipos
		tipoPanel.setLayout(null);
		tipoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Personajes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tipoPanel.setBounds(23, 57, 129, 152);
		panelContenedor.add(tipoPanel);
		iconoD.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Dragon_Age_Origins_new_4_Icon_16.png")));
		iconoD.setBounds(93, 94, 21, 23);
		
		tipoPanel.add(iconoD);
		iconoG.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Warrior_1_Icon_16.png")));
		iconoG.setBounds(93, 68, 21, 23);
		
		tipoPanel.add(iconoG);
		iconoI.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Priest_1_Icon_16.png")));
		iconoI.setBounds(93, 120, 21, 23);
		
		tipoPanel.add(iconoI);
		iconoM.setBounds(93, 16, 21, 23);
		tipoPanel.add(iconoM);
		iconoM.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Mage_1_Icon_16.png")));
		iconoA.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Scout_1_Icon_16.png")));
		iconoA.setBounds(93, 42, 21, 23);
		tipoPanel.add(iconoA);
		tipoGrupo.add(magoRB);
		
		// mago
		magoRB.setForeground(new Color(0, 0, 128));
		magoRB.setFont(new Font("Tahoma", Font.BOLD, 11));
		magoRB.setBounds(6, 16, 109, 23);
		tipoPanel.add(magoRB);
		tipoGrupo.add(arqueroRB);
		
		// arquero
		arqueroRB.setForeground(SystemColor.controlDkShadow);
		arqueroRB.setFont(new Font("Tahoma", Font.BOLD, 11));
		arqueroRB.setBounds(6, 42, 109, 23);
		tipoPanel.add(arqueroRB);
		tipoGrupo.add(guerreroRB);
		
		// guerrero
		guerreroRB.setForeground(new Color(165, 42, 42));
		guerreroRB.setFont(new Font("Tahoma", Font.BOLD, 11));
		guerreroRB.setBounds(6, 68, 109, 23);
		tipoPanel.add(guerreroRB);
		
		// dragón
		tipoGrupo.add(dragonRB);
		dragonRB.setFont(new Font("Tahoma", Font.BOLD, 11));
		dragonRB.setForeground(new Color(51, 102, 51));
		dragonRB.setBounds(6, 94, 109, 23);
		tipoPanel.add(dragonRB);
		
		// dios
		tipoGrupo.add(diosRB);
		diosRB.setForeground(new Color(102, 0, 102));
		diosRB.setFont(new Font("Tahoma", Font.BOLD, 11));
		diosRB.setBounds(6, 120, 109, 23);
		tipoPanel.add(diosRB);
		
		// Etiqueta sexo
		sexoEtiqueta.setBounds(181, 65, 46, 14);
		panelContenedor.add(sexoEtiqueta);
				
		// Etiqueta zodiaco
		zodiacoEtiqueta.setBounds(183, 122, 46, 14);
		panelContenedor.add(zodiacoEtiqueta);
		
		// ComboBox sexo
		sexoComboBox.setModel(new DefaultComboBoxModel<Sexo>(Sexo.values()));
		sexoComboBox.setBounds(182, 86, 109, 28);
		panelContenedor.add(sexoComboBox);
		
		// ComboBox zodiaco
		zodiacoComboBox.setModel(new DefaultComboBoxModel<Zodiaco>(Zodiaco.values()));
		zodiacoComboBox.setBounds(182, 143, 109, 28);
		panelContenedor.add(zodiacoComboBox);
		
		// ComboBox región
		regionEtiqueta.setBounds(309, 65, 46, 14);
		panelContenedor.add(regionEtiqueta);
		regionComboBox.setModel(new DefaultComboBoxModel<Region>(Region.values()));
		regionComboBox.setBounds(310, 86, 109, 28);
		panelContenedor.add(regionComboBox);
		
		// ComboBox raza
		razaEtiqueta.setBounds(311, 122, 46, 14);		
		panelContenedor.add(razaEtiqueta);
		razaComboBox.setModel(new DefaultComboBoxModel<Raza>(Raza.values()));
		razaComboBox.setBounds(310, 143, 109, 28);		
		panelContenedor.add(razaComboBox);
		
		// Texto edad
		edadCampo.setColumns(10);
		edadCampo.setBounds(511, 94, 60, 20);
		panelContenedor.add(edadCampo);
		
		// Etiqueta edad
		edadEtiqueta.setBounds(462, 100, 60, 14);
		panelContenedor.add(edadEtiqueta);
		
		// Etiqueta altura
		alturaEtiqueta.setBounds(462, 128, 60, 14);
		panelContenedor.add(alturaEtiqueta);
		
		// Texto altura
		alturaCampo.setColumns(10);
		alturaCampo.setBounds(511, 122, 60, 20);
		panelContenedor.add(alturaCampo);
		
		// Etiqueta peso
		pesoEtiqueta.setBounds(462, 157, 60, 14);
		panelContenedor.add(pesoEtiqueta);
		
		// Texto peso
		pesoCampo.setColumns(10);
		pesoCampo.setBounds(511, 151, 60, 20);
		panelContenedor.add(pesoCampo);
		descripcionCampo.setBounds(25, 253, 548, 174);
		
		panelContenedor.add(descripcionCampo);
		descripcionEtiqueta.setBounds(23, 228, 149, 14);
		
		panelContenedor.add(descripcionEtiqueta);
		apellidoEtiqueta.setBounds(333, 26, 66, 14);
		
		panelContenedor.add(apellidoEtiqueta);
		apellidoCampo.setColumns(10);
		apellidoCampo.setBounds(406, 23, 165, 20);
		
		panelContenedor.add(apellidoCampo);
		
		JLabel iconoSexo = new JLabel("");
		iconoSexo.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		iconoSexo.setBounds(221, 56, 21, 23);
		panelContenedor.add(iconoSexo);
		
		JLabel iconoRegion = new JLabel("");
		iconoRegion.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		iconoRegion.setBounds(359, 57, 21, 23);
		panelContenedor.add(iconoRegion);
		
		JLabel iconoZodiaco = new JLabel("");
		iconoZodiaco.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		iconoZodiaco.setBounds(239, 117, 21, 23);
		panelContenedor.add(iconoZodiaco);
		
		JLabel iconoRaza = new JLabel("");
		iconoRaza.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/elf3.png")));
		iconoRaza.setBounds(351, 117, 21, 23);
		panelContenedor.add(iconoRaza);
		
		JLabel iconoNombre = new JLabel("");
		iconoNombre.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		iconoNombre.setBounds(18, 21, 21, 23);
		panelContenedor.add(iconoNombre);
		iconoApellido.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/A_Icon_16.png")));
		iconoApellido.setBounds(310, 22, 21, 23);
		
		panelContenedor.add(iconoApellido);
		iconoEdad.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/man489.png")));
		iconoEdad.setBounds(435, 95, 21, 23);
		
		panelContenedor.add(iconoEdad);
		iconoAltura.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/square73.png")));
		iconoAltura.setBounds(435, 126, 21, 23);
		
		panelContenedor.add(iconoAltura);
		iconoPeso.setIcon(new ImageIcon(VentanaPadre.class.getResource("/trabajoFinal/gui/imagenes/weight11.png")));
		iconoPeso.setBounds(433, 151, 21, 23);
		
		panelContenedor.add(iconoPeso);
		{
			// Panel de botones
			botonesPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(botonesPanel, BorderLayout.SOUTH);
			{
				// Botón OK
				botonOK.setActionCommand("OK");
				botonesPanel.add(botonOK);
				getRootPane().setDefaultButton(botonOK);
			}
			{
				// Botón Salir
				// Añadimos una acción al botón Salir
				botonSalir.addActionListener(new ActionListener() {
					// Cierra la ventana
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				botonSalir.setActionCommand("Cancel");
				botonesPanel.add(botonSalir);
			}
		}
	}
}
