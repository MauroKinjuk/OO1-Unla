package consultorio;

public class Medico {
//Atributos
	private String nombre;
	private String apellido;
	private String especialidad;

public Medico(String nombre, String apellido, String especialidad) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.especialidad = especialidad;
}

//Setter y getter
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String traerNombreCompleto() {
		String resultado;
		resultado = nombre + " " + apellido;
		return resultado;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public String calcularIMC(float peso, float altura) {
		String resultado;
		resultado = "IMC " + (peso/(altura*altura));
		return resultado;
	}
}