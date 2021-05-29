package clase5_5;
/*Escribir un programa que mientras que el usuario ingrese un caracter dígito
o caracter letra minúscula, imprima si es caracter dígito o caracter letra
minúscula, y si es letra minúscula imprimir si es vocal o consonante.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		char caracter; 
	    BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
	    
	    try {
	      System.out.println("Ingrese un caracter");
	      caracter = entrada.readLine().charAt(0);
	      while (((caracter >= '0') && (caracter <= '9')) || ((caracter >= 'a') && (caracter <= 'z'))) {
	        if ((caracter >= '0') && (caracter <= '9')) {
	          System.out.println(caracter + " es un digito");
	        } else if ((caracter == 'a') || (caracter == 'e') || (caracter == 'i') || (caracter == 'o') || (caracter == 'u')){
	          System.out.println(caracter + " es una letra minuscula vocal");
	        } else {
	          System.out.println(caracter + " es una letra minuscula consonante");
	        }
	      System.out.println("Ingrese un caracter");
	      caracter = entrada.readLine().charAt(0);
	      }
	      System.out.println("El caracter ingresado no es un digito ni una minuscula");
	    }
	    catch (Exception exc) {
	    	System.out.println(exc);
	    }

	}

}
