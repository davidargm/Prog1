package clase5_11;
/*Escribir un programa que mientras que el usuario ingrese un caracter letra
minúscula, pida ingresar un numero entero. Si el número ingresado está
entre 1 y 5 inclusive deberá imprimir la tabla de multiplicar de dicho
numero.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		char caracter;
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese una letra minuscula para comenzar");
			caracter = entrada.readLine().charAt(0);
			
			while (caracter >= 'a' && caracter <= 'z'){
				System.out.println("Ingrese una numero: ");
				numero = Integer.valueOf(entrada.readLine());
				
				if (numero >= 1 && numero <= 5){
					System.out.println("La tabla de multiplicar de " + numero + " es: ");
					for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
						System.out.println(numero + "*" + multiplicador + " = " + numero*multiplicador);
					}
				}
			}
		}
		catch (Exception exc){
			System.out.println("Ha ingresado un valor invalido");
		}
	}
}
