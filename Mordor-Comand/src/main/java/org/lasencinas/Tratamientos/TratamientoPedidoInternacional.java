package org.lasencinas.Tratamientos;

import org.lasencinas.Interfaces.TratamientoPedido;
import org.lasencinas.Pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido {
    private PedidoInternacional pedidoInternacional = null;


    public TratamientoPedidoInternacional (PedidoInternacional pedidoInternacional) {
        this.pedidoInternacional = pedidoInternacional;
    }

    @Override
    public boolean tratar() {
        if (this.pedidoInternacional.destino().equalsIgnoreCase("Mordor") == false) {
            return true;

        }else {
            return false;
        }
    }
}
