package Practicos2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tpiteraciones17 {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int numero=0, opcion=0, resultado=0;
		boolean terminar=false, ingreso=false;
		while(!terminar) {
			do {

				try {
					System.out.println("ingresar un entero");
					numero = new Integer(entrada.readLine());
					ingreso=true;
				}catch (Exception exc) {
					System.out.println( exc );
					ingreso=false;
				}
			}while(!ingreso);
			do {
				try {

					System.out.println("1: Elevar al cuadrado\n2: Dividir ṕor 2\n3: Mostrar si es multiplo de 3\n4: "
							+ "Raiz Cuadrada\n5: Salir");
					opcion = new Integer(entrada.readLine());
				}catch (Exception exc) {
					System.out.println( exc );
					opcion=0;
				}
			}while((opcion<1)||(opcion>5));
			switch (opcion) {
			case 1: resultado = (int) Math.pow(numero, 2);
				System.out.println(numero+" al cuadrado es: "+ resultado);
				break;
			case 2:resultado = numero/2;
				System.out.println(numero+" dividido 2 es: "+ resultado);
				break;
			case 3: if (numero%3 == 0) {
				System.out.println(numero+" multiplo de 3.");
			}
				break;
			case 4:resultado = (int) Math.sqrt(numero);
				System.out.println("La raiz cuadrada de "+numero+" es: "+ resultado);
				break;
			case 5: terminar=true;
				System.out.println("Hasta la proxima");       
				break;
			}
		}
	}

}
