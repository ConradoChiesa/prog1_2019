public class carga_imprime_matNxM {
    public static int MAXNUM = 100;
    public static int MAXFIL = 5;
    public static int MAXCOL = 3;
    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        cargar_matriz(matNxM);
        imprimir_matriz(matNxM);
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
            System.out.print(i + ":] ");
            for (int j = 0 ; j < MAXCOL; j++)
                System.out.print("["+mat[i][j]+"] ");
            System.out.println("");
        }
    }

}
