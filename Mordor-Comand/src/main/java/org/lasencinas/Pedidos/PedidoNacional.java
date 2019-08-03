package org.lasencinas.Pedidos;


import org.lasencinas.Interfaces.Pedido;

public class PedidoNacional implements Pedido {

    private String destino = null;
    private int peso = 0;
    private String UUID = null;

    public PedidoNacional (String destino,int peso) {
        this.destino = destino;
        this.peso = peso;
        this.UUID = java.util.UUID.randomUUID().toString();
    }


    public String getId() {
        return this.UUID;
    }

    @Override
    public int peso() {
        return this.peso;
    }

    @Override
    public String destino() {
        return this.destino;
    }

}
