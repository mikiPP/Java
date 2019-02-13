package org.lasencinas.Carrera;


import org.lasencinas.Conductor.Conductor;
import org.lasencinas.PoolConductores.PoolConductores;
import org.lasencinas.Tarifa.Tarifa;


public class Carrera {


    private String tarjetaCredito = null;
    private String origen = null;
    private String destino = null;
    private double distancia = 0;
    private int tiempoEsperado = 0;
    private int tiempoCarrera = 0;
    private int valoracion = 0;
    private double costeTotal = 0;
    private Conductor conductor= null;
    private int propina = 0;


    /*------------------------------------ Constructor -----------------------------------------------------*/


    public Carrera(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;  }


    /*--------------------------------------- Getters --------------------------------------------------------*/


    public String getTarjetaCredito() {
        return this.tarjetaCredito;
    }


    public String getOrigen() {
        return this.origen;
    }


    public String getDestino() {
        return this.destino;
    }


    public double getDistancia() {
        return this.distancia;
    }


    public int getTiempoEsperado() {
        return this.tiempoEsperado;
    }


    public int getValoracion() {
        return this.valoracion;
    }


    public double getCosteTotal(){
        return this.costeTotal; }


    public double getCosteEsperado(){
        Tarifa tarifa = new Tarifa();
        return  tarifa.getCosteTotalEsperado(this.getDistancia(),this.getTiempoEsperado()); }


    public Conductor getConductor(){
        return this.conductor; }


    public int getPropina(){
        return this.propina; }


    public int getTiempoCarrera(){
        return tiempoCarrera;
    }




    /*------------------------------------- Setters ------------------------------------------------------------------*/


    public void setTiempoEsperado(int tiempoEsperadoMinutos) {
        this.tiempoEsperado = tiempoEsperadoMinutos;
    }

    public void setTiempoCarrera(int tiempoCarrera){
        this.tiempoCarrera = tiempoCarrera;
    }


    public void setOrigen(String origen) {
        this.origen = origen;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }


    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public void setConductor(Conductor conductor){
        this.conductor = conductor;
    }


    /*-------------------------------------- Methods -----------------------------------------------------------------*/


    public void asignarConductor(PoolConductores conductores){

        setConductor(conductores.asignarConductor()) ;   }


    public void realizarPago(double pago){

        this.costeTotal = pago;

    }


    public void recibirPropina(int propina){

        this.propina = propina;
    }


    public void liberarConductor(){
        this.getConductor().setOcupado(false); }


}