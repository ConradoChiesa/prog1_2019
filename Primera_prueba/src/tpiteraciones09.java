package Practicos2019;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tpiteraciones09 {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		final int listas=2;
		final int maxval=15;
		int acumulado1=0, acumulado2=0, ingreso=0; 
		boolean valido = false;
		for (int i=0;i<listas;i++) {
			System.out.println("Ingrese valores a la lista "+ (i+1));
			for (int j=0;j<maxval;j++) {
				//valido=false;
				do {
					try {
						System.out.println("Ingrese un valor entero");
						ingreso = new Integer(entrada.readLine());
						valido=true;
					}catch (Exception exc){
						System.out.println( exc );
						valido=false;
					}
				}while(!valido);
				if (i==0) {
					acumulado1 += ingreso;
				}else if (i==1) {
					acumulado2 += ingreso;
				}
			}
		}
		if (acumulado1>acumulado2) {
			System.out.println("Lista 1 Mayor");
		} else if (acumulado1<acumulado2) {
			System.out.println("Lista 2 Mayor");
		} else {
			System.out.println("Son iguales");
		}
	}

}
