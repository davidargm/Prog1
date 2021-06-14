package Clase7_17;
/*
Dado un arreglo DESORDENADO de numeros entre 1 y 9 de tamanio MAX que tiene los elementos sin orden, 
se pide lo siguiente:
a) Cargar un arreglo ORDENADO de tamanio MAX (inicializado con -1). 
ORDENADO tiene posiciones del arreglo DESORDENADO de forma tal 
que permite recorrer de forma ascendente y consecutiva los valores 
pares del arreglo DESORDENADO (no se pide ordenar ORDENADO) 
ORDENADO tiene valores -1 al final cuando DESORDENADO tiene valores impares.

Posible ejemplo
DESORDENADO
|4|6|5|8|3|8|3|5|4|7|
ORDENADO
|8|0|1|5|3|-1|-1|-1|-1|-1|

b) Para valores (elemento y posicion) ingresados por el usuario, si elemento esta entre 1 y 9,
es impar, y posicion es valida, insertar el elemento en DESORDENADO en la posicion indicada 
y luego actualizar el arreglo ORDENADO sin acceder a DESORDENADO.

Posible ejemplo
elemento=3
posicion=2
DESORDENADO
|4|6|3|5|8|3|8|3|5|4|
ORDENADO
|9|0|1|6|4|-1|-1|-1|-1|-1|

c) cargar los índices de los valores pares de DESORDENADO en un arreglo PARES de
tamaño MAX sin importar el orden.
– d) ordenar PARES de forma descendente según los valores pares de DESORDENADO
utilizando un método de ordenamiento.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static int MAX = 10;
	public static void main (String [] args) {
		int[] desordenado = new int[MAX];
		int[] ordenado = new int[MAX];
		int[] pares = new int[MAX];
		int pos,elemento;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio(desordenado);
			imprimir_arreglo(desordenado);
			inicializar_arreglo(ordenado);
			inicializar_arreglo(pares);
			//Realizar las tareas con arreglos;
			//a
			cargar_arreglo_indice_ord(desordenado,ordenado);
			imprimir_arreglo(ordenado);
			//c
			System.out.println("Los indices de los valores pares desordenados son: ");
			cargar_arreglo_indice_pares(desordenado,pares);
			imprimir_arreglo(pares);
			//d
			ordernar_indice_pares_desc(desordenado,pares);
			imprimir_arreglo(pares);
			//b
			System.out.println("Ingrese una posicion menor de un arreglo de tamanio MAX: ");
			pos = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un elemento impar entre "+MINVALOR+" y "+(MAXVALOR));
			elemento = Integer.valueOf(entrada.readLine());
			if ((elemento>=MINVALOR)&&(elemento<MAXVALOR)&&((elemento%2)!=0)&&(pos>=0)&&(pos<MAX)){
				insertar_elemento_arreglo_pos(desordenado,elemento,pos);
				actualizar_arreglo_ind(ordenado,pos);
				imprimir_arreglo(desordenado);
				imprimir_arreglo(ordenado);
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}

	public static void insertar_elemento_arreglo_pos(int[] original,int elemento,int pos){
		corrimiento_der(original,pos);
		original[pos] = elemento;
	}

	public static void actualizar_arreglo_ind(int[] arrindices,int pos){
		int posicion = 0;
		while ((posicion < MAX) && (arrindices[posicion] != -1)){
			if (arrindices[posicion] >= pos){
				arrindices[posicion]++;
				if (arrindices[posicion] >= MAX){
					corrimiento_izq(arrindices,posicion);
				}
			}
			posicion++;
		}
	}

	public static void cargar_arreglo_indice_ord(int[] original,int[] arrindices){
		for (int pos = 0; pos < MAX; pos++){
			if ((original[pos]%2) == 0){
				insertar_ordenado_arreglo_pos(original,arrindices,pos);
			}
		}
	}
	

	public static void insertar_ordenado_arreglo_pos(int[] original,int[] arrindices,int pos){
		int posicion=buscar_pos_arreglo_ord(original,arrindices,pos);
		if (posicion<MAX){
			corrimiento_der(arrindices,posicion);
			arrindices[posicion]=pos;
		}
	}
	
	public static int buscar_pos_arreglo_ord(int[] original,int[] arrindices,int pos){
		int posicion=0;
		while ((posicion<MAX) && (arrindices[posicion]!=-1) && (original[arrindices[posicion]]<original[pos])){
			posicion++;
		}
		return posicion;
	}
	
	public static void cargar_arreglo_indice_pares(int[] original,int[] arrindices){
		for (int pos = 0; pos < MAX; pos++){
			if ((original[pos]%2) == 0){
				insertar_arreglo_pares(original,arrindices,pos);
			}
		}
	}
	
	public static void insertar_arreglo_pares(int[] original,int[] arrindices,int pos){
		int posicion=0;
		while(posicion<MAX && arrindices[pos]%2==0){
			posicion++;
		}
		corrimiento_der(arrindices,posicion);
		arrindices[posicion]=pos;
	}
	
	public static void ordernar_indice_pares_desc(int[] original, int[] arrindices){
		ordenar_arreglo_seleccion_par(original, arrindices);
	}
	
	public static void ordenar_arreglo_seleccion_par(int[]original, int[]arr) {
		int pos_menor, tmp;
		for (int i = MAX-1; i > 0; i--) {
			if(arr[i]>0){
				pos_menor = i;
				for (int j = i - 1; j > 0; j--){
					if (original[arr[j]] < original[arr[pos_menor]]) {
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
	}
	


	public static void corrimiento_izq(int[] arr,int pos) {
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

	public static void cargar_arreglo_aleatorio(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(int)((MAXVALOR-MINVALOR)*Math.random() + MINVALOR);  
		}
	}    

	public static void imprimir_arreglo(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	}  		
}
