package org.lasencinas.BlockChain;

import org.lasencinas.Transaction.Transaction;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockChain {


    private List<Transaction> blockChain = new LinkedList<>();


    /*------------------------------ Constructor ------------------------------*/


    public BlockChain(){}


    /*------------------------------ Getters ------------------------------*/

    public List<Transaction> getBlockChain() {
        return blockChain;
    }


    /*------------------------------ Setters ------------------------------*/




    /*------------------------------ Métodos ------------------------------*/


    public void addOrigin (Transaction transaction){
        getBlockChain().add(transaction);

    }


    public void  summarize(){

        for(Transaction transaction : this.getBlockChain()){

            System.out.println(transaction.toString());
        }
    }


    public void summarize(int posicion){
        System.out.println(this.getBlockChain().get(posicion).toString());

    }


    public List<Transaction> loadInputTransactions(PublicKey address){
        List<Transaction> inputTransactions = getBlockChain().stream()
                .filter(transaction -> transaction. getpKey_recipient().equals(address))
                .collect(Collectors.toCollection(ArrayList<Transaction>::new));

        return inputTransactions;
    }


    public List<Transaction> loadOutputTransactions(PublicKey address){

        List<Transaction> outputTransactions = getBlockChain().stream()
                .filter(transaction -> transaction.getpKey_sender().equals(address))
                .collect(Collectors.toCollection(ArrayList<Transaction>::new));

        return outputTransactions;
    }
}
