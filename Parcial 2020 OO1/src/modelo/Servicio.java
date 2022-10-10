package modelo;

public class Servicio {
    private String codServicio;
    private double porcentajeDescuento;
    private boolean enPromocion;

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

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
}
