import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
var = Integer.valueOf(entrada.readLine());
var = entrada.readLine().charAt(0);

try{
	
}
catch (Exception exc){
	System.out.println(exc);
}

//carga de arreglo de char con valores de 'a' a la 'z'
public static void cargar_arreglo_aleatorio_char(char [] arr){
	Random r = new Random();
	for (int pos = 0; pos < MAX; pos++){
		arr[pos]=(char)(r.nextInt(26) + 'a');
	}
}
//carga de arreglo de int con valores de MINVALOR a MAXVALOR
public static void cargar_arreglo_aleatorio_int(int [] arr){
	Random r = new Random();
	for (int pos = 0; pos < MAX; pos++){
		arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
	}
}

//carga de arreglo de double con valores de MINVALOR a MAXVALOR

public static int MAX = 10;
public static int MAXVALOR = 10;
public static int MINVALOR = 1;
	
public static void cargar_arreglo_aleatorio_double(double [] arr){
Random r = new Random();
for (int pos = 0; pos < MAX; pos++){
	arr[pos]=((MAXVALOR-MINVALOR+1)*r.nextDouble() + MINVALOR*1.0);
	}
}
//impresion de arreglo de char
public static void imprimir_arreglo_char(char [] arr){
	for (int pos = 0; pos < MAX; pos++){
	System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
	}
}
//impresion de arreglo de int

public static int MAX = 10;
public static int MAXVALOR = 10;
public static int MINVALOR = 1;

public static void imprimir_arreglo_int(int [] arr){
	for (int pos = 0; pos < MAX; pos++){
		System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
	}
}
//impresion de arreglo de double
public static void imprimir_arreglo_double(double [] arr){
	for (int pos = 0; pos < MAX; pos++){
	System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
	}
}

//corrimiento hacia la derecha de un arreglo de enteros
public static void corrimiento_der(int [] arrenteros, int pos){
	int i = MAX-1;
	while (i > pos){
		arrenteros[i] = arrenteros[i-1];
		i--;
	}
}

//corrimiento hacia la izquierda de un arreglo de enteros
public static void corrimiento_izq(int [] arrenteros, int pos){
	int i = pos;
	while (i < MAX-1){
		arrenteros[i] = arrenteros[i+1];
		i++;
	}
}

