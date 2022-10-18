package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema(){
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio){
        Servicio serv = null;
        int i = 0;
        while(i < lstServicio.size() && serv == null){
            if (lstServicio.get(i).getCodServicio().equals(codServicio)){
                serv = lstServicio.get(i);
            }
            i++;
        }
        return serv;
    }

    public ArrayList<Servicio> traerServicio(boolean enPromocion){
        ArrayList<Servicio> serv = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serv.add(servicio);
            }
        }
        return serv;
    }

    //traigo servicio por dia y por promocion
    public ArrayList<Servicio> traerServicio(LocalDate dia, boolean enPromocion){
        ArrayList<Servicio> serv = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() && servicio.calcularPrecioFinal(dia) > 0) {
                serv.add(servicio);
            }
        }
        return serv;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        Servicio serv = null;
        if (traerServicio(codServicio) == null){
            serv = new Gastronomia(codServicio,porcentajeDescuento,enPromocion,gastronomia,precio,diaSemDesc);
        }else{
            throw new Exception("El servicio con el codigo "+codServicio+" ya existe.");
        }
        return lstServicio.add(serv);
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        Servicio serv = null;
        if (traerServicio(codServicio) == null){
            serv = new Hospedaje(codServicio,porcentajeDescuento,enPromocion,hospedaje,precioPorNoche);
        }else{
            throw new Exception("El servicio con el codigo "+codServicio+" ya existe.");
        }
        return lstServicio.add(serv);
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "lstServicio=" + lstServicio +
                '}';
    }
}
