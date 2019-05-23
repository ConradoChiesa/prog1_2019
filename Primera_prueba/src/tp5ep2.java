package Practicos2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp5ep2 {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		final int MIN = 1;
		final int MAX = 10;
		int num = 0;
		do
		 {
			try {
				System.out.println("Ingrese un número Mayor a 1 y mnenor a 10");
				num = new Integer(entrada.readLine());
			}catch (Exception exc) {
				System.out.println(exc);
				num = 0;
			}
		}while ((num<MIN)||(num>MAX));
		while (num>=0) {
			System.out.println(num);
			num--;
		}
	}

}
