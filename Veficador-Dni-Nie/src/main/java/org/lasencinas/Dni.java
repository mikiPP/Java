package org.lasencinas;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dni implements ValidarDocumento {


    private String dni = null;


    /*------------------------------------------------ Constructor ---------------------------------------------------*/


    public Dni(String dni){
        this.dni = dni;
    }


    /*-------------------------------------------------- Getter ------------------------------------------------------*/


    public String getDni(){
        return  this.dni ;
    }


    /*--------------------------------- Métodos implementados de la interfaz Validador -------------------------------*/


    @Override
    public Matcher createMatcher() {
        /** Método estandar para crear un matcher y validar la expressión regular. **/
        Pattern pattern = Pattern.compile(this.patronDni);
        return pattern.matcher(this.dni);
    }



    @Override
    public Integer getParteNumerica() {
        /** La lógica de este método consiste en buscar todos los nuemeros que se encuentran en el dni e ir añadiendolos a un string
         * para luego poder convertirlo a integer para realizar calculos.En el caso de que encuentre una letra simplemente no añade nada.
         */
        String parteNumerica = "";

        for(int i= 0;i < getDni().length();i++){

            parteNumerica += (Arrays.asList(this.getLetras()).contains(Character.toUpperCase(getDni().charAt(i))) == false) ? getDni().charAt(i) : "";
        }

        return Integer.parseInt(parteNumerica);
    }


    @Override
    public Character getLetra() {
        /** Se encarga de devolver la letra de la última posición del dni. */

        return this.getDni().charAt(getDni().length() - 1);
    }


}
