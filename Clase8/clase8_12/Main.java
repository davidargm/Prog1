package clase8_12;
/*Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, permita encontrar por cada fila la posición de inicio y fin de la
anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
posición de la fila).*/

import java.util.Random;

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_secuencias_char(matchar);
		imprimir_matriz_char(matchar);
		
		for(int i=0;i<MAXFILA;i++){
			int contador = 0;
			int j = MAXCOLUMNA-1;
			int fin = -1;
			int inicio = -1;
			while(j>0 && contador < 2){
				fin = buscarFin(matchar[i],j);
				inicio = buscarInicio(matchar[i],fin);
				contador++;				
				j=inicio-1;
			}
			if(contador==2){
				System.out.println("La anteultima secuencia de la fila "+i+" comienza en "+inicio+" y finaliza en "+fin);
			}
			else{
				System.out.println("En la fila "+i+" existen menos de 2 secuencias");
			}
		}
		
	}
	
	public static int buscarInicio(char[]arrchar, int pos){
		while(arrchar[pos]!=' ' && pos>0){
			pos--;
		}
		return pos+1;
	}
	
	public static int buscarFin(char[]arrchar, int pos){
		while(arrchar[pos]==' ' && pos>0){
			pos--;
		}
		return pos;
	}
	
	public static void cargar_matriz_aleatorio_secuencias_char(char[][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_char(mat[fila]);
		}
		System.out.println("");
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr){
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXCOLUMNA-1] = ' ';
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if (r.nextDouble()>probabilidad){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			else{
				arr[pos]=' ';
			}
		}
	}
	
	public static void imprimir_matriz_char(char [][] mat){
		System.out.print("Arreglo de secuencias char\n");
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			imprimir_arreglo_secuencias_char(mat[fila]);
		}
	}
	
	public static void imprimir_arreglo_secuencias_char(char [] arr){
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
}
