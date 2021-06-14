package clase8_14;
/*Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, elimine de cada fila todas las ocurrencias de una secuencia
patrón dada por un arreglo de caracteres de tamaño igual al tamaño de
columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al
final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.*/

public class Main {
	public static final double probabilidad = 0.4;
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		char [][] matchar = {
				{' ','i','y',' ',' ',' ','v',' ','o','c',' ','t',' ',' ',' ','i','y',' ','k',' '},
				{' ','b',' ','i','y','y',' ','p','b','p','p',' ','m','n','m',' ',' ',' ','i',' '},
				{' ','p',' ',' ','n','g','r','k','x',' ','q',' ','e',' ','f',' ','d','m',' ',' '},
				{' ','m','q',' ','d','b',' ',' ',' ',' ','q','y','b',' ','c','v',' ',' ',' ',' '}};
		
		char[]arrSec = {' ','i','y',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		int iniSec = buscarInicio(arrSec,0);
		int finSec = buscarFin(arrSec,iniSec);
		int tamanio = finSec-iniSec+1;
		
		imprimir_matriz_char(matchar);
		imprimir_arreglo_secuencias_char(arrSec);
		
		for(int i=0;i<MAXFILA;i++){
			int j = 0;
			while(j<MAXCOLUMNA-1){
				int inicio = buscarInicio(matchar[i],j);
				int fin = buscarFin(matchar[i],inicio);
				if(fin-inicio+1==tamanio){
					boolean encontrado = true;
					for(int k=inicio;k<=fin;k++){
						if(matchar[i][k]!=arrSec[iniSec+k-inicio]){
							encontrado = false;
						}
					}
					if (encontrado == true){
						for(int k=inicio;k<=fin;k++){
							corrimiento_izq(matchar[i], inicio);
						}
					}
					else if(encontrado == false){
						j=fin+1;
					}
				}
				else{
					j=fin+1;
				}
			}
		}
		System.out.println("La matriz queda de la siguiente manera");
		imprimir_matriz_char(matchar);

	}
	
	public static void corrimiento_izq(char[] arrenteros, int pos){
		while (pos < MAXCOLUMNA-1){
			arrenteros[pos] = arrenteros[pos+1];
			pos++;
		}
	}
	
	public static int buscarInicio(char[]arrint, int pos){
		int i = pos;
		while(arrint[i]==' ' && i<MAXCOLUMNA-1){
			i++;
		}
		return i;
	}
	
	public static int buscarFin(char[]arrint, int pos){
		while(arrint[pos]!=' ' && pos<MAXCOLUMNA){
			pos++;
		}
		return pos-1;
	}
	
	public static void imprimir_matriz_char(char [][] mat){
		System.out.print("Arreglo de secuencias char\n");
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			imprimir_arreglo_secuencias_char(mat[fila]);
		}
	}
	
	public static void imprimir_arreglo_secuencias_char(char [] arr){
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
}
