package Clase7_1;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.*/

import java.util.Random;

public class Main {
	public static int MAX = 9;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		
		try{
			cargar_arreglo_aleatorio_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			invertir_arreglo(arrenteros);
			
			
			System.out.println("El nuevo arreglo queda: ");
			imprimir_arreglo_int(arrenteros);
			
		}
		catch (Exception exc) {
			System.out.println(exc);
		}

	}
	
	public static void invertir_arreglo(int [] arr){
		/*Variable temporal donde guardo el numero del arreglo*/
		int temp;
		for (int pos = 0; pos < (MAX)/2; pos++){
			temp = arr[pos];
			arr[pos] = arr[(MAX-1) - pos];
			arr[(MAX-1) - pos] = temp;
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
