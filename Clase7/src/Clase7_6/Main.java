package Clase7_6;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencias de numero en el
arreglo si existe. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán tantas
copias de la última posición del arreglo como cantidad de ocurrencias del número).*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			cargar_arreglo_aleatorio_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			System.out.println("Especifique el numero que desea eliminar: ");
			numero = Integer.valueOf(entrada.readLine());
			buscar_numero(arrenteros,numero);
		}
		catch (Exception exc){
			System.out.println(exc);
		}

	}
	
	public static void buscar_numero(int [] arrenteros, int num){
		int pos = 0;
		int encontrados = 0;
		while (pos < MAX){
			if (arrenteros[pos] != num){
				pos++;
			}
			else{
				System.out.println("El numero "+num+" fue encontrado en la posicion "+(pos+encontrados));
				borrar_numero(arrenteros, pos);
				pos++;
				encontrados++;
			}
		}
		
		if(pos==MAX && encontrados==0){
			System.out.println("El numero no fue encontrado en el arreglo");
		}
		else {
			System.out.println("El arreglo queda de la siguiente manera:");
			imprimir_arreglo_int(arrenteros);
		}
	}
	
	public static void borrar_numero(int [] arrenteros, int pos){
		int indice = pos;
		while (indice < MAX-1){
			arrenteros[indice] = arrenteros[indice+1];
			indice++;
		}
	}
	
	public static void cargar_arreglo_aleatorio_int(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}

}

