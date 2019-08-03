package org.lasencinas.ClasesAbstarctas;

import org.lasencinas.PreparacionDesayuno.Caja;
import org.lasencinas.Interfaces.Item;
import org.lasencinas.Interfaces.Packing;

public abstract class Cereales implements Item {

    private Packing empaquetado;


    public Cereales(){
        this.empaquetado = new Caja();
    }



    public String toString() {
        return "\n Item: " + nombre() +"," + " Empaquetado: " + empaquetado().envoltorio() + "," + " Precio: " +  pvp();
    }

    public Packing empaquetado(){
        return this.empaquetado;
    }
}
