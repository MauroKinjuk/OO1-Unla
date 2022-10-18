package modelo;

import java.time.LocalDate;

public class Campamento extends Servicio {
    private LocalDate fechaEgreso;
    private int cantCarpas;
    private double precioCarpa;

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public int getCantCarpas() {
        return cantCarpas;
    }

    public void setCantCarpas(int cantCarpas) {
        this.cantCarpas = cantCarpas;
    }

    public double getPrecioCarpa() {
        return precioCarpa;
    }

    public void setPrecioCarpa(double precioCarpa) {
        this.precioCarpa = precioCarpa;
    }

    public Campamento(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
        super(idServicio, codIngreso, fechaIngreso, checkOut, responsable);
        this.fechaEgreso = fechaEgreso;
        this.cantCarpas = cantCarpas;
        this.precioCarpa = precioCarpa;
    }

    @Override
    public String toString() {
        return "Campamento{" +
                "fechaEgreso=" + fechaEgreso +
                ", cantCarpas=" + cantCarpas +
                ", precioCarpa=" + precioCarpa +
                "} " + super.toString();
    }
}
