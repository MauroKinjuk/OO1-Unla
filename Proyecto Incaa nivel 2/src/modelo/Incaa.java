package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Incaa {

    private List<Pelicula> catalogo = new ArrayList<Pelicula>();
    private List<Genero> genero = new ArrayList<Genero>();

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}
	
    
	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	public boolean agregarPelicula(String nombre, Genero genero) {
		int id = 1;
		
		if(!catalogo.isEmpty()) {
			id = catalogo.get(catalogo.size()-1).getIdPelicula()+1;
		}
		return catalogo.add(new Pelicula(id,nombre, genero));
	}
	
	public void mostrarCatalogo() {
		Iterator<Pelicula> it = catalogo.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
