package ht7.main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class ControladorTest extends TestCase {
	Controlador cont = new Controlador();
	@Test
	void test() {
		String testString = "cellphone,Telefono,telephone portable";
		//assertEquals("cellphone", cont.separarPalabras(testString));
	}

}
