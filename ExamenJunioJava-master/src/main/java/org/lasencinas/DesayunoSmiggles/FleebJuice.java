package org.lasencinas.DesayunoSmiggles;

import org.lasencinas.ClasesAbstarctas.Bebida;

public class FleebJuice extends Bebida {

    private String nombre = null;
    private Float pvp = 0f;

    public FleebJuice(){
        this.nombre = "Fleeb juice";
        this.pvp = 35.0f;
    }

    public String nombre(){
        return this.nombre;
    }

    public Float pvp(){
        return this.pvp;
    }
}
