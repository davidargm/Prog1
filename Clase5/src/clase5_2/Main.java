package clase5_2;

/*Escribir un programa que solicite al usuario el ingreso de un número entero
positivo, y muestre por pantalla los valores entre el numero ingresado y 0
de manera decreciente.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int num;
		final int MIN = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese un numero entero positivo: ");
			num = Integer.valueOf(entrada.readLine());
			System.out.println("Los valores entre " + num + " y " + MIN + " son: ");		
			while (num> MIN && num != 1){
				num--;
				System.out.println(num);
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}

	}

}
