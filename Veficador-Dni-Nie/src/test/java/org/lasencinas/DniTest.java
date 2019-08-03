package org.lasencinas;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class DniTest {

    @Test
    public void dniVerificarPatron(){
        String dnis[] = {"41543266E","41543265K","43217814D","35927111F","19176432K","62717313Q","59166646C","66196132Q","91869219C","69998218H"};

        for(int i = 0; i < dnis.length;i++){

            ValidarDocumento dni = new Dni(dnis[i]);
            assertTrue(dni.verificarPatron()); }
        }

    @Test
    public void dniVerificarPatronFalse(){
        String dnis[] = {"4154326E","3154A3265K","s43217814D","35927111f","191432K","62717313qQ","59166646HC","66196132SQ","91869219AC","69998218"};

        for(int i = 0; i < dnis.length;i++){

            ValidarDocumento dni = new Dni(dnis[i]);
            assertEquals(false,dni.verificarPatron()); }
    }


    @Test
    public void DniValidatorLetra(){
        String dnis[] = {"41543266E","41543265K","43217814D","35927111F","19176432K","62717313Q","59166646C","66196132Q","91869219C","69998218H"};

        for(int i = 0; i < dnis.length;i++){

            ValidarDocumento dni = new Dni(dnis[i]);
            assertTrue(dni.verificarLetra()); }
    }



    @Test
    public void dniVerificar(){
        String dnis[] = {"41543266E","41543265K","43217814D","35927111F","19176432K","62717313Q","59166646C","66196132Q","91869219C","69998218H"};

        for(int i = 0; i < dnis.length;i++){

            ValidarDocumento dni = new Dni(dnis[i]);
            assertTrue(dni.verificarDocumento()); }
    }

    @Test
    public void dniVerificarFalse(){
        String dnis[] = {"41543266H","4143265K","4321781s4D","35927111f","19176432Q","X62717313Q","Z9166646C","6696132Q","91C869219C","69998218h"};

        for(int i = 0; i < dnis.length;i++){

            ValidarDocumento dni = new Dni(dnis[i]);
            assertFalse(dni.verificarDocumento()); }
    }

}



