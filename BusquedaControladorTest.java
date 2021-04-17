package ht7.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class BusquedaControladorTest extends TestCase {
	Controlador cont = new Controlador();
	@Test
	void test() {
		String testString = "cellphone,telefono,telephone portable";
		String[] texto = {"i" , "left", "my", "cellphone", "in", "the", "car"};
		cont.separarPalabras(testString);
		cont.translateText = texto;

		assertEquals(" *i* *left* *my* telefono *in* *the* *car*", cont.Translate(0, 1));
	}

}
