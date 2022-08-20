package test;

import consultorio.Medico;
import consultorio.Paciente;

public class TestConsultorio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente1 = new Paciente("Jose", "Perez", 1.80f,90);
		Paciente paciente2 = new Paciente("Jorge","Fernandez",1.60f,100);
		Medico medico1 = new Medico("Daniel", "Lopez","Cardiologo");
		
		System.out.println("Visita 2:");
		System.out.println("Medico: " + medico1.traerNombreCompleto());
		System.out.println("Paciente " + paciente1.traerNombreCompleto() +": "+ medico1.calcularIMC(paciente1.getPeso(), paciente1.getEstatura()));
		System.out.println("paciente " + paciente2.traerNombreCompleto() + ": "+medico1.calcularIMC(paciente2.getPeso(), paciente2.getEstatura()));
	}

}