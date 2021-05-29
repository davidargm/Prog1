package clase6_3;

/*Escribir un programa que mientras el usuario cargue desde
teclado un caracter letra minúscula, llame a un método
que imprime por pantalla la tabla de multiplicar de 9.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static final int MINMULTIPLICADOR = 1;
	public static final int MAXMULTIPLICADOR = 10;
	public static final int VALOR = 9;
	
	public static void main(String[] args) {
		char caracter;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese un caracter: ");
			caracter = entrada.readLine().charAt(0);
			while (caracter >= 'a' && caracter <= 'z'){
				imprimir_tabla_multiplicar_9();
				System.out.println("Ingrese un caracter: ");
				caracter = entrada.readLine().charAt(0);
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	public static void imprimir_tabla_multiplicar_9(){
		for (int multiplicador = 1; multiplicador <= MAXMULTIPLICADOR; multiplicador++){
			System.out.println(multiplicador + " * " + VALOR + " = " + multiplicador*VALOR);
		}
	}
}
