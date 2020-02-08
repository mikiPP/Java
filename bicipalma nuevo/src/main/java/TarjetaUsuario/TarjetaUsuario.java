package TarjetaUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarjetaUsuario {

    private String id = null;
    private Boolean activada = null;

    public TarjetaUsuario (String id, Boolean activada) {
        this.id = id;
        this.activada = activada;
    }
}