//METODOS DE ORDENAMIENTO
public static void ordenar_arreglo_seleccion(int[]arr) {
	int pos_menor, tmp;
	for (int i = 0; i < MAX; i++) {
		pos_menor = i;
		for (int j = i + 1; j < MAX; j++){
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

public static void ordenar_arreglo_burbujeo(int[] arr){
	int temp;
	for(int i = 1;i < MAX;i++){
		for (int j = 0 ; j < MAX - 1; j++){
			if (arr[j] > arr[j+1]){
			temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;

			}
		}
	}
}

public static void ordenar_arreglo_insercion(int[]arr) {
	int aux, j;
	for (int i = 1; i < MAX; i++) {
		aux = arr[i];
		j = i - 1;
		while ((j >= 0) && (arr[j] > aux)){
			arr[j+1] = arr[j];
			j--;	
		}
		arr[j+1] = aux;
	}
}

//ORDENAR ARREGLO INDICE EN BASE A LA SUMA POR SELECCION - Ej.: 8_10
public static void ordenar_arreglo_indice_seleccion(int[][] original, int arr[]) {
	int pos_menor, tmp;
	int i, j;
	i = 0;
	while (i < MAXFILA) { 
		pos_menor = i;
		j = i + 1;
		while (j < MAXFILA){ 	
			if (obtener_suma_fila(original[arr[j]]) < obtener_suma_fila(original[arr[pos_menor]])) { 	
				pos_menor = j;
			}
			j++;
		}
		if (pos_menor != i){
			tmp = arr[i];
			arr[i] = arr[pos_menor];
			arr[pos_menor] = tmp;
		}
		i++;
	}
}

//ORDENAR COLUMNA POR SELECCION EN BASE A UN VALOR INGRESADO
public static void ordenar_matriz_columna_seleccion(int [][] mat, int columna) {
	int pos_menor, tmp;
	for (int i = 0; i < MAXFILA; i++) { 
		pos_menor = i; 		
		for (int j = i + 1; j < MAXFILA; j++){ 	
			if (mat[j][columna] < mat[pos_menor][columna]) { 	
				pos_menor = j;
			}
		}
		if (pos_menor != i){
			tmp = mat[i][columna];
			mat[i][columna] = mat[pos_menor][columna];
			mat[pos_menor][columna] = tmp;
		}
	}
}

//OBTENER SUMA FILA
public static int obtener_suma_fila(int [] arr){
	int suma = 0;
	for (int columna = 0; columna < MAXCOLUMNA; columna++){
		suma += arr[columna];
	}
	return suma;
}


//OBTENER PROMEDIO FILA
public static int promedio_fila (int[][] mat, int fila){
	int promedio;
	int suma = 0;
	for (int columna = 0 ; columna < MAXCOLUMNA; columna++) {
		suma+=mat[fila][columna];
	}
	promedio = suma/MAXCOLUMNA;
	return promedio;
}

//BUSCAR NUMERO. SE COMBINA CON EL SIGUIENTE METODO "BUSCAR NUMERO INGRESADO POR EL USUARIO"
public static void imprimir_fila_columna_matriz(int[][] mat, int numero){
	int fila = 0;
	int columna = MAXCOLUMNA;
	while ((fila < MAXFILA) && (columna == MAXCOLUMNA)){
		columna = obtener_pos_arreglo(mat[fila],numero);
		if (columna == MAXCOLUMNA){
			fila++;
		}
	}
	if ((fila < MAXFILA) && (columna < MAXCOLUMNA)){
		System.out.println(numero+" se encuentra en "+fila+" y "+columna);
	}
	else {
		System.out.println(numero+" no se encuentra en la matriz");
	}
}

//BUSCAR NUMERO INGRESADO POR EL USUARIO
public static int obtener_pos_arreglo(int [] arr, int numero){
	int posicion = 0;
	while ((posicion < MAXCOLUMNA) && (arr[posicion] != numero)){
		posicion++;
	}
	return posicion;
}


//carga de arreglo aleatorio de secuencias char
public static final double probabilidad_letra = 0.4;

public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr){
	Random r = new Random();
	arr[0] = ' ';
	arr[MAX-1] = ' ';
	for (int pos = 1; pos < MAX-1; pos++){
		if (r.nextDouble()>probabilidad_letra){
			arr[pos]=(char)(r.nextInt(26) + 'a');
		}
		else{
			arr[pos]=' ';
		}
	}
}

//imprimir arreglo aleatorio de secuencias char
public static void imprimir_arreglo_secuencias_char(char [] arr){
	System.out.print("Arreglo de secuencias char\n|");
	for (int pos = 0; pos < MAX; pos++){
		System.out.print(arr[pos]+"|");
	}
	System.out.print("\n");
}

//carga de arreglo aleatorio de secuencias int
public static final double probabilidad_numero = 0.4;

public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
	Random r = new Random();
	arr[0] = 0;
	arr[MAX-1] = 0;
	for (int pos = 1; pos < MAX-1; pos++){
		if (r.nextDouble()>probabilidad_numero){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
		else{
			arr[pos]=0;
		}
	}
}

//imprimir arreglo aleatorio de secuencias int
public static void imprimir_arreglo_secuencias_int(int [] arr){
	System.out.print("Arreglo de secuencias int\n|");
	for (int pos = 0; pos < MAX; pos++){
		System.out.print(arr[pos]+"|");
	}
	System.out.print("\n");
}


//CARGA DE MATRICES

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Clase_8_Ejemplo_1 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		char [][] matchar;                  
		int [][] matint;                  
		double [][] matdouble;                  
		matchar = new char[MAXFILA][MAXCOLUMNA];                  
		matint = new int[MAXFILA][MAXCOLUMNA];                  
		matdouble = new double[MAXFILA][MAXCOLUMNA]; 
		cargar_matriz_int(matint);
		imprimir_matriz_int(matint);
		cargar_matriz_aleatorio_char(matchar);
		cargar_matriz_aleatorio_int(matint);
		cargar_matriz_aleatorio_double(matdouble);
		imprimir_matriz_char(matchar);
		imprimir_matriz_int(matint);
		imprimir_matriz_double(matdouble);
	}

	public static void cargar_matriz_int(int [][] mat){
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			for (int fila = 0; fila < MAXFILA; fila++){
				for (int columna = 0; columna < MAXCOLUMNA; columna++){
					System.out.println("Ingrese un entero para la posicion ["+fila+"]["+columna+"]");
					mat[fila][columna] = Integer.valueOf(entrada.readLine());
				}
			}
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void cargar_matriz_aleatorio_char(char [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(char)(r.nextInt(26) + 'a');
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

	public static void cargar_matriz_aleatorio_double(double [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=((MAXVALOR-MINVALOR-1)*r.nextDouble() + MINVALOR*1.0);  
			}
		}
	}

	public static void imprimir_matriz_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
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

	public static void imprimir_matriz_double(double [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
}

//CARGA DE SECUENCIAS INT Y CHAR//
import java.util.Random;

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int [][] matint = new int[MAXFILA][MAXCOLUMNA];
		char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int(matint);
		cargar_matriz_aleatorio_secuencias_char(matchar);
		imprimir_matriz_char(matchar);
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
