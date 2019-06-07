import java.io.BufferedReader;
import java.io.InputStreamReader;

public class parcial2017T1 {
    public static int MAXFIL = 2;
    public static int MAXCOL = 100;
    public static int MAXNUM = 1000;

    public static void main(String[] args) {
        int matNxM[][] = new int[MAXFIL][MAXCOL];
        int valorCantidad = -1;
        cargar_num_y_cant_producto(matNxM);
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);
        valorCantidad = pedir_valor(MAXNUM);
        ord_cant_asc(matNxM);
        selec_imp_prod(matNxM, valorCantidad);
        System.out.println("");
        imPant.imprimir_matriz_enteros(matNxM, MAXFIL, MAXCOL);
    }

    private static void selec_imp_prod(int[][] matNxM, int valorCantidad) {
        int pos;
        pos = buscar_pos_valor(matNxM,valorCantidad);
        for (int i = MAXCOL-1; i <= pos ; i--) {
            System.out.print("Número de prod: "+i);
            System.out.print("Cantidad de prod: "+matNxM[1][i]);
        }
    }

    private static int buscar_pos_valor(int[][] matNxM, int valorCantidad) {
        int pos = 0, pos_cant = -1;
        while (pos < MAXCOL && pos_cant == -1) {
            if (matNxM[1][pos] <= valorCantidad) {
                pos_cant = pos;
            }
            pos++;
        }
        return pos_cant;
    }

    private static void ord_cant_asc(int[][] matNxM) {
        int i, j, menor, pos, aux;
        for (i = 0; i < MAXCOL; i++) {
            pos = i;
            menor = matNxM[1][i];
            for (j = i+1; j < MAXCOL; j++) {
                if (matNxM[1][j] < menor) {
                    menor = matNxM[1][j];
                    pos = j;
                }
            }
            if (pos != i) {
                aux = matNxM[0][i];
                matNxM[0][i] = matNxM[0][pos];
                matNxM[0][pos] = aux;
                aux = matNxM[1][i];
                matNxM[1][i] = matNxM[1][pos];
                matNxM[1][pos] = aux;
            }
        }
    }

    private static int pedir_valor(int maxnum) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int ingreso = -1;
        while (ingreso < 0 || ingreso > maxnum) {
            try {
                System.out.println("Ingrese un numero valido");
                ingreso = new Integer(entrada.readLine());
            } catch (Exception exc) {
                System.out.println( exc );
                System.out.println( "Ingreso INVALDO.\nVuelva a intentarlo" );
            }
        }
        return ingreso;
    }

    private static void cargar_num_y_cant_producto(int[][] matNxM) {
        for (int i = 0; i < MAXCOL; i++) {
            matNxM[0][i] = i+1;
        }
        for (int i = 0; i < MAXCOL; i++) {
            matNxM[1][i] = (int) (Math.random()*MAXNUM+1);
        }
    }
}
