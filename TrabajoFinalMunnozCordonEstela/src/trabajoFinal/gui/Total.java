package trabajoFinal.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import trabajoFinal.personajes.General;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Calcula la cantidad de coches que hay en el concesionario.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Total extends JDialog {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\

	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 1531130519545859953L;
	
	/**
	 * Panel que contiene los elementos de la ventana.
	 */
	private final JPanel panelContenedor = new JPanel();
	
	/**
	 * Campo de de texto paa el Stock del concesionario.
	 */
	private JTextPane totalPanelTexto = new JTextPane();
	
	/**
	 * Bot&oacute;n Ok
	 */
	private JButton botonOK = new JButton("OK");

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Total dialog = new Total();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *Crea el di&aacute;logo.
	 */
	public Total() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Total.class.getResource("/trabajoFinal/gui/imagenes/equal4.png")));
		setResizable(false);
		setModal(true);
		int cantidadCoches = General.personajes.cantidadPersonajes();
		
		setTitle("Total");
		setBounds(100, 100, 309, 168);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		totalPanelTexto.setBounds(81, 39, 140, 39);
		totalPanelTexto.setBackground(null); // fondo transparente
		totalPanelTexto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalPanelTexto.setText("Hay " +cantidadCoches+ " personajes.");
		panelContenedor.add(totalPanelTexto);
		{
			botonOK.setBounds(118, 92, 61, 29);
			
			// Añade una acción al botón OK
			
			botonOK.addActionListener(new ActionListener() {
				// Se sale de la ventana
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			
			botonOK.setActionCommand("OK");
			panelContenedor.add(botonOK);
		}
	}
}
