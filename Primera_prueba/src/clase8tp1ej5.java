/*Dada una matriz de m × n enteros ordenada ascendentemente
entre filas por la suma de contenido de cada fila, insertar una fila
cuyos elementos se encuentran en el arreglo nuevo de tamaño n
manteniendo el orden.*/
public class clase8tp1oj5 {
    public static int MAXNUM = 100;
    public static int MAXFIL = 10;
    public static int MAXCOL = 3;
    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        cargar_matriz(matNxM);
        imprimir_matriz(matNxM);
        ordenar_cont_fila(matNxM);
        //imprimir_matriz(matNxM);
        ordenar_filas_mayamen(matNxM);
        imprimir_matriz(matNxM);
    }

    private static void ordenar_cont_fila(int[][] matNxM) {
        int AUX;
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 1; j < MAXCOL; j++) {
                for (int k = 0; k < MAXCOL - 1; k++) {
                    if (matNxM[i][k] > matNxM[i][k+1]) {
                        AUX = matNxM[i][k];
                        matNxM[i][k] = matNxM[i][k+1];
                        matNxM[i][k+1] = AUX;
                    }
                }
            }
        }
    }

    private static void ordenar_filas_mayamen(int[][] matNxM) {
        suma_compara_acomodar_filas(matNxM);
    }

    private static void suma_compara_acomodar_filas(int[][] matNxM) {
        int sum_mayor = 0, sum_fila = 0, fil_may = 0;
        for (int i = 1; i < MAXFIL; i++) {
            for (int j = 0; j < MAXFIL - 1; j++) {
                //sum_fila = sumar_fila(matNxM, j);
                //System.out.println(i + ": " + sum_fila);

                if (sumar_fila(matNxM, i) < sumar_fila(matNxM, j)) {
                    sum_mayor = sum_fila;
                    intercambiar_filas(matNxM, j, i); //i = fila actual
                    fil_may = i;
                }
            }
        }
    }

    private static void intercambiar_filas(int[][] matNxM, int fil_may, int i) {
        int AUX;
        for (int j = 0; j < MAXCOL; j++) {
            AUX = matNxM[i][j];
            matNxM[i][j] = matNxM[fil_may][j];
            matNxM[fil_may][j] = AUX;
        }
    }

    private static int sumar_fila(int[][] matNxM, int i) {
        int sum = 0;
        for (int j = 0; j < MAXCOL; j++) {
            sum += matNxM[i][j];
        }
        return sum;
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
