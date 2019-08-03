package org.lasencinas;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private String romanNumber = null;
    private int romanNumberValue = 0;

    /*-------------------------------------- Builder --------------------------------------*/

    public RomanNumber(String romanNumber){
        this.romanNumber = romanNumber;
    }

    public RomanNumber(){}

    /*-------------------------------------- Getter && Setters --------------------------------------*/

    public String getRomanNumber(){
        return this.romanNumber;
    }

    public int getRomanNumberValue(){
        return this.romanNumberValue;
    }

    public void setRomanNumber(String romanNumber){
         this.romanNumber = romanNumber;
    }

    public void setRomanNumberValue(int value){
        this.romanNumberValue = value;
    }


    /*-------------------------------------- Logic --------------------------------------*/


    public int ConverterRomanNumeralsToDecimal() {

        /**This method will call calculateSubstractiveGroup and calculateSumativeGroup to convert
        /* a roman number into a decimal number ,and save this value into romanNumberValue.*/

        this.setRomanNumberValue(calculateSubtractiveGroup() + calculatetSumativeGroup());
        return this.getRomanNumberValue();}



    public void romanNumberValidator(){
        /**In this method,we will check if the given roman number is valid according to de roman numeral rules.If it is valid,
         * we will keep going with the program,instead if it is not valid we will stop the program.
        */

        String validRomanNumber = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        Pattern pattern = Pattern.compile(validRomanNumber);
        Matcher matcher = pattern.matcher(getRomanNumber());


        if( matcher.matches()== false){

            JOptionPane.showMessageDialog(null,"This roman number: " + "'" + getRomanNumber() +"'" + " is not valid.");
            System.exit(0);

        }else{
            //if you get into here,then program will keep going
        }
    }


    public Boolean romanNumberValidator(String romanNumber){
        /**Just the same as the the other method with the same name,but i'll use this to check the tests */

        String validRomanNumber = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        Pattern pattern = Pattern.compile(validRomanNumber);
        Matcher matcher = pattern.matcher(romanNumber);
       return matcher.matches();
    }


    private int calculateSubtractiveGroup(){

        /**Here,we will check if we have got in our input string one or more substractive group,
        /* if there is at least one,it will add to value it's own value, and remove this group in the string
        /* to avoid add it again another time.If there is not any substractive group,we won't do nothing*/

        int value = 0;

        for(RomanNumeral romanNumeral : RomanNumeral.getSubtractiveGroup()){
            if(getRomanNumber().contains(romanNumeral.name())){
                setRomanNumber(getRomanNumber().replace(romanNumeral.name(),""));
                value += romanNumeral.getValue();

            }else{
                //if you get into here,nothing will happen
            }
        }

     return value;}


    private int calculatetSumativeGroup(){
        /** This funtion is about get every sumative group and check if it is in the roman number,if it is in the roman
         * number, we will add hat value if not, nothing will happend.
         *  Just like  calculateSubstractiveGroup but with sumative group.
         */

        int value = 0;

        for(RomanNumeral romanNumeral : RomanNumeral.getSumativeGroup()) {

            for (int i =0; i < getRomanNumber().length();i++) {

               if (romanNumeral.name().charAt(0) == getRomanNumber().charAt(i)){
                    value += romanNumeral.getValue();

                }else{
                   //if you get into here,nothing will happen
                }
            }
        }
        return value;}



}
