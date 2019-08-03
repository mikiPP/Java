package org.lasencinas.Wallet;

import org.lasencinas.BlockChain.BlockChain;
import org.lasencinas.Gensig.GenSig;
import org.lasencinas.Transaction.Transaction;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private PublicKey address = null;
    private PrivateKey sKey = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private List<Transaction> InputTransactions = new ArrayList();
    private List<Transaction> OutputTransactions = new ArrayList();


    /*------------------------------ Constructor ------------------------------*/


    public Wallet(){}


    /*------------------------------ Getters ------------------------------*/

    public PublicKey getAddress() {
        return address;
    }


    public PrivateKey getsKey() {
        return sKey;
    }


    public double getTotalOutput() {
        return total_output;
    }


    public double getTotalInput() {
        return total_input;
    }


    public double getBalance() {
        return balance;
    }

    public List<Transaction> getInputTransactions() {
        return InputTransactions;
    }

    public List<Transaction> getOutputTransactions() {
        return OutputTransactions;
    }

    /*------------------------------ Setters ------------------------------*/

    public void setSK(PrivateKey sKey){

        this.sKey = sKey;
    }


    public void setAddress(PublicKey address){

        this.address = address;
    }

    public void setTotalInput(double total_input) {
        this.total_input = total_input;
    }

    public void setTotalOutput(double total_output) {
        this.total_output = total_output;
    }

    public void setBalance(double balance) {
        if(balance > 0){
            this.balance = balance;
        }else{
            this.balance = 0;
        }
    }

    public void setInputTransactions(BlockChain blockChain) {
        this.InputTransactions = blockChain.loadInputTransactions(this.getAddress());
    }

    public void setOutputTransactions(BlockChain blockChain) {
        this.OutputTransactions = blockChain.loadOutputTransactions(this.getAddress());
    }

    /*------------------------------ Métodos ------------------------------*/


    public void generateKeyPair(){

        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());

    }


    @Override
    public String toString(){

            return "\n" + "Wallet = " + getAddress().hashCode() + "\n" +
                    "Total input = " + getTotalInput() + "\n" +
                    "Total output = " + getTotalOutput() + "\n" +
                    "Balance = " + getBalance() + "\n"; }


    public void loadCoins(BlockChain blockChain){

        this.setTotalOutput(0d);
        this.setTotalInput(0d);



        for(Transaction transaction : blockChain.getBlockChain()){

            if(this.getAddress().equals(transaction.getpKey_recipient())){
                this.setTotalInput(getTotalInput() + transaction.getPigcoins());


            }else{}


            if(this.getAddress().equals(transaction.getpKey_sender())){
                this.setTotalOutput(getTotalOutput() + transaction.getPigcoins());


            }else{}
        }

        this.setBalance(getTotalInput() - getTotalOutput() );

    }

    public void loadInputTransactions(BlockChain blockChain){
        setInputTransactions(blockChain);

    }

    public void loadOutputTransactions(BlockChain blockChain){
        setOutputTransactions(blockChain);

    }
}
