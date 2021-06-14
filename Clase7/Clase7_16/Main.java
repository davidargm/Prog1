package Clase7_16;
/*Hacer un programa que dado el arreglo definido y precargado elimine todas
las secuencias que tienen orden descendente entre sus elementos.*/

public class Main {
	public static int MAX = 20;
	public static void main(String[] args) {
		int [] arrenteros = {0,4,3,2,1,0,0,1,2,0,1,2,3,4,0,0,3,2,0,0};
		int inicio = 0;
		int fin = 0;
		int indice = 0;
		
		imprimir_arreglo_int(arrenteros);
		while(indice < MAX-1){
			if(arrenteros[indice]==0){
				indice++;
			}
			else if (arrenteros[indice+1]!=0){
				inicio = indice;
				fin = buscarFinSecuencia(arrenteros,indice);
				boolean descendente = buscarDescendencia(arrenteros, inicio, fin);
				if (descendente==true){
					eliminarSecuencia(arrenteros, inicio, fin);
				}
				indice++;
			}
			else{
				indice++;
			}
			
		}
		imprimir_arreglo_int(arrenteros);
	}
	
	public static int buscarFinSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]!=0){
			i++;			
		}
		return i-1;
	}
	
	public static boolean buscarDescendencia(int [] arr, int inicio, int fin){
		boolean desc = false;
		int contador = 0;
		int largo = fin-inicio+1;
		for(int i=inicio; i<=fin; i++){
			if(arr[i]>arr[i+1]){
				contador++;
			}
		}
		if (contador == largo){
			desc = true;
		}
		return desc;
	}
	
	public static void eliminarSecuencia(int [] arr, int inicio, int fin){
		for(int i=inicio; i<=fin; i++){
			for(int j=inicio; j<MAX-1; j++){
				arr[j]=arr[j+1];
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
