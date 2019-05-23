package Practicos2019;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class tp5e01 {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int ingreso=1, numero;
		boolean valido = false, numval = false;

		while (ingreso!=0) {

			try {
				System.out.println("Ingrese un entero");
				ingreso = new Integer(entrada.readLine());
				valido = true;
			}catch (Exception exc) {
				System.out.println( exc );
				System.out.println( "Vuelva a intentarlo" );
				ingreso=1;
				valido=false;
			}
			//}
			if ((ingreso!=0)&&(valido)) {

				while (!numval)	{

					try {
						System.out.println("Ingrese un numero");
						numero = new Integer(entrada.readLine());
						System.out.println("El númeo ingresado es: "+ numero);
						numval = true;

					}catch (Exception exc) {
						System.out.println( exc );
						System.out.println( "Vuelva a intentarlo bro" );
						numval = false;
					}
				}
			}
			valido = false;
			numval = false;
		}
	}
}

