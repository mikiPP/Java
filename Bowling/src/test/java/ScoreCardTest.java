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

        puntuacion = "9-3561368153258-7181";
        total = 82;

        assertEquals(total, tarjeta.calculateScore(puntuacion));
    }

    @Test
    public void getStrikeValueTest() {
        String puntuacion = "X345123451234512345";
        assertEquals(74,tarjeta.calculateScore(puntuacion));
    }



    @Test
    public void getSpareValueTest() {
        String puntuacion = "1/345123451234512345";
        String frame ="/";
        assertEquals(70,tarjeta.calculateScore(puntuacion));

    }

    @Test
    public void TotalScoreStrikeTest() {
        /* If on his first try in the frame he knocks down all the
         * pins, this is called a “strike”. His turn is over, and his
         * score for the frame is ten plus the simple total of the
         * pins knocked down in his next two rolls.
         * If he gets a spare or strike in the last (tenth) frame,
         * the bowler gets to throw one or two more bonus balls,
         * respectively. - These bonus throws are taken as part of
         * the same turn. If the bonus throws knock down all the
         * pins, the process does not repeat: the bonus throws are
         * only used to calculate the score of the final frame.
         */

        String pins = "X9-9-9-9-9-9-9-9-9-";
        int total = 100;
        assertEquals(total, tarjeta.calculateScore(pins));

       // two extra final rolls
        pins = "9-9-9-9-9-9-9-9-9-X9-";
        total = 100;

        assertEquals(total,tarjeta.calculateScore(pins));

        pins = "X9-X9-9-9-9-9-9-9-";
        total = 110;
        assertEquals(total,tarjeta.calculateScore(pins));

        // two strikes in a row is a double
        pins = "XX9-9-9-9-9-9-9-9-";
        total = 120;
        assertEquals(total, tarjeta.calculateScore(pins));

        // three strikes in a row is a triple
        pins = "XXX9-9-9-9-9-9-9-";
        total = 141;
        assertEquals(total, tarjeta.calculateScore(pins));

        pins = "XXXXXXXXXXXX";
        total = 300;
        assertEquals(total, tarjeta.calculateScore(pins));

        // two strikes in extra rolls
        pins = "9-9-9-9-9-9-9-9-9-XXX";
        total = 111;
        assertEquals(total, tarjeta.calculateScore(pins));

    }


    @Test
    public void TotalScoreSpareTest() {
        /*
         * If in two tries he knocks them all down, this is called
         * a “spare” and his score for the frame is ten plus the
         * number of pins knocked down on his next throw (in
         * his next turn).
         * If he gets a spare or strike in the last (tenth) frame,
         * the bowler gets to throw one or two more bonus balls,
         * respectively. - These bonus throws are taken as part of
         * the same turn. If the bonus throws knock down all the
         * pins, the process does not repeat: the bonus throws are
         * only used to calculate the score of the final frame.
         */

        String pins = "5/5/5/5/5/5/5/5/5/5/5";
        int total = 150;
        assertEquals(total, tarjeta.calculateScore(pins));

        pins = "9-3/613/815/-/8-7/8/8";
        total = 131;
        assertEquals(total, tarjeta.calculateScore(pins));

        pins = "8/549-XX5/53639/9/X";
        total = 149;
        assertEquals(total, tarjeta.calculateScore(pins));

        pins = "8/549-XX3453639/9/X";
        total = 136;
        assertEquals(total, tarjeta.calculateScore(pins));

        // spare in extra roll
        pins = "X5/X5/XX5/--5/X5/";
        total = 175;
        assertEquals(total, tarjeta.calculateScore(pins));

    }


}
