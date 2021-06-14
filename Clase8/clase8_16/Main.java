package clase8_16;
/*Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados
por espacios de tamaño MAXF x MAXC que están precargadas.
Además se tiene el siguiente método:
a– un método que retorna el índice inicial de la secuencia de mayor tamaño de un
arreglo de secuencias (de caracteres letras minúsculas separados por espacios) de
tamaño MAXFIL.
Se pide realizar un programa que
– contenga la definición de los encabezados de los métodos de carga de la matriz y
del método mencionado en el enunciado (se supone que existen y no se requiere
implementarlos).
b– para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
c– para MAT1 agregue al principio de cada secuencia el primer carácter de la
secuencia de mayor tamaño de dicha fila.
d– en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es
mayor que la primer secuencia en dicha fila para MAT2, las intercambie (la que está
en MAT1 pasa a MAT2 y la que esta en MAT2 pasa a MAT1) sin usar estructuras
auxiliares (otros arreglos o matrices).
e– para un valor de fila ingresado por el usuario verifique e imprima si la primera
secuencia de MAT1 en dicha fila es igual la primera secuencia de MAT2 en dicha fila.*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXF = 4;
	public static final int MAXC = 20;
	public static void main(String[] args) {
		char [][] MAT1 = new char[MAXF][MAXC];
		char [][] MAT2 = new char[MAXF][MAXC];
		cargar_matriz_aleatorio_secuencias_char(MAT1);
		imprimir_matriz_char(MAT1);
		cargar_matriz_aleatorio_secuencias_char(MAT2);
		imprimir_matriz_char(MAT2);
		
		//EJERCICIO a
		/*for(int i=0; i<MAXF; i++){
			int iniMax = buscarIndiceMayor(MAT1[i]);
			System.out.println("La secuencia mayor de la fila "+i+" comienza en "+iniMax);
		}
		
		//EJERCICIO b
		for(int i=0; i<MAXF; i++){
			borrarPrimerVocal(MAT1[i]);
		}
		imprimir_matriz_char(MAT1);
		
		//EJERCICIO c
		for(int i=0; i<MAXF; i++){
			insertarCaracter(MAT1[i]);
		}
		imprimir_matriz_char(MAT1);
		
		//EJERCICIO d
		for(int i=0; i<MAXF; i++){
			compararSecuencias(MAT1[i], MAT2[i]);
		}
		imprimir_matriz_char(MAT1);
		imprimir_matriz_char(MAT2);
		
		//EJERCICIO e
		int fila = getFila();
		compararSecuencias2(MAT1[fila], MAT2[fila]);*/
	}
	
	public static void compararSecuencias2(char[]arr1, char[]arr2){
		int ini1 = buscarInicio(arr1,0);
		int tam1 = getTamanio(arr1,ini1);
		int ini2 = buscarInicio(arr2,0);
		int tam2 = getTamanio(arr2,ini2);
		if(tam1==tam2){
			boolean coinciden = true;
			for(int i=ini1;i<=(ini1+tam1); i++){
				if(arr1[i] != arr2[ini2+i-ini1]){
					coinciden = false;
				}
			}
			if(coinciden==true){
				System.out.println("Las primeras secuencias coinciden");
			}
		}
	}
	
	public static int getFila(){
		int fila = -1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese un numero de fila");
		try{
			fila = Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc){
			System.out.println(exc);
		}
		return fila;
	}
	
	public static void compararSecuencias(char[]arr1, char[]arr2){
		int inicio1 = buscarIndiceMayor(arr1);
		int tamanio1 = getTamanio(arr1,inicio1);
		int inicio2 = buscarInicio(arr2,0);
		int tamanio2 = getTamanio(arr2,inicio2);
		if(tamanio1>tamanio2){
			int diferencia = tamanio1-tamanio2;
			for(int i=diferencia;i>0; i--){
				corrimiento_der(arr2,inicio2);
			}
			reemplazarSecuencias(arr1,arr2,inicio1,inicio2,tamanio1, diferencia);
		}
	}
	
	public static void reemplazarSecuencias(char[]arr1, char[]arr2, int ini1, int ini2, int tam, int dif){
		char temp = 0;
		for(int i = 0; i<=tam; i++){
			temp = arr1[ini1+i];
			arr1[ini1+i]=arr2[ini2+i];
			arr2[ini2+i]=temp;
		}
		for(int j = dif; j>0; j--){
			corrimiento_izq(arr1,ini1);
		}
	}
	
	public static int getTamanio(char[]arr,int pos){
		int i = pos;
		int fin = buscarFin(arr,pos);
		
		return fin-i+1;
	}
	
	public static void insertarCaracter (char[]arrchar){
		int iMax = buscarIndiceMayor(arrchar);
		char temp = arrchar[iMax];
		int j = 0;
		int inicio = 0;
		int fin = 0;
		while(j<MAXC){
			inicio = buscarInicio(arrchar,j);
			fin = buscarFin(arrchar,inicio);
			if(inicio!=iMax){
				corrimiento_der(arrchar,inicio);
				arrchar[inicio]=temp;
				j=fin+2;
			}
			else{
				j=fin+1;
			}
			
		}
	}
	
	public static void borrarPrimerVocal(char[]arrchar){
		int j = 0;
		int inicio = 0;
		int fin = 0;
		while(j<MAXC-1){
			inicio = buscarInicio(arrchar,j);
			fin = buscarFin(arrchar,inicio);
			int vocales = 0;
			for(int k=inicio; k<=fin; k++){
				if(vocales<1 && (arrchar[k] == 'a' || arrchar[k] == 'e' ||arrchar[k] == 'i' ||arrchar[k] == 'o' ||arrchar[k] == 'u')){
					corrimiento_izq(arrchar,k);
					vocales++;
				}
			}
			j = fin+1;
		}
	}
	
	public static int buscarIndiceMayor(char[]arrchar){
		int inicio = 0;
		int fin = 0;
		int inicioMax=0;
		int tamanio = 0;
		int tamanioMax = 0;
		while(inicio<MAXC-1){
			inicio = buscarInicio(arrchar,inicio);
			fin = buscarFin(arrchar,inicio);
			tamanio = fin - inicio +1;
			if(tamanio>tamanioMax){
				tamanioMax=tamanio;
				inicioMax=inicio;
			}
			inicio=fin+1;
		}
		return inicioMax; 
	}
	
	public static void corrimiento_izq(int [] arrenteros, int pos){
		int i = pos;
		while (i < MAXC-1){
			arrenteros[i] = arrenteros[i+1];
			i++;
		}
	}
	
	public static void corrimiento_der(char[]arrchar, int pos){
		int i = MAXC-1;
		while (i > pos){
			arrchar[i] = arrchar[i-1];
			i--;
		}
	}
	
	public static int buscarInicio(char[]arrchar, int pos){
		int i = pos;
		while(arrchar[i]==' ' && i<MAXC-1){
			i++;
		}
		return i;
	}
	
	public static int buscarFin(char[]arrchar, int pos){
		while(arrchar[pos]!=' ' && pos<MAXC-1){
			pos++;
		}
		if(pos==MAXC-1 && arrchar[pos-1]==' '){
			return pos;
		}
		else{
			return pos-1;
		}
	}
	
	public static void corrimiento_izq(char[] arrenteros, int pos){
		while (pos < MAXC-1){
			arrenteros[pos] = arrenteros[pos+1];
			pos++;
		}
	}
	
	public static void cargar_matriz_aleatorio_secuencias_char(char[][] mat){
		for (int fila = 0; fila < MAXF; fila++){
			cargar_arreglo_aleatorio_secuencias_char(mat[fila]);
		}
		System.out.println("");
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr){
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXC-1] = ' ';
		for (int pos = 1; pos < MAXC-1; pos++){
			if (r.nextDouble()>probabilidad){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			else{
				arr[pos]=' ';
			}
		}
	}
	
	public static void imprimir_matriz_char(char [][] mat){
		System.out.print("Arreglo de secuencias char\n");
		for (int fila = 0; fila < MAXF; fila++){
			System.out.print("|");
			imprimir_arreglo_secuencias_char(mat[fila]);
		}
	}
	
	public static void imprimir_arreglo_secuencias_char(char [] arr){
		for (int pos = 0; pos < MAXC; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
}
