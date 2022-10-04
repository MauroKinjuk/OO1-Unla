package test;

import modelo.Genero;
import modelo.Incaa;

public class Test {

	public static void main(String[] args) {

		System.out.println("Inicio Incaa y creo 3 generos");
		Incaa i = new Incaa();
		Genero gen1 = new Genero(1,"Terror");
		Genero gen2 = new Genero(2,"Accion");
		Genero gen3 = new Genero(3,"Drama");

		System.out.println("Agrego tres peliculas con los generos creados");
		i.agregarPelicula("Scary Movie", gen2);
		i.agregarPelicula("Minions", gen2);
		i.agregarPelicula("Ella", gen3);

		System.out.println("Muestro el catalogo");
		i.mostrarCatalogo();

		System.out.println("Traigo pelicula por genero");
		System.out.println(i.traerPelicula(gen2));
	}

}
