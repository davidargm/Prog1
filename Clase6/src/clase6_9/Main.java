package clase6_9;
/*Realizar un programa que dado dos números enteros y un
carácter, todos ingresados por el usuario, muestre por
pantalla el resultado de la operación matemática básica
considerando el valor del carácter. Si ingreso el caracter:
– ‘a’ la suma, ‘b’ la resta, ‘c’ la multiplicación y ‘d’ la división
entre ambos números.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		char caracter;
		int num1;
		int num2;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese un numero entero: ");
			num1 = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un numero entero: ");
			num2 = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un caracter. ‘a’ la suma, ‘b’ la resta, ‘c’ la multiplicación y ‘d’ la división");
			caracter = entrada.readLine().charAt(0);
			
			imprimirOperacion(caracter,num1,num2);
			}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void imprimirOperacion(char caracter, int num1, int num2){
		if (caracter == 'a'){
			System.out.println(num1 + "+" + num2 + " = " + (num1+num2));
		}
		else if (caracter == 'b'){
			System.out.println(num1 + "-" + num2 + " = " + (num1-num2));
		}
		else if (caracter == 'c'){
			System.out.println(num1 + "*" + num2 + " = " + (num1*num2));
		}
		else if (caracter == 'd'){
			System.out.println(num1 + "/" + num2 + " = " + (num1/num2));
		}
	}
}
