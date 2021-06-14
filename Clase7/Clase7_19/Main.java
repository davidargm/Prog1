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
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		int[] ORIGINAL = new int[MAX];
		int[] ORDEN1 = new int[MAX];
		
		cargar_arreglo_aleatorio_secuencias_int(ORIGINAL);
		imprimir_arreglo_secuencias_int(ORIGINAL);
		inicializar_arreglo(ORDEN1);
		buscarSecuenciasPares(ORIGINAL,ORDEN1);
		imprimir_arreglo_secuencias_int(ORDEN1);
		
		eliminarSecuencia(ORIGINAL,ORDEN1);
	}
	
	public static void eliminarSecuencia(int[]arr, int[]ind){
		int pos = getInput();
		if(pos>=0 && pos<MAX){
			int inicio = buscarInicio(arr,(pos-1));
			if(inicio==pos){
				int fin=buscarFin(arr,pos);
				for(int i=pos; i<=fin; i++){
					corrimiento_izq(arr,pos);
				}
				
				imprimir_arreglo_secuencias_int(arr);
				inicializar_arreglo(ind);
				buscarSecuenciasPares(arr,ind);
				imprimir_arreglo_secuencias_int(ind);
			}
			
			else{
				System.out.println("La posicion ingresada no corresponde al inicio de una secuencia");
			}
		}
		
		else{
			System.out.println("La posicion no esta dentro del rango del arreglo");
		}
	}
	
	public static int getInput(){
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int pos = 0;
		try{
			System.out.println("Ingrese la posicion de inicio de la secuencia que desea eliminar");
			pos = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return pos;
	}
	
	public static void buscarSecuenciasPares(int[]arr, int[]ind){
		int inicio = 0;
		int fin = 0;
		while(inicio<MAX-1){
			int suma = 0;
			inicio=buscarInicio(arr,inicio);
			fin=buscarFin(arr,inicio);
			suma=sumarSecuencia(arr,inicio);
			if(suma%2==0 && suma!=0){
				agregarIndice(arr,ind,inicio,suma);
			}
			inicio=fin+1;
		}
		
	}
	
	public static void agregarIndice(int[] arr, int[] ind, int inicio, int suma1){
		int i=0;
		int encontrados = 0;
		while(i<MAX  && encontrados==0){
			if(ind[i]==-1){
				ind[i]=inicio;
				i=MAX;
			}
			else{
				int suma2 = sumarSecuencia(arr, ind[i]);
				if(suma1<suma2){
					corrimiento_der(ind,i);
					ind[i]=inicio;
					encontrados++;
				}
				else{
					i++;
				}
			}
		}
	}
	
	
	public static void corrimiento_der(int[] arr,int pos) {
		int actual = MAX-1;
		while (pos<actual){
			arr[actual] = arr[actual-1];
			actual--;
		}
	}
	
	public static void corrimiento_izq(int[] arr,int pos) {
		while (pos<MAX-1){
			arr[pos] = arr[pos+1];
			pos++;
		}
	} 

	
	public static int sumarSecuencia(int[]arrint, int inicio){
		int total = 0;
		int fin = buscarFin(arrint, inicio);
		for(int i=inicio;i<=fin;i++){
			total += arrint[i];
		}
		return total;
	}
	
	public static int buscarInicio(int []arrint, int pos){
		int i = pos;
		while(arrint[i]==0 && i<MAX-1){
			i++;
		}
		return i;
	}
	
	public static int buscarFin(int[]arrint, int pos){
		while(arrint[pos]!=0 && pos<MAX-1){
			pos++;
		}
		if(pos==MAX-1){
			return pos;
		}
		else{
			return pos-1;
		}
		
	}
	
	public static void inicializar_arreglo(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			arr[pos] = -1;
		}
	} 
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int[]arr){
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
	
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
}
