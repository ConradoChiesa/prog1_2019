/*Se tiene una matriz MAT de enteros de tamaño 5x20, donde en cada fila se tiene secuencias de
números distintos de cero separadas por uno o más ceros. Realizar un programa que para todas
las filas invierta el contenido de las secuencias que tienen tamaño N, y comienzan y terminan con
al menos un 1, siendo N un valor entero cargado desde teclado entre 0 y la cantidad de columnas.
Observaciones: Cada fila empieza y termina con uno o más ceros. Recuerde definir constantes y
modularizar la solución con procedimientos y funciones.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class seg_parcial_2018 {
    public static int MAXFIL=5;
    public static int MAXCOL=20;
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int tam_sec_ing = -1;
        //int matnxm[][] = new int[MAXFIL][MAXCOL];
        int matnxm[][] = {
                {0,1,7,4,2,1,0,0,0,0,0,9,5,4,2,3,0,0,0,0},
                {0,5,3,4,3,1,0,0,1,2,2,9,1,0,5,3,1,0,0,0},
                {0,1,3,4,3,4,0,0,1,2,2,9,1,0,2,3,0,0,0,0},
                {0,1,4,4,3,6,1,0,1,5,2,9,1,0,1,0,1,0,0,0},
                {0,2,7,4,3,7,0,0,1,2,4,9,1,0,0,3,0,0,0,0},
        };
        tam_sec_ing = pedir_numero(MAXCOL-1);
        buscar_procesar_sec(matnxm, tam_sec_ing);
        imprimir_matriz(matnxm);
    }

    private static void buscar_procesar_sec(int[][] matnxm, int tam_sec_ing) {
        int pi = 0, pf = 0, itercol = 0;
        for (int fila = 0; fila < MAXFIL; fila++) {
            itercol = 0; pi = 0; pf = 0;
            while (itercol < MAXCOL && pi != -1) {
                pi=buscar_pi_sec(matnxm, fila, pf);
                if (pi < MAXCOL && pi != -1){
                    pf=buscar_pf(matnxm, fila, pi);
                }
                if (pf-pi == tam_sec_ing-1 && matnxm[fila][pi] == 1 && matnxm[fila][pf] == 1) {
                    invertir_contenido_sec(matnxm, fila, pi, pf);
                }
                itercol = pf++;
                itercol++;
            }
        }
    }

    private static void invertir_contenido_sec(int[][] matnxm, int fila, int pi, int pf) {
        int AUX;
        while (pi <= pf) {
            AUX = matnxm[fila][pi];
            matnxm[fila][pi] = matnxm[fila][pf];
            matnxm[fila][pf] = AUX;
            pi++; pf--;
        }
    }

    public static int buscar_pi_sec(int[][] matnxm, int fila, int pos_ini) {
        int pi = -1;
        while ((pi == -1) && (pos_ini < MAXCOL)) {
            if (matnxm[fila][pos_ini] != 0) {
                pi = pos_ini;
            }
            pos_ini++;
        }
        return pi;
    }

    public static int buscar_pf(int[][] matnxm, int fila, int pi) {
        int pf = -1;
        while (pf == -1 && pi<MAXCOL) {
            if (matnxm[fila][pi] == 0) {
                pf = pi-1;
            }
            pi++;
        }
        if (pf == -1) pf = MAXCOL-1;
        return pf;
    }

    public static int pedir_numero(int maxrango) {
        int valor=-1;
        while ((valor<0)||(valor>maxrango)) {
            try {
                System.out.println("ingrese tamaño de secuencia a buscar");
                valor = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
                System.out.println("Vuelva a intentarlo");
            }
        }
        return valor;
    }
    public static void imprimir_matriz(int[][] mat) {
        System.out.print("   ");
        for (int i = 0; i < MAXCOL; i++) {
            System.out.print("  "+i+"  ");
        }
        System.out.println("");
        for (int i = 0 ; i < MAXFIL; i++){
            System.out.print(i + "  ");
            for (int j = 0 ; j < MAXCOL; j++)
                System.out.print("["+mat[i][j]+"] ");
            System.out.println("\n");
        }
    }
}
