package clase4_7Luna;

/*El astrónomo Metón de Atenas descubrió hacia el siglo V a.C que la luna
repite su ciclo cada 19 años (el mismo día del mismo mes tendrá la misma
fase lunar). Sus aportes permitieron determinar la fase de la luna para una
fecha dada. Los pasos para obtener esa información son:

a. Calcular el número áureo: permite conocer en qué año-tipo del ciclo
nos encontramos considerando la repetición de ciclos cada 19 años.
El número áureo se calcula de la siguiente forma:
	– Tomamos la cifra del año que nos interesa (por ejemplo 2023) y le sumamos 1
	(2023+1=2024)
	– A continuación dividimos el resultado por 19 (ciclo de repetición) y nos
	quedamos con el resto 2024/19 = 106 resto = 10 (10 es el resto entre 2024 y 19). Al
	dividir por 19 hemos eliminado los ciclos repetidos. Así el número áureo es 10.
b. Calcular la epacta: es la edad de la luna en días el 1 de enero del
año elegido, y se calcula de la siguiente forma:
	– Se resta 1 del número áureo, y se multiplica por 11 (en nuestro caso 10-1 = 9; 9*11
	= 99)
	– Después, se divide por 30 (un mes lunar) y de nuevo nos quedamos con el resto:
	99/30 = 3 resto = 9. Significa que el 1 de enero de 2023 habrán pasado 9 días
	desde la última luna nueva.
c. Finalmente, para saber la edad lunar en un día cualquiera,
(supongamos el 15 de junio de 2023) realizaremos la siguiente
operación:

	1) A la epacta (9) le sumamos 1 por cada mes a partir de marzo (por
	ejemplo: de marzo a junio sumamos 4, y si el mes fuera enero de
	marzo a enero sumamos 11), y luego le sumamos el día del mes
	requerido (15), es decir 9+4+15=28.
	2) 28 es la edad lunar para esa fecha, y si pasara de 29 habría que
	reducirlo obteniendo el resto de dividir por 30.
	3) Es decir que el 15 de junio de 2023 habrán pasado 28 días desde la
	última luna nueva, por lo que la luna será menguante casi nueva (a
	falta de un día aproximadamente).

Se pide: hacer un programa completo en el cual se solicite de teclado el
ingreso de un día, un número de mes, y un año; luego calcule la cantidad
de días desde la última luna nueva (edad lunar), e informe por pantalla en
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
