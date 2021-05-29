package clase4_7Luna;

/*El astr�nomo Met�n de Atenas descubri� hacia el siglo V a.C que la luna
repite su ciclo cada 19 a�os (el mismo d�a del mismo mes tendr� la misma
fase lunar). Sus aportes permitieron determinar la fase de la luna para una
fecha dada. Los pasos para obtener esa informaci�n son:

a. Calcular el n�mero �ureo: permite conocer en qu� a�o-tipo del ciclo
nos encontramos considerando la repetici�n de ciclos cada 19 a�os.
El n�mero �ureo se calcula de la siguiente forma:
	� Tomamos la cifra del a�o que nos interesa (por ejemplo 2023) y le sumamos 1
	(2023+1=2024)
	� A continuaci�n dividimos el resultado por 19 (ciclo de repetici�n) y nos
	quedamos con el resto 2024/19 = 106 resto = 10 (10 es el resto entre 2024 y 19). Al
	dividir por 19 hemos eliminado los ciclos repetidos. As� el n�mero �ureo es 10.
b. Calcular la epacta: es la edad de la luna en d�as el 1 de enero del
a�o elegido, y se calcula de la siguiente forma:
	� Se resta 1 del n�mero �ureo, y se multiplica por 11 (en nuestro caso 10-1 = 9; 9*11
	= 99)
	� Despu�s, se divide por 30 (un mes lunar) y de nuevo nos quedamos con el resto:
	99/30 = 3 resto = 9. Significa que el 1 de enero de 2023 habr�n pasado 9 d�as
	desde la �ltima luna nueva.
c. Finalmente, para saber la edad lunar en un d�a cualquiera,
(supongamos el 15 de junio de 2023) realizaremos la siguiente
operaci�n:

	1) A la epacta (9) le sumamos 1 por cada mes a partir de marzo (por
	ejemplo: de marzo a junio sumamos 4, y si el mes fuera enero de
	marzo a enero sumamos 11), y luego le sumamos el d�a del mes
	requerido (15), es decir 9+4+15=28.
	2) 28 es la edad lunar para esa fecha, y si pasara de 29 habr�a que
	reducirlo obteniendo el resto de dividir por 30.
	3) Es decir que el 15 de junio de 2023 habr�n pasado 28 d�as desde la
	�ltima luna nueva, por lo que la luna ser� menguante casi nueva (a
	falta de un d�a aproximadamente).

Se pide: hacer un programa completo en el cual se solicite de teclado el
ingreso de un d�a, un n�mero de mes, y un a�o; luego calcule la cantidad
de d�as desde la �ltima luna nueva (edad lunar), e informe por pantalla en
cual de las 4 fases se corresponde para esa fecha.*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		int dia;
		int mes = 0;
		int anio = 0;
		int numeroAureo;
		int epacta;
		int edadLunar;
		int mesEpacta = 0;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese el numero del dia: ");
			dia = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese el numero del mes: ");
			mes = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese el numero del anio: ");
			anio = Integer.valueOf(entrada.readLine());
			
			numeroAureo = ((anio+1)%19);		
			epacta = (((numeroAureo-1)*11)%30);
			
			//Calculo del valor a sumar a Epacta para la edad lunar
			//El ciclo comienza en el mes de Marzo por lo que Marzo es 1 en mesEpacta, Abril es 2, ..., Enero 11, Febrero 12
			if (mes >= 3 && mes <=12){
				mesEpacta = mes-2;
			}
			else if (mes < 3 && mes >= 1){
				mesEpacta = mes+10;
			}
			else {
				System.out.println("Ingrese un numero de mes valido");
			}
			
			//calculo de edad lunar
			if (epacta+mesEpacta+dia>29){
				edadLunar = ((epacta+mesEpacta+dia)%30);
			}
			else {
				edadLunar = (epacta+mesEpacta+dia);
			}
	
			System.out.println("Fecha: " + dia + "/" + mes + "/" + anio);
			
			if (edadLunar>=0 && edadLunar<=7){
				System.out.println("Luna Nueva");
			}
			else if (edadLunar>7 && edadLunar<=14){
				System.out.println("Cuarto creciente");
			}
			else if (edadLunar>14 && edadLunar<=21){
				System.out.println("Luna Llena");
			}
			else if (edadLunar>21 && edadLunar<=30){
				System.out.println("Menguante");
			}
		}
		catch (Exception exc){
			System.out.println("Ingrese algo valido");
		}
	}
}
