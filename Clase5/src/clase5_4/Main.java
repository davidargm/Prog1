package clase5_4;

/*Escribir un programa que mientras que el usuario ingrese un número entero
distinto de 0, pida ingresar otro número entero y lo imprima.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int num;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un numero entero distinto de 0: ");
			num = Integer.valueOf(entrada.readLine());
			
			while (num!=0){
				System.out.println("El numero ingresado es: " + num);
				System.out.println("Ingrese otro numero entero distinto de 0: ");
				num = Integer.valueOf(entrada.readLine());
			}
			
			System.out.println("Ha ingresado el numero 0");
		}
		
		catch (Exception exc){
			System.out.println("No ha ingresado un numero valido");
		}
	}
}
