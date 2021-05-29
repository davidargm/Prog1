package clase6_5;
/*Escribir un programa que mientras el usuario ingresa un caracter distinto
del caracter ‘*’, invoque a un método que imprima si es caracter dígito o
caracter letra minúscula, y si es letra minúscula imprimir si es vocal o
consonante.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		char caracter;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese un caracter distinto de * ");
		try{
			caracter = entrada.readLine().charAt(0);
			while(caracter != '*'){
				tipoDeCaracter(caracter);
				System.out.println("Ingrese un caracter distinto de * ");
				caracter = entrada.readLine().charAt(0);
			}
			
			System.out.println("Ha salido del programa");
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	public static void tipoDeCaracter(char caracter){
		if (caracter >= 'a' && caracter <= 'z'){
			System.out.println(caracter + " es una letra minuscula");
			if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
				System.out.println(caracter + " es una vocal");
			}
		}
		else if (caracter >= '0' && caracter <= '9'){
			System.out.println(caracter + " es un digito");
		}
		
		else {
			System.out.println(caracter + " no es ni letra minuscula ni digito");
		}
	}
}
