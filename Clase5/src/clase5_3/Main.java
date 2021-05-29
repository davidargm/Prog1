package clase5_3;
/*Escribir un programa que mientras el usuario ingresa un caracter distinto
del caracter ‘*’, muestre por pantalla si es caracter digito, o si es caracter
vocal minúscula.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		
		char caracter;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un caracter distinto de '*': ");
			caracter = entrada.readLine().charAt(0);
			
			while (caracter != '*'){
				if ((caracter>='0') && (caracter<='9')){
					System.out.println("Es un numero");
				}
				else if ((caracter>='a') && (caracter<='z')){
					System.out.println("Es una letra minuscula");
				}
				else {
					System.out.println("No es un caracter valido");
				}
				
				System.out.println("Ingrese un caracter: ");
				caracter = entrada.readLine().charAt(0);
			}
			
			System.out.println("Ha salido del programa");
		}
		
		catch (Exception exc){
			System.out.println(exc);
		}
	}
}
