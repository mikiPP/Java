package org.lasencinas;


import org.junit.Before;
import org.junit.Test;
import org.lasencinas.Transaction.Transaction;
import org.lasencinas.Wallet.Wallet;

import static junit.framework.TestCase.assertNotNull;

public class TransactionTest {

    private Transaction transaction;
    private  Wallet wallet;

   @Before
   public void setUp(){
       transaction = new Transaction();
       wallet = new Wallet();
   }


    @Test
    public void ConstructorTest(){

        wallet.generateKeyPair();
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction("Hash","prev_hash",wallet.getAddress(),wallet.getAddress(),20.0,"Message");
        assertNotNull(transaction1);
        assertNotNull(transaction2);

    }




    @Test
    public void SettersTest(){

       wallet.generateKeyPair();
       transaction.setHash("jash");
       transaction.setMessage("Mesasge");
       transaction.setPigcoins(20d);
       transaction.setPrev_hash("prevHash");
       transaction.setpKey_recipient(wallet.getAddress());
       transaction.setpKey_sender(wallet.getAddress());
       assertNotNull(transaction.getMessage());
       assertNotNull(transaction.getHash());
       assertNotNull(transaction.getPigcoins());
       assertNotNull(transaction.getpKey_recipient());
       assertNotNull(transaction.getpKey_sender());
       assertNotNull(transaction.getPrev_hash());

    }
}
