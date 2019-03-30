package org.lasencinas;


import org.junit.Assert;
import org.junit.Test;
import org.lasencinas.bbdd.InventarioBBDD;
import org.lasencinas.negocio.ControladorEstoc;

public class TestControladorEstoc {

	@Test
	public void test_control_estoc() {
		ControladorEstoc controlador = new ControladorEstoc(new InventarioBBDD());
		
		Assert.assertFalse(controlador.necesitaReponer("tienda norte", "mesa"));
		Assert.assertTrue(controlador.necesitaReponer("tienda norte", "lampara"));

	}

}
