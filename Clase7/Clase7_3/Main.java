package Clase7_3;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
menor posición del arreglo.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int posicion = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese una posicion para el corrimiento a izquierda: ");
			posicion = Integer.valueOf(entrada.readLine());
			corrimiento_izq(arrenteros, posicion);
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		System.out.println("El nuevo arreglo ordenado es: ");
		imprimir_arreglo_int(arrenteros);	
	}
	
	public static void corrimiento_izq(int [] arrenteros, int pos){
		int i = pos;
		while (i < MAX-1){
			arrenteros[i] = arrenteros[i+1];
			i++;
		}
	}
	
	public static void cargar_arreglo_aleatorio_int(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}
}
