package modelo;

import java.time.LocalDate;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) throws Exception {
        if (codServicio.length() != 6){
            throw new Exception("El codigo debe ser de 6 digitos.");
        }else{
            this.codServicio = codServicio;
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

    public abstract double calcularPrecioFinal(LocalDate dia);

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        setCodServicio(codServicio);
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    @Override
    public String toString() {
        return "\nServicio{" +
                "codServicio='" + codServicio + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", enPromocion=" + enPromocion +
                "}\n";
    }
}
