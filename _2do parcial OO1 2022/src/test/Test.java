package test;

import modelo.CampingNacional;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        CampingNacional camp = new CampingNacional();

        System.out.println("1)");
        try {
            camp.agregarPersona("Sergio","Lopez",11111111);
            camp.agregarPersona("Juan","Rodriguez",22222222);
            camp.agregarPersona("Maria","Fernandez",33333333);
            camp.agregarPersona("Juan","Vazquez",44444444);
            camp.agregarPersona("Ana","Martinez",55555555);
            System.out.println(camp.getLstPersonas());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("2)");
        try {
            camp.agregarRecreo("7358902", LocalDate.of(2022,9,2),false,camp.traerPersona(11111111),5,300);
            camp.agregarCampamento("6573540",LocalDate.of(2022,9,3),false,camp.traerPersona(222222222),null,1,1500);
            camp.agregarRecreo("3571398",LocalDate.of(2022,9,3),false,camp.traerPersona(333333333),10,300);
            camp.agregarCampamento("2583941",LocalDate.of(2022,9,3),true,camp.traerPersona(444444444),LocalDate.of(2022,9,8),2,1500);
            camp.agregarRecreo("5243925",LocalDate.of(2022,9,3),true,camp.traerPersona(55555555),8,300);
            System.out.println(camp.getLstServicios());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("3)");
        //traigo los servicios con precio final mayor a 500 y hayan egresado
        System.out.println(camp.traerServicioPorPrecioFinal(500));

        System.out.println("4)");
        //Traigo la lista de servicios que tengan mas de 4 dias en el campamento
        System.out.println(camp.traerCampamentoPorDias(4));

        System.out.println("5)");
        try {
            camp.agregarPersona("Juan","Vazquez",44444444);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("6)");
        try {
            camp.agregarRecreo("3571394",LocalDate.of(2022,9,10),false,camp.traerPersona(33333333),5,300);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}