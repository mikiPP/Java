package org.lasencinas.Tratamientos;

import org.lasencinas.Pedidos.PedidoNacional;

import java.util.Set;
import java.util.stream.Collectors;

public class TratamientoPedidoMultiple {

    private Set<PedidoNacional> pedidos;
    private int numBultos = 0;
    private int pesoTotal = 0;


    public TratamientoPedidoMultiple(Set<PedidoNacional> pedidos) {
        this.pedidos = pedidos;
    }

    public void calcularTotalBultos() {
        getPedidos()
                .stream()
                .filter(pedidoNacional -> {
                    this.numBultos++;
                    return true;
                })
                .collect(Collectors.toSet());
    }


    public void calcularPesoTotal() {
        getPedidos()
                .stream()
                .filter(pedidoNacional -> {
                    this.pesoTotal += pedidoNacional.peso();
                    return true;
                })
                .collect(Collectors.toSet());
    }

    public int getNumBultos() {
        return numBultos;
    }

    public int getPesoTotal() {
        return this.pesoTotal;
    }

    public boolean tratar(){

        calcularPesoTotal();
        calcularTotalBultos();
        return (numBultos == getPedidos().size() && pesoTotal != 0) ? true : false;
    }
    
    
    public Set<PedidoNacional> getPedidos(){
        return this.pedidos;
    }
}