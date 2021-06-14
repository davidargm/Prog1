package clase8_5;
/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando.*/

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
		int numero = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Ingrese el numero que desea borrar");
			numero = Integer.valueOf(entrada.readLine());
			buscarNumero(matInt, numero);
			}
		
		catch (Exception exc){
			System.out.println("Ha ingresado un numero invalido");
		}
		
		imprimir_matriz_int(matInt);
	}

	public static void buscarNumero(int[][] matInt, int num){
		int i = 0;
		int pos = 0;
		boolean encontro = false;
		while(i<MAXFILA && encontro==false){
			int j = 0;
			while(j<MAXCOLUMNA && encontro==false){
				if(matInt[i][j]==num){
					encontro=true;
					pos = j;
				}
				else{
					j++;
				}
			}
			if(encontro==false){
				i++;
			}	
		}
		if(encontro==true){
			corrimiento_izq(matInt[i],pos);
		}
		else{
			System.out.println("El numero "+num+" no se encuentra en la matriz");
		}
		
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
