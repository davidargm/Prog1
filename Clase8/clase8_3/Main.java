package clase8_3;

/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario una posición fila, columna y realice un corrimiento a
izquierda.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	
	public static void main(String[] args) {
		int[][]matInt = new int[MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_int(matInt);
		imprimir_matriz_int(matInt);
		int fila = 0;
		int columna = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Ingrese un numero de fila");
			fila = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un numero de columna");
			columna = Integer.valueOf(entrada.readLine());
			
			if(fila<0 || fila>MAXFILA || columna<0 || columna>MAXCOLUMNA){
				System.out.println("Ha ingresado un numero de fila o columna invalido");
			}
			else{
				corrimiento_izq(matInt[fila],columna);
			}
			
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		
		imprimir_matriz_int(matInt);
	}
	
	public static void corrimiento_izq(int[] arrenteros, int pos){
		int i = pos;
		while (i < MAXCOLUMNA-1){
			arrenteros[i] = arrenteros[i+1];
			i++;
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

