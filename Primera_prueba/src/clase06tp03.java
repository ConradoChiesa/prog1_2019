package Practicos2019;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class clase06tp03 {
	public static final int MAXopcion = 3;
	public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int opcion = ingresar();
		float valor1 = obtenerFloat();
		float valor2 = obtenerFloat();
		float valor3 = obtenerFloat();
		float resultado = 0;
	//	System.out.println(valor1+", " + valor2 +", " + valor3);
		switch (opcion) {
		case 0:
			resultado=raiz(valor1, valor3);
			break;
		case 1:
			resultado = promediar (valor1, valor2, valor3);
			
			break;
		case 2:
			resultado = equacionMat(valor1,valor2, valor3);
			break;
		case 3:
			resultado = promediar (valor1, valor2, valor3);
			resultado = resultado/equacionMat(valor1, valor1, valor2);
			break;

		default:
			break;
		}
		
		System.out.println(resultado);

	}
	public static float equacionMat(float valor1, float valor2, float valor3) {
		float resultado = raiz(valor1, valor3);
		resultado = resultado/valor2;
		return resultado;
	}
	public static float promediar(float valor1, float valor2, float valor3) {
		float resultado = ((valor1 + valor2 + valor3)/3);
		return resultado;
	}
	public static float raiz(float valor1, float valor3) {
		float resultado;
		if (valor1>valor3) {
			resultado = (float) Math.sqrt(valor1 - valor3);
		} else {
			System.out.println("no se puede hacer la raiz de un numero menor a 0");
			resultado = 0;
		}
		return resultado;
	}
	public static float obtenerFloat() {
		float valor = -1;
		while (valor<0) {
			try {
				System.out.println("ingrese in valor con decimales");
				valor = new Float (entrada.readLine());
			} catch (Exception exc) {
				System.out.println("El valor no es valido, vuelva a intentralo");

			}			
		}
		return valor;
	}
	public static int ingresar() {
		int ingresoValido=-1;
		while ((ingresoValido<0)||(ingresoValido>MAXopcion)) {
			try {
				System.out.println("Opción 0: Obtener raiz cuadrada de la resta entre valor1 y valor3\nOpción 1: Obtener el promedio de los 3 valores\nOpción 2: Obtener el resultado de la función EquacionMat(v1,v2,v3) = raiz de (v1-v3)/v2\nOpción 3: Obtener el resultado del cociente entre el promedio los 3 floats ingresados y EquacionMat(valor1,valor1,valor2)");

				ingresoValido = new Integer(entrada.readLine());
			} catch (Exception exc) {
				System.out.println( exc );
				ingresoValido=-1;
			}
		}
		return ingresoValido;
	}
}
