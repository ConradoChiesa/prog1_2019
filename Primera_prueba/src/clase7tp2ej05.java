/*5. Hacer un programa que elimine un elemento en un arreglo
(ordenado decrecientemente) de tamanio MAX=10. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase7tp2ej05 {
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    final static int MAX = 10;
    final static int MAXNUM = 100;

    public static void main(String[] args) {
        int [] nums = new int[MAX];
        int pos;
        llenararreglo(nums);
        imprimirarr(nums);
        selecciondes(nums);
        imprimirarr(nums);
        pos=pedirvalor(nums, MAXNUM);
        corrimiento(nums, pos);
        imprimirarr(nums);

    }

    public static void corrimiento(int[] nums, int pos) {
        if ((pos != 0)&&(pos<MAX/2)) {
            corrimientoder(nums, pos);
        } else {
            corrimientoizq(nums, pos);
        }
    }

    public static void llenararreglo(int[] arr) {
        for (int  i=0;i<MAX;i++) {
            arr[i] = obtener_entero(MAXNUM);
        }
    }

    public static int obtener_entero(int rango) {
        int entero = (int)(Math.random()*rango+1);
        return entero;
    }

    public static void selecciondes(int arr[]) {
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
        for (int j = pos_ini + 1; j < pos_fin; j++){
            if (arr[j] > menor) {
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
            System.out.print(h+ ": [" +arr[h-1]+"]   ");
        System.out.println("");

    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public static int pedirvalor(int[] arr, int max) {
        int valor = -1, pos=-1;
        while (!((valor>0)&&(valor<max))&&(pos==-1)) {
            try {
                imprimir("\ningrese valor que desea borrar");
                valor = new Integer(entrada.readLine());
            }catch(Exception exc) {
                System.out.println(exc);
                valor=-1;
            }
            pos = encontrar_valor(arr, valor, 0, MAX);
            if (pos == -1) {
                imprimir("El Número no fue encontrado");
                valor =-1;
            }
        }

        return pos;
    }

    public static int encontrar_valor(int arr[], int buscado, int pi, int pf) {

        int pos=-1;
        for (int i = pi; i < pf; i++) {
            if (arr[i]==buscado) pos=i;
        }
        return pos;
    }

    public static void corrimientoder(int[] arr, int pos) {
        int indice = pos;
        while (indice > 0) {
            arr[indice]=arr[indice-1];
            indice--;
        }
    }

    public static void corrimientoizq(int[] arr, int pos) {
        int indice = pos;
        while (indice < MAX-1) {
            arr[indice]=arr[indice+1];
            indice++;
        }
    }
}
