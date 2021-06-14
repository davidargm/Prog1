package clase8_10;
/*Se tiene una matriz de enteros de tamaño 4*20 de secuencias de números
entre 1 y 9 (por cada fila), separadas por 0. La matriz esta precargada, y
además cada fila empieza y termina con uno o más separadores 0.
Además, se tiene una matriz de caracteres de tamaño 4*20 de secuencias de
caracteres letras minúsculas entre ‘a’ y ‘z’ (por cada fila), separadas por ‘ ’
(espacios). La matriz esta precargada, y además cada fila empieza y termina
con uno o más separadores ‘ ’.
Considere para los siguientes ejercicios estos tipos de matriz.

10. Hacer un programa que dada la matriz de secuencias de enteros definida
y precargada, permita obtener a través de métodos la posición de inicio y
la posición de fin de la secuencia ubicada a partir de una posición entera
y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
por pantalla ambas posiciones obtenidas.*/

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
		int fila = 0;
		int columna = 0;
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("Ingrese una fila");
		fila = getInput();
		System.out.println("Ingrese una columna");
		columna = getInput();
		if(matint[fila][columna]!=0){
			int inicio = buscarInicio(matint[fila],columna);
			int fin = buscarFin(matint[fila],columna);
			System.out.println("La secuencia comienza en "+inicio);
			System.out.println("La secuencia finaliza en "+fin);
		}
		else{
			System.out.println("Ninguna secuencia comienza en esa posicion");
		}
	}
	
	public static int buscarInicio(int[]arrint, int pos){
		while(arrint[pos]!=0 && pos>0){
			pos--;
		}
		return pos+1;
	}
	
	public static int buscarFin(int[]arrint, int pos){
		while(arrint[pos]!=0 && pos<MAXCOLUMNA){
			pos++;
		}
		return pos-1;
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
