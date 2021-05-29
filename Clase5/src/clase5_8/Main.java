package clase5_8;
/*Escribir un programa que mientras el usuario ingrese un caracter letra
minúscula, acumule la cantidad de vocales que ingreso. Finalmente
muestre por pantalla dicha cantidad.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		char caracter; 
	    int suma;
	    BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
	    
	    try {
	      System.out.println("Ingrese un caracter letra minuscula. Para salir ingrese un valor fuera del rango");
	      caracter = entrada.readLine().charAt(0);
	      suma = 0;
	      while ((caracter >= 'a') && (caracter <= 'z')) {
	        if ((caracter == 'a') || (caracter == 'e') || (caracter == 'i') || (caracter == 'o') || (caracter == 'u')){
	          suma++;
	        }
	        System.out.println("Ingrese un caracter letra minuscula. Para salir ingrese un valor fuera del rango");
	      	caracter = entrada.readLine().charAt(0);
	      }
	      System.out.println("Se ingresaron " + suma + " letras vocales");
	    }
	    catch (Exception exc) {
	   		System.out.println(exc);
	    }

	}

}
