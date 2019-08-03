package org.lasencinas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixMethodsTest {


    @Test
    public void transposeTest() {

        Integer[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};



        assertEquals(expected,MatrixMethods.transpose(test));

        Integer[][] test2 = {{9, 8}, {10, 11}};
        Integer[][] expected2 = {{9,10}, {8, 11}};

        assertEquals(expected2,MatrixMethods.transpose(test2));
    }

    @Test
    public void matrixmultipiler() {

        Integer[][] test1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] test2 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Integer[][] expected = {{14, 32, 50}, {32, 77, 122}, {50, 122, 194}};



        assertEquals(expected,MatrixMethods.matrixMultipiler(test1,test2));

    }
}
