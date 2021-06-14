package Parcial2021_1;
/*
Dos matrices A y B de secuencias (letras minusculas separados por espacios) de 
tamanio MAXFIL x MAXCOL (cada fila empieza y termina con caracteres espacios).

A_un metodo que de un arreglo de secuencias retorna en cuantas secuencias de dicho arreglo 
esta incluida una secuencia que se encuentra en otro arreglo que tiene una unica secuencia.

B_un metodo que permite obtener el indice inicial de la secuencia que le sigue a la secuencia 
central (central porque justo al medio del arreglo esta parte de esa secuencia) de un arreglo de 
secuencias (de caracteres letras minusculas separados por espacios) de tamanio MAXCOL (que empieza y termina con espacios).

C_en cada fila de A, si dicha fila tiene una unica secuencia y hay menos de 25 secuencias que la incluye en dicha fila de B, 
reemplace la secuencia en A por la secuencia que le sigue a la secuencia central de dicha fila 
en B (la separacion previa entre secuencias debe mantenerse).
*/


public class Main {
	public static int MAXCOL = 15;
	public static int MAXFIL = 5;
	public static void main(String[] args) {
		char[][] matCharA = {
				{' ','a','b','c','d',' ',' ','a','b','c',' ',' ','a','b','c',' '},
				{' ','e','f','g','h',' ',' ','e','f','g',' ',' ','a','b','c',' '},
				{' ','a','b','c',' ',' ',' ','e','f','g',' ',' ','a','b',' ',' '},
				{' ','a','j','c','a','b','c','d',' ',' ',' ',' ','f','g',' ',' '},
				{' ','a','b','c','d',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		};
		
		char[][] matCharB = {
				{' ','a','b','c','d',' ',' ','a','b','c',' ',' ','a','b','c',' '},
				{' ','e','f','g','h',' ',' ','e','f','g',' ',' ','a','b','c',' '},
				{' ','a','b','c',' ',' ',' ','e','f','g',' ',' ','a','b','c',' '},
				{' ','a','b','c','d',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
				{' ','a','j','c','a','b','c','d',' ',' ',' ',' ','f','g','h',' '},
		};
		//char[][] matCharB = new char [MAXCOL][MAXFIL];
		char[] arrSec = {' ','a','b','c',' '};
		
		for(int i=0; i<MAXFIL; i++){
			int inicio = 0;
			int suma = 0;
			int fin = 0;
			while(fin<MAXCOL){
				inicio = buscarInicio(matCharA[i], fin);
				fin = buscarFin(matCharA[i],inicio);
				boolean match = compararSecuencia(inicio,matCharA[i],arrSec);
				if(match==true){
					suma++;
				}
				fin++;
			}
			
			System.out.println("En la fila "+i+" la secuencia se encuentra "+suma+" veces.");
		}
		
		buscarSiguienteSecuencia(matCharA[3]);
		
		ejercicioC(matCharA,matCharB);	
	}
	
	public static void ejercicioC(char[][] matCharA, char[][]matCharB){
		for(int i=0; i<MAXFIL; i++){
			int sumaA = sumaDeSecuencias(matCharA[i]);
			int sumaB = sumaDeSecuencias(matCharB[i]);
			if(sumaA==1 && sumaB < 25){
				System.out.println("Haria el reemplazo en la fila "+i);
				reemplazoSecuencia(matCharA[i],matCharB[i]);
			}
		}
		
		imprimir_matriz_char(matCharA);
	}
	
	public static void reemplazoSecuencia(char[] arrCharA, char[] arrCharB){
		int inicioA = 0;
		inicioA = buscarInicio(arrCharA,inicioA);
		int finA = buscarFin(arrCharA,inicioA);
		int inicioB = buscarSiguienteSecuencia(arrCharB);
		for(int i=inicioA; i<=finA; i++){
			arrCharA[i]=arrCharB[inicioB+i-inicioA];
		}
	}
	
	public static int sumaDeSecuencias(char[] arrChar){
		int fin = 0;
		int suma = 0;
		while(fin<MAXCOL){
			int inicio = 0;
			inicio = buscarInicio(arrChar, fin);
			fin = buscarFin(arrChar,inicio);
			fin++;
			if(inicio<MAXCOL){
				suma++;
			}
		}
		return suma;
	}
		
	
	public static int buscarSiguienteSecuencia(char[]arrChar){
		int contador = 0;
		int fin = 0;
		int inicio = 0;
		while(contador != 2 && fin < MAXCOL){
			fin = buscarFin(arrChar, MAXCOL/2);
			fin++;
			contador++;
			inicio = buscarInicio(arrChar,fin);
		}
		return inicio;
	}
	
	public static boolean compararSecuencia(int inicio, char[] arrChar, char[]arrSec){
		int i = 1;
		boolean match = true;
		while(arrSec[i]!= ' ' && match == true){
			if(arrSec[i]!= arrChar[inicio+i-1]){
				match = false;
			}
			i++;
		}
		return match;
	}
	
	public static int buscarInicio(char[]arrChar, int inicio){
		int i = inicio;
		while(arrChar[i]==' ' && i<MAXCOL){
			i++;
		}
	return i;
	}
	
	public static int buscarFin(char[]arrChar, int inicio){
		int j = inicio;
		while(arrChar[j]!=' ' && j <MAXCOL){
			j++;
		}
	return j-1;
	}
	
	public static void imprimir_matriz_char(char [][] mat){
		for (int fila = 0; fila < MAXFIL; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOL; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
	
}
