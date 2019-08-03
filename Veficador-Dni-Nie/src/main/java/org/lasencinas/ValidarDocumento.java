package org.lasencinas;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/** Interfaz encargada de tener los métodos para validar los documentos del estado,los métodos default son los que
 * se aplican a todos los documentos independientemente de como sean aunque si hubiera uno que no funcionara asi simplemente
 * lo podre sobreescribir a su propia lógica.Los métodos abstractos son los que varian entre los diferentes tipos de documentos
 * por eso cada documento debe implementarlo a partir de su lógica.Se puede verificar el documento solo con el método verificarDocumento()
 * aunque si se quiere ser mas específico se puede validar solo la letra o el patrón con los métodos verificarletra y verificar patrón
 * respectivamente.Aparte incluye el listado de letras que contienen los documentos y las expresiones regulares para validar los documentos.
 */

public interface ValidarDocumento {

    /*-------------------------------------------------- Patrones -----------------------------------------------------*/

    String patronDni = "^[0-9]{8}[A-Z&&[^IÑOU]]{1}$";
    String patronNie = "^[XYZ]{1}[0-9]{7}[A-Z&&[^IÑOU]]{1}$";


    /*------------------------------------------- Conjutos para verificar letra ----------------------------------------*/


    Character [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    Map<Character,Integer> assignacionLetra = new HashMap<>();


    /*-------------------------------------------------- Getters -----------------------------------------------------*/


    default Map<Character,Integer> getAssignacionLetra(){
        return ValidarDocumento.assignacionLetra;
    }


    default Character[] getLetras(){
        return ValidarDocumento.letras;
    }


    /*----------------------------------------------- Métodos abstractos  ---------------------------------------------*/


    /**Estos métodos tienen su información el las própias clases que lo implementan */


    Matcher createMatcher();


    Integer getParteNumerica();


    Character getLetra();


    /*---------------------------------------------- Métodos no abstractos  --------------------------------------------*/


    default Boolean verificarDocumento(){

        /** Simplemente verificamos las dos condiciones que necesitamos que sean ciertas para que el documento sea válido
         * que son verificarPatron y verificar letra,si ambas se cumplen devolvemos true y sino devolvemos false. */

        return (this.verificarPatron() && this.verificarLetra() == true) ?  true :  false;
    }


    default boolean verificarPatron(){

        /** Aqui simplemente devolvemos si el documento en questión es válido o no,en caso de que si devolvemos true
         * por contra si es falso devolvemos false.  */

        return   (createMatcher().matches()) ?  true :  false;
    }


    default boolean verificarLetra(){

        /**Este método se encarga de orquestar los diferentes métodos encargados de verificar la letra. */

        this.setMap();
        return this.validadorLetra(this.getParteNumerica(),getLetra());
    }


    default Map<Character,Integer> setMap(){

        /** Básicamente introducimos los valores de la tabla de asignación del estado al mapa para poder verificar
         * si la letra es correcta.
         */

        for(int valorLetra =0; valorLetra < getLetras().length; valorLetra++ ){
            getAssignacionLetra().put(getLetras()[valorLetra],valorLetra);
        }
    return getAssignacionLetra();
    }


    default boolean  validadorLetra(Integer parteNumerica,Character letra){

        /** Devolvemos true si la letra del documento coincide con la que debe ser en la tabla de asignación y false si
         * pasa el caso contrario.
         */

        return (ValidarDocumento.assignacionLetra.get(letra) == parteNumerica % this.getLetras().length) ?  true :  false;
    }


}
