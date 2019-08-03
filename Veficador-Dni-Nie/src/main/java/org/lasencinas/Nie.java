package org.lasencinas;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nie implements ValidarDocumento {


    private String nie = null;


    /*------------------------------------------------ Constructor ---------------------------------------------------*/


    public Nie(String nie){
        this.nie = nie;
    }


    /*-------------------------------------------------- Getter ------------------------------------------------------*/


    public String getNie(){
        return  this.nie ;
    }


    /*---------------------------------------------- Métodos de la clase ---------------------------------------------*/


    public String subtituirPrimeraLetraPorSuValor(){

        /** En este método nos encargamos de substituir la primera letra del nie que puede ser X,Y o Z por su respectivo valor
         * que en este caso es 0,1 y 2 respectivamente,en caso de que llegara otra letra a la primera posicion devolveriamos null.
          */

        switch (getNie().charAt(0)){
            case 'X':
                return  "0";

            case 'Y':
                return  "1";

            case 'Z':
                return  "2";

            default:
                return null;

        }
    }


    public String  convertirParteNumericaAEntero(){

        /** La lógica de este método consiste en buscar todos los nuemeros que se encuentran en el nie e ir añadiendolos a un string
         * para luego poder convertirlo a integer para realizar calculos.En el caso de que encuentre una letra simplemente no añade nada.
         */

        String parteNumerica = "";

        for(int i= 0;i < getNie().length();i++){

            parteNumerica += (Arrays.asList(this.getLetras()).contains(Character.toUpperCase(getNie().charAt(i))) == false) ? getNie().charAt(i) : "";
        }

        return parteNumerica;
    }


    /*--------------------------------- Métodos implementados de la interfaz Validador -------------------------------*/


    @Override
    public Matcher createMatcher() {
        /** Método estandar para crear un matcher y validar la expressión regular. **/

        Pattern pattern = Pattern.compile(ValidarDocumento.patronNie);
        return  pattern.matcher(getNie());

    }


    @Override
    public Integer getParteNumerica(){
        /** La lógica principal de este método es devolver como Interger la parte numérica del Nie para poder realizar cálculos
         * para hacerlo,llama a subtituirPrimeraLetraPorSuValor() y convertirParteNumericaAEntero() y estos construyen un String
         * con todos los números del Nie y los pasa a integer con la función parseInt.  */

        return(Integer.parseInt(subtituirPrimeraLetraPorSuValor() + convertirParteNumericaAEntero()));
    }


    @Override
    public Character getLetra(){
        /** Se encarga de devolver la letra de la última posición del Nie. */

        return this.getNie().charAt(getNie().length()-1);
    }


}