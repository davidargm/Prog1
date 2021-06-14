package Clase7_14;
/*Hacer un programa que dado el arreglo definido y precargado, y un número
entero ingresado por el usuario, copie de forma continua las secuencias de
tamaño igual al número ingresado en otro arreglo de iguales características e
inicializado con 0. La copia en este último arreglo deben comenzar desde el
principio del mismo.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int MAX = 20;
	public static void main(String[] args) {
		int [] arrenteros = {0,1,5,0,0,4,5,0,7,6,0,5,8,0,7,6,0,0,5,0};
		//inicializo en 0
		int [] secuencias = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int tamano = 0;
		int inicio = -1;
		int fin = -1;
		int inicioSec = 0;
		
		imprimir_arreglo_int(arrenteros);
		tamano = getTamano();
		if(tamano<MAX && tamano > 0){
			while(inicio<MAX){
				inicio = buscarInicioSecuencia(arrenteros,fin);//1
				if(inicio<(MAX-1)){
					fin = buscarFinSecuencia(arrenteros, inicio);//3
					if(fin-inicio+1 == tamano){
						insertarSecuencia(arrenteros, inicio, tamano, secuencias, inicioSec);
						inicioSec+=tamano;
					}
				}
				else{
					inicio++;
				}
			}
			imprimir_arreglo_int(secuencias);
		}
		else {
			System.out.println("No hay una secuencia del largo ingresado");
		}
	}
	
	public static int getTamano(){
		int entero = -1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Ingrese un tamano de secuencia");
			entero = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println("No ha ingresado un numero valido");
		}
		return entero;
	}
	
	public static int buscarInicioSecuencia(int [] arr, int fin){
		int i = fin+1;
		while(i< MAX && arr[i]==0){
			i++;
		}
		return i;
	}
	
	public static int buscarFinSecuencia(int [] arr, int inicio){
		int i = inicio;
		while(i< MAX-1 && arr[i]!=0){
			i++;			
		}
		return i-1;
	}
	
	public static void insertarSecuencia(int [] arr, int inicio, int tamano, int [] sec, int iniSec){
		for(int i = iniSec; i < (iniSec+tamano); i++){
			sec[i] = arr[inicio+(i-iniSec)];
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}
}
