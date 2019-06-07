/*Dada una matriz de m × n de caracteres con filas que tienen
secuencias de caracteres separadas por uno o más espacios ‘ ’,
realizar un programa que ordene ascendentemente cada fila de la
matriz por tamaño de secuencias. Las secuencias deberán quedar
separadas por un carácter espacio siempre que haya lugar. */

public class clase8tp1oj10 {
    public static int MAXFIL = 3;
    public static int MAXCOL = 16;
    public static int MAXP = 2;
    public static int MAXR = 5;
    public static void main(String[] args) {
        char matNxM[][] = {
                {' ','r','e','a','l','i','z','a','r',' ',' ',' ','l','o','s',' '},
                {' ','e','j','e','r','c','i','c','i','o','s',' ',' ','y',' ',' '},
                {' ',' ',' ',' ',' ','p','r','a','c','t','i','c','o','s',' ',' '},
        };
        imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL); //Usando objetos por primera vez que lo utilizo y la mejore para que funcione imprimiendo matices MxN
        buscar_acomodar_sec(matNxM);
        //procesar
        //1:buscar secuencia, 2:comparar por longitud, 3: comparar elementos, 4:remplezar arrgelos
        //imprimir resultados
        imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL);
    }

    private static void buscar_acomodar_sec(char[][] matNxM) {

        //                 MODULARIZAR
        int pos_ini = 0, pos_fin = 0, ini_menor=0, fin_menor=MAXCOL, sec_menor = 0;
        for (int fila = 0; fila < MAXFIL; fila++) {

            pos_ini = 0; pos_fin = 0; ini_menor = 0; fin_menor=MAXCOL; sec_menor = 0;
            pos_ini = buscar_pos_ini(matNxM, fila, pos_fin);
            while (pos_ini != -1 && pos_fin != -1){
                if (pos_ini != -1) {
                    pos_fin = buscar_pos_fin(matNxM, fila, pos_ini);
                }
                //hacer cosas
                if (pos_fin-pos_ini < fin_menor-ini_menor) {
                  ini_menor = pos_ini;
                  fin_menor = pos_fin;
                  sec_menor = pos_fin-pos_ini+1;
                }
                pos_ini = buscar_pos_ini(matNxM, fila, pos_fin+1);
            }
            if (ini_menor != 1) {
                int pos = ini_menor, fin_int = 0;
                //while (!(pos > pos_fin)) {
                for (int i = 1; i <= sec_menor; i++) {
                    intercambiar(matNxM, fila, i, pos);
                    pos++;
                    fin_int = i+1;
                }
                while (matNxM[fila][fin_int] != ' ') {
                    char AUX;
                    AUX = matNxM[fila][fin_int];
                    borrar_posicion(matNxM, fila, fin_int);
                    //corrimiento_izq(matNxM, fila, pos, ini_menor);
                    matNxM[fila][pos_fin] = AUX;
                    //fin_int++;

                }
            }
            chequear_sep_sec(matNxM, fila); // chequea los espacios vacios y los borra dejando solo un espacio vacio ente secuencias
        }

    }

    private static void chequear_sep_sec(char[][] matNxM, int fila) {
        int pos_ini = 0, pos_fin = 0;
        //pos_ini = 0; pos_fin = 0;
        pos_ini = buscar_pos_ini(matNxM, fila, pos_fin);
        while (pos_ini != -1 && pos_fin != -1){
            if (pos_ini != -1)
                pos_fin = buscar_pos_fin(matNxM, fila, pos_ini);
            if (pos_fin != -1)
                pos_ini = buscar_pos_ini(matNxM, fila, pos_fin+1);
            while (pos_ini-pos_fin > 2) { //inicio menos fin sea > a 2
                borrar_posicion(matNxM, fila, (pos_fin + 2));
                pos_ini = buscar_pos_ini(matNxM, fila, pos_fin+1);
            }
        }
    }

    private static void intercambiar(char[][] matNxM, int fila, int i, int pos) {
        char AUX;
        AUX = matNxM[fila][pos];
        matNxM[fila][pos] = matNxM[fila][i];
        matNxM[fila][i] = AUX;
    }

    private static void borrar_posicion(char[][] matNxM, int fila, int pos_ini) {
        int AUX;
        while (pos_ini < MAXCOL) {
            if (pos_ini == MAXCOL-1) {
                matNxM[fila][pos_ini] = ' ';
            } else {
                matNxM[fila][pos_ini] = matNxM[fila][pos_ini+1];
            }
            pos_ini++;
        }
    }

    private static int buscar_pos_fin(char[][] matNxM, int fila, int pos_ini) {
        int pos_fin = -1;
        while (pos_fin == -1 && pos_ini < MAXCOL) {
            if (matNxM[fila][pos_ini] == ' ') {
                pos_fin = pos_ini-1;
            }
            pos_ini++;
        }
        return pos_fin;
    }

    private static int buscar_pos_ini(char[][] matNxM, int fila, int pos_fin) {
        int pos_ini = -1;
        while (pos_ini == -1 && pos_fin < MAXCOL) {
            if (matNxM[fila][pos_fin] != ' ') {
                pos_ini = pos_fin;
            }
            pos_fin++;
        }
        return pos_ini;
    }


}
