package clase8_9;
/*Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
se encuentra precargada, solicite al usuario el ingreso de una fila y dos
números enteros (columnas de la matriz), y ordene de forma creciente la
matriz en la fila indicada entre las dos posiciones columnas ingresadas.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int[][]matInt = new int[MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_int(matInt);
		imprimir_matriz_int(matInt);
		System.out.println("Ingrese una numero de fila");
		int fila = getInput();
		System.out.println("Ingrese una posicion del arreglo");
		int col1 = getInput();
		System.out.println("Ingrese otra posicion del arreglo");
		int col2 = getInput();
		
		if(col1>col2){
			int temp;
			temp=col1;
			col1=col2;
			col2=temp;
		}
		
		ordenar_arreglo_seleccion(matInt[fila], col1, col2);
		imprimir_matriz_int(matInt);
	}
	
	public static void ordenar_arreglo_seleccion(int[]arr, int col1, int col2) {
		int pos_menor, tmp;
		for (int i = col1; i < col2; i++) {
			pos_menor = i;
			for (int j = i + 1; j <= col2; j++){
				if (arr[j] < arr[pos_menor]) {
					pos_menor = j;
				}
			}		
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
		}
	}
	
	public static int getInput(){
		int input = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			input = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return input;
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
