package Practicos2019;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class clase6tp2 {
	public static final int MAX = 1000;
	public static void main(String[] args) {
		int numdado = numero_dado();
		int salio = calcular_tiros(numdado);
		System.out.println("El número "+ numdado +" salio "+ salio+" veces.");
	}
	

	public static int numero_dado () {
		int valorvalido = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while ((valorvalido<1)||(valorvalido>6)) {
			try {
				System.out.println("Ingrese un entero entre 1 y 6");
				valorvalido = new Integer(entrada.readLine());
			} catch (Exception exc) {
				System.out.println( exc );
				System.out.println("Debe ingresar un numero entre 1 y 6");
			}
		}
		return valorvalido;
	}

	public static int calcular_tiros(int numdado) {
		int dado = 0;
		int salio = 0;
		for (int i=0; i<MAX; i++) {
			dado = (int) (6*Math.random() + 1);
			if(dado == numdado) {
				salio ++;
			}
		}
		return salio;
	}
}
