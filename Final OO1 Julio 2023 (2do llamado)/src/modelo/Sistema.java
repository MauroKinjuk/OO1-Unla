package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	// agrego las listas
	private List<Cliente> lstclientes;
	private List<Vuelo> lstvuelos;
	private List<Carga> lstcargas;

	public List<Cliente> getLstclientes() {
		return lstclientes;
	}

	public List<Carga> getLstcargas() {
		return lstcargas;
	}

	public void setLstcargas(List<Carga> lstcargas) {
		this.lstcargas = lstcargas;
	}

	public void setLstclientes(List<Cliente> lstclientes) {
		this.lstclientes = lstclientes;
	}

	public List<Vuelo> getLstvuelos() {
		return lstvuelos;
	}

	public void setLstvuelos(List<Vuelo> lstvuelos) {
		this.lstvuelos = lstvuelos;
	}

	public Sistema() {
		super();
		this.lstclientes = new ArrayList<>();
		this.lstvuelos = new ArrayList<>();
		this.lstcargas = new ArrayList<>();
	}

	// Agrego clientes
	public boolean agregarCliente(int idCliente, String nombre, String apellido, Long dni) {
		return lstclientes.add(new Cliente(idCliente, nombre, apellido, dni));
	}

	public Cliente traerCliente(long dni) {
		// Me traigo el cliente que tenga ese dni
		Cliente cliente = null;
		int i = 0;
		while (i < lstclientes.size() && cliente == null) {
			if (lstclientes.get(i).getDni() == dni) {
				cliente = lstclientes.get(i);
			}
			i++;
		}
		return cliente;
	}

	public Vuelo traerVuelo(String vuelo) {
		Vuelo vuelo1 = null;
		int i = 0;
		while (i < lstvuelos.size() && vuelo1 == null) {
			if (lstvuelos.get(i).getVuelo() == vuelo) {
				vuelo1 = lstvuelos.get(i);
			}
			i++;
		}
		return vuelo1;
	}

	public boolean agregarVuelo(String vuelo, LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraArribo,
			int pesoMaximoEquipaje) throws Exception {
		int id = 1;
		//Si la fechaHoraArribo es null y la fechaHoraPartida es anterior a la actual lanzo la excepcion "ERROR"
		if (fechaHoraArribo == null && fechaHoraPartida.isBefore(LocalDateTime.now())) {
			throw new Exception("ERROR: El vuelo no arribo, por lo tanto la fechaHora de partida es anterior a la actual.");
		}
		if(!lstvuelos.isEmpty()) {
			id = lstvuelos.get(lstvuelos.size()-1).getIdVuelo()+1;
		}
		return lstvuelos.add(new Vuelo(id, vuelo, fechaHoraArribo, fechaHoraPartida, pesoMaximoEquipaje));
	}

	// agrego equipaje
	public boolean agregarEquipaje(String aeroPuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente,
			Vuelo vuelo, boolean excedePeso) {
		int id = 1;
		// ID Incremental
		if (!lstcargas.isEmpty()) {
			id = lstcargas.get(lstcargas.size() - 1).getIdCarga() + 1;
		}
		// Añado el equipaje
		return lstcargas.add(new Equipaje(id, aeroPuertoOrigen, aeropuertoDestino, peso, cliente, vuelo, excedePeso));
	}

	// Agrego envio
	public boolean agregarEnvio(String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente,
			Vuelo vuelo, String domicilioEntrega) {
		// ID Incremental
		int id = 1;
		if (!lstcargas.isEmpty()) {
			id = lstcargas.get(lstcargas.size() - 1).getIdCarga() + 1;
		}
		// Añado el envio
		return lstcargas
				.add(new Envio(id, aeropuertoOrigen, aeropuertoDestino, peso, cliente, vuelo, domicilioEntrega));
	}

	//Creo una funcion que me trae los equipajes excedidos de peso de un vuelo
	public List<Equipaje> traer(Vuelo vuelo, boolean excedido) {
		List<Equipaje> equipajes = new ArrayList<>();
		for (Carga carga : lstcargas) {
			if (carga instanceof Equipaje) {
				Equipaje equipaje = (Equipaje) carga;
				if (equipaje.getVuelo().equals(vuelo) && equipaje.isExcedePeso() == excedido) {
					equipajes.add(equipaje);
				}
			}
		}
		return equipajes;
	}

	@Override
	public String toString() {
		return "Sistema [lstclientes=" + lstclientes + ", lstvuelos=" + lstvuelos + ", lstcargas=" + lstcargas + "]";
	}


}
