import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase7tp2ej08 {
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public final static int MAX = 20;
    public final static int MAXPAT = 4;
    public final static int MAXNUM = 100;
    public final static int MAXOP = 6;

    public static void main(String args[]) {
       //int nums[] = new int[MAX];
        int nums[] = {12,5,2,0,0,54,32,23,14,0,8,0,0,65,45,0,0,43,0,8};
     //   int comparar[] = {23,67,0,0};

        //llenararreglo(nums);
        imprimirarr(nums);
        menu(nums);
    }

    public static void menu(int nums[]) {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("OPCIONES\n" +
                    "1: Devoler la posición de inicio y fin de la primer sec de números distinta de ceros.\n" +
                    "2: Devoler la posición de inicio y fin de la sec de números distintos de ceros cuya suma del contenido sea mayor.\n" +
                    "3: Devoler la posición de inicio y fin de la anteúltima secuencia " +
                            "de números distintos de ceros.\n" +
                    "4: Hacer un programa que dado un número N ingresado por el " +
                            "usuario, elimine las secuencias de tamaño N de números distintos" +
                            "de cero.\n"+
                    "5: Hacer un programa que elimine de un arreglo todas las " +
                            "ocurrencias de una secuencia patrón dada por otro arreglo.\n" +
                    "6: Elimine de un arreglo todas las secuencias" +
                            "que tienen orden descendente entre sus elementos.\n" +
                    "0: Para salir.");
            opcion = pedir_numero(MAXOP);
            switch (opcion) {
                case 1: primer_sec(nums);
                    break;
                case 2: sec_mayor(nums);
                    break;
                case 3: anteultima_sec(nums);
                    break;
                case 4: buscar_borrar_sec_n(nums);
                    break;
                case 5: buscar_borrar_sec_patron(nums);
                    break;
                case 6: buscar_eliminar_sec_desc(nums);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Anda a dormir querido suerte");
                    break;
            }
        }
    }

    private static void buscar_eliminar_sec_desc(int[] nums) {
        int pos_ini = 0, pos_fin = -1;
        boolean decreciente = false;
        while (pos_ini < MAX) {
            pos_ini = buscar_pi_sec(nums, pos_fin+1);
            pos_fin = buscar_pf(nums, pos_ini);
            decreciente = verificar_decrecimiento(nums, pos_ini, pos_fin);
            if (decreciente) borrar_sec_n(nums, pos_ini, pos_fin+1);
            pos_ini = pos_fin;
            pos_ini++;
        }
        imprimirarr(nums);
    }

    private static boolean verificar_decrecimiento(int[] nums, int pos_ini, int pos_fin) {
        boolean decreciente = true;
        while ((decreciente) && (pos_ini < pos_fin)) {
            if (nums[pos_ini]<nums[pos_ini+1]) decreciente = false;
            pos_ini++;
        }
        return decreciente;
    }

    public static void buscar_borrar_sec_patron(int[] nums) {
        int patron[] = new int[MAXPAT];
        llenarpatron(patron);
        buscar_sec_patron(nums, patron);
        imprimirarr(nums);
    }

    public static void buscar_sec_patron(int[] nums, int[] patron) {
        int pos = 0, pos_pat = 0, pi = 0, pf = 0;
        while(pos < MAX) {
            pos_pat = 0;
            if (nums[pos] == patron[pos_pat]) {
                pi = pos;
                while ((pos_pat<MAXPAT) && (nums[pos] == patron[pos_pat])) {
                    pos++; pos_pat++;
                    if (pos_pat == MAXPAT-1) {
                        pf = ++pos;
                        borrar_sec_n(nums, pi, pf);
                        pos_pat = 0;
                    }
                }
            }
         pos++;
        }
    }

    public static void llenarpatron(int[] patron) {
        for (int i = 0; i < MAXPAT; i++) patron[i] = pedir_numero(MAXNUM);
    }

    public static void buscar_borrar_sec_n(int[] nums) {
        int ingresado = pedir_numero(MAX);
        buscar_sec_n(nums, ingresado);
    }

    public static void buscar_sec_n(int[] nums, int n) {
        int pos = 0, sum_ite = 0, pos_ini = 0, pos_fin = 0;

        while (pos < MAX) {
            if (nums[pos] != 0) {
                pos_ini = buscar_pi_sec(nums, pos_fin);
                pos_fin = buscar_pf(nums, pos_ini);
                pos = pos_fin;
                pos_fin++;
                if (pos_fin-pos_ini == n) {
                    borrar_sec_n(nums, pos_ini, pos_fin);
                }
            }
            pos++;
        }
        imprimirarr(nums);
    }

    public static void borrar_sec_n(int[] nums, int pos_ini, int pos_fin) {

        for (int i = pos_ini; i < pos_fin; i++)
            nums[i] = -1;

    }

    public static void anteultima_sec(int[] nums) {
        int pi = 0, pias = -1, pfas = -1;
        pi = buscar_ultima_sec(nums); //posicion inicio ultima secuencia
        //Buscar la anteultima  secuencia
        pfas = buscar_dist_cero_inverso(nums, pi-1);
        pias = buscar_ini_sec_atras_adelante(nums, pfas);
        System.out.println("la anteúltima secuendia comienza en la posición "+pias+" y termina en la posición "+pfas+".\n");
    }

    private static int buscar_dist_cero_inverso(int[] nums, int pi) {
        int pf = -1;
        while ((pf == -1) && (pi>0)) {
            if (nums[pi] != 0) {
                pf = pi;
            }
            pi--;
        }
        return pf;
    }

    public static int buscar_ini_sec_atras_adelante(int[] nums, int pos) {
        int pf = -1, pi = -1;
        while ((pi == -1) && (pos > 0)) {
            if (nums[pos] == 0) {
                pi = pos+1;
            }
            pos--;
        }
        return pi;
    }

    public static int buscar_ultima_sec(int[] nums) {
        int pos = MAX-1, pf = -1, pi = -1;
        while ((pi == -1) && (pos > 0)) {
            if (nums[pos] != 0) {
               pi = buscar_pi_con_pf(nums, pos);
            }
            pos--;
        }
        return pi;
    }

    public static int buscar_pi_con_pf(int[] nums, int pf) {
        int pi = -1;
        while ((pi == -1) && (pf > 0)) {
            if (nums[pf] == 0) {
                pi = pf+1;
            }
            pf--;
        }
        if (pi == -1) pi++;
        return pi;
    }

    public static void sec_mayor(int[] nums) {
        int sum_sec_may = 0, sum_aux, pi_may = -1, pf_may = -1;
        int pos = 0;
        int pos_ini = 0, pos_fin = 0;
        while(pos_fin<MAX) {

            pos_ini = buscar_pi_sec(nums, pos_fin);// pos_ini va a tener la primer posicion de la sec siguiente
            pos_fin = buscar_pf(nums, pos_ini);
            sum_aux = sumar_valores(nums, pos_ini, pos_fin);
            if (sum_aux > sum_sec_may) {
                sum_sec_may = sum_aux;
                pi_may = pos_ini;
                pf_may = pos_fin;
            }
            pos_fin++;
            pos++;
        }
        System.out.println("La secuencia mayor se encuentra entre " + pi_may + " y " + pf_may + ", con un valor de " + sum_sec_may +".\n");
    }

    public static int sumar_valores(int[] nums, int pos_ini, int pos_fin) {
        int sum = 0;
        for (int i = pos_ini; i <= pos_fin ; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int buscar_pi_sec(int[] nums, int pos_ini) {
        int pi = -1, pos = pos_ini;
        while ((pi == -1) && (pos < MAX)) {
            if (nums[pos] != 0) {
                pi = pos;
            }
            pos++;
        }
        return pi;
    }

    public static int buscar_pf(int[] nums, int pi) {
        int pf = -1;
        while ((pf == -1) && (pi<MAX)) {
            if (nums[pi] == 0) {
                pf = pi-1;
            }
            pi++;
        }
        if (pf == -1) pf = MAX-1;
        return pf;
    }

    public static int pedir_numero (int maximo) {
        int valorvalido = -1;
        while ((valorvalido<0)||(valorvalido>maximo)) {
            try {
                System.out.println("Ingrese un entero entre 1 y "+maximo);
                valorvalido = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
            }
        }
        return valorvalido;
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
        for (int h=0;h<MAX;h++)
            System.out.print(h+ ": [(: " +arr[h]+" :)]   ");
        System.out.println("");
    }

    public static void primer_sec(int[] nums) {
        int pi = -1, pf = -1;
        pi = buscar_pi_sec(nums, 0);
        pf = buscar_pf(nums, pi);
        System.out.println("La primer secuencia comienza en la posición "+pi+ " y termina en la " + pf);
    }

}
