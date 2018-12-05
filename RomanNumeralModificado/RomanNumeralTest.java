//MODIFICADO

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith (Parameterized.class)
public class RomanNumeralTest
{
	public String roman;
	public int decimal;
	
	
	
	public RomanNumeralTest (String roman, int decimal)
   {
		this.roman = roman;
		this.decimal = decimal;
   }

	
		@Parameters
	public static Collection<Object[]> romanValues()
	{
		return Arrays.asList (new Object [][] {{"V", 5}, {"MXV", 1015}, {"CD", 400}, {"XXX", 30} ,{"V", 5}, {"MXV", 1015},{"XXX", 30}});
	}
	
	//@Parameters
	//public static Collection<Object[]> romanValues()
	//{
		//return Arrays.asList (new Object [][] { {"MXV", 5},{"XXXX", 40}, {"MXVI", 1015}, {"MXV", 5}, {"XXXX", 40} , {"MXVI", 1015}, {"Z", 5}, {"5", 5}, {"VIIII", 9}});
	//}
	
	
	
	@Test
	public void additionTest()
	{
		assertTrue ("Addition Test", decimal == RomanNumeral.convierte(roman));
	}
	//@Test
	//public void additionTest()
	//{
		//assertFalse ("Addition Test", decimal == RomanNumeral.convierte(roman));
	//}
 }
   
	
	
	// Test para String nulo
	//@Test (expected = IllegalArgumentException.class)
	//public void testForNullString()
	//{
		//RomanNumeral.convierte("");
	//}

	// Test para String ilegal
	//@Test (expected = IllegalArgumentException.class)
	//public void testForNoRoman()
	//{
		//RomanNumeral.convierte("HJK");
	//}

	 //Test para String ilegal (pero parecido a romano)
	 //@Test (expected = IllegalArgumentException.class)
	 //public void testForIllegalRoman()
	 //{
	 	//RomanNumeral.convierte("XIIII");
	 //}

	
	// Test para String romano
	//@Test
	//public void testForRoman()
	//{
		//assertTrue("Ese numero no es romano", 17 == RomanNumeral.convierte("XVII")); // Se imprimirá este msg si test falla
	//}
