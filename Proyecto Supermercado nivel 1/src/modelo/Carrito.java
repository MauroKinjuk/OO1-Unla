package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private LocalDate fecha;
    private LocalTime hora;
    private List<ItemCarrito> lstItem;

    public Carrito(){
        this.lstItem = new ArrayList<>();
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<ItemCarrito> getLstItem() {
        return lstItem;
    }

    public void setLstItem(List<ItemCarrito> lstItem) {
        this.lstItem = lstItem;
    }

    public boolean agregarItem(Producto producto, int cantidad){
        int id = 1;

        if (!lstItem.isEmpty()){
            id = lstItem.get(lstItem.size() - 1).getIdItem() + 1;
        }else{
            if (traerItem(producto.getIdProducto()) != null){
                cantidad += traerItem(producto.getIdProducto()).getCantidad();
            }
        }

        return lstItem.add(new ItemCarrito(id,producto,cantidad));
    }

    public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
        boolean flag = false;
        ItemCarrito p = traerItem(producto.getIdProducto());

        if (traerItem(producto.getIdProducto()) == null){
            throw new Exception("El producto no existe");
        }

        if (p.getCantidad() > cantidad){
            p.setCantidad(p.getCantidad()-cantidad);
            flag = true;
        }else{
            lstItem.remove(traerItem(producto.getIdProducto()));
        }

        return flag;
    }

    public ItemCarrito traerItem(int id){
        ItemCarrito item = null;
        int i = 0;

        while(i<lstItem.size() && item == null){
            if (lstItem.get(i).getIdItem() == id){
                item = lstItem.get(i);
            }
            i++;
        }

        return item;
    }

    public float calcularTotal(){
        float total = 0;

        for (ItemCarrito itemCarrito : lstItem) {
            total += itemCarrito.calcularSubTotal();
        }
        return total;
    }
}
