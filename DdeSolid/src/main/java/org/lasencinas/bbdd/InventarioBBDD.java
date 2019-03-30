package org.lasencinas.bbdd;


import org.lasencinas.negocio.AcessoDatos;

public class InventarioBBDD implements AcessoDatos {


	// Metodo de consulta a la base de datos
	
	public int numeroProductos(String tienda, String producto) {
		return BBDD.stocs.get(tienda).get(producto);
	}
}
