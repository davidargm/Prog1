package clase8_13;
/*Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada, y un número entero ingresado por el usuario, elimine de cada fila
las secuencias de tamaño igual al número ingresado.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int [][] matint = new int[MAXFILA][MAXCOLUMNA];
		int tamanio = -1;
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el tamanio de secuencia que desea borrar");
		tamanio = getInput();
		for(int i=0;i<MAXFILA;i++){
			int j = 0;
			while(j<MAXCOLUMNA-1){
				int inicio = buscarInicio(matint[i],j);
				int fin = buscarFin(matint[i],inicio);
				if(fin-inicio+1==tamanio){
					for(int k=inicio;k<=fin;k++){
						corrimiento_izq(matint[i], inicio);
					}
				}
				else{
					j=fin+1;
				}
			}
		}
		System.out.println("La matriz queda de la siguiente manera");
		imprimir_matriz_int(matint);

	}
	
	public static void corrimiento_izq(int[] arrenteros, int pos){
		while (pos < MAXCOLUMNA-1){
			arrenteros[pos] = arrenteros[pos+1];
			pos++;
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
	
	
	public static int buscarInicio(int[]arrint, int pos){
		int i = pos;
		while(arrint[i]==0 && i<MAXCOLUMNA-1){
			i++;
		}
		return i;
	}
	
	public static int buscarFin(int[]arrint, int pos){
		while(arrint[pos]!=0 && pos<MAXCOLUMNA){
			pos++;
		}
		return pos-1;
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
	
	public static void cargar_matriz_aleatorio_secuencias_int(int [][]mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
		}
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA-1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if (r.nextDouble()>probabilidad){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}
}
