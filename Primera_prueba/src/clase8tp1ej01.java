import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8tp1ej01 {
    public final static int MAX = 10;
    public final static int MAXNUM = 100;
    public final static char MINOP = 'a';
    public final static char MAXOP = 'b';
    public final static char SI = 's';
    public final static char NO = 'n';
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int mat[][] = new int[MAX][MAX];
        cargar_matriz(mat);
        imprimir_matriz(mat);
        menu(mat);
    }

    private static void menu(int[][] mat) {

        char opcion = ' ';
        boolean salir = false;
        while (!salir) {
            System.out.println("Ingrese una opción:\n" +
                    "a) Obtener la suma de una diagonal.\n" +
                    "b) Invierta el contenido entre las posiciones inicio y fin de una fila dada."
            );
            opcion = pedir_char_opcion_valido();
            switch (opcion) {
                case 'a': obtener_sum_diagonal(mat);
                    break;
                case 'b': inv_con_pos_ini_y_fin_fila(mat);
                    break;
            }
        }
    }

    private static void inv_con_pos_ini_y_fin_fila(int[][] mat) {
        int pos_ing = pedir_numero(MAX-1);
        intercambiar_cont_fila(mat, pos_ing, 0, MAX-1);
        imprimir_matriz(mat);
        System.out.println(pos_ing);
    }

    private static void intercambiar_cont_fila(int[][] mat, int fila, int p1, int p2) {
        int AUX;
        AUX = mat[fila][p1];
        mat[fila][p1] = mat[fila][p2];
        mat[fila][p2] = AUX;
    }

    private static void obtener_sum_diagonal(int[][] mat) {
        int sum = 0;
        char sino = ' ';
        for (int i = 0; i < MAX; i++) {
            sum += mat[i][i];
        }
        System.out.println(sum);
        System.out.println("Desea sumar la diagonal transversa: 'SI': s   'NO': n");
        sino = peguntarsiono();
        if (sino == SI) {
            sum_diag_trans(mat);
        }

    }

    private static void sum_diag_trans(int[][] mat) {
        int sum = 0, col = MAX-1;
        for (int i = 0; i < MAX; i++) {
            //for (int j = MAX-1; j >= 0 ; j--) {
                sum += mat[i][col--];
           // }
        }
        System.out.println(sum);
    }

    private static char peguntarsiono() {
        char valido = ' ';
        while ((valido != SI) && (valido != NO) ) {
            valido = pedir_char();

        }
        return valido;
    }

    private static char pedir_char() {
        char valido = ' ';
        try {
            System.out.println("Ingrese una opción:");
            valido = (char) (entrada.readLine().charAt(0));
        } catch (Exception exc) {
            System.out.println("Debe ingresar un caracter valido");
            valido = ' ';
        }
        return valido;
    }

    private static char pedir_char_opcion_valido() {
        char valido = ' ';
        while ((valido < MINOP) || (valido > MAXOP) ) {
            valido = pedir_char();
        }
        return valido;

    }

    public static void cargar_matriz(int[][] mat) {
        for (int i = 0 ; i < MAX; i++)
            for (int j = 0 ; j < MAX; j++)
                //mat[i][j] = (int)(Math.random()*MAXNUM+1);
                mat[i][j] = obtener_entero(MAXNUM); //Si no existe la funcion obtener entero comentar esta linea y descomentar la anterior
    }

    public static int obtener_entero(int rango) {
        int entero = (int)(Math.random()*rango+1);
        return entero;
    }

    public static void imprimir_matriz(int[][] mat) {
        for (int i = 0 ; i < MAX; i++){
            for (int j = 0 ; j < MAX; j++)
                System.out.print(j+": ["+mat[i][j]+"] ");
            System.out.println("");
        }
    }


    private static int pedir_numero (int maximo) {
        int valorvalido = -1;
        while ((valorvalido < 0)||(valorvalido > maximo)) {
            try {
                System.out.println("Ingrese un entero entre 0 y "+maximo);
                valorvalido = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
            }
        }
        return valorvalido;
    }
}
