import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8tp1oj7 {
        public static int MAXFIL = 5;
        public static int MAXCOL = 6;
        public static void main(String[] args) {
            int TAM = 0;
            //char matNxM[][] = new char[MAXFIL][MAXCOL];
            char matNxM[][] = {
                    {' ','b','e',' ','h',' '},
                    {' ','v','f','h','a',' '},
                    {' ',' ','v','r','r','e'},
                    {' ','f','r',' ','g','u'},
                    {' ','y','i','g','g',' '},
            };
            
            imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL);
            TAM = pedir_TAM();
            buscar_eliminar_sec(matNxM, TAM);
            imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL);
        }
//Este procedimineto fue hecho en la practica con un ayudante, contempla la excepción que devuelven posiciones -1

    private static void buscar_eliminar_sec(char[][] matNxM, int TAM) {
        int pos_ini = 0, pos_fin = 0;
        for (int fila = 0; fila < MAXFIL; fila++) {
            pos_ini = 0; pos_fin = 0;
            pos_ini = buscar_pos_ini(matNxM, fila, pos_fin);
            while (pos_ini != -1 && pos_fin != -1){
                if (pos_ini != -1) {
                    pos_fin = buscar_pos_fin(matNxM, fila, pos_ini);

                }

                //hacer cosas
                if (pos_fin - pos_ini == TAM - 1) {
                    corrimiento_izq(matNxM, fila, pos_ini, pos_fin);
                    pos_fin--;
                }
                pos_ini = buscar_pos_ini(matNxM, fila, pos_fin+1);
            }
        }

    }

    private static void corrimiento_izq(char[][] matNxM, int fila, int pos_ini, int pos_fin) {
        int pos_int = pos_fin+1;
//        while (pos_ini < pos_fin) {
        for (int i = pos_ini; i <= pos_fin; i++) {
            borrar_posicion(matNxM, fila, pos_ini);
//            pos_int++;
//            pos_ini++;
        }
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

    private static int pedir_TAM() {
        BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));
        int ingreso = 0;
        while (ingreso < 1 || ingreso > MAXCOL) {
            try {
                System.out.println("Ingrese un número entre 1 y "+ (MAXCOL-1));
                ingreso = new Integer(entrada.readLine());
            }catch (Exception exc) {
                System.out.println( exc );
                System.out.println("Debe ingresar un número valido");
            }
        }
        return ingreso;
    }

    //public static void cargar_matriz(char[][] mat) {
        //    for (int i = 0 ; i < MAXFIL; i++)
        //        for (int j = 0 ; j < MAXCOL; j++)
        //            //mat[i][j] = (int)(Math.random()*MAXNUM+1);
                    // mat[i][j] = obtener_entero(MAXNUM); //Si no existe la funcion obtener entero comentar esta linea y descomentar la anterior
        //}

        public static int obtener_entero(int rango) {
            int entero = (int)(Math.random()*rango+1);
            return entero;
        }



}
