package PoolConductores;

import Conductor.Conductor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
public class PoolConductores {

    private Set<Conductor> poolConductores;

    public PoolConductores (Set<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }

    public Conductor asignarConductor() {

        // Forma funcional


        Optional<Conductor> conductor = this.getPoolConductores()
                              .stream()
                              .filter(condctor -> !condctor.getOcupado())
                              .findFirst();

        conductor.ifPresent(conductorFromOptional -> conductorFromOptional.setOcupado(true));

        return conductor.orElse(null);

        //Forma imperativa

//        for(Conductor conductor : getPoolConductores()) {
//            if(!conductor.getOcupado()) {
//                conductor.setOcupado(true);
//                return conductor;
//            }
//        }
//        return null;
    }
}
