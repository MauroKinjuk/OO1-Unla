package test;

import modelo.Genero;
import modelo.Incaa;
import modelo.Pelicula;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Incaa i = new Incaa();
		Genero gen1 = new Genero(1,"Terror");
		Genero gen2 = new Genero(2,"Accion");
		Genero gen3 = new Genero(3,"Drama");
		
		i.agregarPelicula("Scary Movie", gen1);
		i.agregarPelicula("Minions", gen2);
		i.agregarPelicula("Ella", gen3);
		
		i.mostrarCatalogo();
	}

}
