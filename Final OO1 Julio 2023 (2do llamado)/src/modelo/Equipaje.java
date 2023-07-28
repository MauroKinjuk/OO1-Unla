package modelo;

public class Equipaje extends Carga {
	private boolean excedePeso;

	public boolean isExcedePeso() {
		return excedePeso;
	}

	public void setExcedePeso(boolean excedePeso) {
		this.excedePeso = excedePeso;
	}



	public Equipaje(int idCarga, String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente,
			Vuelo vuelo, boolean excedePeso) {
		super(idCarga, aeropuertoOrigen, aeropuertoDestino, peso, cliente, vuelo);
		this.excedePeso = excedePeso;
	}

	@Override
	public String toString() {
		return "Equipaje [excedePeso=" + excedePeso + ", idCarga=" + idCarga + ", aeropuertoOrigen=" + aeropuertoOrigen
				+ ", aeropuertoDestino=" + aeropuertoDestino + ", peso=" + peso + ", cliente=" + cliente + ", vuelo="
				+ vuelo + "]";
	}



}
