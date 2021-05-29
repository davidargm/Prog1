package clase4_1;

/*Escribir un programa que permita el ingreso de un carácter y realice:
_ imprima es carácter dígito si el carácter ingresado es carácter
dígito,
_ o imprima no es carácter dígito*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		char caracter;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
			System.out.println("Ingrese un caracter: ");
			
			caracter = entrada.readLine().charAt(0);
			
			if (((caracter >= 'a') && (caracter <= 'z')) || ((caracter >= 'A') && (caracter <= 'Z')) || ((caracter >= '0') && (caracter <= '9'))) {
				System.out.println("Es un caracter");
			}
			
			else {
				System.out.println("No es un caracter");
			}
		}
		
		catch (Exception exc) {
			System.out.println(exc);
		}
	}
}
