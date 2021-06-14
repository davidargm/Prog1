package Clase7_19;
/*Se tiene un arreglo ORIGINAL precargado de secuencias de números de
tamaño MAX con ceros entre secuencias, al principio y al final del arreglo.
Además se tiene un arreglo ORDEN1 precargado de tamaño MAX. ORDEN1
tiene posiciones de inicio de secuencia de ORIGINAL que permite recorrer de
forma ascendente y consecutiva las secuencias que suman una cantidad par
(ORDEN1 tiene valores -1 al final de las posiciones válidas). Se pide:
– Dada una posición válida ingresada por el usuario desde teclado, eliminar la
secuencia en ORIGINAL con inicio en esa posición y actualizar el arreglo ORDEN1.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		
		int [] arrenteros = new int [MAX];
		int [] orden1 = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
		int indice = 0;
		int posicion = 0;
		int inicio = 0;
		int fin = 0;
		int i = 0;
		
		cargar_arreglo_aleatorio_secuencias_int(arrenteros);
		imprimir_arreglo_secuencias_int(arrenteros);
		
		while (i < MAX-1){
			if (arrenteros[i]==0){
				i++;
			}
			else {
				inicio = i;
				fin = buscarFinSecuencia(arrenteros, inicio);
				int suma = sumarSecuencia(arrenteros, inicio);
				i = fin+1;
				if (suma%2==0){
					insertarInicio(arrenteros,orden1, inicio);
				}
			}
		}
		imprimir_arreglo_secuencias_int(orden1);
		posicion = getPosicionSecuencia();
		for(int k = 0; k<MAX-1; k++){
			if(posicion==arrenteros[k]){
				borrarSecuencia(arrenteros, posicion);
				borrarIndice(orden1,posicion);
				imprimir_arreglo_secuencias_int(arrenteros);
				imprimir_arreglo_secuencias_int(orden1);
			}
			else{
				System.out.println("La posicion no corresponde al comienzo de una secuencia");
			}
		}
	}
	
	public static void borrarIndice(int[] ind, int pos){
		int j = pos;
		while (pos<MAX-1){
			ind[j] = ind[j+1];
			j++;
		}
	}
	
	
	public static void borrarSecuencia(int [] arrenteros, int pos){
		int m = pos;
		while(arrenteros[pos] < MAX && arrenteros[pos]!=0){
			for(int n = pos; n<(MAX-1); n++){
				arrenteros[n]=arrenteros[n+1];
			}
		}
	}
	
	public static int getPosicionSecuencia(){
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		try{
			System.out.println("Ingrese una posicion del arreglo: ");
			input = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println("Ingresaste cualquier verdura");
		}
		return input;
	}
	
	public static void insertarInicio(int[] arrenteros, int[] indiceSumaPar, int inicio){
		int posicion = buscarPosicionInd(arrenteros, indiceSumaPar, inicio);
		corrimiento_der(indiceSumaPar, posicion);
		indiceSumaPar[posicion]= inicio;
	}
	
	public static int buscarPosicionInd(int[] arrenteros, int[] ind, int posicion){
		int pos = 0;
		int sumaInd = 0;
		int sumaSec = 0;
		while((pos < MAX-1) && (ind[pos] != -1) && sumaInd>sumaSec){
			int inicioInd = ind[pos];
			sumaInd = sumarSecuencia(arrenteros, inicioInd);
			sumaSec = sumarSecuencia(arrenteros, posicion);
			if(sumaInd<sumaSec){
				pos++;
			}
			
		}
		return pos;
	}
	
	public static int sumarSecuencia(int [] arr, int inicio){
		int suma = 0;
		int i = inicio;
		while(i<MAX && arr[i]!= 0){
			suma += arr[i];
			i++;
		}
		return suma;
	}
	
	public static int buscarFinSecuencia(int [] arr, int pos){
		int i = pos;
		while(arr[i]!=0){
			i++;			
		}
		return i-1;
	}
	
	public static void corrimiento_der(int[] ind, int posicion) {
		int actual = MAX-1;
		while (posicion<actual){
			ind[actual] = ind[actual-1];
			actual--;
		}
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
		for (int pos = 1; pos < MAX-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}

	//imprimir arreglo aleatorio de secuencias int
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");		
	}

}
