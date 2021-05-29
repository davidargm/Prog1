package clase6_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Escribir un programa que mientras el usuario cargue desde
teclado un numero entero distinto de 0, imprima por
pantalla la suma que se obtiene de invocar un método
que calcula la sumatoria de los primeros 200 números
naturales (son números enteros en 1 y 200).*/

public class Main {
	public static final int MIN = 1;
	public static final int MAX = 200;
	public static void main(String[] args) {
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Ingrese un numero entero distinto de 0");
			numero = Integer.valueOf(entrada.readLine());
			while(numero != 0){
				imprimirSuma();
				System.out.println("Ingrese un numero entero distinto de 0");
				numero = Integer.valueOf(entrada.readLine());
			}
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	public static void imprimirSuma(){
		int suma = 0;
		for(int numeroSuma = MIN; numeroSuma<= MAX; numeroSuma++){
			suma += numeroSuma;
		}
		System.out.println("La suma de 1 a 200 es: " + suma);
	}
}
