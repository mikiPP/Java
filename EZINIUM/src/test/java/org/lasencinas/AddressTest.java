package org.lasencinas;

import org.junit.Before;
import org.junit.Test;
import org.lasencinas.Address.Address;
import org.lasencinas.TokenContract.TokenContract;

import java.security.PrivateKey;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class AddressTest {

    private Address address;

    @Before
    public void setUp(){
        address = new Address();
    }

    @Test
    public void generate_key_pair_test() {

        assertNotNull(address);
        address.generateKeyPair();
        assertNotNull(address.getPK());
        assertNotNull(address.getSK());
    }

    @Test
    public void ConstructorTest(){
        Address jen = new Address();
        assertNotNull(jen);
        Address morty = new Address();
        assertNotNull(morty);
    }

    @Test
    public void addEZITest(){

        Address  jen = new Address();
        jen.addEZI(20d);
        assertEquals(20d,jen.getBalance(),0.0);

        address.addEZI(-10d);
        assertEquals(-10,address.getBalance(),00.0);


    }


    @Test
    public void transferEZI_test() {

        Address rick = new Address();
        rick.generateKeyPair();

        rick.addEZI(20d);

        rick.transferEZI(20d);

        assertEquals(40d, rick.getBalance(), 0d);
    }

    @Test
    public void payableNotEnoughtEnziniums_Test(){

        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        Address morty = new Address();
        morty.generateKeyPair();

        morty.addEZI(5d);
        morty.send(ricknillos,10d);
        assertEquals(5d,morty.getBalance());

    }

    @Test
    public void ReventaConEnziniums(){
        Address rick = new Address();
            rick.generateKeyPair();

        TokenContract tokenContract = new TokenContract(rick);
            tokenContract.addOwner(rick.getPK(), 100d);

        Address morty = new Address();
        morty.generateKeyPair();
        morty.addEZI(20d);
        morty.send(tokenContract,10d);
        assertEquals(10d,morty.getBalance(),0.0);
        assertEquals(2d,tokenContract.getBalances().get(morty.getPK()));

        Address jen = new Address();
        jen.generateKeyPair();
        jen.addEZI(10d);
        jen.send(tokenContract,5d,morty);
        assertEquals(5d,jen.getBalance());
        assertEquals(1.0,tokenContract.getBalances().get(jen.getPK()));
        assertEquals(15d,morty.getBalance());
        assertEquals(1.0,tokenContract.getBalances().get(morty.getPK()));



        //Caso de que no tenga suficiente dinero jen

        jen.send(tokenContract,2d,morty);
        assertEquals(5d,jen.getBalance());
        assertEquals(1.0,tokenContract.getBalances().get(jen.getPK()));
        assertEquals(15d,morty.getBalance());
        assertEquals(1.0,tokenContract.getBalances().get(morty.getPK()));





    }

}

