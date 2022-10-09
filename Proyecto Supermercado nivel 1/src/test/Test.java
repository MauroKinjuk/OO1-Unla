package test;

import modelo.Carrito;
import modelo.Supermercado;

public class Test {
    public static void main(String[] args) {
        Supermercado sup = new Supermercado();

        //Agregar
        System.out.println("Agrego 3 productos \n--------");
        try {
            sup.agregarProducto("Mayonesa",10);
            sup.agregarProducto("Ketchup",20);
            sup.agregarProducto("Papas",30);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Traer
        System.out.println("Traigo los 3 productos y uno que no existe:");
        System.out.println(sup.traerProducto(1));
        System.out.println(sup.traerProducto(2));
        System.out.println(sup.traerProducto(3));
        System.out.println(sup.traerProducto(4));

        //Modificar y Eliminar
        try {
            //Modificar
            System.out.println("-------\nModifico un producto y lo imprimo:");
            sup.modificarProducto(1,"Palmitos",40);
            System.out.println(sup.traerProducto(1));

            //Eliminar
            System.out.println("-------\nElimino un producto y lo trato de imprimir:");
            sup.eliminarProducto(3);
            System.out.println(sup.traerProducto(3));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Creo un nuevo carrito
        Carrito car = new Carrito();

        System.out.println("Agrego dos productos al carrito \n--------");
        car.agregarItem(sup.traerProducto(1),3);
        car.agregarItem(sup.traerProducto(2),2);

        System.out.println("Elimino un producto de la lista y lo imprimo");
        try {
            car.eliminarItem(sup.traerProducto(1),1);
            System.out.println(car.traerItem(1) + "\n--------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Calculo el total de la lista
        // 2 palmitos ($80) y 2 Ketchup ($40) = $120
        System.out.println("El total de su carrito es de: " + car.calcularTotal());
    }
}
