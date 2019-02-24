package org.lasencinas.TokenContract;

import org.lasencinas.Address.Address;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;

public class TokenContract {

    private Address address = null;
    private String name = null;
    private String symbol = null;
    private Double totalSupply = 0d;
    private Map<PublicKey, Double> balances = new HashMap();
    final  private Double CosteEntrada = 5d;





    /*------------------------------ Constructor ------------------------------*/

    public TokenContract(){
        //Constructor Vacio
    }

    public TokenContract(Address address){
        this.address = address;
    }


    /*------------------------------ Getters ------------------------------*/

    public Address getAddress() {
        return address;
    }

    public String Name() {
        return name;
    }

    public String symbol() {
        return symbol;
    }

    public Double totalSupply() {
        return totalSupply;
    }

    public Map<PublicKey, Double> getBalances() {
        return this.balances;
    }

    public Double getCosteEntrada() {
        return CosteEntrada;
    }


    /*------------------------------ Setters ------------------------------*/



    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    /*------------------------------ Métodos ------------------------------*/

    @Override
    public String toString() {

        return "\n" + "Name = " + Name() + "\n" +
                "Symbol = " + symbol() + "\n" +
                "totalSupply = " + totalSupply() + "\n" +
                "Owner PK = " + getAddress().getPK().hashCode(); }



    public void addOwner(PublicKey PK,Double entradas){

        getBalances().putIfAbsent(PK,entradas);    }


    public Integer numOwners() {

    return this.getBalances().size(); }


    public double balanceOf(PublicKey PK){
        try{
        return getBalances().get(PK);}

        catch (NullPointerException e){
            return 0d;
        }
    }

    public void transfer(PublicKey PK, Double entradas){
        try {


        require(this.balanceOf(getAddress().getPK()) > entradas);

        Double balanceDueño = this.balanceOf(this.getAddress().getPK()) -entradas;
        getBalances().replace(getAddress().getPK(),balanceDueño);
        getBalances().put(PK,balanceOf(PK)+entradas); }

        catch (Exception e){

        }

    }

    public void transfer(PublicKey PKVendedor,PublicKey PKComprador, Double entradas) {
        try {


            require(this.balanceOf(PKVendedor) > entradas);

            Double balanceDueño = this.balanceOf(PKVendedor) - entradas;
            getBalances().replace(PKVendedor, balanceDueño);
            getBalances().put(PKComprador, balanceOf(PKComprador) + entradas);
        } catch (Exception noEntradas) {

        }

    }

    public void require(Boolean condicion)throws Exception {
        if (condicion) {

        } else {
            Exception noEntradas = new Exception();
            throw noEntradas;
        }

    }
    public void owners(){

        for(PublicKey PK : getBalances().keySet()){
            if(getAddress().getPK().equals(PK)){

            }else{

                System.out.println("Owner: " + PK.hashCode() + " " + getBalances().get(PK) + " " + symbol);

            }
        }

    }

    public Double totalTokensSold(){
        Double entradasVendidas = 0d;

        for(PublicKey PK : getBalances().keySet()){
            if(getAddress().getPK().equals(PK)){

            }else{
               entradasVendidas += balanceOf(PK);
            }
        }

   return entradasVendidas; }


    public void payable(PublicKey PK,Double enziniums){

        Double entradas =  enziniums/this.getCosteEntrada(); //Supongo que el valor de las entradas es 5d pero no se si hay mas valores posibles
        Math.floor(entradas);
        this.transfer(PK,entradas);
        this.getAddress().transferEZI(enziniums);

    }


    public void payable(PublicKey PKComprador,Double enziniums,Address vendedor){

        Double entradas =  enziniums/this.getCosteEntrada(); //Supongo que el valor de las entradas es 5d pero no se si hay mas valores posibles
        Math.floor(entradas);
        this.transfer(vendedor.getPK(),PKComprador,entradas);
        vendedor.transferEZI(enziniums);

    }





    }
