
import static org.junit.Assert.*;

import Conductor.Conductor;
import org.junit.Test;



public class ConductorTest {

    @Test
    public void ConstructorYgetConductorTest() {
        String nombre = "Samantha";
        Conductor conductor = new Conductor(nombre);
        assertEquals(nombre, conductor.getNombre());
    }

    @Test
    public void ValoracionMediaTest() {
        String nombre = "Samantha";
        Conductor conductor = new Conductor(nombre);
        conductor.setValoracion((byte) 5);
        assertEquals(5, conductor.getValoracion(), 0.1);

        int numeroValoraciones = 0;
        for (int valoracion = 0; valoracion <= 5; valoracion++) {
            conductor.setValoracion((byte) valoracion);
            numeroValoraciones++;
        }

        assertEquals(2.875, conductor.getValoracion(), 0.1);
    }
}