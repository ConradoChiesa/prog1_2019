import java.io.BufferedReader;
import java.io.InputStreamReader;

public class parcialAlan {

    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public final static int MAX = 5;
    public final static int MAXNUM = 10;
    public static void main(String[] args) {
        //int matNxN[][] = new int[MAX][MAX];
        //clase8tp1ej4.cargar_matriz(matNxN, MAX, MAX, MAXNUM);
        int matNxN[][] = {
                {1,0,0,0,5},
                {0,2,0,4,0},
                {0,0,3,0,0},
                {0,2,0,2,5},
                {5,0,0,0,1},
        };
        imPant.imprimir_matriz_enteros(matNxN, MAX, MAX);
        buscar_capicua_diag_a(matNxN); //diagonal izq der arriba abajo (0,0) a (9,9)
        buscar_capicua_diag_b(matNxN); //diagonal izq der abajo arriba (0,9) a (9,0)
    }

    private static void buscar_capicua_diag_a(int[][] matNxN) {
        //declarar variables
        int pos_ini = 0, pos_fin = MAX-1;
        boolean nocapicua = false;
        //comprar desde [0,0] a [9,9]
        while (pos_ini < pos_fin && !nocapicua) {
            if (!compara(matNxN, pos_ini, pos_ini, pos_fin, pos_fin)) {
                System.out.println("La diagonal A no es capicua");
                nocapicua = true;
            }
            pos_ini++;
            pos_fin--;
        }
        if (!nocapicua) System.out.println("La diagonal A es capicua");
    }

    private static boolean compara(int[][] matNxN, int fila1, int col1, int fila2, int col2) {
        if (matNxN[fila1][col1] != matNxN[fila2][col2]) return false;
        return true;
    }

    private static void buscar_capicua_diag_b(int[][] matNxN) {
       //declarar variables
        int pos_ini = 0, pos_fin = MAX-1;
        boolean nocapicua = false;
       //comprar desde [0,0] a [9,9]
        while (pos_ini < pos_fin && !nocapicua) {
            if (!compara(matNxN, pos_ini, pos_fin, pos_fin, pos_ini)) {
                System.out.println("La diagonal B no es capicua");
                nocapicua = true;
            }
            pos_ini++;
            pos_fin--;
        }
        if (!nocapicua) System.out.println("La diagonal B es capicua");
    }
}
