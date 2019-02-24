package org.lasencinas;


import org.junit.Before;
import org.junit.Test;
import org.lasencinas.Address.Address;
import org.lasencinas.TokenContract.TokenContract;

import java.security.acl.Owner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class TokenContractTest {

    private TokenContract tokenContract;


    @Before
    public void setUp(){
        Address address = new Address();
        address.generateKeyPair();
        tokenContract = new TokenContract(address);
    }

    @Test
    public void constructorTest(){
        TokenContract testConstructor = new TokenContract();
        assertNotNull(testConstructor);

        Address test = new Address();
        test.generateKeyPair();

        TokenContract ricknillos = new TokenContract(test);
        assertNotNull(ricknillos);
    }


    @Test
    public void SettersYGettersTest(){
        Address testSetGet = new Address();
        testSetGet.generateKeyPair();
        TokenContract tokenContractSetGet = new TokenContract(testSetGet);
        tokenContractSetGet.setName("TestGetSet");
        tokenContractSetGet.setSymbol("Test");
        tokenContractSetGet.setTotalSupply(10d);

        assertNotNull(tokenContractSetGet.getAddress().getPK().hashCode());
        assertEquals("TestGetSet",tokenContractSetGet.Name());
        assertEquals("Test",tokenContractSetGet.symbol());
        assertEquals(10d,tokenContractSetGet.totalSupply(),0d);

    }

    @Test
    public void addOwnerTest(){
        Address owner = new Address();
        owner.generateKeyPair();
        tokenContract.addOwner(owner.getPK(),10d);
        assertEquals(10d,tokenContract.getBalances().get(owner.getPK()),0.0);
        tokenContract.addOwner(owner.getPK(),20d);
        assertEquals(10d,tokenContract.getBalances().get(owner.getPK()),0.0);
    }

    @Test
    public void numOwnersTest(){
        Integer UNO = 1;
        tokenContract.addOwner(tokenContract.getAddress().getPK(),tokenContract.totalSupply());
        assertEquals(UNO,tokenContract.numOwners());
        Address test = new Address();
        test.generateKeyPair();
        TokenContract tokenContract1 = new TokenContract(test);
        tokenContract.addOwner(tokenContract1.getAddress().getPK(),tokenContract.totalSupply());
        Integer DOS = 2;
        assertEquals(DOS,tokenContract.numOwners());
    }

    @Test
    public void balanceOfTest(){

        tokenContract.addOwner(tokenContract.getAddress().getPK(),tokenContract.totalSupply());
        assertEquals(tokenContract.totalSupply(),tokenContract.balanceOf(tokenContract.getAddress().getPK()));
        Address test = new Address();
        test.generateKeyPair();
        TokenContract tokenContract1 = new TokenContract(test);
        tokenContract1.addOwner(tokenContract1.getAddress().getPK(),20d);

        assertEquals(20d,tokenContract1.balanceOf(tokenContract1.getAddress().getPK()));
    }

     @Test
    public void balanceofTestNull(){
        Double prueba = tokenContract.balanceOf(tokenContract.getAddress().getPK());
        assertEquals(0d,prueba);
    //    este test es el que falla
    }

    @Test
    public void transferTest(){

        Address morty = new Address();

        morty.generateKeyPair();
        tokenContract.setTotalSupply(100d);
        tokenContract.addOwner(tokenContract.getAddress().getPK(),(tokenContract.totalSupply()));
        tokenContract.transfer(morty.getPK(), 2d);
        assertEquals(98d,tokenContract.balanceOf(tokenContract.getAddress().getPK()));
        assertEquals(2d,tokenContract.balanceOf(morty.getPK()));
        tokenContract.transfer(morty.getPK(),1000d); // reviso que no de una excepcion
        tokenContract.transfer(morty.getPK(), 2d);
        assertEquals(4d,tokenContract.balanceOf(morty.getPK()));
    }

    @Test
    public void ReventaTest(){
        Address morty = new Address();

        morty.generateKeyPair();
        tokenContract.setTotalSupply(100d);
        tokenContract.addOwner(tokenContract.getAddress().getPK(),(tokenContract.totalSupply()));
        tokenContract.transfer(morty.getPK(), 2d);
        Address test = new Address();
        test.generateKeyPair();
        tokenContract.transfer(morty.getPK(),test.getPK(),1d);
        assertEquals(1d,tokenContract.balanceOf(morty.getPK()));
        assertEquals(1d,tokenContract.balanceOf(test.getPK()));

    }



    @Test
    public void payable_test() {

            Address rick = new Address();
            rick.generateKeyPair();
            TokenContract ricknillos = new TokenContract(rick);
            ricknillos.addOwner(rick.getPK(), 100d);
            Address morty = new Address();
            morty.generateKeyPair();

            morty.addEZI(20d);

            // verifico la transferencia de entradas
            ricknillos.payable(morty.getPK(), morty.getBalance());
            assertEquals(4d, ricknillos.balanceOf(morty.getPK()), 0d);

            // verifico la trasnferencia de EZI
            assertEquals(20d, ricknillos.getAddress().getBalance(), 0d);
        }


}


