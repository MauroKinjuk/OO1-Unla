package modelo;

import java.time.LocalDateTime;

public class Vuelo {
	private int idVuelo;
	private String vuelo;
	private LocalDateTime fechaHoraArribo;
	private LocalDateTime fechaHoraPartida;
	private int pesoMaximoEquipaje;

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getVuelo() {
		return vuelo;
	}

	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}

	public LocalDateTime getFechaHoraArribo() {
		return fechaHoraArribo;
	}

	public void setFechaHoraArribo(LocalDateTime fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}

	public LocalDateTime getFechaHoraPartida() {
		return fechaHoraPartida;
	}

	public void setFechaHoraVuelo(LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraArribo) throws Exception {
		//Si la fechaHoraArribo es null y la fechaHoraPartida es anterior a la actual lanzo la excepción "ERROR"
		if(fechaHoraArribo == null && fechaHoraPartida.isBefore(LocalDateTime.now())) {
			throw new Exception("ERROR: El vuelo no arribo, por lo tanto la fechaHora de partida es anterior a la actual.");
		}
		this.fechaHoraPartida = fechaHoraPartida;
		this.fechaHoraArribo = fechaHoraArribo;
	}

	public int getPesoMaximoEquipaje() {
		return pesoMaximoEquipaje;
	}

	public void setPesoMaximoEquipaje(int pesoMaximoEquipaje) {
		this.pesoMaximoEquipaje = pesoMaximoEquipaje;
	}
	
	public Vuelo(int idVuelo, String vuelo, LocalDateTime fechaHoraArribo, LocalDateTime fechaHoraPartida,
			int pesoMaximoEquipaje) throws Exception {
		super();
		this.idVuelo = idVuelo;
		this.vuelo = vuelo;
		setFechaHoraVuelo(fechaHoraPartida, fechaHoraArribo);
		this.pesoMaximoEquipaje = pesoMaximoEquipaje;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", vuelo=" + vuelo + ", fechaHoraArribo=" + fechaHoraArribo
				+ ", fechaHoraPartida=" + fechaHoraPartida + ", pesoMaximoEquipaje=" + pesoMaximoEquipaje + "]";
	}

}
