package clase5_7;

/*Escribir un programa que mientras que el usuario ingrese un número entero
entre 1 y 10 inclusive, lleve la suma de los números ingresados y la cantidad
de sumas que realizó. Finalmente, cuando sale del ciclo muestre por
pantalla el resultado del promedio de todo lo ingresado.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int entero;
	    int suma; 
	    int contador; 
	    double promedio;
	    BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
	    
	    try {
	      System.out.println("Ingrese un valor del 1 al 10. Para finalizar ingrese un valor fuera del rango");
	      entero = Integer.valueOf(entrada.readLine());
	      suma = 0; 
	      contador = 0;
	      while ((entero >= 0) && (entero <= 10)) {
	        suma = suma + entero;
	        contador++;
	        System.out.println("Ingrese un valor del 1 al 10. Para finalizar ingrese un valor fuera del rango");
	     	entero = Integer.valueOf(entrada.readLine());
	      }
	      promedio = (double)suma/contador;
	      System.out.println("El promedio de los valores ingresados es: " + promedio);
	    }
	    catch (Exception exc) {
	    	System.out.println(exc);
	    }

	}

}
