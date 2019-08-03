package org.lasencinas;

import org.junit.Before;
import org.junit.Test;
import org.lasencinas.BlockChain.BlockChain;
import org.lasencinas.Gensig.GenSig;
import org.lasencinas.Transaction.Transaction;
import org.lasencinas.Wallet.Wallet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import java.security.KeyPair;

public class WalletTest {

    private Wallet wallet;
    private BlockChain blockChain;


    @Before
    public void setUp(){
         wallet = new Wallet();
         blockChain = new BlockChain();
    }

    @Test
    public void setKeys(){
        KeyPair pair = GenSig.generateKeyPair();
        wallet.setSK(pair.getPrivate());
        wallet.setAddress(pair.getPublic());
        assertNotNull(wallet.getAddress());
        assertNotNull(wallet.getsKey());
    }


    @Test
    public void generateKeyPair(){
        wallet.generateKeyPair();
        assertNotNull(wallet.getAddress());
        assertNotNull(wallet.getsKey());
    }

    @Test
    public void walletLoadCoins(){

        Wallet wallet1 = new Wallet();
        wallet.generateKeyPair();
        wallet1.generateKeyPair();

        Transaction trx = new Transaction("Hash","Prev_hash",wallet.getAddress(),wallet1.getAddress(),20d,"message");
        Transaction transaction = new Transaction("Hash","Prev_hash",wallet1.getAddress(),wallet.getAddress(),10d,"message");

        blockChain.addOrigin(transaction);
        blockChain.addOrigin(trx);

        wallet1.loadCoins(blockChain);
        wallet.loadCoins(blockChain);

        assertEquals(10d,wallet.getTotalInput(),0d);
        assertEquals(20d,wallet.getTotalOutput(),0d);
        assertEquals(20d,wallet1.getTotalInput(),0d);
        assertEquals(10d,wallet1.getTotalOutput(),0d);
        assertEquals(0d,wallet.getBalance(),0d);
        assertEquals(10d,wallet1.getBalance(),0d);
    }

    @Test
    public void walletLoadConinsTestYourself(){

        Wallet wallet1 = new Wallet();
        wallet.generateKeyPair();
        wallet1.generateKeyPair();

        Transaction trx = new Transaction("Hash","Prev_hash",wallet.getAddress(),wallet1.getAddress(),20d,"message");
        Transaction transaction = new Transaction("Hash","Prev_hash",wallet1.getAddress(),wallet1.getAddress(),10d,"message");

        blockChain.addOrigin(transaction);
        blockChain.addOrigin(trx);
        wallet1.loadCoins(blockChain);
        wallet.loadCoins(blockChain);

        assertEquals(0d,wallet.getTotalInput(),0d);
        assertEquals(20d,wallet.getTotalOutput(),0d);
        assertEquals(30d,wallet1.getTotalInput(),0d);
        assertEquals(10d,wallet1.getTotalOutput(),0d);
        assertEquals(0d,wallet.getBalance(),0d);
        assertEquals(20d,wallet1.getBalance(),0d);


    }


}
