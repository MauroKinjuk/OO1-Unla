package test;

import modelo.Sistema;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Sistema sis = new Sistema();

        try {
            System.out.println("1-1)");
            sis.agregarGastronomia("3281", 22.0, true, "Hamburguesa con fritas", 250.0, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1-2)");
            sis.agregarGastronomia("328142",22.0,true,"Hamburguesa con fritas",250.0,3);

            System.out.println("1-3)");
            sis.agregarHospedaje("4271",15.0,true,"Cabaña 4 personas",2500.0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1-4)");
            sis.agregarHospedaje("427135",15.0,true,"Cabaña 4 personas",2500.0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("2-1)");
        System.out.println(sis.traerServicio("328142").calcularPrecioFinal(LocalDate.of(2020,10,30)));

        System.out.println("2-2)");
        System.out.println(sis.traerServicio("427135").calcularPrecioFinal(LocalDate.of(2020,10,30)));

        System.out.println("3");
        try {
            sis.agregarGastronomia("348397",10.0,true,"Milanesa con papas fritas",420.0,2);
            sis.agregarHospedaje("348789",15.0,true,"Habitacion simple",1500.0);
            sis.agregarGastronomia("182835",20.0,false,"Gaseosa",120.0,3);
            sis.agregarHospedaje("438719",10.0,false,"Habitacion doble",2500.0);
            System.out.println(sis);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("4-1)");
        System.out.println(sis.traerServicio(true));

        System.out.println("4-2)");
        System.out.println(sis.traerServicio(LocalDate.of(2020,10,28),true));

    }

    }
