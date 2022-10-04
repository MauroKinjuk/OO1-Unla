package test;

import modelo.Incaa;

public class Test {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Incaa i = new Incaa();
		

		System.out.println("1: Agrego pelicula (Barman y Superman)");
		i.agregarPelicula("Batman");
		i.agregarPelicula("Superman");

		System.out.println("2: Traigo pelicula por id y por nombre");
		System.out.println(i.traerPelicula(1));
		System.out.println(i.traerPelicula("Superman"));

		try {
			System.out.println("3: Modifico la pelicula de ID 1, le cambio el nombre a DeadPool");
			i.modificarPelicula(1,"DeadPool");
			System.out.println(i.traerPelicula(1));

			System.out.println("4: Elimino la pelicula de id 1, y trato de mostrarla");
			i.eliminarPelicula(1);
			System.out.println(i.traerPelicula(1));

			System.out.println("5: Trato de eliminar una pelicula que no existe");
			i.eliminarPelicula(3);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
