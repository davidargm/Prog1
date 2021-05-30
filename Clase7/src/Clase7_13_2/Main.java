package Clase7_13_2;
/*Hacer un programa que dado el arreglo definido y precargado, y un número
entero ingresado por el usuario, elimine las secuencias de tamaño igual al
número ingresado.*/

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
		int tamanio = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			cargar_arreglo_aleatorio_secuencias_int(arrenteros);
			imprimir_arreglo_secuencias_int(arrenteros);
			System.out.println("Ingrese un largo de secuencia");
			tamanio = Integer.valueOf(entrada.readLine());
			buscarSecuencia(arrenteros, tamanio);
			imprimir_arreglo_secuencias_int(arrenteros);
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void buscarSecuencia(int [] arr, int tamanio){
		int i = 0;
		while(i< MAX-1){
			if(arr[i]==0){
				i++;
			}
			else{
				int fin = buscarFinSecuencia(arr, i);
				int largo = fin - i +1;
				if(largo == tamanio){
					eliminarSecuencia(arr, fin, i);
				}
				i = fin+1;
			}
		}
	}
	
	public static int buscarFinSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]!=0){
			i++;			
		}
		return i-1;
	}
	
	//public static void eliminarSecuencia(int [] arr, int inicio, int fin){
	public static void eliminarSecuencia(int [] arrenteros,int fin, int inicio){
		for(int i = inicio; i <= fin; i++){
			int indice = inicio;
			while (indice < MAX-1){
				arrenteros[indice] = arrenteros[indice+1];
				indice++;
			}
		}
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
