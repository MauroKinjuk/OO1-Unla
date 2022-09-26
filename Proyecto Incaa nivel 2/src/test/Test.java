package test;

import modelo.Genero;
import modelo.Incaa;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Incaa i = new Incaa();
		Genero gen1 = new Genero(1,"Terror");
		Genero gen2 = new Genero(2,"Accion");
		Genero gen3 = new Genero(3,"Drama");
		
		i.agregarPelicula("Scary Movie", gen1);
		i.agregarPelicula("Top gun", gen3);
		i.agregarPelicula("Pela", gen3);
		i.agregarPelicula("Minions", gen2);
		i.agregarPelicula("Minions 2", gen3);
		
		//Pelicula por id
		System.out.println("---- \nTraigo pelicula por id:");
		System.out.println(i.traerPelicula(1));
		
		
		//Pelicula por nombre
		System.out.println("---- \nTraigo pelicula por nombre: ");
		System.out.println(i.traerPelicula("Mini"));

		System.out.println("Modifico el nombre de la pelicula");
		i.modificarPelicula(1, "Hola");
		System.out.println(i.traerPelicula(1));
		
		//Pelicula por Genero
		System.out.println("---- \nTraigo pelicula por genero:");
		System.out.println(i.traerPelicula(gen3));
		
		//i.mostrarCatalogo();
	}

}
