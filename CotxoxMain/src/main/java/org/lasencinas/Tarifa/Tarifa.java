package org.lasencinas.Tarifa;

public class Tarifa {


    // Creo las variables con mayúscula y con final porque son constantes y fijas no van a cambiar


    private final double COSTE_MILLA = 1.35;
    private final double COSTE_MINUTO = 0.35;
    private final int COSTE_MINIMO = 5;
    private final double PORCENTAJE_COMISION = 0.2; // 0.2 = 20%



    public Tarifa(){}


    /*------------------------------- Getters ----------------------------------------------*/

    public double getCOSTE_MILLA(){

        return this.COSTE_MILLA; }


    public double getCOSTE_MINUTO(){

        return this.COSTE_MINUTO; }


    public  double getPORCENTAJE_COMISION(){

        return this.PORCENTAJE_COMISION; }


    public int getCOSTE_MINIMO(){

        return this.COSTE_MINIMO; }


    public double getCosteDistancia(double distancia){

        return  this.getCOSTE_MILLA() * distancia;

    }


    public double getCosteTiempo(int minutos){

        return  this.getCOSTE_MINUTO() * minutos;

    }


    public double getCosteTotalEsperado(double distancia, int minutos){

        if(this.getCosteDistancia(distancia) + this.getCosteTiempo(minutos) > getCOSTE_MINIMO()){

            return this.getCosteDistancia(distancia) + this.getCosteTiempo(minutos);

        }else{
            return (double) getCOSTE_MINIMO();
        }
    }
}
