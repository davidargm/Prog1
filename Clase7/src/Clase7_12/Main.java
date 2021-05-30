package Clase7_12;
/*Hacer un programa que dado el arreglo definido y precargado permita
encontrar la posición de inicio y fin de la anteúltima secuencia (considerar
comenzar a buscarla a partir de la ultima posición del arreglo).*/

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
		getAnteultimaSecuencia(arrenteros);
	}
	
	public static void getAnteultimaSecuencia(int [] arr){
		int i = MAX-1;
		int contador = 0;
		int inicio = 0;
		int fin = 0;
		while(i > 0 && contador < 2){
			if(arr[i]==0){
				i--;
			}
			else{
				if (contador==0){
					i = buscarInicioSecuencia(arr, i)-1;
					contador++;
				}
				else{
					fin = i;
					inicio = buscarInicioSecuencia(arr, i);
					contador++;
				}
			}
		}
		if (arr[fin]==0){
			System.out.println("Solo hay una secuencia en el arreglo");
		}
		else{
			System.out.println("La anteultima secuencia comienza en "+inicio+" y termina en "+fin);
		}
	}
	
	public static int buscarInicioSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]>0){
			i--;			
		}
		return i+1;
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
