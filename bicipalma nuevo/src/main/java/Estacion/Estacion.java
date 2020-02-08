package Estacion;

import Bicicleta.Bicicleta;
import TarjetaUsuario.TarjetaUsuario;
import com.sun.corba.se.impl.orbutil.ObjectUtility;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Estacion {

    private Integer id = null;
    private String direccion = null;
    private Integer numeroAnclajes = null;
    private Bicicleta[] anclajes = null;


    public Estacion(Integer id, String direccion, Integer numeroAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = numeroAnclajes;
        this.anclajes = new Bicicleta[numeroAnclajes];
    }

    public void consultarEstacion() {
        System.out.println("id: " + getId());
        System.out.println("direccion: " + getDireccion());
        System.out.println("numeroAnclajes: " + getNumeroAnclajes());
    }

    public Integer anclajesLibres() {
        Integer anclajesLibres = 0;

        for (int i = 0; i < getAnclajes().length; i++) {

            if (getAnclajes()[i] == null) {
                anclajesLibres ++;
            }
        }
        return anclajesLibres;
    }

    public void anclarBicicleta(Bicicleta bicicleta) {

        for (int i = 0; i < getAnclajes().length; i++) {

            if (getAnclajes()[i] == null) {
                getAnclajes()[i] = bicicleta;
                mostrarAnclaje(bicicleta, i);
                break;
            }

        }
    }

    public void consultarAnclajes() {
        for (int i = 0; i < getAnclajes().length; i++) {

            if (!Objects.isNull(getAnclajes()[i])) { // == getAnclajes()[i] != null
                System.out.println("Anclaje " + i + " " + getAnclajes()[i]);

            } else {
                System.out.println("Anclaje " + i + " libre" );
            }

        }
    }

    private void mostrarAnclaje(Bicicleta bicicleta, Integer numeroAnclaje) {
        System.out.println("bicicleta: " + bicicleta.getId() + " anclada en el anclaje: " + numeroAnclaje);
    }

    public Boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.getActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {

        if (!tarjetaUsuario.getActivada()) return;  // básicamente si la tarjeta no esta activada para la ejecución.

        Integer posicionAnclaje = null;
        Bicicleta bicicletRetirada = null;

        while (Objects.isNull(bicicletRetirada)) {
            posicionAnclaje =  generarAnclaje();
            bicicletRetirada = getAnclajes()[posicionAnclaje];
        }

        getAnclajes()[posicionAnclaje] = null;
        mostrarBicicleta(bicicletRetirada,posicionAnclaje);


    }

    private void mostrarBicicleta(Bicicleta bicicletRetirada, Integer posicionAnclaje) {
        System.out.println("Bicicleta retirada: " + bicicletRetirada + " del anclaje: " + posicionAnclaje);
    }

    private Integer generarAnclaje() {

        double positionDouble =  Math.random() * getAnclajes().length ;
        return (int) positionDouble;
    }
}
