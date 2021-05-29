package clase4_6;
/*Construir un programa que solicite desde teclado un número de
mes y posteriormente notifique por pantalla la cantidad de días
de ese mes. En el caso de que ingrese 2 como número de mes
(febrero), para imprimir la cantidad de días deberá solicitar
ingresar un número de anio (no usar ñ), para determinar si es
bisiesto o no con la siguiente sentencia:
_si ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) es verdadero,
entonces es bisiesto.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int numeroMes;
		int anio;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un numero del mes: ");
			numeroMes = Integer.valueOf(entrada.readLine());
			
			if (numeroMes >= 1 && numeroMes <= 12 && numeroMes != 2){
				switch (numeroMes){
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:{
						System.out.println("El mes tiene 31 dias");
						break;
					}
					case 4: case 6: case 9: case 11:{
						System.out.println("El mes tiene 30 dias");
						break;
					}
				}
			}
			else if (numeroMes == 2){
				System.out.println("Ingrese el anio: ");
				anio = Integer.valueOf(entrada.readLine());
				
				if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
					System.out.println("El mes tiene 29 dias");
				}
				else {
					System.out.println("El mes tiene 28 dias");
				}
			}
			else{
				System.out.println("Ingrese un numero de mes valido");
			}
		}
		
		catch (Exception exc){
			System.out.println("Ingrese un numero de mes valido");
		}

	}

}
