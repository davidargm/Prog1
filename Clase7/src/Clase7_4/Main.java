package Clase7_4;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo (posición
0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y
colocar el numero en el arreglo en la posición indicada.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			cargar_arreglo_aleatorio_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese el numero que desea insertar al inicio: ");
			numero = Integer.valueOf(entrada.readLine());
			insertar_numero_al_inicio(arrenteros, numero);
			imprimir_arreglo_int(arrenteros);
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	public static void insertar_numero_al_inicio(int [] arrenteros, int num){
		int indice = MAX-1;
		while (indice > 0){
			arrenteros[indice] = arrenteros[indice-1];
			indice--;
		}
		
		arrenteros[0]= num;
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
