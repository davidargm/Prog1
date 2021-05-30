package Clase7_11;
/*Hacer un programa que dado el arreglo definido y precargado permita
encontrar la posición de inicio y fin de la secuencia cuya suma de valores sea
mayor.*/

import java.util.Random;

public class Main {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		
		cargar_arreglo_aleatorio_secuencias_int(arrenteros);
		imprimir_arreglo_secuencias_int(arrenteros);
		getSecuenciaMayor(arrenteros);
		
	}
	public static void getSecuenciaMayor(int [] arr){
		int i = 0;
		int inicioMax = 0;
		int finMax = 0;
		int sumaMax = 0;
		int inicio = 0;
		int fin = 0;
		int sumaTemporal = 0;
		
		while (i < MAX-1){
			if (arr[i]==0){
				i++;
			}
			else {
				inicio = i;
				fin = buscarFinSecuencia(arr, inicio);
				sumaTemporal = sumarSecuencia(arr, inicio, fin);
				i = fin+1;
				if (sumaTemporal > sumaMax){
					sumaMax = sumaTemporal;
					inicioMax = inicio;
					finMax = fin;
				}
			}
		}
		System.out.println("La mayor secuencia comienza en "+inicioMax+", finaliza en "+finMax+" y suma un total de "+sumaMax);
	}
	public static int sumarSecuencia(int [] arr, int inicio, int fin){
		int suma = 0;
		for(int i = inicio; i <= fin; i++){
			suma += arr[i];
		}
		return suma;
	}
	
	public static int buscarFinSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]!=0){
			i++;			
		}
		return i;
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