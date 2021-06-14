package clase8_11;
/*Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada permita encontrar por cada fila la posición de inicio y fin de la
secuencia cuya suma de valores sea mayor.*/

import java.util.Random;

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int [][] matint = new int[MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int(matint);
		for(int i=0;i<MAXFILA;i++){
			buscarSecuenciaMayor(matint[i]);
		}
		
	}
	
	public static void buscarSecuenciaMayor(int[]arrint){
		int suma = 0;
		int i = 0;
		int inicioMayor = 0;
		int finMayor = 0;
		while(i<MAXCOLUMNA){
			int inicio = buscarInicio(arrint,i);
			if(inicio!=MAXCOLUMNA-1){
				int fin = buscarFin(arrint,inicio);
				int total = sumarSecuencia(arrint,inicio,fin);
				if(total>suma){
					suma=total;
					inicioMayor=inicio;
					finMayor=fin;
				}
				i=fin+1;
			}
			else{
				i=MAXCOLUMNA;
			}
			
		}
		System.out.println("La secuencia mayor suma un total de "+suma+", comienza en "+inicioMayor+" y finaliza en "+finMayor);
	}
	
	public static int sumarSecuencia(int[]arrint, int inicio, int fin){
		int total = 0;
		for(int i=inicio;i<=fin;i++){
			total += arrint[i];
		}
		return total;
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
