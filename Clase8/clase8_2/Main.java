package clase8_2;

/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima.*/

import java.util.Random;

public class Main {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int cantidadPares = 0;
		int[][]matInt = new int[MAXFILA][MAXCOLUMNA];
		
		cargar_matriz_aleatorio_int(matInt);
		imprimir_matriz_int(matInt);
		cantidadPares=contadorPares(matInt);
		System.out.println("Hay "+cantidadPares+" numeros pares en la matriz");
	}
	
	public static int contadorPares(int[][]matInt){
		int pares = 0;
		for(int i=0;i<MAXFILA;i++){
			for(int j=0;j<MAXCOLUMNA;j++){
				if(matInt[i][j]%2==0){
					pares++;
				}
			}
		}
		return pares;
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
