import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que cargue en un arreglo de enteros 5 valores desde teclado y lo imprima.
ESTE EJEMPLO ESTA HECHO SIN METODOS, SOLO PARA EXPLICAR COMO FUNCIONA (MAS ADELANTE SE HACE CON
METODOS)
*/

public class Main {
	public static int MAX = 5;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			for (int pos = 0; pos < MAX; pos++){
				System.out.println("Ingrese un entero: ");
				arrenteros[pos] = Integer.valueOf(entrada.readLine());
			}
			for (int pos = 0; pos < MAX; pos++){
				System.out.println("arrenteros["+pos+"] = "+arrenteros[pos]);
			}
		}
		catch (Exception exc) {
			System.out.println(exc);
		}

	}
}
