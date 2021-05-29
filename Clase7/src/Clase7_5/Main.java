package Clase7_5;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un
número igual) en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un
corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima
posición).*/
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
		boolean encontro = false;
		while (encontro == false && pos < MAX){
			if (arrenteros[pos] != num){
				pos++;
			}
			else{
				encontro = true;
			}
		}
		
		if(pos==MAX){
			System.out.println("El numero no fue encontrado en el arreglo");
		}
		else if(encontro==true){
			System.out.println("El numero "+num+" fue encontrado en la posicion "+pos);
			borrar_numero(arrenteros, pos);
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
