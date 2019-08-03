package org.lasencinas;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RomanNumeralsTest {


    public static String[] RomanNumerals;
    RomanNumber test;



    @BeforeClass
    public static void CreationArrayRomanNumeralsSetup(){
        RomanNumerals = new String[13];
        int RomanNumeralsInArray = 0;
        for(RomanNumeral RomanNumeral : RomanNumeral.values()){
            RomanNumerals[RomanNumeral.ordinal()] = RomanNumeral.name();
            RomanNumeralsInArray += 1;
        }
        assertThat(RomanNumeralsInArray).isEqualTo(RomanNumeral.values().length);
    }

    @Before
    public void setUp(){
         test = new RomanNumber();
    }

    @Test
    public void romanNumeralBuilderTest() {

        RomanNumeral romanNumeral = RomanNumeral.I;
        assertThat(romanNumeral).isInstanceOf(RomanNumeral.class);
        assertThat(romanNumeral.ordinal()).isEqualTo(0);
        assertThat(romanNumeral.name()).isEqualToIgnoringWhitespace("I");
        assertThat(RomanNumeral.valueOf(romanNumeral.name())).isEqualTo(RomanNumeral.I);
        assertThat(romanNumeral.compareTo(romanNumeral.I)).isEqualTo(0);
        assertThat(romanNumeral.toString()).isEqualToIgnoringWhitespace("I");
        assertThat(romanNumeral.equals(romanNumeral.I)).isEqualTo(true);
        assertThat(RomanNumeral.values()[0]).isEqualTo(romanNumeral);}


    @Test
    public void RomanNumeralGetValueTest(){
        RomanNumeral I = RomanNumeral.I;
        assertThat(I.getValue()).isEqualTo(1);
    }

    @Test
    public void RomanNumeralGetLetterTest(){
        RomanNumeral I = RomanNumeral.I;
        assertThat(I.name()).isEqualTo("I");
    }

    @Test
    public void RomanNumeralNamesIteratorTest(){
        for(RomanNumeral romanNumeral : RomanNumeral.values()){
            assertThat(romanNumeral.name()).isIn(RomanNumerals);
        }
    }

    @Test
    public void RomanNumeralToDecimalSimpleTest(){

        String mil = "M";
        test.setRomanNumber(mil);
        assertEquals(1000,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("D");
        assertEquals(500,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("C");
        assertEquals(100,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("L");
        assertEquals(50,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("X");
        assertEquals(10,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("V");
        assertEquals(5,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("I");
        assertEquals(1,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("IV");
        assertEquals(4,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("IX");
        assertEquals(9,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("XL");
        assertEquals(40,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("XC");
        assertEquals(90,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("CD");
        assertEquals(400,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("CM");
        assertEquals(900,test.ConverterRomanNumeralsToDecimal());


    }


    @Test
    public void RomanNumeralToDecimalSumativeTest() {
       

        String test0 = "MDCLXVI";
        test.setRomanNumber(test0);
        assertEquals(1666,test.ConverterRomanNumeralsToDecimal());


        String test1 = "MMDCCLXXVII";
        test.setRomanNumber(test1);
        assertEquals(2777,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("MMMDCCCLXXXVIII");
        assertEquals(3888,test.ConverterRomanNumeralsToDecimal());

    }

    @Test
    public void RomanNumeralToDecimalSubstractiveTest() {


        String test0 = "IV";
        test.setRomanNumber(test0);
        assertEquals(4,test.ConverterRomanNumeralsToDecimal());


        String test1 = "IX";
        test.setRomanNumber(test1);
        assertEquals(9,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("XIX");
        assertEquals(19,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("CXC");
        assertEquals(190,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("MCM");
        assertEquals(1900,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("IXIV");
        assertEquals(13,test.ConverterRomanNumeralsToDecimal());

        test.setRomanNumber("CDXLIV");
        assertEquals(444,test.ConverterRomanNumeralsToDecimal());



   }



   @Test
    public void RomanNumeralToDecimalSumativeAndSubstractiveTest(){

       test.setRomanNumber("CDXXXIX");
       assertEquals(439,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("XLV");
       assertEquals(45,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CMCDXXXIX");
       assertEquals(1339,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CDXCV");
       assertEquals(495,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CDL");
       assertEquals(450,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("MCML");
       assertEquals(1950,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("XLIX");
       assertEquals(49,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("XCIX");
       assertEquals(99,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CDXCIX");
       assertEquals(499,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CMXCIX");
       assertEquals(999,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CDXC");
       assertEquals(490,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CMXC");
       assertEquals(990,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("XLI");
       assertEquals(41,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("XXXIX");
       assertEquals(39,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CCCXC");
       assertEquals(390,test.ConverterRomanNumeralsToDecimal());

       test.setRomanNumber("CDX");
       assertEquals(410,test.ConverterRomanNumeralsToDecimal());

   }

    @Test
    public void repeatMoreThanThreeTimesTest(){


        assertEquals(false,test.romanNumberValidator("IIII"));

        assertEquals(true,test.romanNumberValidator("III"));

        assertEquals(true,test.romanNumberValidator("II"));

        assertEquals(false,test.romanNumberValidator("XXXX"));

        assertEquals(true,test.romanNumberValidator("XXX"));

        assertEquals(true,test.romanNumberValidator("XX"));

        assertEquals(true,test.romanNumberValidator("XXXIX"));

        assertEquals(false,test.romanNumberValidator("CCCC"));

        assertEquals(true,test.romanNumberValidator("CCCXC"));

        assertEquals(true,test.romanNumberValidator("CCC"));

        assertEquals(true,test.romanNumberValidator("CC"));

        assertEquals(false,test.romanNumberValidator("MMMM"));

        assertEquals(true,test.romanNumberValidator("MMMCM"));

        assertEquals(true,test.romanNumberValidator("MMM"));

        assertEquals(true,test.romanNumberValidator("MM"));

        //deberia ir? assertEquals(true,test.romanNumberValidator("IVCM"));

    }

    @Test
    public void repeatMoreThanOneTimeTest() {

        assertEquals(false,test.romanNumberValidator("DD"));

        assertEquals(true,test.romanNumberValidator("D"));

        assertEquals(false,test.romanNumberValidator("DDD"));

        assertEquals(false,test.romanNumberValidator("LL"));

        assertEquals(true,test.romanNumberValidator("L"));

        assertEquals(false,test.romanNumberValidator("LLL"));

        assertEquals(false,test.romanNumberValidator("VV"));

        assertEquals(true,test.romanNumberValidator("V"));

        assertEquals(false,test.romanNumberValidator("VVV"));


    }
    
    
    @Test
    public void NotValidSubstractingGrouTest(){

        assertEquals(false,test.romanNumberValidator("DM"));

        assertEquals(false,test.romanNumberValidator("LC"));

        assertEquals(false,test.romanNumberValidator("VL"));

        assertEquals(false,test.romanNumberValidator("CCM"));

        assertEquals(false,test.romanNumberValidator("XM"));

        assertEquals(false,test.romanNumberValidator("XXL"));

        assertEquals(false,test.romanNumberValidator("IIX"));

        assertEquals(false,test.romanNumberValidator("IC"));

        assertEquals(false,test.romanNumberValidator("IL"));
        
        
    }
}
