package clase4_4;

/*Hacer un programa que solicite la carga desde consola de un
numero entero y realice:
_si el numero es positivo, imprima “grande” si es mayor a 100 o “chico “ si
es menor. Además deberá imprimir que el valor es positivo.
_si no lo es, imprima si el numero es par, o si el numero es múltiplo de 3, o
ninguna de las opciones anteriores.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int num;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Ingrese un numero entero: ");
			num = Integer.valueOf(entrada.readLine());
			
			if (num>0){
				System.out.println(num + " es positivo");
				if (num>100){
					System.out.println(num + " es grande");
				}
				else {
					System.out.println(num + " es chico");
				}
			}
			
			else {
				if (num % 2 == 0){
					System.out.println("Es par");
				}
				else if (num % 3 == 0){
					System.out.println("Es multiplo de 3");
				}
				else {
					System.out.println("No es ni par ni multiplo de 3");
				}
			}
		}
		catch (Exception exc) {
			System.out.println(exc);
		}

	}

}
