package modelo;

import java.time.LocalDate;

public class Hospedaje extends Servicio{
    private String hospedaje;
    private double precioPorNoche;

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    //Si esta en promocion aplica descuento de lunes a viernes utilizando el porcentajedescuento
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = 0;
        if (isEnPromocion()){
            if (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5){
                precioFinal = precioPorNoche - (precioPorNoche * (getPorcentajeDescuento()/100));
            }
        }else{
            precioFinal = precioPorNoche;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Hospedaje{" +
                "hospedaje='" + hospedaje + '\'' +
                ", precioPorNoche=" + precioPorNoche +
                "} " + super.toString();
    }
}
