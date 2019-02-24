package org.lasencinas.Address;

import org.lasencinas.GenSig.GenSig;
import org.lasencinas.TokenContract.TokenContract;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    private PublicKey PK = null;
    private PrivateKey SK = null;
    private Double balance = 0d;
    private final String simbolo = "EZI";

    /*------------------------------ Constructor ------------------------------*/

    public Address(){
        //Constructor vacio
    }


    /*------------------------------ Getters ------------------------------*/

    public PublicKey getPK() {
        return PK;
    }

    public PrivateKey getSK() {
        return SK;
    }

    public Double getBalance() {
        return balance;
    }

    public String getSimbolo() {
        return simbolo;
    }



    /*------------------------------ Setters ------------------------------*/

    public void setPK(PublicKey PK) {
        this.PK = PK;
    }

    public void setSK(PrivateKey SK) {
        this.SK = SK;
    }

    public void setBalance(Double balance) {
        this.balance += balance;
    }



    /*------------------------------ Métodos ------------------------------*/

    public void generateKeyPair(){

        KeyPair pair = GenSig.generateKeyPair();
        this.setPK(pair.getPublic());
        this.setSK(pair.getPrivate());


    }


    @Override
    public String toString() {
        return "\n" + "PK = " + this.getPK().hashCode() + "\n" +
                "Balance = " + this.getBalance() + " " + this.getSimbolo() + "\n" ;
}


    public void addEZI(Double ezi){
        this.setBalance(ezi);
    }


    public void send(TokenContract tokenContract,Double enziniums){

        try {

            this.addEZI(-enziniums);
            //Comprobamos si tiene suficiente dinero y diniero suficiente para una entrada
            if(this.getBalance() > 0 && enziniums > tokenContract.getCosteEntrada() ){

                tokenContract.payable(this.getPK(),enziniums);


            }else{
                Exception dineroInsuficiente = new Exception();
                throw  dineroInsuficiente;
            }

        }catch (Exception dineroInsuficente){
            this.addEZI(+enziniums); //Reseteamos la compra ya que no se ha dado a cabo
        }
        }




    public void transferEZI(Double enziniums){
       this.addEZI(enziniums);
    }


    /*---------------------------Reventa con enziniums -----------------*/

    public void send(TokenContract tokenContract,Double enziniums,Address vendedor){

        try {

            this.addEZI(-enziniums);
            //Comprobamos si tiene suficiente dinero y diniero suficiente para una entrada

            if(this.getBalance() > 0 && enziniums >= tokenContract.getCosteEntrada() ){

                tokenContract.payable(this.getPK(),enziniums,vendedor);


            }else{
                Exception dineroInsuficiente = new Exception();
                throw  dineroInsuficiente;
            }

        }catch (Exception dineroInsuficente){
            this.addEZI(enziniums); //Reseteamos la compra ya que no se ha dado a cabo
        }

    }



    }

