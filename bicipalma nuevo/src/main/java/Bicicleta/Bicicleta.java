package Bicicleta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bicicleta {

    private Integer id = null;

    public Bicicleta (int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
