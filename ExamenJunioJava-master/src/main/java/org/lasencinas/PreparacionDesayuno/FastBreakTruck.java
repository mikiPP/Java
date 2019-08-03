package org.lasencinas.PreparacionDesayuno;

import org.lasencinas.DesayunoEyeholes.Eyeholes;
import org.lasencinas.DesayunoEyeholes.Plumbus;
import org.lasencinas.DesayunoEyeholes.TurbulentJuice;
import org.lasencinas.DesayunoSmiggles.FleebJuice;
import org.lasencinas.DesayunoSmiggles.Smiggles;
import org.lasencinas.Interfaces.Item;


public class FastBreakTruck {


    public FastBreakTruck() {
    }


    public static Desayuno prepararEyeHoles() {
        Desayuno desayuno = new Desayuno();
        desayuno.añadirItemDesayuno(new Eyeholes());
        desayuno.añadirItemDesayuno(new TurbulentJuice());
        return desayuno;
    }

    public static Desayuno prepararSmiggles() {
        Desayuno desayuno = new Desayuno();
        desayuno.añadirItemDesayuno(new Smiggles());
        desayuno.añadirItemDesayuno(new FleebJuice());
        return desayuno;
    }

    public static void incluirJuguete(Desayuno desayuno) {
        if (containsEyeholes(desayuno)) {
            desayuno.añadirItemDesayuno(new Plumbus());
        }else {
            return;
        }


    }

    private static Boolean containsEyeholes(Desayuno desayuno) {
        boolean containEyeHoles = false;

        for (Item item : desayuno.getDesayuno()) {
            if (item.nombre().equals("Eyeholes")){
                return true;
            }else {
                //nothing
            }
        }

        return containEyeHoles;
    }


}


