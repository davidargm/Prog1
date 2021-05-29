package clase6_7;
/*Escribir un programa que mientras el usuario ingresa un numero de mes
(entero) entre 1 y 12 inclusive, muestre por pantalla la cantidad de días del
mes ingresado (suponer febrero de 28 días) (¿mostrar por pantalla la
cantidad de días del mes debería realizarse con un método? Debería).*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		int mes;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese un numero del mes: ");
		
		try{
			mes = Integer.valueOf(entrada.readLine());
			while(mes >= 1 && mes <= 12){
				int cantidadDias;
				cantidadDias = diasMes(mes);
				System.out.println("El mes " + mes + " tiene " + cantidadDias + " dias");
				System.out.println("Ingrese un numero del mes: ");
				mes = Integer.valueOf(entrada.readLine());
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}

	}
	public static int diasMes(int mes){
		int dias = 0;
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
			dias = 31;
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
			dias = 30;
		}
		else if (mes == 2){
			dias = 28;
		}
		return dias;
	}

}
