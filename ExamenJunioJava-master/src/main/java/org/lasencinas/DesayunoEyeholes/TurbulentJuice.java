package org.lasencinas.DesayunoEyeholes;

import org.lasencinas.ClasesAbstarctas.Bebida;

public class TurbulentJuice extends Bebida {

    private String nombre = null;
    private Float pvp = 0f;

    public TurbulentJuice(){
        this.nombre = "Turbulent juuuuuuice";
        this.pvp = 30.0f;
    }

    public String nombre(){
        return this.nombre;
    }

    public Float pvp(){
        return this.pvp;
    }

}
