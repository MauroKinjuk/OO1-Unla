package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaSaludDispositivos {
    private List<Dispositivo> lstDispositivos;
    private List<Empresa> lstEmpresas;

    public SistemaSaludDispositivos() {
        this.lstDispositivos = new ArrayList<>();
        this.lstEmpresas = new ArrayList<>();
    }

    public boolean agregarEmpresa(String nombre){
        //Empresa empresa = null;
        int id = 1;
        if (!lstEmpresas.isEmpty()){
            id = lstEmpresas.get(lstEmpresas.size() - 1).getId() + 1;
        }
        return lstEmpresas.add(new Empresa(id, nombre));
    }

    public Empresa traerEmpresa(String nombre){
        Empresa empresa = null;
        int i = 0;
        while(i<lstEmpresas.size() && empresa == null){
            if (lstEmpresas.get(i).getNombre().equals(nombre)){
                empresa = lstEmpresas.get(i);
            }
            i++;
        }
        return empresa;
    }

    public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
        //Dispositivo dispositivo = null;
        int id = 1;
        if (!lstDispositivos.isEmpty()){
            id = lstDispositivos.get(lstDispositivos.size() - 1).getId() + 1;
        }
        return lstDispositivos.add(new Dispositivo(id, nombre, codigo, empresa));

    }

    public Dispositivo traerDispositivo(String codigo){
        Dispositivo dispositivo = null;
        int i = 0;

        while(i<lstDispositivos.size() && dispositivo == null){
            if (lstDispositivos.get(i).getCodigo().equals(codigo)){
                dispositivo = lstDispositivos.get(i);
            }
            i++;
        }
        return dispositivo;
    }

}
