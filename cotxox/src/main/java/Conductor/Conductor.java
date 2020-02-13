package Conductor;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Conductor {

    private String nombre = null;
    private String modelo = null;
    private String matricula = null;
    private Double valoracion = null;
    private List<Byte> valoraciones = new ArrayList<Byte>();
    private Boolean ocupado = false;


    public Conductor (String nombre) {
        this.nombre = nombre;
    }

    public void setValoracion (Byte valoracion) {

        this.getValoraciones().add(valoracion);

        //funcional
        Double sumaValoraciones = getValoraciones()
                                  .stream()
                                  .map(Byte::doubleValue)
                                  .reduce(0D,Double::sum);

        //imperativo
        // Double sumaValoraciones = 0;
        // for(Byte valoracionEnElArray : valoraciones) {
        //      sumaValoracionesEnElArray += valoracion;
        // }

        this.valoracion = sumaValoraciones / getValoraciones().size();
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

}
