package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;

    private Sistema(){
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio){
        Servicio s = null;
        int i = 0;
        while(i<lstServicio.size() && s == null){
            if (lstServicio.get(i).getCodServicio().equals(codServicio)){
                s = lstServicio.get(i);
            }
            i++;
        }
        return s;
    }

    public List<Servicio> traerServicio(boolean enPromocion){
        List<Servicio> s = new ArrayList<>();

        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion()) {
                s.add(servicio);
            }
        }

        return s;
    }


}
