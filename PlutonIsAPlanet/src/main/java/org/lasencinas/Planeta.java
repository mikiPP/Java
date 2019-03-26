package org.lasencinas;

import java.util.EnumSet;

public enum Planeta {

    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private double MASA = 0f;
    private double RADIO = 0f;
    public static final double G = 6.67300E-11;


    /*----------------------------------------Constructor-------------------------------------------*/
    // privado porque esta clase estara oculta

    Planeta(double MASA, double RADIO) {
        this.MASA = MASA;
        this.RADIO = RADIO;
    }


    /*----------------------------------------GETTERS-------------------------------------------*/

    public double getMasa() {
        return this.MASA;
    }

    public double getRadio() {
        return this.RADIO;
    }



    /*----------------------------------------Logica-------------------------------------------*/

    public double pesoSuperficie(double pesoHumano){
        //Peso_en_Superficie = tu_Masa * Gravedad_en_superficie

        return masaHumano(pesoHumano) * gravedadSuperficie();

    }


    public double masaHumano(double pesoHumano){
        //tu_masa = tu_peso_en_la_Tierra / gravedad_superficial_tierra;

        return pesoHumano / EARTH.gravedadSuperficie();
    }


    public double gravedadSuperficie(){
        //Gravedad_en_superficie = G * Masa_del_planeta / Radio_del_planeta_al_cuadrado

        return this.G * this.getMasa() / Math.pow(this.getRadio(),2);
    }



    public static EnumSet<Planeta> getPlanetasTerrestres(){
        return EnumSet.range(MERCURY, MARS);
    }

    public static EnumSet<Planeta> getGigantesGaseosos(){
        return EnumSet.range(JUPITER, NEPTUNE);

        }




}
