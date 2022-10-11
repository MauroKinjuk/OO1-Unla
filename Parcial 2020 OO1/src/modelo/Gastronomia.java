package modelo;

import java.time.LocalDate;

public class Gastronomia extends Servicio{
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    public double calcularPrecioFinal(LocalDate dia){
        double precioFinal;
        if (dia.getDayOfWeek().getValue() == diaSemDesc){
            precioFinal = precio - (precio * (porcentajeDescuento/100));
        }else{
            precioFinal = precio;
        }
        return precioFinal;
    }

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }
}
