package org.lasencinas.Tratamientos;

import org.lasencinas.Interfaces.TratamientoPedido;
import org.lasencinas.Pedidos.PedidoPeligroso;

public class TratamientoPedidoPeligroso extends PedidoPeligroso implements TratamientoPedido {

    private PedidoPeligroso pedidoPeligroso;

    public TratamientoPedidoPeligroso (PedidoPeligroso pedidoPeligroso){
        this.pedidoPeligroso = pedidoPeligroso;
    }

    @Override
    public boolean tratar() {
        if(pedidoPeligroso.instrucion.equalsIgnoreCase("no ponerselo en el dedo") == false){
            return true;
        }else {return false;}
    }
}
