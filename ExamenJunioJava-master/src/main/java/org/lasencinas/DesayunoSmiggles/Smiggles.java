package org.lasencinas.DesayunoSmiggles;

import org.lasencinas.ClasesAbstarctas.Cereales;

public class Smiggles extends Cereales {

    private String nombre = null;
    private Float pvp = 0f;

    public Smiggles(){
        this.nombre = "Smiggles";
        this.pvp = 50.0f;
    }

    public String nombre(){
        return this.nombre;
    }

    public Float pvp(){
        return this.pvp;
    }
}
