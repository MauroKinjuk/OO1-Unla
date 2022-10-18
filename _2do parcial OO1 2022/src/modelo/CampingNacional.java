package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampingNacional {
    private List<Persona> lstPersonas;
    private List<Servicio> lstServicios;

    public CampingNacional(){
        this.lstPersonas = new ArrayList<>();
        this.lstServicios = new ArrayList<>();
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public List<Servicio> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(List<Servicio> lstServicios) {
        this.lstServicios = lstServicios;
    }

    public Persona traerPersona(long dni){
        //Traigo persona por dni
        int i = 0;
        Persona p = null;
        while (i < lstPersonas.size() && p == null){
            if (lstPersonas.get(i).getDni() == dni){
                p = lstPersonas.get(i);
            }
            i++;
        }
        return p;
    }

    public boolean agregarPersona(String apellido, String nombre, long dni) throws Exception {
        int id = 1;

        if (!lstPersonas.isEmpty()) {
            if (traerPersona(dni) == null) {
                id = lstPersonas.get(lstPersonas.size() - 1).getIdPersona() + 1;
            } else {
                throw new Exception("La persona con ese dni ya existe");
            }
        }

        return lstPersonas.add(new Persona(id,apellido,nombre,dni));
    }

    public Servicio traerServicioPorCodigo(String codigo){
        Servicio s = null;
        int i = 0;

        while(i<lstServicios.size() && s == null){
            if (lstServicios.get(i).codIngreso.equals(codigo)){
                s = lstServicios.get(i);
            }
            i++;
        }
        return s;
    }

    public boolean agregarRecreo(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, int cantPersonas, double precioPersona) throws Exception {
        int id = 1;
        if (!lstServicios.isEmpty()){
            if (traerServicioPorCodigo(codIngreso) == null){
                id = lstServicios.get(lstServicios.size() - 1).getIdServicio() + 1;
            }else{
                throw new Exception("El codigo ya existe");
            }
        }

        return lstServicios.add(new Recreo(id,codIngreso,fechaIngreso,checkOut,responsable,cantPersonas,precioPersona));
    }

    public boolean agregarCampamento(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
        int id = 1;
        if (!lstServicios.isEmpty()){
            if (traerServicioPorCodigo(codIngreso) == null){
                id = lstServicios.get(lstServicios.size() - 1).getIdServicio() + 1;
            }else{
                throw new Exception("El codigo ya existe");
            }
        }

        return lstServicios.add(new Campamento(id,codIngreso,fechaIngreso,checkOut,responsable,fechaEgreso,cantCarpas,precioCarpa));
    }

    public int cantidadDias(){
        //Devuelve la cantidad de dias entre la fecha de ingreso e egreso
        //Si no se egreso lo calcula con la fecha actual
        int dias = 0;
        for (Servicio s: lstServicios){
            if (s instanceof Campamento c){
                if (c.isCheckOut()){
                    dias += c.getFechaEgreso().getDayOfYear() - c.getFechaIngreso().getDayOfYear();
                }else{
                    dias += LocalDate.now().getDayOfYear() - c.getFechaIngreso().getDayOfYear();
                }
            }
        }
        return dias;
    }

    public double calcularPrecioFinal(){
        //Si la clase es Recreo devuelvo el precio de la persona * la cantidad de personas
        //Si la clase es Campamento devuelvo el precio de la carpa * la cantidad de carpas * la cantidad de dias
        double precioFinal = 0;
        for (Servicio s: lstServicios){
            if (s instanceof Recreo){
                Recreo r = (Recreo) s;
                precioFinal += r.getPrecioPersona() * r.getCantPersonas();
            }else if (s instanceof Campamento){
                Campamento c = (Campamento) s;
                precioFinal += c.getPrecioCarpa() * c.getCantCarpas() * cantidadDias();
            }
        }
        return precioFinal;
    }

    public List<Servicio> traerServicioPorPrecioFinal(double mayorIgualA){
        //devuelvo la lista por precio final y que hayan egresado
        List<Servicio> lstServicios = new ArrayList<>();
        for (Servicio s: this.lstServicios){
            if (calcularPrecioFinal() >= mayorIgualA && s.isCheckOut()){
                lstServicios.add(s);
            }
        }
        return lstServicios;
    }

    //Traigo lista de campamentos por cantidad de dias
    public List<Servicio> traerCampamentoPorDias(int mayorIgualA){
        List<Servicio> lstServicios = new ArrayList<>();
        for (Servicio s: this.lstServicios){
            if (s instanceof Campamento c){
                if (cantidadDias() >= mayorIgualA && c.isCheckOut()){
                    lstServicios.add(s);
                }
            }
        }
        return lstServicios;
    }



}
