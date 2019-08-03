package com.company;

public class TarjetaUsuario {

    private String id = null;
    private boolean activada = false;

    TarjetaUsuario(String id,boolean activada){
        this.id = id;
        this.activada = activada;
    }

    public boolean getActivada(){
        return this.activada;
    }

    public String getId(){
        return this.id;

    }

    public void setActivada(Boolean activada) {
        this.activada = activada;
    }
}
