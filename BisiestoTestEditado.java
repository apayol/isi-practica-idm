//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class BisiestoTestEditado
{

	//Test para comprobar que con año negativo se eleva la excepción.
	@Test (expected = IllegalArgumentException.class) // Este test decora la anotación @Test con la clase de la excepción esperada.
	public void testForNegativeYear()
	{
		Bisiestos.esBisiesto(-1);
	}

	//Test para comprobar que año 0 no es bisiesto
	@Test
	public void testForZeroYear()
	{
		assertFalse(Bisiestos.esBisiesto(0));
	}

	//Test para comprobar año múltiplo de 4
	@Test
	public void testMult4()
	{
		assertTrue(Bisiestos.esBisiesto(4));
	}

	//Test para comprobar año múltiplo de 100 pero no de 400
	@Test
	public void testMult100()
	{
		assertFalse(Bisiestos.esBisiesto(100));
	}

	//Test para comprobar año múltiplo de 400
	@Test
	public void testMult400()
	{
		assertTrue(Bisiestos.esBisiesto(400));
	}

	//Test para comprobar año no múltiplo de 4
	@Test
	public void testNotMult4()
	{
		assertFalse(Bisiestos.esBisiesto(101));
	}
}
