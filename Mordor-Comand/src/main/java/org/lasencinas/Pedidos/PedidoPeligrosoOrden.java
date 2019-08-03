package org.lasencinas.Pedidos;

import org.lasencinas.Interfaces.Pedido;

public class PedidoPeligrosoOrden extends PedidoPeligroso implements Pedido {




        public PedidoPeligrosoOrden(String destino,String instrucion){
            this.destino = destino;
            this.instrucion = instrucion;
            super.UUID = java.util.UUID.randomUUID().toString();

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
