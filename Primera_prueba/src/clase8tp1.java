import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8tp1 {
    final static int MAX = 10; // Filas y columnas matriz
    final static int MAXNUM = 100; //Maximo número a cargar
    final static int MAXOP = 4; //Opciones

    public static void main (String args[]){
           int mat [][] = new int [MAX][MAX];
           int col, fil;
        cargar_matriz(mat);
        imprimir_matriz(mat);
        ofreceropciones(mat);

    }

    public static void ofreceropciones(int mat[][]) {
        imprimirmensaje("OPCIONES\n1: Sumar una columna dada.\n" +
                "2: Sumar una fila dada.\n" +
                "3: Invierta el contenido entre las posiciones inicio y fin de una fila dada.\n" +
                "4: Armar SUDOKU.");
        int opcion;
        opcion = pedir_numero(MAXOP);
        switch (opcion){
            case 1: sumarColumna(mat);break;
            case 2: sumarFila(mat);break;
            case 3: invertir_posicion_fila(mat);break;
            case 4: armar_sudoku(mat);break;
        }
    }
/*--------------------------------------------------------------------------------------------------------------------*/
/*Esto es un ejercicio que pense en hacer en base a un juego que me gusta, SUDOKU*/

    public static void armar_sudoku(int mat[][]) {
        // mat = new int [MAX][MAX];
        int tmp = 0;
        boolean valid = false;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                int pos = mat[i][j];
                do {
                    valid=buscarfilcol(mat, pos, i, j);

                    if (valid) {
                        tmp = obtener_entero(MAX);
                        mat[i][j] = tmp;
                    }
                }while (valid);

            }
        }

                imprimir_matriz(mat);
    }

    public static boolean buscarfilcol(int mat[][], int buscado, int fil, int col) {
        boolean valid = false;
        int acumuladofil = 0, acumuladocol = 0;
        while (!((acumuladofil > 1)||(acumuladocol > 1))){
            for (int i = 0; i < MAX; i++) {
                if (mat[fil][i] == buscado) {
                    acumuladofil++;
                }
            }
            for (int i = 0; i < MAX; i++) {
                if (mat[i][col] == buscado) {
                    acumuladocol++;
                }
            }
        }
        if ((acumuladofil > 1)||(acumuladocol > 1)) {
            valid=true;
        }
        return valid;
    }


    /*--------------------------------------------------------------------------------------------------------------------*/

    public static void intercambiar_contenido_arreglo(int[][] arr, int pos_ini, int pos_fin, int fil) {
        int tmp = arr[fil][pos_ini];
        arr[fil][pos_ini] = arr[fil][pos_fin];
        arr[fil][pos_fin] = tmp;
    }

    public static void invertir_posicion_fila(int[][] mat) {
        imprimirmensaje("Ingrese numero de fila");
        int fil = obtener_fila_colum();
        intercambiar_contenido_arreglo(mat, 0, (MAX-1), fil);
        imprimir_matriz(mat);
       // int fil = (pedir_numero(MAX)-1);
    }

    public static int obtener_fila_colum() {
        int filcol = (pedir_numero(MAX)-1);
        return filcol;
    }

    public static void sumarColumna(int mat[][]) {
        imprimirmensaje("Ingrese numero de columna");
        int col = obtener_fila_colum();
        int suma = 0;
        for (int i = 0; i<MAX; i++) {
            suma += mat[i][col];
        }
        System.out.println("La suma de la columna "+(col+1)+" es: "+suma);

    }

    public static void sumarFila(int mat[][]) {
        imprimirmensaje("Ingrese numero de fila");
        int fil = obtener_fila_colum();
        int suma = 0;
        for (int i = 0; i<MAX; i++) {
            suma += mat[fil][i];
        }
        System.out.println("La suma de la fila "+(fil+1)+" es: "+suma);
    }

    public static void imprimirmensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static int pedir_numero (int MAXOP) {
        int valorvalido = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        while ((valorvalido<1)||(valorvalido>MAXOP)) {
            try {
                System.out.println("Ingrese un entero entre 1 y "+MAXOP);
                valorvalido = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
            }
        }
        return valorvalido;
    }

    public static void cargar_matriz(int[][] mat) {
        for (int i = 0 ; i < MAX; i++)
            for (int j = 0 ; j < MAX; j++)
                mat[i][j] = (int)(Math.random()*MAXNUM+1);
    }

    public static void imprimir_matriz(int[][] mat) {
        for (int i = 0 ; i < MAX; i++){
            for (int j = 0 ; j < MAX; j++)
                System.out.print(" "+mat[i][j]);
            System.out.println("");
        }
    }

    public static int obtener_entero(int rango) {
        int entero = (int)(Math.random()*rango+1);
        return entero;
    }
}
