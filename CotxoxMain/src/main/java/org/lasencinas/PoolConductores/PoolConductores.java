package org.lasencinas.PoolConductores;

import org.lasencinas.Conductor.Conductor;

import java.util.HashSet;

public class PoolConductores {
    private HashSet<Conductor> poolConductores = new HashSet() ;

    public PoolConductores(HashSet conductores){
        this.poolConductores = conductores;
    }

    public HashSet<Conductor> getPoolConductores(){
        return poolConductores;
    }




    public Conductor asignarConductor(){

        for(Conductor conductores : this.poolConductores){
            if(conductores.isOcupado() == false){
                conductores.setOcupado(true);
                return  conductores;

            }else{
                ;
            }

        }

        return null;}

}