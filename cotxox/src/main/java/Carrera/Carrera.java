package Carrera;

import Conductor.Conductor;
import PoolConductores.PoolConductores;
import Tarifa.Tarifa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carrera {


    private Integer tiempoEsperado = null;
    private Integer TiempoCarrera = null;
    private Integer propina = null;
    private Double distancia = null;
    private Double costeTotal = null;
    private String tarjetaCredito = null;
    private String origen = null;
    private String destino = null;
    private Conductor conductor = null;


    public Carrera (String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Double getCosteEsperado () {

        return Tarifa.getCosteTotalEsperado(this);
        // como this hace referencia al objeto de la clase lo puedo pasar por parámetro como objeto Carrera
        /**
         * En caso de hacerlo sin static sería crear el objeto Tarifa tarifa = new Tarifa();
         * luego tarifa.getCosteTotalEsperado(this)
         * */
    }

    public void asignarConductor(PoolConductores poolConductores) {

        this.setConductor(poolConductores.asignarConductor());
    }

    public void  realizarPago(Double coste) {
        this.setCosteTotal(coste);
    }

    public void recibirPropina(Integer propina) {
        this.setPropina(propina);
    }


    public void liberarConductor() {
        this.getConductor().setOcupado(false);
    }
}
