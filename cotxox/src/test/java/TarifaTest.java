import static org.junit.Assert.*;

import Tarifa.Tarifa;
import org.junit.Test;



public class TarifaTest {

    Carrera.Carrera carrera = new Carrera.Carrera("4929637175949220");

    @Test
    public void getCosteDistanciaTest() {

        double distancia = 7.75;
        double esperado = 10.4625;
        double delta = 0.01;

        assertEquals(esperado, Tarifa.getCosteDistancia(distancia), delta);
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
        assertEquals(costeTotal, tarifa.getCosteTotalEsperado(carrera), delta);
    }

    @Test
    public void getCosteTotalEsperadoMinimoTest() {
        Tarifa tarifa = new Tarifa();
        carrera.setDistancia(2.00);
        carrera.setTiempoEsperado(2);
        double delta = 0.01;
        assertEquals(5, tarifa.getCosteTotalEsperado(carrera), delta);
    }

}