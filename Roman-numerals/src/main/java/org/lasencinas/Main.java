package org.lasencinas;

public class Main {

    /** In the Main class we will create one string to set one romanNumber,when we got this,we will try to
     * validate this number.If this number is valid we will translate it into a decimal number if not,we will
     * show a message that says that this roman number is not valid and the program will stop.
     *
     */

    public static void main(String[] args){

        RomanNumber romanNumber = new RomanNumber("VV");
        romanNumber.romanNumberValidator();
        romanNumber.ConverterRomanNumeralsToDecimal();
        System.out.println(romanNumber.getRomanNumberValue());
    }


}
