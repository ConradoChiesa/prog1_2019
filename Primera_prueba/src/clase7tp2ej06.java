import java.io.BufferedReader;
import java.io.InputStreamReader;

/*6. Hacer un programa que elimine los valores pares en un arreglo de
tamaño MAX=10.*/
public class clase7tp2ej06 {
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public final static int MAX = 10;
    public final static int MAXNUM = 100;
    public final static int mult2 =2;

    public static void main(String[] args) {

        int [] nums = new int[MAX];
        llenararreglo(nums);
        imprimirarr(nums);
        buscar_borrar_pares(nums);
        imprimirarr(nums);

    }

    public static void buscar_borrar_pares(int[] nums) {
        int pos=0, pos_de_par=-1;
        while (pos < MAX) {
            pos_de_par = buscar_posicion(nums, pos);
            if (pos_de_par == 0){
                corrimientoizq(nums, pos_de_par);
                pos--;
            } else {
                corrimientoder(nums, pos_de_par);
            }
            pos++;
        }
    }

    public static int buscar_posicion(int[] nums, int pos) {
        int pos_de_par = -1;

        while ((pos_de_par == -1) && (pos < MAX)) {
            if (nums[pos]%mult2 == 0) {
                pos_de_par = pos;
            }
           pos++;
        }
        return pos_de_par;
    }


    /*corrimiento de 0 hasta la posicion inclusive
    * si el primero es para hacer corrimiendo a izq completo*/

    public static void corrimientoizq(int[] arr, int pos) {
        int indice = pos;
        while (indice < MAX-1) {
            arr[indice]=arr[indice+1];
            indice++;
        }
    }

    public static void corrimientoder(int[] arr, int pos) {
        int indice = pos;
        while (indice > 0) {
            arr[indice]=arr[indice-1];
            indice--;
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
