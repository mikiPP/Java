package org.lasencinas.DesayunoEyeholes;

import org.lasencinas.ClasesAbstarctas.Cereales;

public class Eyeholes extends Cereales {

    private String nombre = null;
    private float pvp = 0f;


    public Eyeholes(){
        this.nombre = "Eyeholes";
        this.pvp = 25.0F;
    }

    public String nombre(){
        return this.nombre;
    }

    public Float pvp(){
        return this.pvp;
    }


}
