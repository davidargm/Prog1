package clase5_1;
/*Escribir un programa que mientras el usuario ingrese un n�mero entero
menor que 10 y mayor a 1, muestre por pantalla si el n�mero es m�ltiplo de
2 y m�ltiplo de 3 simult�neamente. (�Los valores mencionados deber�an
ser constantes?. De a poco habr�a que definirlos como constantes).*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int num;
		final int MIN = 1;
		final int MAX = 10;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese un numero entero menor que 10 y mayor que 1: ");
			num = Integer.valueOf(entrada.readLine());
			
			while (num> MIN && num < MAX){
				if (num%2 == 0 && num%3 == 0){
					System.out.println(num + " es multiplo de 2 y 3");
				}
				else {
					System.out.println(num + " no es multiplo de 2 y 3");
				}
				System.out.println("Ingrese un numero entero menor que 10 y mayor que 1: ");
				num = Integer.valueOf(entrada.readLine());
			}
			
			System.out.println("Ha ingresado un numero fuera del rango permitido");
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		
	}

}
