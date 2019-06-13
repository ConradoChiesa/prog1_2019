public class seg_parcial2019 {
    final static int M = 5;
    final static int N = 15;
    final static int MITAD = 2;

    public static void main(String[] args) {
        char[][] matMXN = {{' ','1','2','1',' ','3','4',' ',' ','1','2',' ','1',' ',' '},
                {' ','3','4','5',' ','1','2',' ',' ','1','1',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ','1','1',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ','3','4',' ',' ','1','1',' ','1',' ',' '}};
        buscar_borrar_sec_central(matMXN);
        imprimir_matriz(matMXN);
    }

    private static void buscar_borrar_sec_central(char[][] matMXN) {
        int pos_ini = 0, pos_fin = 0, contador = 0;
        for (int i = 0; i < M; i++) {
            pos_ini = 0; pos_fin = 0; contador = 0;
            while (pos_ini != -1 && pos_fin != -1) {
                pos_ini = buscar_pos_inicio(matMXN, pos_fin+1, i);
                if (pos_ini != -1) {
                    pos_fin = buscar_pos_fin(matMXN, pos_ini, i);
                }
                contador ++;
                pos_ini = buscar_pos_inicio(matMXN, pos_fin+1, i);
            }
            contador = (contador/MITAD)+1;
            borrar_sec(matMXN, i, contador);
        }
    }

    private static void borrar_sec(char[][] matMXN, int fila, int contador) {
        int pos_ini = 0, pos_fin = 0;
        while (contador != 0) {
            pos_ini = buscar_pos_inicio(matMXN, pos_fin+1, fila);
            pos_fin = buscar_pos_fin(matMXN, pos_ini, fila);
            contador--;
            if (contador == 0) {
                while (pos_fin >= pos_ini) {
                    borrar(matMXN, fila, pos_ini);
                    pos_fin--;
                }
                contador--;
            }
        }
    }

    private static void borrar(char[][] matMXN, int fila, int pos_ini) {
        while (pos_ini < N-1) {
            matMXN[fila][pos_ini] = matMXN[fila][pos_ini+1];
            pos_ini++;
        }
    }

    private static int buscar_pos_fin(char[][] matMXN, int pos_ini, int fila) {
        int pos_fin = -1;
        while (pos_fin == -1 && pos_ini < N) {
            if (matMXN[fila][pos_ini] == ' ') {
                pos_fin = pos_ini-1;
            }
            pos_ini++;
        }
        return pos_fin;
    }

    private static int buscar_pos_inicio(char[][] matMXN, int pos_fin, int fila) {
        int pos_ini = -1;
        while (pos_ini == -1 && pos_fin < N) {
            if (matMXN[fila][pos_fin] != ' ') {
                pos_ini = pos_fin;
            }
            pos_fin++;
        }
        return pos_ini;
    }

    private static void imprimir_matriz(char[][] matMXN) {
        System.out.println("-------------------");
        for (int i = 0 ; i < M; i++){
            for (int j = 0 ; j < N; j++)
                System.out.print(" "+matMXN[i][j]);
            System.out.println("");
        }
    }
}
