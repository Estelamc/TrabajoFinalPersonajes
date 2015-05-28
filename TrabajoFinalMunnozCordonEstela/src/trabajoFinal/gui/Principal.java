package trabajoFinal.gui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.KeyStroke;
import trabajoFinal.personajes.Fichero;
import trabajoFinal.personajes.FicheroCorruptoException;
import trabajoFinal.personajes.General;
import trabajoFinal.personajes.Gestion;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * Ventana principal que gestiona el programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Principal {

	// ------------------------------------------------------------------------------------------ \\
	// ------------------------------------  NUESTROS CAMPOS  ----------------------------------- \\
	// ------------------------------------------------------------------------------------------ \\
	
	/**
	 * Marco principal que contiene todos los elementos de la ventana.
	 */
	private JFrame ventanaPrincipal = new JFrame();
		
	/**
	 * Panel para contener elementos.
	 */
	private JPanel panelContenedor;
	
	/**
	 * Barra de men&uacute;.
	 */
	private JMenuBar menuBarra = new JMenuBar();
	
	
	// ----------------------------------- Ficheros ---- \\
	
	/**
	 * Men&uacute; Ficheros.
	 */
	private JMenu menuFicheros = new JMenu("Ficheros");
	
	/**
	 * Submen&uacute; Abrir.
	 */
	private JMenuItem menuAbrir = new JMenuItem("Abrir");
	
	/**
	 * Submen&uacute; Nuevo.
	 */
	private JMenuItem menuNuevo = new JMenuItem("Nuevo");
	
	/**
	 * Subme&uacute; Guardar.
	 */
	private JMenuItem menuGuardar = new JMenuItem("Guardar");
	
	/**
	 * Submen&uacute; Guardar como.
	 */
	private JMenuItem menuGuardarComo = new JMenuItem("Guardar como...");
	
	/**
	 * L&iacute;nea que separa el submen&uacute; Salir del resto.
	 */
	private JSeparator separador = new JSeparator();
	
	/**
	 * Submen&uacute; Salir.
	 */
	private JMenuItem menuSalir = new JMenuItem("Salir");
	
	
	// ----------------------------------- Personaje ---- \\
	
	/**
	 * Men&uacute; Personaje.
	 */
	private final JMenu menuPersonaje = new JMenu("Personaje");
	
	/**
	 * Men&uacute; A&ntilde;adir Personaje.
	 */
	private final JMenuItem menuAnnadirP = new JMenuItem("A\u00F1adir");
	
	/**
	 * Men&uacute; Eliminar Personaje.
	 */
	private final JMenuItem menuEliminarP = new JMenuItem("Eliminar");
	
	/**
	 * Men&uacute; Buscar Personaje.
	 */
	private final JMenu menuBuscarP = new JMenu("Buscar");
	
	/**
	 * Men&uacute; Buscar Personaje por el Nombre.
	 */
	private final JMenuItem menuNombreP = new JMenuItem("Buscar por el nombre");
	
	/**
	 * Men&uacute; Buscar Personaje por el Sexo.
	 */
	private final JMenuItem menuSexoP = new JMenuItem("Buscar por el sexo");
	
	/**
	 * Men&uacute; Buscar Personaje por la Regi&oacute;n.
	 */
	private final JMenuItem menuRegionP = new JMenuItem("Buscar por la regi\u00F3n");
	
	/**
	 * Men&uacute; Buscar Personaje por el Zodiaco.
	 */
	private final JMenuItem menuZodiacoP = new JMenuItem("Buscar por el zodiaco");
	
	/**
	 * Men&uacute; Buscar Personaje por la Raza.
	 */
	private final JMenuItem menuRazaP = new JMenuItem("Buscar por la raza");
	/**
	 * Men&uacute; Mostrar Personajes.
	 */
	private final JMenuItem menuMostrarP = new JMenuItem("Mostrar");
	
	/**
	 * Men&uacute; Total de Personajes.
	 */
	private final JMenuItem menuTotalP = new JMenuItem("Total");
	
	
	// ----------------------------------- Mago ---- \\
	
	/**
	 * Men&uacute; Mago. 
	 */
	private JMenu menuMago = new JMenu("Mago");
	
	/**
	 * Men&uacute; Buscar magos.
	 */
	private final JMenu menuBuscarM = new JMenu("Buscar");
	
	/**
	 * Submen&uacute; Buscar mago por el nombre.
	 */
	private JMenuItem menuNombreM = new JMenuItem("Buscar por el nombre");	
	
	/**
	 * Submen&uacute; Buscar magos por el sexo.
	 */
	private JMenuItem menuSexoM = new JMenuItem("Buscar por el sexo");
	
	/**
	 * Men&uacute; Buscar magos por la regi&oacute;n.
	 */
	private JMenuItem menuRegionM = new JMenuItem("Buscar por la regi\u00F3n");
	
	/**
	 * Men&uacute; Buscar magos por el signo del zodiaco.
	 */
	JMenuItem menuZodiacoM = new JMenuItem("Buscar por el zodiaco");
	
	/**
	 * Submen&uacute; Buscar magos por la raza.
	 */
	private final JMenuItem menuRazaM = new JMenuItem("Buscar por la raza");
	
	/**
	 * Submen&uacute; Mostrar magos existentes.
	 */
	private JMenuItem menuMostrarM = new JMenuItem("Mostrar magos");
	
	/**
	 * Submen&uacute; Total de magos.
	 */
	private JMenuItem menuTotalM = new JMenuItem("Total de magos");
	
		
	// ----------------------------------- Arquero ---- \\
	
	/**
	 * Men&uacute; Arquero.
	 */
	private JMenu menuArquero = new JMenu("Arquero");	
	
	/**
	 * Men&uacute; para buscar arqueros.
	 */
	private final JMenu menuBuscarA = new JMenu("Buscar");
	
	/**
	 * Men&uacute; para buscar un arquero por su nombre.
	 */
	private JMenuItem menuNombreA = new JMenuItem("Buscar por el nombre");	
	
	/**
	 * Men&uacute; para buscar arqueros por el sexo.
	 */
	private JMenuItem menuSexoA = new JMenuItem("Buscar por el sexo");	
	
	/**
	 * Men&uacute; para buscar arqueros por la regi&oacute;n.
	 */
	private JMenuItem menuRegionA = new JMenuItem("Buscar por la regi\u00F3n");	
	
	/**
	 * Men&uacute; para buscar arqueros por el signo del zodiaco.
	 */
	private JMenuItem menuZodiacoA = new JMenuItem("Buscar por el zodiaco");
	
	/**
	 * Men&uacute; para mostrar los arqueros existentes.
	 */
	private JMenuItem menuMostrarA = new JMenuItem("Mostrar arqueros");

	/**
	 * Men&uacute; para ver el total de arqueros.
	 */
	private JMenuItem menuTotalA = new JMenuItem("Total de arqueros");
	
	/**
	 * Men&uacute; para buscar a un arquero por su raza.
	 */
	private final JMenuItem menuRazaA = new JMenuItem("Buscar por la raza");
	
	
	// ----------------------------------- Guerrero ---- \\
	
	/**
	 * Men&uacute; Guerrero.
	 */
	private final JMenu menuGuerrero = new JMenu("Guerrero");
	
	/**
	 * Men&uacute; para buscar guerreros.
	 */
	private final JMenu menuBuscarG = new JMenu("Buscar");
	
	/**
	 * Men&uacute; para buscar un guerrero por el nombre.
	 */
	private final JMenuItem menuNombreG = new JMenuItem("Buscar por el nombre");
	
	/**
	 * Men&uacute; para buscar un guerrero por el sexo.
	 */
	private final JMenuItem menuSexoG = new JMenuItem("Buscar por el sexo");
	
	/**
	 * Men&uacute; para buscar un guerrero por la regi&oacute;n.
	 */
	private final JMenuItem menuRegionG = new JMenuItem("Buscar por la regi\u00F3n");
	
	/**
	 * Men&uacute; para buscar un guerrero por el signo del zodiaco.
	 */
	private final JMenuItem menuZodiacoG = new JMenuItem("Buscar por el zodiaco");
	
	/**
	 * Men&uacute; para buscar un guerrero por su raza.
	 */
	private final JMenuItem menuRazaG = new JMenuItem("Buscar por la raza");
	
	/**
	 * Men&uacute; para mostrar los guerreros existentes.
	 */
	private final JMenuItem menuMostrarG = new JMenuItem("Mostrar guerreros");
	
	/**
	 * Men&uacute; para ver el total de guerreros existentes.
	 */
	private final JMenuItem menuTotalG = new JMenuItem("Total de guerreros");	
	
	
	// ----------------------------------- Dragón ---- \\
	
	/**
	 * Men&uacute; Drag&oacute;n.
	 */
	private final JMenu menuDragon = new JMenu("Drag\u00F3n");
	
	/**
	 * Men&uacute; para buscar dragones.
	 */
	private final JMenu menuBuscarD = new JMenu("Buscar");
	
	/**
	 * Men&uacute; para buscar un drag&oacute;n por su nombre.
	 */
	private final JMenuItem menuNombreD = new JMenuItem("Buscar por el nombre");
	
	/**
	 * Men&uacute; para buscar dragones por el sexo.
	 */
	private final JMenuItem menuSexoD = new JMenuItem("Buscar por el sexo");
	
	/**
	 * Men&uacute; para buscar dragones por la regi&oacute;n.
	 */
	private final JMenuItem menuRegionD = new JMenuItem("Buscar por la regi\u00F3n");
	
	/**
	 * Men&uacute; para buscar dragones por el signo del zodiaco.
	 */
	private final JMenuItem menuZodiacoD = new JMenuItem("Buscar por el zodiaco");
	
	/**
	 * Men&uacute; para mostrar los dragones existentes.
	 */
	private final JMenuItem menuMostrarD = new JMenuItem("Mostrar dragones");
	
	/**
	 * Men&uacute; para ver el total de dragones.
	 */
	private final JMenuItem menuTotalD = new JMenuItem("Total de dragones");
	
	
	// ----------------------------------- Ayuda ---- \\
	
	/**
	 * Men&uacute; Ayuda.
	 */
	private JMenu menuAyuda = new JMenu("Ayuda");

	/**
	 * Submen&uacute; Ver Ayuda para ver 
	 * las instrucciones del programa.
	 */
	private JMenuItem menuVerAyuda = new JMenuItem("Ver Ayuda");

	/**
	 * Submen&uacute; Acerca de que contiene 
	 * informaci&oacute;n sobre el programa.
	 */
	private JMenuItem menuAcercaDe = new JMenuItem("Acerca de...");
	
	
	// ----------------------------------- Otros ---- \\
	
	/**
	 * Ventana para gestionar archivos.
	 */
	private JFileChooser ventanaSeleccion = new JFileChooser();
	
	/**
	 * Filtro para seleccionar archivos de tipo objeto.
	 */
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos OBJ", "obj");
	
	/**
	 * Etiqueta que contiene la imagen de la ventana principal.
	 */
	private JLabel imagen = new JLabel("", new ImageIcon(Principal.class.getResource(
			"/trabajoFinal/gui/imagenes/Groups_Icon_256.png")), JLabel.CENTER);
			
		
	// ------------------------------------------------------------------------------------------ \\
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	// ------------------------------------------------------------------------------------------ \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la apliaci&oacute;n.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos del marco principal.
	 */
	private void initialize() {
		
		// Quitamos todos los filtros del JFileChooser y añadimos el filtro para "obj"
		ventanaSeleccion.setAcceptAllFileFilterUsed(false);
		ventanaSeleccion.setFileFilter(filtro);
		
				
		// ----------------------------------- Ventana Principal ----------------------------------- \\
		
		ventanaPrincipal.setResizable(false); // No se le puede cambiar el tamaño
		ventanaPrincipal.setTitle(General.personajes.getNombre() + " - "); // Le ponemos título a la ventana
		ventanaPrincipal.setBounds(100, 100, 612, 300); // Dimesiones y ubicación de la ventana
		ventanaPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Botón x que no haga nada por defecto
		ventanaPrincipal.setBackground(SystemColor.activeCaptionBorder);
		ventanaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource(
				"/trabajoFinal/gui/imagenes/Groups_Icon_32.png")));
		
		// Añadimos una acción al cerrar con la x, que es que pregunte si queremos guardar en caso de haber cambios
		
		WindowListener cerrarConX = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(Gestion.getModificado()==true) { 		
					if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", 
							"Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
						guardar();	// SI - GUARDA / CANCEL - NADA= Sale
				}
				System.exit(0);
			}
		};
		ventanaPrincipal.addWindowListener(cerrarConX);
		
		ventanaPrincipal.setJMenuBar(menuBarra); // Añadimos la barra de menú
		ventanaPrincipal.getContentPane().setLayout(null); 
	
		// PARA AÑADIR UNA IMAGEN a la ventana		
		imagen.setBounds(0, 11, 606, 252);
		ventanaPrincipal.getContentPane().add(imagen);
		menuFicheros.setFont(new Font("Candara", Font.BOLD, 14));
		menuFicheros.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Documents_Icon_16.png")));
		
	
		// ----------------------------------- Menú Ficheros ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuBarra.add(menuFicheros); // Añadimos Ficheros a la barra de menús
		
		menuNuevo.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/file_obj.gif")));
		menuFicheros.add(menuNuevo);
		
		menuAbrir.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/open.gif")));
		menuFicheros.add(menuAbrir);
		
		menuGuardar.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/guardar.png")));
		menuFicheros.add(menuGuardar);
		
		menuGuardarComo.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/guardar.png")));
		menuFicheros.add(menuGuardarComo);
		
		menuFicheros.add(separador);
		
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/salir.gif")));
		menuFicheros.add(menuSalir);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuFicheros.setMnemonic('F'); // Le ponemos una tecla de acceso rápido
		menuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); 
		menuNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		menuGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		// ---- Añadir Acciones ---- \\
				
		menuAbrir.addActionListener(new ActionListener() { // Abrir archivo
			public void actionPerformed(ActionEvent e) {
					abrir();
				}
		});
		menuNuevo.addActionListener(new ActionListener() { // Crear archivo nuevo
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		menuGuardar.addActionListener(new ActionListener() { // Guardar archivo
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		menuGuardarComo.addActionListener(new ActionListener() { // Guardar como
			public void actionPerformed(ActionEvent e) { 
					guardarComo();
			}
		});		
		menuSalir.addActionListener(new ActionListener() { // Salir
			// Sale de la aplicaci&oacute;n
			public void actionPerformed(ActionEvent e) {
				if(Gestion.getModificado()==true) { 		
					if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", 
							"Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
						guardar();	// SI - GUARDA / CANCEL - NADA=ABRE Y EL NUEVO MACHACA
				}
				System.exit(0);
			}
		});
		
		
		// ----------------------------------- Menú Personaje ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuPersonaje.setFont(new Font("Candara", Font.BOLD, 14));
		menuPersonaje.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Misc_User_Icon_16.png")));
		menuBarra.add(menuPersonaje);
		
		menuAnnadirP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Add_1_Icon_16.png")));
		menuPersonaje.add(menuAnnadirP);
				
		menuEliminarP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Math_minus_Icon_16.png")));
		menuPersonaje.add(menuEliminarP);
		
		menuBuscarP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuPersonaje.add(menuBuscarP);
				
		menuNombreP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		menuBuscarP.add(menuNombreP);
		
		menuSexoP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		menuBuscarP.add(menuSexoP);
		
		menuRegionP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		menuBuscarP.add(menuRegionP);
		
		menuZodiacoP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		menuBuscarP.add(menuZodiacoP);
		
		menuRazaP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/elf3.png")));
		menuBuscarP.add(menuRazaP);
				
		menuMostrarP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuPersonaje.add(menuMostrarP);
				
		menuTotalP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		menuPersonaje.add(menuTotalP);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuPersonaje.setMnemonic('P');
		
		// ---- Añadir Acciones ---- \\
		
		menuAnnadirP.addActionListener(new ActionListener() { // AÑADIR PERSONAJE
			public void actionPerformed(ActionEvent e) {
				Annadir annadir = new Annadir();
				annadir.setVisible(true);
			}
		});
		
		menuTotalP.addActionListener(new ActionListener() { // MOSTRAR TOTAL PERSONAJES
			public void actionPerformed(ActionEvent arg0) {
				if(General.personajes.cantidadPersonajes() != 0){
					Total total = new Total();
					total.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que contabilizar. "
							+ "\nAñade personajes para poder ver cuántos hay.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuMostrarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0){
					/*Mostrar mostrar = new Mostrar();
					mostrar.setVisible(true);*/
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que contabilizar. "
							+ "\nAñade personajes para poder ver cuántos hay.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuNombreP.addActionListener(new ActionListener() { // BUSCAR PESONAJE POR NOMBRE
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0){
					BuscarPorNombre buscar = new BuscarPorNombre();
					buscar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que buscar. "
							+ "\nAñade personajes para poder buscarlos.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuEliminarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ELIMINAR PERSONAJE
				
				if(General.personajes.cantidadPersonajes() != 0){
					Eliminar eliminar = new Eliminar();
					eliminar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que eliminar. "
							+ "\nAñade personajes para poder eliminarlos.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
				
		// ----------------------------------- Menú Mago ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuBarra.add(menuMago);
		menuMago.setFont(new Font("Candara", Font.BOLD, 14));
		menuMago.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Mage_1_Icon_16.png")));
		
		menuBuscarM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuMago.add(menuBuscarM);
		
		menuBuscarM.add(menuNombreM);
		menuNombreM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
				
		menuBuscarM.add(menuSexoM);
		menuSexoM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		
		menuRegionM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		menuBuscarM.add(menuRegionM);
				
		menuZodiacoM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		menuBuscarM.add(menuZodiacoM);
		
		menuRazaM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/elf3.png")));
		menuBuscarM.add(menuRazaM);
		
		menuMostrarM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuMago.add(menuMostrarM);
		
		menuTotalM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		menuMago.add(menuTotalM);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuMago.setMnemonic('M');
		menuNombreM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuSexoM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuRegionM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));	
		menuZodiacoM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		menuMostrarM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuTotalM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		
		menuSexoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(General.personajes.cantidadPersonajes() != 0) {
					
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El listado está vacío. \nAñade personajes para poder buscarlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuMostrarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Mostrar Listado
				if(General.personajes.cantidadPersonajes() != 0) {
					
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El listado está vacío. \nAñade personajes para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuTotalM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana de total disponible
				if(General.personajes.cantidadPersonajes() != 0) {
					Total total = new Total();
					total.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"No hay personajes en el listado. \nAñade personajes para poder saber cuántos hay.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuNombreM.addActionListener(new ActionListener() { // Abre la ventana de Buscar por nombre
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0) {
					
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El listado está vacío. \nAñade personajes para poder buscarlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});	
		
		
		// ----------------------------------- Menú Arquero ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
				
		menuArquero.setFont(new Font("Candara", Font.BOLD, 14));
		menuArquero.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Scout_1_Icon_16.png")));
		menuBarra.add(menuArquero);
		
		menuBuscarA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuArquero.add(menuBuscarA);
		
		menuNombreA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		menuBuscarA.add(menuNombreA);
		
		menuSexoA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		menuBuscarA.add(menuSexoA);
		
		menuRegionA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		menuBuscarA.add(menuRegionA);
		
		menuZodiacoA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		menuBuscarA.add(menuZodiacoA);
		
		menuRazaA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/elf3.png")));
		menuBuscarA.add(menuRazaA);
				
		menuMostrarA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuArquero.add(menuMostrarA);
		
		
		menuTotalA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		menuArquero.add(menuTotalA);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuArquero.setMnemonic('A');
				
		// ----------------------------------- Menú Guerrero ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuGuerrero.setFont(new Font("Candara", Font.BOLD, 14));
		menuGuerrero.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Warrior_1_Icon_16.png")));
		menuBarra.add(menuGuerrero);
		
		menuBuscarG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuGuerrero.add(menuBuscarG);
		
		menuNombreG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		menuBuscarG.add(menuNombreG);
		
		menuSexoG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		menuBuscarG.add(menuSexoG);
		
		menuRegionG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		menuBuscarG.add(menuRegionG);
		
		menuZodiacoG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		menuBuscarG.add(menuZodiacoG);
		
		menuRazaG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/elf3.png")));
		menuBuscarG.add(menuRazaG);
		
		menuMostrarG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuGuerrero.add(menuMostrarG);
		
		menuTotalG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		menuGuerrero.add(menuTotalG);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
				
		menuGuerrero.setMnemonic('G');
		
		// ----------------------------------- Menú Dragón ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuDragon.setFont(new Font("Candara", Font.BOLD, 14));
		menuDragon.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Dragon_Age_Origins_new_4_Icon_16.png")));
		menuBarra.add(menuDragon);
		
		menuBuscarD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuDragon.add(menuBuscarD);
		
		menuNombreD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));
		menuBuscarD.add(menuNombreD);
		
		menuSexoD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Sex_Male_Female_Circled_Icon_16.png")));
		menuBuscarD.add(menuSexoD);
		
		menuRegionD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/System_Map_Icon_16.png")));
		menuBuscarD.add(menuRegionD);
		
		menuZodiacoD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/pisces10.png")));
		menuBuscarD.add(menuZodiacoD);
		
		menuMostrarD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuDragon.add(menuMostrarD);
		
		menuTotalD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		menuDragon.add(menuTotalD);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuDragon.setMnemonic('D');
		
		
		// ----------------------------------- Menú Ayuda ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuBarra.add(menuAyuda);
		
		menuVerAyuda.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Alarm_Help_and_Support_Icon_16.png")));
		menuAyuda.add(menuVerAyuda);
		
		menuAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Info_Icon_16.png")));
		menuAyuda.add(menuAcercaDe);
		
		menuAyuda.setFont(new Font("Candara", Font.BOLD, 14));
		menuAyuda.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Alarm_Help_and_Support_Icon_16.png")));
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuAyuda.setMnemonic('A');
		menuVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		
		// ---- Añadir Acciones ---- \\
			
		menuVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Ayuda
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		
		menuAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Acerca de
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		
	}

	
	// ------------------------------------------------------------------------------------------ \\
	// ----------------------------------- MÉTODOS EXTRAS ----------------------------------- \\
	// ------------------------------------------------------------------------------------------ \\
		
	/**
	 * Abre un archivo existente.
	 */
	private void abrir() {
		if(Gestion.getModificado()==true) { 		
			if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", 
					"Hay cambios sin guardar", JOptionPane.YES_NO_OPTION)==0)
				guardar();	// SI - GUARDA / No - NADA=ABRE Y EL NUEVO MACHACA
		}
		
		if (ventanaSeleccion.showOpenDialog(panelContenedor) == JFileChooser.APPROVE_OPTION) {
			Gestion.setArchivo(ventanaSeleccion.getSelectedFile());
			try {
				General.personajes = Gestion.abrir(Gestion.getArchivo());
				ventanaPrincipal.setTitle(General.personajes.getNombre()+ " - " + Gestion.getArchivo().getName());
				JOptionPane.showMessageDialog(panelContenedor, "Archivo abierto con éxito.", "Abierto", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException | IOException | FicheroCorruptoException e) {
				JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}			
		}
	}
	
	/**
	 * Guarda el listado de personajes en un archivo con un nombre 
	 * especificado y en el lugar del ordenador indicado.
	 */
	private void guardarComo() {
		if (ventanaSeleccion.showSaveDialog(panelContenedor) == JFileChooser.APPROVE_OPTION) {
			Gestion.setArchivo(ventanaSeleccion.getSelectedFile());
			if(Fichero.siArchivoExiste(Gestion.getArchivo())) { // Si existe, pregunto qué hacer
				if(JOptionPane.showConfirmDialog(panelContenedor, "El archivo ya existe. ¿Desea reemplazarlo?", "Confirmar Guardar como", 
						JOptionPane.YES_NO_OPTION)==0)
					guardar();	// SI - GUARDA / NO o CANCEL - NADA
			}
			else { // Si no existe, me lo sobreescribe
				guardar();
			}	
		}
	}
	
	/**
	 * Sobreescribe el archivo que tiene el listado de personajes.
	 */
	protected void guardar() {
		if(Gestion.getArchivo()==null | Gestion.getArchivo().getName()=="Sin_titulo.obj") { 		
			guardarComo();
		}
		
		else {
			try {
				Gestion.guardar(Gestion.getArchivo(), General.personajes);
				ventanaPrincipal.setTitle(General.personajes.getNombre() + " - " + Gestion.getArchivo().getName());
				JOptionPane.showMessageDialog(panelContenedor, "Archivo guardado con éxito.", "Guardado", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(panelContenedor, "No se pudo guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Crea un archivo nuevo desde cero.
	 */
	private void nuevo() {
		if(Gestion.getModificado()==true) { 		
			if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", "Hay cambios sin guardar", 
					JOptionPane.YES_NO_OPTION)==0)
				guardar();	// SI - GUARDA / CANCEL - NADA=ABRE Y EL NUEVO MACHACA
		}
		
		try {
			Gestion.nuevo(); 
			ventanaPrincipal.setTitle(General.personajes.getNombre() + " - " + Gestion.getArchivo().getName()); 
			JOptionPane.showMessageDialog(panelContenedor, "Archivo creado con éxito.", "Creado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(panelContenedor, "No se pudo crear un archivo nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
