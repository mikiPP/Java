package org.lasencinas.Conductor;

import java.util.ArrayList;

public class Conductor {


    private String nombre = null;
    private String modelo = null;
    private String matricula = null;
    private Double valoracionMedia = 0.0;
    private ArrayList<Double> valoraciones = new ArrayList<Double>();
    private boolean ocupado;


    /*-----------------------------Constructor------------------------------------------*/




    public Conductor(String nombre){
        this.nombre = nombre ;
    }



    /*--------------------------Getters --------------------------------------------------------*/

    public Double getValoracion(){
        return this.valoracionMedia;
    }


    public ArrayList getValoraciones(){
        return this.valoraciones;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getModelo(){
        return this.modelo;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public Boolean isOcupado(){
        return ocupado;
    }


    public int getNumeroValoraciones() {
        return this.getValoraciones().size();
    }


    /*----------------------------Setters ------------------------------------------------------------------*/


    public void setValoracion(double valoracion){


        this.getValoraciones().add(valoracion);

        Double acumulador = 0.0;

        for(int i = 0; i< this.getValoraciones().size();i++){
            acumulador += (Double) this.getValoraciones().get(i);

        }

        this.valoracionMedia = acumulador / (this.valoraciones.size()) ;
    }

    public void setOcupado (Boolean ocupado){
        this.ocupado = ocupado;
    }

    public void setMatricula (String matricula){

        this.matricula = matricula;
    }


    public void setModelo (String modelo){

        this.modelo = modelo;
    }


}
