package clase4_3;

/*Escribir un programa que ingrese un número entero por teclado y
realice:
_ imprima es múltiplo de 6 y de 7 si cumple con esa condición,
_ o imprima es mayor a 30 y múltiplo de 2 si cumple con esa
condición,
_ imprima si el cociente de la división de dicho número con 5 es
mayor a 10 sin importar las condiciones previas.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {
		int num1;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Ingrese un numero: ");
			num1 = Integer.valueOf(entrada.readLine());
			
			if ((num1 % 6 == 0) && (num1 % 7 == 0)){
				System.out.println(num1 + " es multipo de 6 y 7");
			}
			else if ((num1 > 30) && (num1 % 2 == 0)){
				System.out.println(num1 + " es mayor a 30 y múltiplo de 2");
			}
			
			
			if (num1 / 5 > 10){
				System.out.println(num1 + "/5 es mayor a 10");
			}
			else {
				System.out.println(num1 + "/5 no es mayor a 10");
			}
		}
		
		catch (Exception exc){
			System.out.println(exc);
		}

	}

}
