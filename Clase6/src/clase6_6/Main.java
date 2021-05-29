package clase6_6;
/*Escribir un programa que mientras que el usuario ingrese un número entero
natural, llame a un método que calcule la sumatoria entre 1 y dicho
numero y se lo retorne como resultado.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static final int uno = 1;
	public static void main(String[] args) {
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese un numero entero natural: ");
		
		try{
			numero = Integer.valueOf(entrada.readLine());
			while(numero >= 1){
				int total = suma(numero);
				System.out.println("La suma de " + uno + "+" + numero + " da como resultado = " + total);
				System.out.println("Ingrese un numero entero natural: ");
				numero = Integer.valueOf(entrada.readLine());
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	public static int suma(int numeroSuma){
		return numeroSuma + uno;
	}
}
