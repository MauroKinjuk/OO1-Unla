package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;

public class Incaa {
	
	private List<Pelicula> catalogo;

	//Mejora la creacion del ArrayList
	public Incaa(){
		this.catalogo = new ArrayList<>();
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}
	
	// 1
	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p1 = null;
		int i = 0;

		//Doble punto de control en el while, checkeando el tamaño y que no sea null
		while (i < catalogo.size() && p1 == null) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				p1 = catalogo.get(i);
			}
			i++;
		}
		return p1;
	}
	
	//2
	public boolean agregarPelicula(String pelicula) {
		int id = 1;
		//Si el catalogo NO esta vacio, entonces genero un id, si no es 1
		if(!catalogo.isEmpty()) {
			id = catalogo.get(catalogo.size()-1).getIdPelicula()+1;
		}
		return catalogo.add(new Pelicula(id, pelicula));
	}
	
	//3
	public Pelicula traerPelicula(String partePelicula) {
		Pelicula p1 = null;
		int i = 0;

		//Doble punto de control en el while, checkeando el tamaño y que no sea null
		while (i < catalogo.size() && p1 == null) {
			if (catalogo.get(i).getPelicula().equals(partePelicula)) {
				p1 = catalogo.get(i);
			}
			i++;
		}
		return p1;
	}
	
	//4
	public boolean modificarPelicula(int idPelicula, String pelicula) throws Exception {
		boolean resultado = false;
		Pelicula p1 = traerPelicula(idPelicula);
		
		if(p1 == null) {
			throw new Exception("La pelicula con el id "+idPelicula+" no se encuentra registrada");
		}else {
				p1.setPelicula(pelicula);
				resultado = true;
		}
		return resultado;
	}
	
	//5
	public boolean eliminarPelicula(int idPelicula) throws Exception {
		boolean  resultado = false;
		Pelicula p1 = traerPelicula(idPelicula);
		
		if(p1 == null) {
			throw new Exception ("La pelicula con el id "+idPelicula+" no se encuentra resgitrada");
		}else {
				catalogo.remove(p1);
				resultado = true;
		}
		
		return resultado;
	}
}
