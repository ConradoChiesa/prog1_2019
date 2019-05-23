package Practicos2019;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class tp5ep1 {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		final int MIN = 0;
		final int MAX = 10;
		int num = 0;
while(num<=0) {
	try {
		System.out.println("Ingrese un número natural");
		num = new Integer(entrada.readLine());
	}catch (Exception exc) {
		System.out.println(exc);
		num = 0;
	}
}
System.out.println("Tabla de multiplicar del " + num);
for (int i=MIN;i<=MAX;i++) {
	System.out.println(num+"x"+i+" = "+(num*i));
}
	}

}
