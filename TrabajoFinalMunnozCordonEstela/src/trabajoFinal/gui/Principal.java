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
	 * Submen&uacute; A&ntilde;adir Personaje.
	 */
	private final JMenuItem menuAnnadir = new JMenuItem("A\u00F1adir");
	
	/**
	 * Submen&uacute; Eliminar Personaje.
	 */
	private final JMenuItem menuEliminar = new JMenuItem("Eliminar");
	
	/**
	 * Submen&uacute; Buscar Personaje por el Tipo.
	 */
	private final JMenu menuBuscarP = new JMenu("Buscar Tipos");
	
	/**
	 * Submen&uacute; Buscar Personaje por el Nombre.
	 */
	private final JMenuItem menuBuscarN = new JMenuItem("Buscar Nombre");
	
	/**
	 * Submen&uacute; Buscar Magos.
	 */
	private JMenuItem menuBuscarM = new JMenuItem("Buscar Magos");
	
	/**
	 * Submen&uacute; Buscar Arqueros.
	 */
	private	JMenuItem menuBuscarA = new JMenuItem("Buscar Arqueros");
	
	/**
	 * Submen&uacute; Buscar Guerreros.
	 */
	private	JMenuItem menuBuscarG = new JMenuItem("Buscar Guerreros");
	
	/**
	 * Submen&uacute; Buscar Dioses.
	 */
	private	JMenuItem menuBuscarD = new JMenuItem("Buscar Dioses");
	
	/**
	 * Submen&uacute; Buscar Dragones.
	 */
	private	JMenuItem menuBuscarDr = new JMenuItem("Buscar Dragones");
	
	/**
	 * Submen&uacute; Mostrar Personajes.
	 */
	private final JMenuItem menuMostrar = new JMenuItem("Mostrar");
	
	
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
	 * 
	 * @param args Lista de argumentos que hacen funcionar
	 * la apliaci&oacute;n.
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
		ventanaPrincipal.setBounds(100, 100, 339, 294); // Dimesiones y ubicación de la ventana
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
		imagen.setBounds(0, 0, 333, 244);
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
				
		menuAnnadir.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Add_1_Icon_16.png")));
		menuPersonaje.add(menuAnnadir);
			
		menuEliminar.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Math_minus_Icon_16.png")));
		menuPersonaje.add(menuEliminar);
		
		menuBuscarN.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/N_Icon_16.png")));		
		menuPersonaje.add(menuBuscarN);
				
		menuBuscarP.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Search_Icon_16.png")));
		menuPersonaje.add(menuBuscarP);
						
		menuBuscarM.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Mage_1_Icon_16.png")));
		menuBuscarP.add(menuBuscarM);
						
		menuBuscarA.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Scout_1_Icon_16.png")));
		menuBuscarP.add(menuBuscarA);
				
		menuBuscarG.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Warrior_1_Icon_16.png")));
		menuBuscarP.add(menuBuscarG);
				
		menuBuscarD.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Runes_of_Magic_Priest_1_Icon_16.png")));
		menuBuscarP.add(menuBuscarD);
				
		menuBuscarDr.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/Dragon_Age_Origins_new_4_Icon_16.png")));
		menuBuscarP.add(menuBuscarDr);
						
		menuMostrar.setIcon(new ImageIcon(Principal.class.getResource("/trabajoFinal/gui/imagenes/view24.png")));
		menuPersonaje.add(menuMostrar);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuPersonaje.setMnemonic('P');
		menuBuscarP.setMnemonic('B');
		menuBuscarN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuAnnadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));	
		menuMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuBuscarDr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBuscarD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		menuBuscarG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuBuscarA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuBuscarM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		// ---- Añadir Acciones ---- \\
		
		menuAnnadir.addActionListener(new ActionListener() { // AÑADIR PERSONAJE
			public void actionPerformed(ActionEvent e) {
				Annadir annadir = new Annadir();
				annadir.setVisible(true);
			}
		});
		
		menuEliminar.addActionListener(new ActionListener() {
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
		
		menuBuscarN.addActionListener(new ActionListener() { // BUSCAR PESONAJE POR NOMBRE
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0){
					Buscar buscar = new Buscar();
					buscar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que buscar. "
							+ "\nAñade personajes para poder buscarlos.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuBuscarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0 || General.personajes.getMagos().size() != 0){
					BuscarMagos mostrarMagos = new BuscarMagos();
					mostrarMagos.setVisible(true);
				}			
				else 
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay magos que mostrar. "
							+ "\nAñade magos para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuBuscarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0 || General.personajes.getArqueros().size() != 0){
					BuscarArqueros buscarArqueros = new BuscarArqueros();
					buscarArqueros.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay arqueros que mostrar. "
							+ "\nAñade arqueros para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuBuscarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0 || General.personajes.getGuerreros().size() != 0){
					BuscarGuerreros buscarGuerreros = new BuscarGuerreros();
					buscarGuerreros.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay guerreros que mostrar. "
							+ "\nAñade guerreros para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuBuscarDr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0 || General.personajes.getDragones().size() != 0){
					BuscarDragones buscarDragones = new BuscarDragones();
					buscarDragones.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay dragones que mostrar. "
							+ "\nAñade dragones para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuBuscarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0 || General.personajes.getDioses().size() != 0){
					BuscarDioses buscarDioses = new BuscarDioses();
					buscarDioses.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay dioses que mostrar. "
							+ "\nAñade dioses para poder verlos.",
							"Listado vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(General.personajes.cantidadPersonajes() != 0){
					Mostrar mostrar = new Mostrar();
					mostrar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"Oops... No hay personajes que mostrar. "
							+ "\nAñade personajes para poder verlos.",
							"Listado de personajes vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
			
		
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
