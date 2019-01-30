import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ScoreCardTest {

    private ScoreCard tarjeta = null;

    @Before
    public void setUp(){
        tarjeta = new ScoreCard();
    }


    @Test
    public void PuntuacionPorBoloTest(){
        String puntuacion = "-123456789";
        for(int i = 0; i < puntuacion.length();i++){
            assertEquals(i,tarjeta.calculateScore(Character.toString(puntuacion.charAt(i))));
        }
    }

    @Test
    public void PuntuacionSimpleTest() {
        String puntuacion = "12345123451234512345";
        int total = 60;
        assertEquals(total,tarjeta.calculateScore(puntuacion));
    }

    @Test
    public void PuntuacionHeartBreakTest() {
        String puntuacion ="9-9-9-9-9-9-9-9-9-9-";
        int total = 90;
        assertEquals(total,tarjeta.calculateScore(puntuacion));
    }

    @Test
    public void getStrikeValueTest() {
        String puntuacion = "X345123451234512345";
        assertEquals(74,tarjeta.calculateScore(puntuacion));
    }



    @Test
    public void getSpareValueTest() {
        String puntuacion = "1/345123451234512345";
        assertEquals(70,tarjeta.calculateScore(puntuacion));
    }

}