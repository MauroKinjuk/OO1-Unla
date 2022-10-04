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

    public boolean agregarProducto(String producto, float precio){
        int id = 1;
        if (!gondola.isEmpty()){
            id = gondola.get(gondola.size() - 1).getIdProducto() + 1;
        }
        return gondola.add(new Producto(id, producto,precio));
    }

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


}
