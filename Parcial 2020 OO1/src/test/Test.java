package test;

import modelo.Gastronomia;
import modelo.Hospedaje;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {

        System.out.println("1-1)");
        /*
        try {
            Gastronomia gas = new Gastronomia("3281",22.0,true,"Hamburguesa con fritas",250.0,3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }*/

        System.out.println("1-2)");
        Gastronomia g1 = null;
        try {
            g1 = new Gastronomia("328142", 22.0, true, "Hamburguesa con fritas", 250.0, 3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("1-3)");
        /*
        try {
            Hospedaje h1 = new Hospedaje("4271",15.0,true,"Cabaña 4 personas",2500.0);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }*/

        System.out.println("1-4)");

        try {
            Hospedaje h2 = new Hospedaje("427135", 15.0, true, "Cabaña 4 personas", 2500.0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("2-1)");
        //calculo el precio final de g1
        System.out.println(g1.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
    }
}
