package org.lasencinas.ClasesAbstarctas;

import org.lasencinas.Interfaces.Item;
import org.lasencinas.Interfaces.Packing;
import org.lasencinas.PreparacionDesayuno.Tubo;

public abstract class Bebida implements Item {

    private Packing empaquetado;


    public Bebida(){
        this.empaquetado = new Tubo();
    }

    public String toString() {
        return "\n Item: " + nombre() +"," + " Empaquetado: " + empaquetado().envoltorio() + "," + " Precio: " +  pvp();
    }

    @Override
    public Packing empaquetado() {
        return this.empaquetado;
    }

}
