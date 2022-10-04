package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {

    private List<Pelicula> catalogo = new ArrayList<>();

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}


	public boolean agregarPelicula(String nombre, Genero genero) {
		int id = 1;
		
		if(!catalogo.isEmpty()) {
			id = catalogo.get(catalogo.size()-1).getIdPelicula()+1;
		}
		return catalogo.add(new Pelicula(id,nombre, genero));
	}
	
	public void mostrarCatalogo() {
		for (Pelicula pelicula : catalogo) {
			System.out.println(pelicula);
		}
	}

	//Traigo pelicula por ID
	public Pelicula traerPelicula(int id){
		Pelicula p = null;
		int i = 0;
		while(i<catalogo.size() && p == null){
			if(catalogo.get(i).getIdPelicula() == id){
				p = catalogo.get(i);
			}
			i++;
		}
		return p;
	}

	//Traigo todas las peliculas de un mismo genero
	public List<Pelicula> traerPelicula(Genero genero){
		List<Pelicula> p = new ArrayList<>();
		int i = 0;
		while(i<catalogo.size()){
			if (catalogo.get(i).getGenero() == genero){
				p.add(catalogo.get(i));
			}
			i++;
		}
		return p;
	}

}
