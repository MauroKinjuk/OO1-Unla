package test;

import incaa.Incaa;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Incaa i = new Incaa();
		
		try {
			//1
			i.agregarPelicula("Batman");
			i.agregarPelicula("Superman");
			//2
			System.out.println(i.traerPelicula(1));
			System.out.println(i.traerPelicula("Superman"));
			//3
			i.modificarPelicula(1,"DeadPool");
			System.out.println(i.traerPelicula(1));
			//4
			i.eliminarPelicula(1);
			System.out.println(i.traerPelicula(1));
			//Muestro una excepsion
			i.eliminarPelicula(3);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
