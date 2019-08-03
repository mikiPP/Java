package org.lasencinas;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class NieTest {

    @Test
    public void nieVerificarPatron(){
        String nies[] = {"Z3585823J","Y3418502A","Y3418502A","Z8133408S","Y8440714G","Z1775164Y","Z7012923K","Y3456979R","Y9332314D","X9797562E"};

        for(int i = 0; i < nies.length;i++){

            ValidarDocumento nie = new Nie(nies[i]);
            assertTrue(nie.verificarPatron()); }
    }

    @Test
    public void nieVerificarLetraFalse(){
        String nies[] = {"X154326E","A1543265K","13217814D","x5927111F","Q91764322","Z2717313","X66646C","y6196132Q","Z1869Z19C","X99918H"
                ,"X3217814Ñ","Y3217814U","Z3217814O","Z3217814I"};

        for(int i = 0; i < nies.length;i++){

            ValidarDocumento nie = new Nie(nies[i]);
            assertEquals(false,nie.verificarPatron()); }
    }


    @Test
    public void getParteNumerica(){
        ValidarDocumento nie = new Nie("X1543266E");

        assertEquals((Integer) 1543266,nie.getParteNumerica());

        ValidarDocumento nie2 = new Nie("Y1543265K");

        assertEquals((Integer) 11543265,nie2.getParteNumerica());

    }


    @Test
    public void getLetra(){
        ValidarDocumento nie = new Nie("X1543266E");

        assertEquals((Character) 'E',nie.getLetra());

        ValidarDocumento nie2 = new Nie("Y1543265K");

        assertEquals((Character) 'K',nie2.getLetra());

    }


    @Test
    public void validarLetra(){
        ValidarDocumento nie = new Nie("X1543266N");
        assertTrue(nie.verificarLetra());
    }

    @Test
    public void nieValidator(){
        String nies[] = {"Z3585823J","Y3418502A","Y3418502A","Z8133408S","Y8440714G","Z1775164Y","Z7012923K","Y3456979R","Y9332314D","X9797562E"};

        for(int i = 0; i < nies.length;i++){

            ValidarDocumento nie = new Nie(nies[i]);
            assertTrue(nie.verificarDocumento()); }
    }

    @Test
    public void nieValidatorFalse(){
        String nies[] = {"X1543266E","Y1543265K","Z3217814D","X5927111F","Z9176432K","Z27313Q","Z9166646C","X6196132q","91869219C","X9998218Ñ"};

        for(int i = 0; i < nies.length;i++){

            ValidarDocumento nie = new Nie(nies[i]);
            assertFalse(nie.verificarDocumento()); }
    }
}