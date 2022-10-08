package modelo;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Producto> gondola;

    public Supermercado() {
        this.gondola = new ArrayList<>();
    }

    public List<Producto> getGondola() {
        return gondola;
    }

    public void setGondola(List<Producto> gondola) {
        this.gondola = gondola;
    }

    public boolean agregarProducto(String producto, float precio) throws Exception {
        int id = 1;
        if (!gondola.isEmpty()){
            id = gondola.get(gondola.size() - 1).getIdProducto() + 1;
        }
        /* Si el producto no existe me va a devolver null
        Por lo tanto compruebo que si al traer el producto es diferente a null
        Largo una excepcion de que el producto ya existe */
        if (traerProducto(producto) != null){
            throw new Exception("Ya existe un producto con ese nombre.");
        }
        return gondola.add(new Producto(id, producto,precio));
    }

    //Traigo productos por ID y otro por Nombre
    public Producto traerProducto(int idProducto){
        Producto p = null;
        int i = 0;

        while(i<gondola.size() && p == null){
            if (gondola.get(i).getIdProducto() == idProducto){
                p = gondola.get(i);
            }
            i++;
        }

        return p;
    }

    public Producto traerProducto(String producto){
        Producto p = null;
        int i = 0;

        while(i<gondola.size() && p == null){
            if (gondola.get(i).getProducto().equals(producto)){
                p = gondola.get(i);
            }
            i++;
        }

        return p;
    }

    public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception {
        boolean flag = false;
        Producto p = traerProducto(idProducto);

        if(p == null){
            throw new Exception("El producto no existe.");
        }else{
            p.setProducto(producto);
            /* Como el ejercicio pide modificar con double el precio, pero al mismo tiempo en
             la declaracion de producto pide que sea float, hago un casteo */
            p.setPrecio((float) precio);
            flag = true;
        }

        return flag;
    }

    public boolean eliminarProducto(int idProducto) throws Exception {
        boolean flag = false;
        Producto p = traerProducto(idProducto);

        if (p == null){
            throw new Exception("El producto no existe.");
        }else{
            gondola.remove(p);
            flag = true;
        }

        return flag;
    }

}
