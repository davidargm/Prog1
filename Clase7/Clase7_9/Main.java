package Clase7_9;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int MAX = 10;
	
	public static void main(String[] args) {
		int num1;
		int num2;
		int [] coordenadas = {0,0};
		int [] arrenteros = {5,4,2,9,4,3,8,5,7,8};
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese una posicion del arreglo");
			num1 = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese otra posicion del arreglo");
			num2 = Integer.valueOf(entrada.readLine());
			ordernarInput(num1, num2, coordenadas);
			ordenar_arreglo_seleccion(arrenteros, coordenadas[0], coordenadas [1]);
			imprimir_arreglo_int(arrenteros);
		}
		catch (Exception exc){
			System.out.println("Ha ingresado una posicion fuera del rango");
		}
	}
	
	public static int [] ordernarInput(int num1, int num2, int [] coordenadas){
		int temp;
		if (num1 > num2){
			temp = num2;
			coordenadas[1] = num1;
			coordenadas[0] = temp;
		}
		else {
			coordenadas[0] = num1;
			coordenadas[1] = num2;
		}
		return coordenadas;
	}
	
	public static void ordenar_arreglo_seleccion(int[]arr, int coor1, int coor2) {
		int pos_menor, tmp;
		for (int i = coor1; i <= coor2; i++) {
			pos_menor = i;
			for (int j = i + 1; j <= coor2; j++){
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
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}

}
