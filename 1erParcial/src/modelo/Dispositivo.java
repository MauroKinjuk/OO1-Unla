package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
    private int id;
    private String nombre;
    private String codigo; //Tiene validacion (CU3)
    private List<Metrica> lstMetricas;
    private Empresa empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Metrica> getLstMetricas() {
        return lstMetricas;
    }

    public void setLstMetricas(List<Metrica> lstMetricas) {
        this.lstMetricas = lstMetricas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Dispositivo(int id, String nombre, String codigo, Empresa empresa) throws Exception {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        if (codigo.length() == 5){
            if (codigo.charAt(0) == 'A' || codigo.charAt(0) == 'B'){
                int suma = 0;
                for (int i = 1; i < codigo.length(); i++) {
                    suma += Integer.parseInt(String.valueOf(codigo.charAt(i)));
                }
                if (codigo.charAt(0) == 'A' && suma % 2 == 0){
                    this.codigo = codigo;
                } else if (codigo.charAt(0) == 'B' && suma % 2 != 0){
                    this.codigo = codigo;
                } else {
                    throw new Exception("EL codigo debe ser par si la letra empieza con A, impar si es con B");
                }
            } else {
                throw new Exception("El codigo debe empezar por la letra A o B");
            }
        } else {
            throw new Exception("El codigo debe contener 5 caracteres");
        }

        this.lstMetricas = new ArrayList<>();
    }

    public boolean agregarMetrica(int valor, LocalDate fecha, LocalTime hora){
        Metrica metrica = null;
        return lstMetricas.add(new Metrica(valor, fecha, hora));
    }

    public Metrica traerMetrica(LocalDate desde, LocalTime hora){
        Metrica metrica = null;
        int i = 0;
        while(i<lstMetricas.size()){
            if (lstMetricas.get(i).getFecha().equals(desde) && lstMetricas.get(i).getHora().equals(hora)){
                metrica = lstMetricas.get(i);
            }
            i++;
        }
        return metrica;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", lstMetricas=" + lstMetricas +
                ", empresa=" + empresa +
                '}';
    }
}
