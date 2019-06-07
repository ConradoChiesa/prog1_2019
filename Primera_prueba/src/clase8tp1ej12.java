/*Dada una matriz de enteros, ordenar la matriz de forma
ascendente.*/
public class clase8tp1ej12 {
    public static int MAXNUM = 100;
    public static int MAXFIL = 10;
    public static int MAXCOL = 5;
    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        cargar_matriz(matNxM);
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);
        ordenar_matriz_enteros_menor_mayor(matNxM, MAXFIL,MAXCOL);
        System.out.println("");
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);

    }

    private static void ordenar_matriz_enteros_menor_mayor(int[][] matNxM, int maxfila, int maxcol) {
        int fila=0, col=0, pos_col_menor, pos_fila_menor, i, j, AUX;
        while (fila < maxfila) {
            pos_fila_menor = fila;
            pos_col_menor = col;
            i = fila;
            j = col;
            while(i < maxfila) {
                if (matNxM[i][j] < matNxM[pos_fila_menor][pos_col_menor]) {
                    pos_fila_menor = i;
                    pos_col_menor = j;
                }
            j++;
            if (j >= maxcol) { j=0; i++;}

            }
            if (pos_col_menor != col || pos_fila_menor != fila) {
                AUX = matNxM[fila][col];
                matNxM[fila][col] = matNxM[pos_fila_menor][pos_col_menor];
                matNxM[pos_fila_menor][pos_col_menor] = AUX;
            }
            col++;
            if (col >= maxcol) {col = 0; fila++;}
        }
    }

    public static void cargar_matriz(int[][] mat) {
        for (int i = 0 ; i < MAXFIL; i++)
            for (int j = 0 ; j < MAXCOL; j++)
                //mat[i][j] = (int)(Math.random()*MAXNUM+1);
                mat[i][j] = obtener_entero(MAXNUM); //Si no existe la funcion obtener entero comentar esta linea y descomentar la anterior
    }

    public static int obtener_entero(int rango) {
        int entero = (int)(Math.random()*rango+1);
        return entero;
    }

}
