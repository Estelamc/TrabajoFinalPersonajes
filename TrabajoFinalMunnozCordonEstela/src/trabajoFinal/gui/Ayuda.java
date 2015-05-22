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

/**
 * Contiene informaci&oacute;n que puede servir de ayuda para el manejo del programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Ayuda extends JDialog {

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
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public Ayuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/trabajoFinal/gui/imagenes/Alarm_Help_and_Support_Icon_16.png")));
		
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 533, 847);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBackground(SystemColor.control);
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		
		// Etiqueta Añadir
		
		etiquetaAnnadir.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaAnnadir.setForeground(new Color(102, 51, 102));
		etiquetaAnnadir.setBounds(50, 22, 70, 20);
		panelContenedor.add(etiquetaAnnadir);
		
		// Etiqueta Eliminar
				
		etiquetaEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaEliminar.setForeground(new Color(102, 51, 102));
		etiquetaEliminar.setBounds(52, 217, 46, 14);
		panelContenedor.add(etiquetaEliminar);
		
		// Etiqueta Buscar por nombre
				
		etiquetaBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaBuscar.setForeground(new Color(102, 51, 102));
		etiquetaBuscar.setBounds(50, 285, 165, 14);
		panelContenedor.add(etiquetaBuscar);
		
		// Etiqueta Buscar por sexo
				
		etiquetaBuscarSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaBuscarSexo.setForeground(new Color(102, 51, 102));
		etiquetaBuscarSexo.setBounds(49, 354, 141, 14);
		panelContenedor.add(etiquetaBuscarSexo);
		
		// Etiqueta Mostrar personajes
				
		etiquetaMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaMostrar.setForeground(new Color(102, 51, 102));
		etiquetaMostrar.setBounds(50, 639, 200, 14);
		panelContenedor.add(etiquetaMostrar);
		
		// Etiqueta Total
				
		etiquetaTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaTotal.setForeground(new Color(102, 51, 102));
		etiquetaTotal.setBounds(50, 697, 121, 14);
		panelContenedor.add(etiquetaTotal);
		
		// Panel de texto para Añadir personaje
				
		textoAnnadir.setBackground(SystemColor.control);
		textoAnnadir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoAnnadir.setText("A\u00F1ade un personaje al listado seleccionando cu\u00E1l "
				+ "ser\u00E1 su nombre, apellido, altura, peso, edad, raza (en su caso), signo del zodiaco, "
				+ "sexo, regi\u00F3n donde vive y una descripci\u00F3n informativa sobre \u00E9l. "
				+ "Para poder a\u00F1adirlo todos sus datos deben ser v\u00E1lidos.\r\n\r\nEl nombre "
				+ "ser\u00E1 \u00FAnico, por lo que no podr\u00E1 haber otro personaje con el mismo nombre, "
				+ "aunque s\u00ED con el mismo apellido (pueden ser familia). "
				+ "El nombre ha de\r\ntener como m\u00EDnimo tres letras, empezar\u00E1 por ma\u00FDuscula, "
				+ "y puede llevar un gui\u00F3n\r\npara nombres compuestos, en cuyo caso, la letra que "
				+ "seguir\u00E1 al gui\u00F3n deber\u00E1 ser\r\nmay\u00FAscula (Ej: Iz-Kod). "
				+ "Por el contrario, el apellido no permite guiones y en ambos casos se permiten tildes.");
		textoAnnadir.setBounds(50, 47, 452, 160);
		panelContenedor.add(textoAnnadir);
		
		// Panel de texto para Eliminar personaje
				
		textoEliminar.setBackground(SystemColor.control);
		textoEliminar.setForeground(Color.BLACK);
		textoEliminar.setText("Elimina un personaje del listado cuando coincide el nombre "
				+ "introducido con uno existente.");
		textoEliminar.setBounds(50, 239, 452, 34);
		panelContenedor.add(textoEliminar);
		
		// Panel de texto para Buscar un personaje
				
		textoBuscar.setBackground(SystemColor.control);
		textoBuscar.setForeground(Color.BLACK);
		textoBuscar.setText("Busca un personaje cuyo nombre coincida con el introducido y lo muestra.");
		textoBuscar.setBounds(50, 308, 452, 27);
		panelContenedor.add(textoBuscar);
		
		// Panel de texto para Buscar personajes de un sexo
		
		textoBuscarSexo.setBackground(SystemColor.control);
		textoBuscarSexo.setForeground(Color.BLACK);
		textoBuscarSexo.setText("Busca todos los personajes que tengan el sexo seleccionado y los muestra.");
		textoBuscarSexo.setBounds(50, 379, 452, 20);
		panelContenedor.add(textoBuscarSexo);
		
		// Panel de texto para Mostrar todos los personajes
		
		textoMostrar.setBackground(SystemColor.control);
		textoMostrar.setForeground(Color.BLACK);
		textoMostrar.setText("Muestra todos los personajes existentes en el listado.");
		textoMostrar.setBounds(50, 658, 452, 27);
		panelContenedor.add(textoMostrar);
		
		// Panel de texto para Mostrar cantidad de personajes
		
		textoTotal.setBackground(SystemColor.control);
		textoTotal.setForeground(Color.BLACK);
		textoTotal.setText("Muestra la cantidad total de personajes que hay en el listado.");
		textoTotal.setBounds(50, 721, 452, 27);
		panelContenedor.add(textoTotal);
		{
			// Botón OK
			
			okButton.addActionListener(new ActionListener() {
				// Se sale de la ventana
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			okButton.setBounds(228, 784, 70, 27);
			panelContenedor.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		
		etiquetaRegion.setForeground(new Color(102, 51, 102));
		etiquetaRegion.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaRegion.setBounds(50, 419, 141, 14);
		panelContenedor.add(etiquetaRegion);
		
		
		textoBuscarRegion.setText("Busca todos los personajes que vivan en una determinada "
				+ "regi\u00F3n y los muestra.");
		textoBuscarRegion.setForeground(Color.BLACK);
		textoBuscarRegion.setBackground(SystemColor.activeCaptionBorder);
		textoBuscarRegion.setBounds(50, 444, 452, 20);
		panelContenedor.add(textoBuscarRegion);
		
		
		etiquetaZodiaco.setForeground(new Color(102, 51, 102));
		etiquetaZodiaco.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaZodiaco.setBounds(50, 487, 184, 14);
		panelContenedor.add(etiquetaZodiaco);
		
		
		textoBuscarZodiaco.setText("Busca todos los personajes que tengan el signo del zodiaco "
				+ "indicado y los muestra.");
		textoBuscarZodiaco.setForeground(Color.BLACK);
		textoBuscarZodiaco.setBackground(SystemColor.activeCaptionBorder);
		textoBuscarZodiaco.setBounds(51, 512, 452, 20);
		panelContenedor.add(textoBuscarZodiaco);
		
		
		etiquetaRaza.setForeground(new Color(102, 51, 102));
		etiquetaRaza.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaRaza.setBounds(50, 556, 141, 14);
		panelContenedor.add(etiquetaRaza);
		
		
		textoBuscarRaza.setText("Busca todos los personajes que tengan la raza seleccionada "
				+ "y los muestra. S\u00F3lo tienen raza los magos, los arqueros y los guerreros; "
				+ "los dragones y los dioses no.");
		textoBuscarRaza.setForeground(Color.BLACK);
		textoBuscarRaza.setBackground(SystemColor.activeCaptionBorder);
		textoBuscarRaza.setBounds(51, 581, 452, 36);
		panelContenedor.add(textoBuscarRaza);
	}
}
