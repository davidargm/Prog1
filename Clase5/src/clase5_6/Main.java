package clase5_6;
/*Escribir un programa que mientras que el usuario ingrese un número entero
entre 1 y 10 inclusive, lleve la suma de los números ingresados. Finalmente,
cuando sale del ciclo muestre por pantalla el resultado de la suma.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int entero;
	    int suma = 0; 
	    BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
	    
	    try {
	      System.out.println("Ingrese un valor del 1 al 10. Para obtener el resultado de la suma, ingrese un valor fuera del rango");
	      entero = Integer.valueOf(entrada.readLine());
	      while ((entero >= 0) && (entero <= 10)) {
	        suma = suma + entero;
	        System.out.println("Ingrese un valor del 1 al 10. Para obtener el resultado de la suma, ingrese un valor fuera del rango");
	      	entero = Integer.valueOf(entrada.readLine());  
	      }
	      System.out.println("El resultado es: " + suma);
	    }
	    catch (Exception exc) {
	    	System.out.println(exc);
	    }

	}

}
