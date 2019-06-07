/*Dada una matriz de m × n enteros, realizar los métodos necesarios
para ordenar cada una de sus filas.*/

public class clase8tp1ej4 {
    public static int MAXNUM = 100;
    public static int MAXFIL = 5;
    public static int MAXCOL = 2;
    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        cargar_matriz(matNxM, MAXFIL, MAXCOL, MAXNUM);
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);
        ordenar_mat_asc(matNxM);
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);
    }

    private static void ordenar_mat_asc(int[][] matNxM) {

        for (int i = 0; i < MAXFIL; i++) {
            ordenar_fila_mayamen(matNxM, i);
        }
    }

    private static void ordenar_fila_mayamen(int[][] matNxM, int fila) {
        int AUX;
        for (int j = 1; j < MAXCOL; j++) {
            for (int k = 0; k < MAXCOL-1; k++) {
                if (matNxM[fila][k] > matNxM[fila][k+1]) {
                    AUX = matNxM[fila][k];
                    matNxM[fila][k] = matNxM[fila][k+1];
                    matNxM[fila][k+1] = AUX;
                }
            }
        }
    }

    public static void cargar_matriz(int[][] mat,int fila, int col,int maximo) {
        for (int i = 0 ; i < fila; i++)
            for (int j = 0 ; j < col; j++)
                //mat[i][j] = (int)(Math.random()*MAXNUM+1);
                mat[i][j] = obtener_entero(maximo); //Si no existe la funcion obtener entero comentar esta linea y descomentar la anterior
    }

    public static int obtener_entero(int rango) {
        int entero = (int)(Math.random()*rango+1);
        return entero;
    }



}
