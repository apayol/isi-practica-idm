//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class DescuentoBlackFridayTestModificado
{

	// // Test con precio entero (0 céntimos)
	// @Test
	// public void testForZeroDecimal ()
	// {
	// 	assertTrue("testForZeroDecimal_Error",		// Se imprimirá este msg si test falla
	// 		42.0 == DescuentoBlackFriday.PrecioFinal(60.0));
	// }
	//
	// //Test con precio orignal decimal (céntimos != 0)
	// @Test
	// public void testForDecimal()
	// {
	// 	assertTrue("testForDecimal_Error",		// Se imprimirá este msg si test falla
	// 		41.93 == DescuentoBlackFriday.PrecioFinal(59.90));
	// }

	//Test con precio original negativo
	@Test (expected = IllegalArgumentException.class) // Este test decora la anotación @Test con la clase de la excepción esperada.
	public void testForNegativePrice()
	{
		DescuentoBlackFriday.PrecioFinal(-1.0);
	}

	//Test con precio original cero
	@Test (expected = IllegalArgumentException.class)
	public void testForZeroPrice()
	{
		DescuentoBlackFriday.PrecioFinal(0.0);
	}
	// Los dos test siguientes dependen de si el dia actual es Black Friday o no. 
	// Test con precio original válido => Si NO es Black Friday, el test debe fallar.
	@Test
	public void testForValidPrice_BlackFriday()
	{
		assertTrue("testForValidPrice_Error", 70.0 == DescuentoBlackFriday.PrecioFinal(100.0)); // Se imprimirá este msg si test falla
	}

	// Test con precio original válido => Si es Black Friday, el test debe fallar.
	@Test
	public void TestforValidPrice()
	{
		assertTrue("testForValidPrice_Error", 100.0 == DescuentoBlackFriday.PrecioFinal(100.0)); // Se imprimirá este msg si test falla
	}
}
