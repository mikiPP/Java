package org.lasencinas;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public interface Validator {

    String patronDni = "^[0-9]{8}[A-Z&&[^IÑOU]]{1}$";
    String patronNie = "^[XYZ]{1}[0-9]{7}[A-Z&&[^IÑOU]]{1}$";
    Character [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    Map<Character,Integer> assignacionLetra = new HashMap<>();



    Matcher createMatcher();


    Integer getParteNumerica();

    Character getLetra();

    default Boolean validador(){
        return (this.verificarPatron() && this.verificarLetra() == true) ?  true :  false;
    }


    default boolean verificarPatron(){
        return   (createMatcher().matches()) ?  true :  false;
    }

    default Map<Character,Integer> getAssignacionLetra(){
        return Validator.assignacionLetra;
    }

    default Character[] getLetras(){
        return Validator.letras;
    }

    default boolean verificarLetra(){
        this.setMap();
        return this.validadorLetra(this.getParteNumerica(),getLetra());
    }

    default Map<Character,Integer> setMap(){

        for(int valorLetra =0; valorLetra < getLetras().length; valorLetra++ ){
            getAssignacionLetra().put(getLetras()[valorLetra],valorLetra);
        }
    return getAssignacionLetra();
    }

    default boolean  validadorLetra(Integer parteNumerica,Character letra){

        return (Validator.assignacionLetra.get(letra) == parteNumerica % this.getLetras().length) ?  true :  false;
    }




}
