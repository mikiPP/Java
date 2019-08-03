package org.lasencinas;

import org.junit.Before;
import org.junit.Test;
import org.lasencinas.BlockChain.BlockChain;
import org.lasencinas.Transaction.Transaction;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BlockChainTest {

    BlockChain blockChain;
    Transaction trx;


    @Before
    public void setUp(){
        blockChain = new BlockChain();
        trx = new Transaction();
    }

    @Test
    public void ConstructorTest(){
        BlockChain blockChain1 = new BlockChain();
        assertNotNull(blockChain1);
    }

    @Test
    public void AddOriginTest(){

        blockChain.addOrigin(trx);
        assertEquals(1,blockChain.getBlockChain().size());

        blockChain.addOrigin(trx);
        assertEquals(2,blockChain.getBlockChain().size());


    }
}
