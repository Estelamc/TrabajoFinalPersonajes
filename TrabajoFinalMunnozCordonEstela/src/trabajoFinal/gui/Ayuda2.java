package trabajoFinal.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Contiene informaci&oacute;n que puede servir de ayuda para el manejo del programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Ayuda2 extends JDialog {
	public Ayuda2() {
		setTitle("Ayuda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda2.class.getResource("/trabajoFinal/gui/imagenes/Alarm_Help_and_Support_Icon_16.png")));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 518, 260);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n<head>\r\n\t<title></title>\r\n</head>\r\n<body>\r\n<h1 style=\"text-align: justify;\">LISTADO DE PERSONAJES LITERARIOS PARA RELATOS O CUALQUIER PROYECTO CREATIVO:</h1>\r\n\r\n<h2 style=\"text-align: justify;\">INTRODUCCI&Oacute;N:</h2>\r\n\r\n<p style=\"text-align: justify;\">Entre mis aficiones, una de ellas es escribir. Tengo varios relatos empezados, as&iacute; como comics (tambi&eacute;n me entretengo dibujando en ocasiones), y un problema con el que me encuentro normalmente es que al retomarlos, como suele pasar bastante tiempo, ya que ando normalmente ocupada con otras cosas, no me acuerdo bien de<br />\r\ntodo, sobre todo de los datos de los personajes (su nombre, raza, personalidad, reino, etc).</p>\r\n\r\n<p style=\"text-align: justify;\">Como consecuencia, pierdo mucho tiempo (y no dispongo de mucho) en intentar recordar todo y organizar mis ideas.</p>\r\n\r\n<p style=\"text-align: justify;\">Tengo m&aacute;s de un relato empezado y recordar todos los detalles de todos, es complicado y, usualmente, se me ocurren ideas que a&ntilde;adir de alguno de ellos de vez en cuando, no siempre del mismo. De repente se me ocurre un personaje nuevo para una de mis historias, por ejemplo.</p>\r\n\r\n<p style=\"text-align: justify;\">Por todo ello, encontr&eacute; interesante crear una aplicaci&oacute;n para los escritores, donde poder guardar la informaci&oacute;n de sus personajes inventados, ya que para poder escribir es importante tenerlos muy claros y organizados.</p>\r\n</body>\r\n</html>\r\n");
		scrollPane.setViewportView(lblNewLabel);
	}

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 7496760684131528000L;
	
	/**
	 * Panel contenedor que contiene los elementos de la ventana.
	 */
	private final JPanel panelContenedor = new JPanel();
	
	/**
	 * Etiqueta para la Añadir.
	 */
	JLabel etiquetaAnnadir = new JLabel("A\u00F1adir");
	
	/**
	 * Etiqueta para Eliminar.
	 */
	JLabel etiquetaEliminar = new JLabel("Eliminar");
	
	/**
	 * Etiqueta para Buscar por nombre.
	 */
	JLabel etiquetaBuscar = new JLabel("Buscar por nombre");
	
	/**
	 * Etiqueta para Buscar por sexo.
	 */
	JLabel etiquetaBuscarSexo = new JLabel("Buscar por sexo");
	
	/**
	 * Etiqueta para Buscar por regi&oacute;n.
	 */
	JLabel etiquetaRegion = new JLabel("Buscar por regi\u00F3n");
	
	/**
	 * Etiqueta para Buscar por signo del zodiaco.
	 */
	JLabel etiquetaZodiaco = new JLabel("Buscar por signo del zodiaco");
	
	/**
	 * Etiqueta para Buscar por raza.
	 */
	JLabel etiquetaRaza = new JLabel("Buscar por raza");
	
	/**
	 * Etiqueta para Mostrar.
	 */
	JLabel etiquetaMostrar = new JLabel("Mostrar");
	
	/**
	 * Etiqueta para el Total.
	 */
	JLabel etiquetaTotal = new JLabel("Total");
	
	/**
	 * Panel de texto para A&ntilde;adir un personaje.
	 */
	JTextPane textoAnnadir = new JTextPane();
	
	/**
	 * Panel de texto para Eliminar un personaje.
	 */
	JTextPane textoEliminar = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un personaje.
	 */
	JTextPane textoBuscar = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un personaje por sexo.
	 */
	JTextPane textoBuscarSexo = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un personaje por regi&oacute;n.
	 */
	JTextPane textoBuscarRegion = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un personaje por signo del zodiaco.
	 */
	JTextPane textoBuscarZodiaco = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un personaje por raza.
	 */	
	JTextPane textoBuscarRaza = new JTextPane();
	
	/**
	 * Panel de texto para mostrar el listado.
	 */
	JTextPane textoMostrar = new JTextPane();	
	
	/**
	 * Panel de texto para la cantidad de personajes.
	 */
	JTextPane textoTotal = new JTextPane();
		
	/**
	 * Bot&oacute;n OK.
	 */
	private JButton okButton = new JButton("OK");

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\

	
}
