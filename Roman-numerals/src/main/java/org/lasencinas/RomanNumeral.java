package org.lasencinas;

import java.util.EnumSet;

public enum RomanNumeral {

    I(1),
    V(5),
    X( 10),
    L(50),
    C(100),
    D(500),
    M(1000),
    IV(4),
    IX(9),
    XL(40),
    XC(90),
    CD(400),
    CM(900);


    private int value = 0;


    /*-------------------------------------- Constructor --------------------------------------*/

    RomanNumeral(int value) {
        this.value = value;
    }


    /*-------------------------------------- Getters --------------------------------------*/

    public int getValue() {
        return value;
    }

    public static EnumSet<RomanNumeral> getSumativeGroup(){
        return EnumSet.range(I, M);

    }

    public static EnumSet<RomanNumeral> getSubtractiveGroup(){
        return EnumSet.complementOf(getSumativeGroup());

    }
}




