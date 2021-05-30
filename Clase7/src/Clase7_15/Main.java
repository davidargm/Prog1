package Clase7_15;
/*Hacer un programa que dado el arreglo definido y precargado elimine del
arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo
de iguales características (solo tiene esa secuencia). Al eliminar se pierden los
valores haciendo los corrimientos.*/

public class Main {

	public static int MAX = 20;
	public static void main(String[] args) {
		int [] arrenteros = {0,1,2,3,4,0,0,1,2,0,1,2,3,4,0,0,1,2,0,0};
		int [] sec = {1,2,3};
		int indice = 0;
		imprimir_arreglo_int(arrenteros);
		//System.out.println("La secuencia a borrar es:");
		//imprimir_arreglo_int(sec);
		while(indice < (MAX-1)){
			if(arrenteros[indice]==0){
				indice++;
			}
			else{
				compararSecuencia(indice, arrenteros,sec);
				indice++;
			}
		}
		imprimir_arreglo_int(arrenteros);
	}
	
	public static void compararSecuencia(int indice, int [] arr, int [] sec){
		//boolean coincidencias = false;
		int i = indice;
		while(i < MAX-1){
			if(arr[i]==sec[0]){
				if(arr[i+1]==sec[1]){
					if(arr[i+2]==sec[2]){
						borrarSecuencia(i, arr);
					}
				}
			}
			i++;
		}
	}
	
	
	//public static void eliminarSecuencia(int [] arr, int inicio, int fin){
	public static void borrarSecuencia(int indice, int [] arrenteros){
		for(int i = indice; i < (indice+3); i++){
			for(int j = indice; j<(MAX-1); j++){
				arrenteros[j]=arrenteros[j+1];
			}
		}
	}
	
	public static void imprimir_arreglo_int(int [] arr){
		System.out.println(" ");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
	}
}
