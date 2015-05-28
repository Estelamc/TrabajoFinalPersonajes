package trabajoFinal.personajes;

public class Test {

	public static void main(String[] args) throws ApellidoNoValidoException, NombreNoValidoException, RegionNoValidaException, SexoNoValidoException, AlturaNoValidaException, PesoNoValidoException, ZodiacoNoValidoException, EdadNoValidaException, RazaNoValidaException {
		Mago mago = new Mago("Atayo", "Mullis", Sexo.HOMBRE, Zodiaco.LIBRA, 26, 1.70, 75.0, 
				Region.BOSQUE, Raza.HUMANO, "Aprendiz de hechicero.");

		Personaje personaje = (Personaje)mago;
		System.out.println(personaje instanceof Mago); // TRUE
		System.out.println(personaje instanceof Guerrero); // FALSE
	}

}
