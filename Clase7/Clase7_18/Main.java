package Clase7_18;
/*Se tiene un arreglo ORIGINAL precargado de caracteres letras minúsculas de
tamaño MAX que está ordenado de forma ascendente. Además se tiene un
arreglo ORDEN1 precargado de tamaño MAX. ORDEN1 tiene posiciones de
ORIGINAL de forma tal que permita recorrer de forma ascendente y
consecutiva los caracteres vocales de ORIGINAL. ORDEN1 tendrá valores -1 al
final en el caso de que ORIGINAL tenga consonantes. Se pide:
– Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha
posición en ORIGINAL, y actualizar el arreglo ORDEN1.
– Imprimir los caracteres vocales siguiendo el orden establecido en ORIGINAL.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int MAX = 10;
	public static void main(String[] args) {
		char[] original = {'z','u','c','d','a','g','i','o','o','z'};
		int[] orden1 = new int [MAX]; //{0,4,6,8,9,-1,-1,-1,-1,-1};
		int posicion;
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
		
		try{
			imprimir_arreglo_char(original);
			inicializarInd(orden1);
			buscarVocales(original,orden1);
			imprimir_arreglo_int(orden1);
			System.out.println("Ingrese la posicion que desea borrar");
			posicion = Integer.valueOf(entrada.readLine());
			buscarPosicion(original, posicion);
			imprimir_arreglo_char(original);
			inicializarInd(orden1);
			buscarVocales(original,orden1);
			imprimir_arreglo_int(orden1);
			System.out.println("Las vocales en el orden original son: ");
			
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		
	}
	
	public static void inicializarInd(int[] ind){
		for(int i = 0; i < MAX; i++){
			ind[i]=-1;
		}
	}
	
	public static void buscarVocales(char[]original, int[] ind){
		int i = 0;
		while(i<MAX){
			if(original[i] == 'a' || original[i] == 'e' ||original[i] == 'i' ||original[i] == 'o'||original[i] == 'u'){
				insertarPosicion(original, ind, i);
			}
			i++;
		}
	}
	
	public static void insertarPosicion(char[]original, int[] ind, int pos){
		int posicion = buscarPosicionInd(original, ind, pos);
		corrimiento_der(ind, posicion);
		ind[posicion]= pos;
	}
	
	public static int buscarPosicionInd(char[] original, int[] ind, int posicion){
		int pos = 0;
		while((pos < MAX) && (ind[pos] != -1) && (original[posicion] > original[ind[pos]])){
			pos++;
		}
		return pos;
	}
	
	
	public static void buscarPosicion(char[] original, int pos){
		int i= 0;
		while(i < MAX){
			if(i==pos){
				borrarLetra(original, i);
			}
			i++;
		}
	}
	
	public static void borrarLetra(char[] original, int pos){
		while (pos<MAX-1){
			original[pos] = original[pos+1];
			pos++;
		}
	}
		
	public static void corrimiento_der(int[] ind, int posicion) {
		int actual = MAX-1;
		while (posicion<actual){
			ind[actual] = ind[actual-1];
			actual--;
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	}
	
	public static void imprimir_arreglo_char(char [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	}


}
