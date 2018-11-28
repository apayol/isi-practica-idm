//MODIFICADO

import java.util.*;
import java.lang.String;

public class RomanNumeral {
	public static int convierte (String romanNumber) {

		if (romanNumber == ""){
			throw new IllegalArgumentException ("RomanNumeral.convierte");
		}

		int decimal = 0;
		int lastNumber = 0;
		//creamos las variables
		int m = 0;
		int d = 0;
		int c = 0;
		int l = 0;
		int x = 0;
		int v = 0;
		int i = 0;
		String romanNum = romanNumber.toUpperCase(); // caso de minusculas
		for (int y = romanNum.length() - 1; y >= 0 ; y--) {
			char romanChar = romanNum.charAt(y); // cogemos char a char
			switch (romanChar) {
	    case 'M':
	    	decimal = processDecimal(1000, lastNumber, decimal);
	    	lastNumber = 1000;
	    	m= m +1;
	      break;

			case 'D':
	    	decimal = processDecimal(500, lastNumber, decimal);
	    	lastNumber = 500;
	    	d= d +1;
	    	break;

	    case 'C':
	    	decimal = processDecimal(100, lastNumber, decimal);
	    	lastNumber = 100;
	    	c = c + 1;
	    	break;

			case 'L':
	    	decimal = processDecimal(50, lastNumber, decimal);
	     	lastNumber = 50;
	     	l= l +1;
	      break;

			case 'X':
	    	decimal = processDecimal(10, lastNumber, decimal);
	    	lastNumber = 10;
	    	x = x + 1;
	    	break;

	    case 'V':
	    	decimal = processDecimal(5, lastNumber, decimal);
			lastNumber = 5;
			v= v +1;
	      break;

	    case 'I':
	    	decimal = processDecimal(1, lastNumber, decimal);
	    	lastNumber = 1;
	    	i= i +1;
     		break;

	    default: //caso no romano
	    	throw new IllegalArgumentException ("RomanNumeral.convierte");
	    }
	  }
	  if (i>3 ||v>3 ||x>3 ||l>3 || c>3 ||d>3 || m>3) {
			throw new RuntimeException("Número romano no válido(tiene + de 3 letras =)");
	  }
	  return decimal;
	  }

		//necesario un boolean flag para numeros tipo IIII if (lastNumber == decimal && flag true error)
		public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
			if (lastNumber > decimal) {
				return lastDecimal - decimal;
			} else {
				return lastDecimal + decimal;
			}
		}

	  public static void main(String args[]) {
			RomanNumeral test = new RomanNumeral();

			System.out.println(test.convierte("XIV"));
	    System.out.println(test.convierte("MMCM"));
	    //System.out.println(test.convierte("IIIIIIII"));
	    //ERROR:  java -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar RomanNumeral
		//Sale 8 y luego salta la excepción. Debería salir directamente la excepción. Solucionado
	   // System.out.println(test.convierte("HJK"));
	    System.out.println(test.convierte("XXXX"));
	    }
}
