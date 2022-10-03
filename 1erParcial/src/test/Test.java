package test;

import modelo.SistemaSaludDispositivos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args){
        SistemaSaludDispositivos e1 = new SistemaSaludDispositivos();

        System.out.println("1) ");
        e1.agregarEmpresa("Empresa 1");
        e1.agregarEmpresa("Empresa 2");

        System.out.println("2) ");
        System.out.println(e1.traerEmpresa("Empresa 1"));

        System.out.println("3) ");
        try {
            e1.agregarDispositivo("Sensor Calor","A2020",e1.traerEmpresa("Empresa 1"));
            e1.agregarDispositivo("Sensor Presion","A2325",e1.traerEmpresa("Empresa 1"));
            e1.agregarDispositivo("Sensor Temperatura","B2021",e1.traerEmpresa("Empresa 2"));
            e1.agregarDispositivo("Sensor Humedad","B2326",e1.traerEmpresa("Empresa 2"));
            System.out.println("4) ");
            e1.agregarDispositivo("Sensor Movimiento", "B2022",e1.traerEmpresa("Empresa 1"));
        }catch (Exception e){
            System.out.println("Excepcion: "+e.getMessage());
        }

        System.out.println("5) ");
        System.out.println(e1.traerDispositivo("A2020"));

        System.out.println("6) ");
        //Agrego metricas
        e1.traerDispositivo("A2020").agregarMetrica(18,LocalDate.of(2022,9,18),LocalTime.of(10,0));
        e1.traerDispositivo("A2020").agregarMetrica(19,LocalDate.of(2022,9,19),LocalTime.of(12,30));
        e1.traerDispositivo("A2020").agregarMetrica(23,LocalDate.of(2022,9,20),LocalTime.of(15,0));
        e1.traerDispositivo("A2020").agregarMetrica(20,LocalDate.of(2022,9,21),LocalTime.of(18,30));
        e1.traerDispositivo("A2020").agregarMetrica(18,LocalDate.of(2022,9,22),LocalTime.of(22,30));

        System.out.println("7) ");
        System.out.println(e1.traerDispositivo("A2020").traerMetrica(LocalDate.of(2022,9,19),LocalTime.of(12,30)));

        System.out.println("8) ");
        //System.out.println(e1.traerDispositivo("A2020").traerMetricas(LocalDate.of(2022,9,19),LocalDate.of(2022,9,21)));

    }
}
