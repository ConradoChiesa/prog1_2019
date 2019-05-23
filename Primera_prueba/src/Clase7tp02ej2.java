package Practicos2019;

public class Clase7tp02ej2 {
	final static int MAX = 10;
	public static void main(String[] args) {
		int arr[]=new int[MAX];
		llenararreglo(arr); //Lo llena de forma aleatoria
		seleccion(arr); // Lo ordena de menor a mayor
		imprimirarr(arr); // Imprime el arreglo
	}
	
	public static void seleccion(int arr[]) {
		int i, pos;
		for (i = 0; i < MAX; i++) { 
			pos = i; 
			pos = obtener_posicion_menor_arreglo(arr, pos, MAX);
			if (pos != i){
			intercambiar_contenido_arreglo(arr, i, pos);
			}
		}
	}
	
	public static int obtener_posicion_menor_arreglo(int[] arr, int pos_ini, int pos_fin) {
		int menor = arr[pos_ini];
		for (int j = pos_ini + 1; j < MAX; j++){
			if (arr[j] < menor) {
				menor = arr[j];
				pos_ini = j;
			}
		}
		return pos_ini;
	}
	
	public static void intercambiar_contenido_arreglo(int[] arr, int i, int pos) {
		int tmp = arr[i];
		arr[i] = arr[pos];
		arr[pos] = tmp;
	}

	
	public static void imprimirarr(int[] arr) {
		
		for (int h=1;h<=MAX;h++) 
			System.out.print(h+ ": " +arr[h-1]+"   ");
	}
	
	
	public static void llenararreglo(int[] arr) {
		for (int  i=0;i<MAX;i++) {
			arr[i] = obtenerEnteros();
		}		
	}
	
	public static int obtenerEnteros() {
		int temp = (int)(MAX*Math.random()+1);
		return temp;
	}
}