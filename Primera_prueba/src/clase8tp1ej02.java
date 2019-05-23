import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Dada una matriz de m × n enteros, realizar los métodos necesarios
para insertar una fila en la posición pos.*/
public class clase8tp1ej02 {
    public static int MAXNUM = 100;
    public static int MAXFIL = 5;
    public static int MAXCOL = 3;
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        cargar_matriz(matNxM);
        imprimir_matriz(matNxM);
        insertar_fila_en_pos(matNxM);
    }

    public static void insertar_fila_en_pos(int[][] matNxM) {
        System.out.println("Ingrese numero de fila a insertar. NOTA: Se eliminará la última fila");
        int fil_ing = pedir_numero(MAXFIL-1);
        correr_filas(matNxM, fil_ing);
        //System.out.println(fil_ing);
        imprimir_matriz(matNxM);
    }

    public static void correr_filas(int[][] matNxM, int fila) { //fila es la posición de insercion de fila
        int col = MAXCOL - 1, fil = MAXFIL - 1;
        if (fila < MAXFIL - 1) {
            while (fil > fila) {
                for (int i = 0; i < MAXCOL; i++) {
                    matNxM[fil][i] = matNxM[fil-1][i];
                }
                fil--;
            }

        }
        borrar_cont_fila(matNxM,fila);
    }

    private static void borrar_cont_fila(int[][] matNxM, int fila) {
        for (int i = 0; i < MAXCOL; i++) matNxM[fila][i] = -1;
    }

    public static int pedir_numero (int maximo) {
        int valorvalido = -1;
        while ((valorvalido < 0)||(valorvalido > maximo)) {
            try {
                System.out.println("Ingrese un entero entre 0 y "+ maximo);
                valorvalido = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
            }
        }
        return valorvalido;
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
        for (int i = 0 ; i < MAXFIL; i++){
            for (int j = 0 ; j < MAXCOL; j++)
                System.out.print(j+": ["+mat[i][j]+"] ");
            System.out.println("");
        }
    }

}
