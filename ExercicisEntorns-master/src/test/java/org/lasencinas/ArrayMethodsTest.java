package org.lasencinas;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayMethodsTest {


    @Test
    public void voidListShouldReturnFalse(){
        List<Integer> list = new ArrayList<>();

        assertFalse(ListMethods.binarySearch(list,0));
    }


    @Test
    public void IntegerInListShouldReturnTrue(){

        Integer[] integers = {1,2,4,5,6,7,8,9,10};

        List<Integer> list = Arrays.asList(integers);

        assertTrue(ListMethods.binarySearch(list,5));
        assertTrue(ListMethods.binarySearch(list,2));
        assertTrue(ListMethods.binarySearch(list,1));
        assertTrue(ListMethods.binarySearch(list,10));
        assertTrue(ListMethods.binarySearch(list,9));
        assertTrue(ListMethods.binarySearch(list,7));

    }


    @Test
    public void IntegerInListShouldReturnTrue2(){

        Integer[] integers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};

        List<Integer> list = Arrays.asList(integers);

        assertTrue(ListMethods.binarySearch(list,35));
        assertTrue(ListMethods.binarySearch(list,40));
        assertTrue(ListMethods.binarySearch(list,19));
        assertTrue(ListMethods.binarySearch(list,1));
        assertTrue(ListMethods.binarySearch(list,30));
        assertTrue(ListMethods.binarySearch(list,21));

    }


    @Test
    public void IntegerInListShouldReturnFalse(){

        Integer[] integers = {1,2,4,5,6,7,8,9,10};

        List<Integer> list = Arrays.asList(integers);

        assertFalse(ListMethods.binarySearch(list,50));
        assertFalse(ListMethods.binarySearch(list,11));
        assertFalse(ListMethods.binarySearch(list,0));

    }


    @Test
    public void IntegerInListShouldReturnFalse2(){

        Integer[] integers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};

        List<Integer> list = Arrays.asList(integers);

        assertFalse(ListMethods.binarySearch(list,0));
        assertFalse(ListMethods.binarySearch(list,50));
        assertFalse(ListMethods.binarySearch(list,41));

    }


    @Test
    public void BubbleSortTest(){

        Integer[] integers = {3,5,14,2,1,25,6,4,12,21,7,0};

        Integer[] integers2 = {0,1,2,3,4,5,6,7,12,14,21,25};

        List<Integer> list = Arrays.asList(integers);
        List<Integer> expected = Arrays.asList(integers2);

        assertEquals(expected, ListMethods.bubbleSort(list));

        Integer[] integersTest2 = {76,19,98,67,33,50,5,31,55,16,45,20,30,74,48,66,28,1,75,15};

        Integer[] integers2Test2 = {1,5,15,16,19,20,28,30,31,33,45,48,50,55,66,67,74,75,76,98};

        List<Integer> listTest2 = Arrays.asList(integersTest2);
        List<Integer> expectedTest2 = Arrays.asList(integers2Test2);




        assertEquals(expectedTest2, ListMethods.bubbleSort(listTest2));

    }


    @Test
    public void quickSortTest(){

        Integer[] integers = {3,5,14,2,1,25,6,4,12,21,7,0};

        Integer[] integers2 = {0,1,2,3,4,5,6,7,12,14,21,25};

        List<Integer> list = Arrays.asList(integers);
        List<Integer> expected = Arrays.asList(integers2);

        assertEquals(expected,ListMethods.Quicksort(list));

        Integer[] integersTest2 = {76,19,98,67,33,50,5,31,55,16,45,20,30,74,48,66,28,1,75,15};

        Integer[] integers2Test2 = {1,5,15,16,19,20,28,30,31,33,45,48,50,55,66,67,74,75,76,98};

        List<Integer> listTest2 = Arrays.asList(integersTest2);
        List<Integer> expectedTest2 = Arrays.asList(integers2Test2);




        assertEquals(expectedTest2, ListMethods.Quicksort(listTest2));
    }
}
