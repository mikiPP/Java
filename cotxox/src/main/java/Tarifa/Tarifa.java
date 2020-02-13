package Tarifa;

import Carrera.Carrera;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tarifa {


   /**
    He hecho esta clase estática porqué el estado siempre es el mismo, és decir,
    las variables no cambian su valor.

    la expresión () ? : es un operador ternario equivale a un if() {}  else{}

    Uso Tarifa.COSTE_MINIMO y no el valor directamente porque si lo tuviera que cambiar solo lo he de hacer
    en un sitio y no en cada uno de los sitios que se utiliza.
    **/

    private static final  Double COSTE_MILLA = 1.35;
    private static final Double COSTE_MINUTO = 0.35;
    private static final Double COSTE_MINIMO = 5.0;
    private static final Integer PORCENTAJE_COMISION = 20;


    public static Double getCosteDistancia(Double distancia) {

        return  Tarifa.COSTE_MILLA * distancia;
    }

    public static Double getCosteTiempo(Integer tiempo) {

       return  Tarifa.COSTE_MINUTO * tiempo;
    }

    public static Double getCosteTotalEsperado(Carrera carrera) {

        Double costeTotal = Tarifa.getCosteDistancia(carrera.getDistancia()) + Tarifa.getCosteTiempo(carrera.getTiempoEsperado());

        return (costeTotal > Tarifa.COSTE_MINIMO) ? costeTotal : Tarifa.COSTE_MINIMO;
    }

}
