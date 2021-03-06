package Clase7_7;
/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tama?o 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendr?
que realizar un corrimiento a derecha (se pierde el ?ltimo valor del arreglo)
y colocar el numero en el arreglo en la posici?n indicada.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static int MAX = 10;
	
	public static void main(String[] args) {
		int [] arrenteros = {1,1,2,3,4,5,5,6,7,8};
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese el numero que desea agregar: ");
			numero = Integer.valueOf(entrada.readLine());
			/*no se si esta bien pasar una funcion por parametro. de otra forma no se como traer posicion*/
			corrimiento_der(arrenteros, buscarPosicion(arrenteros,numero));
			imprimir_arreglo_int(arrenteros);
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}
	
	public static int buscarPosicion(int [] arr, int num){
		int posicion = 0;
		while(posicion < MAX && num > arr[posicion]){
			posicion++;
		}
		return posicion;
	}
	
	public static void corrimiento_der(int [] arrenteros, int pos){
		int indice = MAX-1;
		while (indice > pos){
			arrenteros[indice] = arrenteros[indice-1];
			indice--;
		}
	}
}
