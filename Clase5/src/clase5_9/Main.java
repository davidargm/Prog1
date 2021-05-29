package clase5_9;

/*Escribir un programa que mientras el usuario ingrese un caracter letra
minúscula, se quede con la menor y la mayor letra ingresada. Finalmente
muestre por pantalla dichas letras.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		char letra;
		char letraMenor = ' ';
		char letraMayor = ' ';
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println ("Ingresar una letra minuscula. Para salir ingresar un valor fuera del rango");
			letra = entrada.readLine().charAt(0);
			
			while (letra>= 'a' && letra<='z'){
				
				if (letra >= letraMayor){
					if (letraMenor == ' '){
						letraMenor = letraMayor;
						letraMayor = letra;
					}
					else {
						letraMayor = letra;
					}
				}
				else if (letraMenor == ' ' || letra<letraMenor){
					letraMenor = letra;
				}
				
				System.out.println ("Ingresar una letra minuscula. Para salir ingresar un valor fuera del rango");
				letra = entrada.readLine().charAt(0);
			}
			
			System.out.println("Letra menor: " + letraMenor);
			System.out.println("Letra mayor: " + letraMayor);
		}
		
		catch (Exception exc) {
	    	System.out.println(exc);
	    }
		
	}
}
