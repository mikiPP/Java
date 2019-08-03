package org.lasencinas.ClasesAbstarctas;

import org.lasencinas.Interfaces.Item;
import org.lasencinas.Interfaces.Packing;
import org.lasencinas.PreparacionDesayuno.Caja;

public abstract class Juguete implements Item {

    private Packing envoltorio = null;

    public Juguete () {
        envoltorio = new Caja();
    }

    public String toString() {
        return "\n Item: " + nombre() +"," + " Empaquetado: " + empaquetado().envoltorio() + "," + " Precio: " +  pvp();
    }

    public Packing empaquetado(){
        return this.envoltorio;
    }
}
