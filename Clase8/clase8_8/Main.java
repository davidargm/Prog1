package clase8_8;
/*Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y elimine la primer ocurrencia de numero en la
fila indicada (un número igual) si existe.*/

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
		int fila = -1;
		int numero = -1;
		cargar_matriz_aleatorio_int(matInt);
		for(int i=0;i<MAXFILA;i++){
			ordenar_arreglo_seleccion(matInt[i]);
		}
		imprimir_matriz_int(matInt);
		fila = getFila();
		numero = getNumero();
		buscarNumero(matInt[fila], numero);
		imprimir_matriz_int(matInt);
	}
	
	public static void buscarNumero(int[]arrInt, int num){
		int pos = MAXCOLUMNA;
		pos = buscarPosicion(arrInt, num);
		if(pos!=MAXCOLUMNA){
			corrimiento_izq(arrInt,pos);
		}
		if(pos==MAXCOLUMNA){
			System.out.println("El numero ingresado no se encuentra en la fila");
		}
	}
	
	public static int buscarPosicion(int[]arrInt, int num){
		int pos = 0;
		while(pos<MAXCOLUMNA && arrInt[pos]!=num){
			pos++;
		}
		return pos;
	}
	
	public static void corrimiento_izq(int [] arrenteros, int pos){
		int i = pos;
		while (i < MAXCOLUMNA-1){
			arrenteros[i] = arrenteros[i+1];
			i++;
		}
	}
	
	public static int getFila(){
		int fila = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Ingrese la fila que desea modificar");
			fila = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return fila;
	}
	
	public static int getNumero(){
		int num = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Ingrese el numero que desea borrar");
			num = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return num;
	}
	
	public static void ordenar_arreglo_seleccion(int[]arr) {
		int pos_menor, tmp;
		for (int i = 0; i < MAXFILA; i++) {
			pos_menor = i;
			for (int j = i + 1; j < MAXCOLUMNA; j++){
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
