package Clase7_10;
/*Hacer un programa que dado el arreglo definido y precargado permita
obtener a través de métodos la posición de inicio y la posición de fin de la
secuencia ubicada a partir de una posición entera ingresada por el
usuario. Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int pos;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			cargar_arreglo_aleatorio_secuencias_int(arrenteros);
			imprimir_arreglo_secuencias_int(arrenteros);
			System.out.println("Ingrese una posicion para saber el inicio y fin de la secuencia");
			pos = Integer.valueOf(entrada.readLine());
			if (arrenteros[pos] != 0){
				buscarInicioSecuencia(arrenteros, pos);
				buscarFinSecuencia(arrenteros, pos);
			}
			else {
				System.out.println("La posicion ingresada no esta dentro de una secuencia");
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		
	}
	public static void buscarInicioSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]>0){
			i--;			
		}
		System.out.println("La secuencia comienza en la posicion "+(i+1));
	}
	
	public static void buscarFinSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]!=0){
			i++;			
		}
		System.out.println("La secuencia finaliza en la posicion "+(i-1));
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
		for (int pos = 1; pos < MAX-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}

	//imprimir arreglo aleatorio de secuencias int
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
}
