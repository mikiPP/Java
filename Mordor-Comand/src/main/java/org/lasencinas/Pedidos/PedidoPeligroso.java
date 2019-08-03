package org.lasencinas.Pedidos;

import org.lasencinas.Interfaces.Pedido;

public class PedidoPeligroso implements Pedido  {

    public String destino = null;
    public String instrucion = null;
    public String UUID = null;



    public String getId(){
        return this.UUID;
    }

    @Override
    public int peso() {
        return 0;
    }

    @Override
    public String destino() {
       return this.destino;
    }
}
