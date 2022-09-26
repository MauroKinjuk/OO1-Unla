package modelo;

import java.util.ArrayList;
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

	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p1 = null;
		int i = 0;
		while(i < catalogo.size()) {
			if(catalogo.get(i).getIdPelicula() == idPelicula) {
				p1 = catalogo.get(i);
			}
			i++;
		}
		
		return p1;
	}
	
	public boolean agregarPelicula(String nombre, Genero genero) {
		int id = 1;
		
		if(!catalogo.isEmpty()) {
			id = catalogo.get(catalogo.size()-1).getIdPelicula()+1;
		}
		return catalogo.add(new Pelicula(id,nombre, genero));
	}

	public List<Pelicula> traerPelicula(String partePelicula) {
		List<Pelicula> aux= new ArrayList<>();  
		
		for(Pelicula p: this.catalogo) {
			if(p.getPelicula().contains(partePelicula)) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public List<Pelicula> traerPelicula (Genero genero) {
		List<Pelicula> p1 = new ArrayList<>();
		
		for(Pelicula p : this.catalogo) {
			if(p.getGenero() == genero) {
				p1.add(p);
			}
		}
		return p1;
	}
	
	public boolean modificarPelicula(int idPelicula, String pelicula) throws Exception {
		Pelicula encontrada = traerPelicula(idPelicula);
		boolean resultado = false;
		
		if(encontrada == null) {
			throw new Exception("Pelicula no encontrada");
		}else {
			encontrada.setPelicula(pelicula);
			resultado = true;
		}
		
		return resultado;
		
	}
	
	
	
}
