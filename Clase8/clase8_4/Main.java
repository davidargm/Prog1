package clase8_4;
/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
y colocar el numero en la matriz en la posición fila, columna indicada.*/

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
		int numero = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Ingrese un numero de fila");
			fila = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un numero de columna");
			columna = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese el numero que desea insertar");
			numero = Integer.valueOf(entrada.readLine());
			
			if(fila<0 || fila>MAXFILA || columna<0 || columna>MAXCOLUMNA){
				System.out.println("Ha ingresado un numero de fila o columna invalido");
			}
			else{
				corrimiento_der(matInt[fila],columna);
				insertarNumero(matInt[fila],columna,numero );
			}
			
		}
		catch (Exception exc){
			System.out.println("Ha ingresado un numero invalido");
		}
		
		imprimir_matriz_int(matInt);
	}
	
	public static void insertarNumero(int[] arrenteros, int pos, int num){
		arrenteros[pos] = num;
	}
	
	public static void corrimiento_der(int [] arrenteros, int pos){
		int i = MAXCOLUMNA-1;
		while (i > pos){
			arrenteros[i] = arrenteros[i-1];
			i--;
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