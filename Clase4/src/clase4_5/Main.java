package clase4_5;
/*Hacer un programa que solicite la carga desde consola de
un carácter y realice: imprima si es dígito, o letra minúscula, o
es cualquier otro carácter. Si es letra minúscula indicar si es
vocal o consonante.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		char caracter;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un caracter: ");
			caracter = entrada.readLine().charAt(0);
			
			if ((caracter>='0') && (caracter<='9')){
				System.out.println("Es un numero");
			}
			else if ((caracter>='a') && (caracter<='z')){
				System.out.println("Es una letra minuscula");
				if ((caracter=='a') || (caracter == 'e') || (caracter == 'i') || (caracter == 'o') || (caracter == 'u')){
					System.out.println("Es una vocal");
				}
				else {
					System.out.println("Es una consonante");
				}
			}
			else {
				System.out.println("No es un caracter valido");
			}
		}
		
		catch (Exception exc){
			System.out.println(exc);
		}

	}

}
