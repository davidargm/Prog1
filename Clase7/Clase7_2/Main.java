package Clase7_2;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima.*/
import java.util.Random;

public class Main {
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		cargar_arreglo_aleatorio_int(arrenteros);
		imprimir_arreglo_int(arrenteros);
		contadorPares(arrenteros);
		
	}
	
	public static void contadorPares(int [] arr){
		int contador = 0;
		for (int pos = 0; pos < MAX; pos++){
			if (arr[pos]%2 == 0){
				contador++;
			}
		}
		System.out.println("Hay "+contador+" numeros pares en el arreglo.");
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
