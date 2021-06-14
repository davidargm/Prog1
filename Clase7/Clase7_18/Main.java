package Clase7_18;
/*
Se tiene un arreglo ORIGINAL precargado de caracteres letras minúsculas de
tamaño MAX que está ordenado de forma ascendente. Además se tiene un
arreglo ORDEN1 precargado de tamaño MAX. ORDEN1 tiene posiciones de
ORIGINAL de forma tal que permita recorrer de forma ascendente y
consecutiva los caracteres vocales de ORIGINAL. ORDEN1 tendrá valores -1 al
final en el caso de que ORIGINAL tenga consonantes. Se pide:
– Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha
posición en ORIGINAL, y actualizar el arreglo ORDEN1.
– Imprimir los caracteres vocales siguiendo el orden establecido en ORIGINAL.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static int MAX = 10;
	public static void main (String [] args) {
		char[] ORIGINAL = new char[MAX];
		int[] ORDEN1 = new int[MAX];
		int pos = 0;
		cargar_arreglo_aleatorio_char(ORIGINAL);
		ordenar_arreglo_seleccion(ORIGINAL);
		inicializar_arreglo(ORDEN1);
		imprimir_arreglo_char(ORIGINAL);
		cargar_indice_vocales(ORIGINAL, ORDEN1);
		imprimir_arreglo_int(ORDEN1);
		pos=getInput();
		inicializar_arreglo(ORDEN1);
		eliminar_letra(ORIGINAL,pos, ORDEN1);
		imprimir_arreglo_char(ORIGINAL);
		imprimir_arreglo_int(ORDEN1);
		imprimir_volales(ORIGINAL);
	}
	
	public static void imprimir_volales(char[]arr){
		System.out.println("Las vocales son: ");
		System.out.print("|");
		for(int i=0; i<MAX; i++){
			if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){
				System.out.print(arr[i]+"|");
			}
		}
	}
	
	public static void eliminar_letra(char[]arr, int pos,  int [] ind){
		corrimiento_izq(arr,pos);
		cargar_indice_vocales(arr, ind);
	}
	
	//recorre el arreglo original buscando vocales
	public static void cargar_indice_vocales(char[] arr, int[]ind){
		for(int i=0; i<MAX; i++){
			if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){
				int pos = buscar_posicion(arr, ind, i);
				ind[pos]=i;
			}
		}
	}
	
	//para buscar la posicion en el indice
	public static int buscar_posicion(char[] arr, int[] ind, int i){
		int j = 0;
		int encontrados = 0;
		while(j<MAX && ind[j]!=-1 && encontrados==0){
			if(arr[i]<arr[j]){
				corrimiento_der(ind,j);
				encontrados++;
			}
			else{
				j++;
			}
		}
		return j;
	}
	
	public static void cargar_arreglo_aleatorio_char(char [] arr){
		Random r = new Random();
		for (int i = 0; i < MAX; i++){
			arr[i]=(char)(r.nextInt(26) + 'a');
		}
	}
	
	public static void imprimir_arreglo_char(char [] arr){
		System.out.print("|");
		for (int i = 0; i < MAX; i++){
			System.out.print(arr[i]+"|");
		}
		System.out.println("");
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		System.out.print("|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.println(" ");
	}
	
	public static int getInput(){
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int pos = 0;
		try{
			System.out.println("Ingrese la posicion del arreglo que desea eliminar");
			pos = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return pos;
	}
	
	public static void ordenar_arreglo_seleccion(char[]arr) {
		char tmp;
		int pos_menor;
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

	public static void corrimiento_izq(char[] arr,int pos) {
		while (pos<MAX-1){
			arr[pos] = arr[pos+1];
			pos++;
		}
	}  

	public static void corrimiento_der(int[] arr,int pos) {
		int actual = MAX-1;
		while (pos<actual){
			arr[actual] = arr[actual-1];
			actual--;
		}
	}    

	public static void inicializar_arreglo(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			arr[pos] = -1;
		}
	}  		
} 
