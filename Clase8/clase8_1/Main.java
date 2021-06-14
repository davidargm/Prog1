package clase8_1;
/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.*/

import java.util.Random;

public class Main {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int[][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		
		cargar_matriz_aleatorio_int(matint);
		imprimir_matriz_int(matint);
		
		for(int i=0; i<MAXFILA; i++){
			invertir_arreglo(matint[i]);
		}
		System.out.println("La matriz invertida es: ");
		imprimir_matriz_int(matint);
	}
	
	public static void invertir_arreglo(int[] arr){
		int i = 0;
		int j = MAXCOLUMNA -1;
		int temp = 0;
		while(i<j){
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}
	}
	
	public static void cargar_matriz_aleatorio_int(int [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR);
			}
		}
	}
	
	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}

}
