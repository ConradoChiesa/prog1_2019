import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que invierta el orden de los elementos de un
arreglo de tamaño MAX=10.*/

public class clase7tp2ej07 {
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public final static int MAX = 10;
    public final static int MAXNUM = 100;

    public static void main(String[] args) {
        int [] nums = new int[MAX];
        llenararreglo(nums);
        imprimirarr(nums);
        invertir_orden_arr(nums, 0, MAX-1);
        imprimirarr(nums);
    }

    public static void invertir_orden_arr(int[] nums, int pi, int pf) {
        int aux;
        while (pi < pf) {
            aux = nums[pi];
            nums[pi] = nums[pf];
            nums[pf] = aux;
            pi++;
            pf--;
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

    public static void imprimirarr(int[] arr) {

        for (int h=1;h<=MAX;h++)
            System.out.print(h+ ": [(: " +arr[h-1]+" :)]   ");
        System.out.println("");

    }

}
