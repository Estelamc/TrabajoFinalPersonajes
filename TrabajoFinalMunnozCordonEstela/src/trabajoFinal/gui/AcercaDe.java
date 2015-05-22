package trabajoFinal.gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JTextPane;

import trabajoFinal.personajes.General;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Contiene informaci&oacute;n sobre el programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class AcercaDe extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de la versi&oacute;n.
	 */
	private static final long serialVersionUID = -8366563078223223981L;
	
	/**
	 * Panel contenedor de los elementos de la ventana.
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Panel de desplazamiento.
	 */
	private JScrollPane PanelDesplazamiento = new JScrollPane();

	/**
	 * &Aacute;rea de texto.
	 */
	private JTextArea informacionTexto = new JTextArea();
	
	/**
	 * Panel de texto para el nombre del autor.
	 */
	JTextPane NombreAutorTexto = new JTextPane();
	
	/**
	 * Panel de texto para el autor.
	 */
	JTextPane autorTexto = new JTextPane();
	
	/**
	 * Panel de texto para la fecha de creaci&oacute;n.
	 */
	JTextPane FechaCreacionTexto = new JTextPane();
	
	/**
	 * Panel de texto para el e-mail.
	 */
	JTextPane emailTexto = new JTextPane();	
	
	/**
	 * Panel de texto para el FaceBook.
	 */
	JTextPane facebookTexto = new JTextPane();	
	
	/**
	 * Panel de texto para el nombre del Programa.
	 */
	JTextPane nombrePrograma = new JTextPane();
	
	/**
	 * Bot&oacute;n OK.
	 */
	Button botonOK = new Button("OK");
	
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public AcercaDe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/trabajoFinal/gui/imagenes/Info_Icon_16.png")));
		setModal(true); // No puede estar abierta a la vez que otra ventana.
		setResizable(false); // No se puede cambiar el tamaño
		setTitle("Acerca de"); // Título de la ventana
		setBounds(100, 100, 437, 429); // Dimensiones 
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		{
			PanelDesplazamiento.setBounds(38, 164, 355, 156);
			contentPanel.add(PanelDesplazamiento);
			{
				// Área de texto
				informacionTexto.setEditable(false);
				informacionTexto.setBackground(SystemColor.control);
				informacionTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
				informacionTexto.setText("Este programa se cre\u00F3 con fines educativos\r\ny su uso queda restringido a \u00E9stos, sin ser\r\nv\u00E1lida su venta u obtener beneficios monetarios\r\na trav\u00E9s de cualquier medio. Queda permitida su\r\nlibre distribuci\u00F3n y uso.\r\n\r\nEl programa servir\u00E1 para la gesti\u00F3n\r\nde un listado de personajes de modo que\r\npodamos a\u00F1adir o eliminarlos; as\u00ED como \r\nmostrar todos los existentes hasta el \r\nmomento, o buscar uno concreto por el \r\nnombre, la regi\u00F3n, la raza, el signo del \r\nzodiaco o el sexo.\r\n\r\nLos personajes dispondr\u00E1n de un nombre\r\nunequ\u00EDvoco, de modo que no podr\u00E1n\r\na\u00F1adirse personajes con el mismo nombre\r\no con un nombre nulo. Para buscar un\r\npersonaje se buscar\u00E1 de acuerdo a su\r\nnombre.\r\n\r\nLos personajes tambi\u00E9n dispondr\u00E1n de un\r\nsigno del zodiaco, una raza, un sexo y una\r\nregi\u00F3n donde vivir.\r\n\r\nEntre los personajes a crear, dispondremos\r\nde magos, arqueros, guerreros, dragones y\r\ndioses.");
				PanelDesplazamiento.setViewportView(informacionTexto);
			}
		}
		
		// Panel de texto para el nombre del autor
		
		NombreAutorTexto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NombreAutorTexto.setBackground(SystemColor.control);
		NombreAutorTexto.setEditable(false);
		NombreAutorTexto.setForeground(new Color(51, 51, 153));
		NombreAutorTexto.setText("Estela Mu\u00F1oz Cord\u00F3n");
		NombreAutorTexto.setBounds(119, 88, 141, 20);
		contentPanel.add(NombreAutorTexto);
		
		// Panel de texto para indicar el autor
		
		autorTexto.setBackground(SystemColor.control);
		autorTexto.setEditable(false);
		autorTexto.setText("Autor:");
		autorTexto.setBounds(62, 88, 47, 20);
		contentPanel.add(autorTexto);
		
		// Panel de texto para la Fecha de creación
		
		FechaCreacionTexto.setBackground(SystemColor.control);
		FechaCreacionTexto.setEditable(false);
		FechaCreacionTexto.setText("Fecha de creación:  "+getFecha()); //Donde pone la fecha de creación
		FechaCreacionTexto.setBounds(229, 11, 182, 20);
		contentPanel.add(FechaCreacionTexto);
		{
			// Panel de texto para el email
			
			emailTexto.setBackground(SystemColor.control);
			emailTexto.setEditable(false);
			emailTexto.setText("e-mail");
			emailTexto.setBounds(62, 119, 47, 20);
			contentPanel.add(emailTexto);
		}
		{
			// Panel de texto para la dirección del FaceBook
		
			facebookTexto.setBackground(SystemColor.control);
			facebookTexto.setForeground(new Color(51, 51, 153));
			facebookTexto.setText("https://www.facebook.com/estela.munoz.733");
			facebookTexto.setEditable(false);
			facebookTexto.setBounds(119, 119, 278, 20);
			contentPanel.add(facebookTexto);
		}
		{
			// Panel de texto para el nombre del programa
		
			nombrePrograma.setBackground(SystemColor.control);
			nombrePrograma.setFont(new Font("Tahoma", Font.BOLD, 14));
			nombrePrograma.setForeground(new Color(102, 51, 102));
			nombrePrograma.setEditable(false);
			nombrePrograma.setText(General.personajes.getNombre() + " v1.0");
			nombrePrograma.setBounds(119, 52, 141, 25);
			contentPanel.add(nombrePrograma);
		}
		
		// Botón OK
		
		botonOK.addActionListener(new ActionListener() {
			// Sale de la ventana
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		botonOK.setBounds(175, 343, 70, 22);
		contentPanel.add(botonOK);
	}
	
	/**
	 * Devuelve la fecha actual.
	 * 
	 * @return fecha actual.
	 */
	private static String getFecha(){
		Calendar fechaActual = Calendar.getInstance();
		String dia=Integer.toString(fechaActual.get(Calendar.DATE));
		String mes= Integer.toString(fechaActual.get(Calendar.MONTH));
		String anno= Integer.toString(fechaActual.get(Calendar.YEAR));
		return  dia + "/" + mes +"/"+ anno;
	}
}
