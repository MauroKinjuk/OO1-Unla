package modelo;

import java.time.LocalDate;

public class Servicio {
    private String codServicio;
    protected double porcentajeDescuento;
    private boolean enPromocion;

    private LocalDate dia;

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) throws Exception {
        if (codServicio.length() == 6){
            this.codServicio = codServicio;
        }else{
            throw new Exception("El codigo debe tener una longitud de 6.");
        }
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        setCodServicio(codServicio);
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
}
