package test;

import java.time.LocalDateTime;

import modelo.Sistema;

public class Test {

	public static void main(String[] args) throws Exception {
		Sistema sistema = new Sistema();
		System.out.println("1)");
		// Agrego los siguientes clientes
		sistema.agregarCliente(1, "Jorge", "Newberry", 12345678L);
		sistema.agregarCliente(2, "Teodoro", "Fells", 12569874L);
		sistema.agregarCliente(3, "Bartolome", "Cattaneo", 13456987L);
		sistema.agregarCliente(4, "Raul", "Goubat", 11321654L);
		sistema.agregarCliente(5, "Alfedo", "Agneta", 13987523L);
		// Me imprimo todos los clientes
		System.out.println(sistema.getLstclientes());

		System.out.println("2)");
		// Me traigo el cliente con el dni 12569874
		System.out.println(sistema.traerCliente(12569874L));

		System.out.println("3)");
		// Me agrego los siguientes vuelos
		sistema.agregarVuelo("AR2234", LocalDateTime.of(2023, 6, 25, 22, 20, 0), LocalDateTime.of(2023, 6, 26, 0, 0, 0),
				10);
		sistema.agregarVuelo("AR6678", LocalDateTime.of(2023, 6, 25, 22, 40, 0),
				LocalDateTime.of(2023, 6, 26, 23, 59, 59), 15);
		sistema.agregarVuelo("AR2356", LocalDateTime.of(2023, 8, 30, 15, 42, 0), null, 12);
		sistema.agregarVuelo("AR4234", LocalDateTime.of(2023, 6, 26, 21, 20, 0), LocalDateTime.of(2023, 6, 27, 0, 0, 0),
				10);
		sistema.agregarVuelo("AR9678", LocalDateTime.of(2023, 6, 26, 21, 41, 0),
				LocalDateTime.of(2023, 6, 27, 23, 59, 59), 15);
		// Imprimo los vuelos
		System.out.println(sistema.getLstvuelos());

		System.out.println("4)");
		// Traigo el vuelo "AR2234"
		System.out.println(sistema.traerVuelo("AR2234"));

		System.out.println("5)");
		// Con un try catch trato de agregar el vuelo "AR2435"
		try {
			sistema.agregarVuelo("AR2435", LocalDateTime.of(2023, 5, 27, 15, 20, 0), null, 15);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("6)");
		// Agrego las siguientes cargas
		sistema.agregarEnvio("AEP", "COR", 15, sistema.traerCliente(13987523L), sistema.traerVuelo("AR2234"),
				"Saenz 2222 Buenos Aires");
		sistema.agregarEquipaje("AEP", "JUJ", 10, sistema.traerCliente(13456987L), sistema.traerVuelo("AR2234"), true);

		sistema.agregarEnvio("AEP", "COR", 15, sistema.traerCliente(11321654L), sistema.traerVuelo("AR2234"),
				"Cabildo 342 Avellaneda");
		sistema.agregarEquipaje("AEP", "JUJ", 30, sistema.traerCliente(12569874L), sistema.traerVuelo("AR6678"), false);

		sistema.agregarEnvio("AEP", "COR", 52, sistema.traerCliente(12569874L), sistema.traerVuelo("AR6678"),
				"Colombres 596 Lomas de Zamora");
		sistema.agregarEquipaje("AEP", "COR", 15, sistema.traerCliente(12345678L), sistema.traerVuelo("AR6678"), true);

		// Imprimo todas las cargas
		System.out.println(sistema.getLstcargas());

		System.out.println("7)");
		System.out.println(sistema.traer(sistema.traerVuelo("AR2234"), true));
	}

}
