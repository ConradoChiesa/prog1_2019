package Practicos2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase7tp02ej1 {
	static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	final static int MAX = 10;
	final static int MAXNUM = 100;
	public static void main(String[] args) {
		int valor;
		int [] nums = new int[MAX];
		llenararreglo(nums);
		ordenararr(nums);
		imprimirarr(nums);
		valor=pedirvalor();
		insertarvalor(nums, valor);
		imprimirarr(nums);
		
	}
	
	public static void insertarvalor(int[] nums, int valor) {
		int pos=buscarpos(nums, valor);
		corrimientoder(nums, pos);
		nums[pos]=valor;
		//System.out.println(pos);
		
//		corrimientoder(nums);
//		int pos=0;
		//pos = encontrarpos(nums);
	}

	public  static int buscarpos(int[] nums, int valor) {
		int pos=0;
		while((pos<MAX)&&(nums[pos]<valor)) {
			pos++;
		}
		return pos;
	}

	public static int pedirvalor() {
		int valor = -1;
		while (!((valor>0)&&(valor<MAXNUM))) {
			try {
				System.out.println("\n\ningrese valor a insertar");
				valor = new Integer(entrada.readLine());
			}catch(Exception exc) {
				System.out.println(exc);
				valor=-1;
			}
		}
		
		return valor;
	}
	public static void corrimientoder(int[] arr, int pos) {
		int indice = MAX-1;
		while (indice>=pos) {
				arr[indice]=arr[indice-1];
				indice--;
			}
		}
	public static void imprimirarr(int[] nums) {
		for (int j = 1; j <= MAX; j++) 
			System.out.print(j+ ": " +nums[j-1]+"   ");		
	}

	public static void llenararreglo(int[] arr) {
		for (int  i=0;i<MAX;i++) {
			arr[i] = obtener_entero();
		}		
	}
	
	public static int obtener_entero() {
		int entero= (int)(Math.random()*MAXNUM+1);
		return entero;
	}
	
	public static void ordenararr(int[] arr) {
		int temp;
		for(int	i = 1;i < MAX;i++){
			for (int j = 0 ; j < MAX-1; j++){
				if (arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	} 
}
	
//	public static void insercion (int arr[]) { //Ordena por insección
//		for (int i = 1; i < MAX; i++) {
//			int aux = arr[i];
//			int j = i - 1;
//			while ((j >= 0) && (arr[j] > aux)){
//				arr[j+1] = arr[j]; j--;
//			}
//			arr[j+1] = aux;
//		}
//	}
//	public static void selección(int[] nums) { //Ordena por selección
//		int i, j, menor, pos, temp;
//		for (i = 0; i < MAX; i++) {
//			menor = nums[i];
//			pos = i;
//			for (j = i+1; j < MAX; j++) {
//				if (nums[j]<menor) {
//					menor = nums[j];
//					pos = j;
//				}
//			}
//			if (pos!=i) {
//				temp = nums[i];
//				nums[i] = nums[pos];
//				nums[pos] = temp;
//			}
//		}
//	}
//	public static void burbujeo (int[] arr){ //Ordena por burbujeo
//		int temp;
//		for(int	i = 1;i < MAX;i++){
//			for (int j = 0 ; j < MAX - 1; j++){
//				if (arr[j] > arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
//	} 

