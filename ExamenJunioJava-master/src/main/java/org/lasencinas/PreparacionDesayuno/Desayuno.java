package org.lasencinas.PreparacionDesayuno;

import org.lasencinas.Interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class Desayuno {

    private List<Item> desayuno = new ArrayList<>();

    public void mostrarItems() {
        for (Item item : desayuno) {
            System.out.println(item.toString());
        }
    }

    public float getCoste() {

        float coste = 0;

        for (Item item : desayuno) {
            coste += item.pvp();
        }
        return coste;
    }

    public void añadirItemDesayuno(Item item){
        getDesayuno().add(item);
    }

    public List<Item> getDesayuno() {
        return desayuno;
    }
}
