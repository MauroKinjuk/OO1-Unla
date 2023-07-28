package modelo;

public class Envio extends Carga {
	private String domicilioEntrega;

	public String getDomicilioEntrega() {
		return domicilioEntrega;
	}

	public void setDomicilioEntrega(String domicilioEntrega) {
		this.domicilioEntrega = domicilioEntrega;
	}

	public Envio(int idCarga, String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente, Vuelo vuelo,
			String domicilioEntrega) {
		super(idCarga, aeropuertoOrigen, aeropuertoDestino, peso, cliente, vuelo);
		this.domicilioEntrega = domicilioEntrega;
	}

	@Override
	public String toString() {
		return "Envio [domicilioEntrega=" + domicilioEntrega + ", idCarga=" + idCarga + ", aeropuertoOrigen="
				+ aeropuertoOrigen + ", aeropuertoDestino=" + aeropuertoDestino + ", peso=" + peso + ", cliente="
				+ cliente + ", vuelo=" + vuelo + "]";
	}


}
