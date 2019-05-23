
public class Clase7tp02ejbis {
	final static int MAX = 10;
	final static int MAXNUM = 100;
	public static void main(String[] args) {
		int arr[]=new int[MAX];
		llenararreglo(arr); //Lo llena de forma aleatoria
		insercion(arr); // Lo ordena de menor a mayor
		imprimirarr(arr); // Imprime el arreglo
	}
	public static void insercion (int arr[]) { //Ordena por insección
	for (int i = 1; i < MAX; i++) {
		int aux = arr[i];
		int j = i - 1;
		while ((j >= 0) && (arr[j] > aux)){
			intercambiarpos(arr, (j+1), j);
			j--;
		}
		intercambiarvalor(arr, (j+1), aux);
	}
		
		
}
	private static void intercambiarvalor(int[] arr, int i, int aux) {
		arr[i] = aux;
		
	}
	private static void intercambiarpos(int[] arr, int i, int j) {
		arr[i] = arr[j];
		
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
		int temp = (int)(MAXNUM*Math.random()+1);
		return temp;
	}
}
