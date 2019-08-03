package org.lasencinas.Procesadores;

import org.lasencinas.EnumType.Status;
import org.lasencinas.Interfaces.Pedido;
import org.lasencinas.Interfaces.Procesador;
import org.lasencinas.Interfaces.TratamientoPedido;

public class Oficina  implements Procesador {

    @Override
    public boolean procesa(TratamientoPedido pedido) {
       return pedido.tratar();
    }

    public String printarStatus(boolean expresion, Pedido pedido){

        if(expresion){
            return pedido.destino() + " " + Status.ACEPTADO;

        }else {
            return pedido.destino() + " " + Status.RECHAZADO;
        }


    }
}
