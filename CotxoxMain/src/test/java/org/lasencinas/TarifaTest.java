package org.lasencinas;


import static org.junit.Assert.*;
import org.junit.Test;
import org.lasencinas.Carrera.Carrera;
import org.lasencinas.Tarifa.Tarifa;


public class TarifaTest {

    Carrera carrera = new Carrera("4929637175949220");

    @Test
    public void getCosteDistanciaTest() {
        Tarifa tarifa = new Tarifa();
        double distancia = 7.75;
        double esperado = 10.4625;
        double delta = 0.01;

        assertEquals(esperado, tarifa.getCosteDistancia(distancia), delta);
    }

    @Test
    public void getCosteTiempo() {
        Tarifa tarifa = new Tarifa();
        int minutos = 10;
        double costeTiempoEsperado = 3.5;
        double delta = 0.01;
        assertEquals(costeTiempoEsperado, tarifa.getCosteTiempo(minutos), delta);
    }

    @Test
    public void getCosteTotalEsperado() {
        Tarifa tarifa = new Tarifa();
        carrera.setDistancia(7.75);
        carrera.setTiempoEsperado(10);
        double costeTotal = 7.75 * 1.35 + 0.35 * 10;
        double delta = 0.01;
        assertEquals(costeTotal, tarifa.getCosteTotalEsperado(carrera.getDistancia(),carrera.getTiempoEsperado()), delta);
    }

    @Test
    public void getCosteTotalEsperadoMinimoTest() {
        Tarifa tarifa = new Tarifa();
        carrera.setDistancia(2.00);
        carrera.setTiempoEsperado(2);
        double delta = 0.01;
        assertEquals(5, tarifa.getCosteTotalEsperado(carrera.getDistancia(),carrera.getTiempoEsperado()), delta);
    }

}