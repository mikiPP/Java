package org.lasencinas.DesayunoEyeholes;

import org.lasencinas.ClasesAbstarctas.Juguete;

public class Plumbus extends Juguete {

    private String nombre = null;
    private float pvp = 0f;


    public Plumbus(){
        this.nombre = "Plumbus";
        this.pvp = 100.0F;
    }

    public String nombre(){
        return this.nombre;
    }

    public Float pvp(){
        return this.pvp;
    }
}
