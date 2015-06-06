package trabajoFinal.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private static final long serialVersionUID = 3904008192742712963L;
	
	/**
	 * Panel que contiene los elementos de la ventana de di&aacute;logo.
	 */
	private final JPanel panelContenedor = new JPanel();
	
	/**
	 * Bot&oacute;n Ok.
	 */
	private JButton botonOK = new JButton("OK");
	
	/**
	 * Panel de desplazamiento para poder subir y bajar con una barra 
	 * de desplazmiento e ir viendo el texto en su totalidad.
	 */
	private JScrollPane panelDesplazamiento = new JScrollPane();
	
	/**
	 * Etiqueta que contiene la informaci&oacute;n del programa com ayuda.
	 */
	private JLabel ayudaEtiqueta = new JLabel("<html>\r\n<head>\r\n\t<title></title>\r\n</head>\r\n<body>\r\n<h1 "
				+ "style=\"text-align: center;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">PNJCREATOR: </span></span></h1>\r\n\r\n<h2 style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;"
				+ "\">1.INTRODUCCI&Oacute;N:</span></span></h2>\r\n\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Entre mis "
				+ "aficiones, una de ellas es escribir. Tengo varios relatos empezados, as&iacute; como comics "
				+ "<br>(tambi&eacute;n me entretengo dibujando en ocasiones), y un problema con el que me encuentro<br> "
				+ "normalmente es que al retomarlos, como suele pasar bastante tiempo, ya que ando normalmente<br> ocupada"
				+ " con otras cosas, no me acuerdo bien de todo, sobre todo de los datos de los personajes<br> (su nombre, "
				+ "raza, personalidad, reino, etc).</span></span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Como consecuencia, "
				+ "pierdo mucho tiempo (y no dispongo de mucho) en intentar recordar todo y<br> organizar mis ideas.</span>"
				+ "</span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Tengo m&aacute;s de un relato empezado y recordar "
				+ "todos los detalles de todos, es complicado y,<br> usualmente, se me ocurren ideas que a&ntilde;adir "
				+ "de alguno de ellos de vez en cuando, no siempre<br> del mismo. De repente se me ocurre un personaje "
				+ "nuevo para una de mis historias, por ejemplo.</span></span></p>\r\n<br>\r\n<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Por "
				+ "todo ello, encontr&eacute; interesante crear una aplicaci&oacute;n para los escritores, donde poder "
				+ "guardar<br> la informaci&oacute;n de sus personajes inventados, ya que para poder escribir es importante"
				+ " tenerlos<br> muy claros y organizados.</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;"
				+ "</p>\r\n\r\n<h2 style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">2.FICHEROS:</span></span></h2>\r\n\r\n<p style=\"text-align: justify;\"><span"
				+ " style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">La ventana principal del "
				+ "programa cuenta con un primer men&uacute; llamado Ficheros, que contiene<br> como submen&uacute;s Nuevo,"
				+ " Abrir, Guardar, Guardar como y Salir. Este men&uacute; se encargar&aacute; de la<br> gesti&oacute;n de"
				+ " ficheros, cuya finalidad ser&aacute; almacenar nuestro listado de personajes en nuestro<br> ordenador"
				+ " y gracias a los cuales podremos acceder a &eacute;l. </span></span></p>\r\n<br>\r\n<p style=\"text-align:"
				+ " justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">La tecla"
				+ " de acceso r&aacute;pido del men&uacute; Ficheros ser&aacute; la F (mnemonic).</span></span></p>\r\n\r\n<h3"
				+ " style=\"text-align: justify;\">&nbsp;</h3>\r\n\r\n<h3 style=\"text-align: justify;\"><span style=\"font-size"
				+ ":9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">2.1. NUEVO:</span></span></h3>\r\n\r\n<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,"
				+ "sans-serif;\">Crea un archivo nuevo en el que poder crear un listado de personajes. Las teclas de acceso"
				+ "<br> r&aacute;pido son Ctrl+N (accelerator).</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">"
				+ "&nbsp;</p>\r\n\r\n<h3 style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">2.2.ABRIR:</span></span></h3>\r\n\r\n<p style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Abre un archivo "
				+ "que almacena un listado de personajes anteriormente guardado en nuestro<br> ordenador para poder verlo o"
				+ " modificarlo. Las teclas de acceso r&aacute;pido son Ctrl+A (accelerator).</span></span></p>\r\n\r\n<p "
				+ "style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">2.3. GUARDAR:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">Guarda el listado de personajes si deseamos no perder los cambios que hemos "
				+ "realizado sobre &eacute;l<br> (sobreescribe el archivo). Si se guarda por primera vez, entonces se abrir&aacute;"
				+ " una ventana de<br> di&aacute;logo para Guardar como. Las teclas de acceso r&aacute;pido son Ctrl+G (accelerator)."
				+ "</span></span></p>\r\n\r\n<h3 style=\"text-align: justify;\">&nbsp;</h3>\r\n\r\n<h3 style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">2.4. GUARDAR COMO:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Guarda el listado de personajes en un archivo con el nombre y en el lugar del "
				+ "ordenador que<br> indiquemos. Las teclas de acceso r&aacute;pido son Ctrl+Ma&yacute;us+G (accelerator).</span>"
				+ "</span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">2.5. SALIR:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">Permite salir del programa, cerrando la ventana principal. Las teclas de acceso "
				+ "r&aacute;pido son Ctrl+S<br> (accelerator).</span></span></p>\r\n\r\n<p style=\"text-align: "
				+ "justify;\">&nbsp;</p>\r\n\r\n<h2 style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">3. PERSONAJE:</span></span></h2>\r\n\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Este es el segundo men&uacute; "
				+ "de la ventana principal de la apliaci&oacute;n, el cu&aacute;l permite la gesti&oacute;n del<br> listado de personajes."
				+ " Contiene los submen&uacute;s A&ntilde;adir, Eliminar, Buscar Nombre, Buscar tipos y<br> Mostrar. "
				+ "Su mnemonic es la letra P.</span></span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Para poder eliminar, buscar o mostrar"
				+ " un personaje no se permite tener un listado vac&iacute;o; hay que<br> a&ntilde;adir alguno antes.</span>"
				+ "</span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">3.1. A&Ntilde;ADIR:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Las teclas de acceso r&aacute;pido son Ctrl+May&uacute;s+A (accelerator).</span></span>"
				+ "</p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Crea un personaje. Para ello hay que rellenar los campos:</span></span></p>\r\n\r\n<ul>"
				+ "\r\n\t<li>\r\n\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Nombre (de tipo String): nombre del personaje que empezar&aacute; por may&uacute;scula,"
				+ " pudiendo<br> continuar de otra u otras letras min&uacute;sculas y un gui&oacute;n seguido de una letra may&uacute;scula"
				+ " y<br> otras letras min&uacute;sculas (esto es opcional, no tiene porqu&eacute; contener un gui&oacute;n seguido de<br> "
				+ "una letra may&uacute;scula). Como m&iacute;nimo tendr&aacute; tres letras y se permiten tildes y la letra &ntilde; (u<br>"
				+ " &Ntilde;). No contendr&aacute; n&uacute;meros ni otras signos especiales aparte del gui&oacute;n. El patr&oacute;n para"
				+ " la<br> expresi&oacute;n regular ser&iacute;a:<br> &quot;^[A-Z&Aacute;&Eacute;&Iacute;&Oacute;&Uacute;&Ntilde;]([a-z&aacute;"
				+ "&eacute;&iacute;&oacute;&uacute;&ntilde;]+[-][A-Z&Aacute;&Eacute;&Iacute;&Oacute;&Uacute;&Ntilde;])?[a-z&aacute;&eacute;"
				+ "&iacute;&oacute;&uacute;&ntilde;]{2,}$&quot;</span></span></p>\r\n\t</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;"
				+ " margin-left: 40px;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Por tanto, "
				+ "permitir&iacute;amos nombres como:</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">&bull; Rock-Naut.</span></span></p>\r\n\r\n<p"
				+ " style=\"text-align: justify; margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva"
				+ ",sans-serif;\">&bull; Von-Set.</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">&bull; Z&iacute;an.</span></span>"
				+ "</p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">&bull; Nora.</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">&bull; Nel.</span></span>"
				+ "</p>\r\n\r\n<p style=\"text-align: justify; margin-left: 40px;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">Y no permitir&iacute;amos nombre como:</span></span></p>\r\n\r\n<p style=\"text-align: "
				+ "justify; margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "&bull; A.</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">&bull; alan.</span></span></p>\r\n\r\n<p style=\"text-align: "
				+ "justify; margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "&bull; Liun-null.</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">&bull; Aal.</span></span></p>\r\n\r\n<p style=\"text-align: justify; "
				+ "margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">&bull; Ali4.</span>"
				+ "</span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 80px;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">&bull; 4Ana.</span></span></p>\r\n\r\n<p style=\"text-align: justify; margin-left: 40px;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">El nombre ser&aacute; &uacute;nico"
				+ " para cada personaje, sin posibilidad de haber m&aacute;s de un personaje<br> con el mismo nombre. Actuar&aacute;, pues, "
				+ "como su identificador. El campo del nombre se<br> pondr&aacute; de color rojo en caso de que se escriba un nombre "
				+ "inv&aacute;lido.</span></span></p>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Apellido (de tipo String): "
				+ "tiene que tener como m&iacute;nimo tres letras (de la &ldquo;a&rdquo; a la &ldquo;z&rdquo;,<br> incluida la &ldquo;&ntilde;&rdquo;)"
				+ " y la primera ha de estar en may&uacute;sculas. Permite tildes, pero no caracteres<br> especiales (guiones, signos "
				+ "de interrogaci&oacute;n...) ni n&uacute;meros. El patr&oacute;n para la expresi&oacute;n<br> regular ser&iacute;a: "
				+ "&quot;^[A-Z&Aacute;&Eacute;&Iacute;&Oacute;&Uacute;&Ntilde;][a-z&ntilde;&aacute;&eacute;&iacute;&oacute;&uacute;]{2,}"
				+ "$&quot;</span></span></p>\r\n\t</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify; margin-left: 40px;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Puede haber m&aacute;s de un personaje"
				+ " con el mismo apellido (pueden ser familiares).</span></span></p>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align:"
				+ " justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Personajes: se selecciona"
				+ " el tipo de personaje que vamos a crear (Mago, Arquero,<br> Guerrero, Dios, Dragon).</span>"
				+ "</span></p>\r\n\t</li>\r\n</ul>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Edad (de tipo int): "
				+ "a&ntilde;os que tiene el personaje. Oscilar&aacute; entre los 16 y 100 a&ntilde;os. En el<br> caso de ser de "
				+ "la raza Elfo o No-Muerto o de tipo Dios no hay l&iacute;mite de edad, y si se trata<br> de un personaje de tipo "
				+ "Dragon puede llegar a tener 500 a&ntilde;os.</span></span></p>\r\n\t</li>\r\n</ul>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "Altura (de tipo double): altura en metros del personaje. Oscilar&aacute; entre 1.30 y 2.0 metros.</span></span>"
				+ "</p>\r\n\t</li>\r\n</ul>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Peso (de tipo double): "
				+ "peso en Kilos del personaje. Tendr&aacute; valores comprendidos entre<br> 40.0 y 200.0 Kilos (de tipo double)."
				+ "</span></span></p>\r\n\t</li>\r\n</ul>\r\n<br>\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Descripci&oacute;n "
				+ "(de tipo String): datos informativos del personaje.</span></span></p>\r\n\t</li><br>\r\n\t<li>\r\n\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,"
				+ "sans-serif;\">Sexo (enumeraci&oacute;n Sexo): g&eacute;nero del personaje: </span>"
				+ "</span></p>\r\n\r\n\t<ul>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Mujer.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "Hombre.</span></span></p>\r\n\t\t</li>\r\n\t</ul>\r\n\t</li><br>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Regi&oacute;n (enumeraci&oacute;n"
				+ " Region): zona donde vive el personaje:</span></span></p>\r\n\r\n\t<ul>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Bosque.</span>"
				+ "</span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Costa (para los que vivan en una bah&iacute;a o en la "
				+ "playa).</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Monta&ntilde;a.</span>"
				+ "</span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Desierto.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "Cuevas.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Estepa (terreno llano "
				+ "sin apenas &aacute;rboles.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Valle "
				+ "(zona entre dos monta&ntilde;as).</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Volc&aacute;nica "
				+ "(zona cercana a un volc&aacute;n).</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">R&iacute;o "
				+ "(linde de un r&iacute;o).</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\">"
				+ "<span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Lagos.</span></span>"
				+ "</p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Nevada (zona nevada).</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Selva."
				+ "</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Isla.</span></span></p>\r\n\t\t</li>\r\n\t</ul>\r\n\t</li>\r\n</ul>"
				+ "\r\n\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family:"
				+ " verdana,geneva,sans-serif;\">Zodiaco (enumeraci&oacute;n Zodiaco): signo del zodiaco del personaje que puede ayudar a<br>"
				+ " hacernos una idea de su personalidad, ya que cada signo del zodiaco viene asociado a<br> unos rasgos de personalidad."
				+ "</span></span></p>\r\n\r\n\t<ul>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Aries.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Tauro."
				+ "</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Geminis.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">C&aacute;ncer.</span></span>"
				+ "</p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Leo.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Virgo."
				+ "</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Libra.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "Escorpio.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Sagitario.</span></span>"
				+ "</p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Capricornio.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Acuario."
				+ "</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Piscis.</span></span></p>\r\n\t\t</li>\r\n\t</ul>\r\n\t</li>"
				+ "\r\n</ul>\r\n\r\n<ul>\r\n\t<li>\r\n\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Raza (enumeraci&oacute;n Raza): la raza del personaje"
				+ " en caso de ser de tipo Mago, Arquero y<br> Guerrero.</span></span></p>\r\n\r\n\t<ul>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "Humano.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">No-Muerto.</span></span></p>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t<p "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Elfo."
				+ "</span></span></p>\r\n\t\t</li>\r\n\t</ul>\r\n\t</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">No se puede a&ntilde;adir un "
				+ "personaje que ya exista en el listado, ni dejar campos vac&iacute;os o con valores<br> no v&aacute;lidos.</span>"
				+ "</span></p>\r\n\r\n<h3 style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">3.2. ELIMINAR:</span></span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Borra un personaje del listado "
				+ "busc&aacute;ndolo por su nombre. Dar&aacute; un mensaje de error en el caso de<br> que el personaje no exista o el"
				+ " campo del nombre tenga un valor incorrecto. El campo del nombre<br> se pondr&aacute; de color rojo en caso de que "
				+ "se escriba un nombre inv&aacute;lido.</span></span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Las teclas de acceso r&aacute;pido "
				+ "son Ctrl+E (accelerator).</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">"
				+ "3.3. BUSCAR NOMBRE:</span></span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span "
				+ "style=\"font-family: verdana,geneva,sans-serif;\">Muestra un personaje concreto busc&aacute;ndolo por su nombre, que"
				+ " es el &uacute;nico campo rellenable,<br> puesto que los dem&aacute;s est&aacute;n deshabilitados. Dar&aacute; un "
				+ "mensaje de error en el caso de que el<br> personaje no exista o el campo del nombre tenga un valor incorrecto.</span>"
				+ "</span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Las teclas de acceso r&aacute;pido son Ctrl+May&uacute;s+N (accelerator).</span></span>"
				+ "</p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: justify;\"><span "
				+ "style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">3.4. BUSCAR TIPOS:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">A este submen&uacute; podemos acceder pulsando la letra B (mnemonic). Aqu&iacute; "
				+ "contamos con los<br> submen&uacute;s Buscar Magos (Ctrl+May&uacute;s+M), Buscar Arqueros (Ctrl+Alt+A), Buscar "
				+ "Guerreros<br> (Ctrl+Alt+G), Buscar Dragones (Ctrl+May&uacute;s+D) y Buscar Dioses (Ctrl+D), que se encargan<br> "
				+ "de mostrar, respectivamente, los magos del listado de personajes, o los arqueros o guerreros<br> o dragones o dioses "
				+ "por separado. As&iacute; vemos los personajes dividos por tipos.</span></span></p>\r\n<br>\r\n<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Para los tipos Dios "
				+ "y Dragon no estar&iacute;a visible la raza; mientras que para los tipos Mago, Arquero<br> y Guerrero s&iacute;.</span>"
				+ "</span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Los campos en esta ventana no son editables, ya que su &uacute;nica funci&oacute;n es "
				+ "la visualizaci&oacute;n.</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">3.5. MOSTRAR:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Permite visualizar todos los personajes del listado ordenados alfab&eacute;ticamente. "
				+ "Los campos no<br> son editables, ya que s&oacute;lo se desea verlos. </span></span></p>\r\n<br>\r\n<p style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">Las teclas de acceso "
				+ "r&aacute;pido son Ctrl+M (accelerator).</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h2 "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">4. "
				+ "AYUDA:</span></span></h2>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">El tercer men&uacute; sirve para acceder a la parte informativa del programa, de modo que "
				+ "pueda<br> servirnos de ayuda en caso de tener alguna duda sobre &eacute;l. Consta de los submen&uacute;s Ver Ayuda<br> y "
				+ "Ver Acerca De.</span></span></p>\r\n<br>\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Podemos acceder a &eacute;l desde el teclado pulsando la letra "
				+ "A (mnemonic)</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 style=\"text-align: "
				+ "justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">4.1. VER AYUDA:</span>"
				+ "</span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: "
				+ "verdana,geneva,sans-serif;\">Contiene toda la informaci&oacute;n relativa a la utilizaci&oacute;n del programa para "
				+ "facilitar su comprensi&oacute;n y<br> ser capaces de seguir disfrutando de su uso en caso de duda. La tecla de acceso "
				+ "r&aacute;pido es F1<br> (accelerator).</span></span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h3 "
				+ "style=\"text-align: justify;\"><span style=\"font-size:9px;\"><span style=\"font-family: verdana,geneva,sans-serif;\">4.2. "
				+ "VER ACERCA DE:</span></span></h3>\r\n\r\n<p style=\"text-align: justify;\"><span style=\"font-size:9px;\">"
				+ "<span style=\"font-family: verdana,geneva,sans-serif;\">Desde aqu&iacute; podemos ver datos informativos sobre el programa, "
				+ "como el nombre del autor o su<br> versi&oacute;n. La tecla de acceso r&aacute;pido es F2 (accelerator).</span>"
				+ "</span></p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<p "
				+ "style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n</body>\r\n</html>\r\n");
	
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Crea la ventana de di&aacute;logo.
	 */
	public Ayuda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/trabajoFinal/gui/imagenes/Alarm_Help_and_Support_Icon_16.png")));
		setTitle("Ver Ayuda");
		setBounds(100, 100, 730, 644);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		panelDesplazamiento.setBorder(null);
		
		panelDesplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelDesplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDesplazamiento.setBounds(24, 11, 676, 553);
		panelContenedor.add(panelDesplazamiento);		
		panelDesplazamiento.setViewportView(ayudaEtiqueta);			
		
		botonOK.setBounds(332, 585, 59, 23);
		panelContenedor.add(botonOK);
			
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
}
