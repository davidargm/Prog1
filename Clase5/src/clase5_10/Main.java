package clase5_10;

/*Escribir un programa que mientras el usuario ingresa un numero de mes
(entero) entre 1 y 12 inclusive, muestre por pantalla la cantidad de d�as del
mes ingresado (suponer febrero de 28 d�as).*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int mes;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Ingrese un numero de mes: ");
			mes = Integer.valueOf(entrada.readLine());
			
			while (mes >= 1 && mes <= 12){
				switch (mes) {
				 case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
					 System.out.println("El mes tiene 31 dias");
					 break;
				 }
				 case 4: case 6: case 9: case 11: {
					 System.out.println("El mes tiene 30 dias");
					 break;
				 }
				 case 2: {
					 System.out.println("El mes tiene 28 dias");
					 break;
				 }
				}
				
				System.out.println("Ingrese un numero de mes: ");
				mes = Integer.valueOf(entrada.readLine());
			}			
		}
		catch (Exception exc){
			System.out.println("Ha ingresado un valor invalido");
		}
		
		System.out.println("Ha ingresado un valor invalido");
	}
}
