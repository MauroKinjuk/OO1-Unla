package modelo;

import java.time.LocalDate;

public abstract class Servicio {
    protected int idServicio;
    protected String codIngreso;
    protected LocalDate fechaIngreso;
    protected boolean checkOut;
    protected Persona responsable;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getCodIngreso() {
        return codIngreso;
    }

    public void setCodIngreso(String codIngreso) throws Exception {
        if (esValidoDigitoControl(codIngreso)){
            this.codIngreso = codIngreso;
        }else{
            throw new Exception("El codigo ingresado no es valido");
        }
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public Servicio(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable) throws Exception {
        this.idServicio = idServicio;
        setCodIngreso(codIngreso);
        this.fechaIngreso = fechaIngreso;
        this.checkOut = checkOut;
        this.responsable = responsable;
    }

    public boolean esValidoDigitoControl(String codIngreso){
        int suma = 0;
        boolean flag = false;
        for (int i = 0; i <6;i++){
            //recorro el string hasta su longitud de 6. Mientras voy sumando
            suma += Integer.parseInt(codIngreso.substring(i,i+1));
        }
        //En el caso que la suma con modulo de 10  sea igual al ultimo digito del codigo
        if (suma % 10 == Integer.parseInt(codIngreso.substring(6,7))){
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", codIngreso='" + codIngreso + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", checkOut=" + checkOut +
                ", responsable=" + responsable +
                '}';
    }
}
