package modelo;

public class Pelicula {

	private int idPelicula;
	private String pelicula;
	private Genero genero;
	
	public Pelicula(int idPelicula, String pelicula, Genero genero) {
		this.idPelicula = idPelicula;
		this.pelicula = pelicula;
		this.genero = genero;
	}


	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return  "ID : " + idPelicula +
				"\nPelicula : " + pelicula + "\n" +
				genero+
				"----------------------\n";
	}
}
