package org.lasencinas;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        double peso = Integer.parseInt( JOptionPane.showInputDialog(
                null,"Introduzca su peso",
                "Calcular peso en los planetas del Sistema Solar",
                JOptionPane.QUESTION_MESSAGE) );

        for(Planeta planeta : Planeta.values()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }

        System.out.println("\nYour weight only on the terrestrial planets: ");
        for(Planeta planeta: Planeta.getPlanetasTerrestres()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }

        System.out.println("\nYour weight only on the gas giant planets: ");
        for(Planeta planeta: Planeta.getGigantesGaseosos()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
    }

}