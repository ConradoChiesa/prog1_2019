import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Dada una matriz de m × n de caracteres con filas que tienen
secuencias de caracteres separadas por uno o más espacios ‘ ’,
realizar un programa que reemplace todas las ocurrencias de una
secuencia patrón dada en un arreglo P, por la secuencia contenida
en el arreglo R (Las secuencias en P y R pueden tener distinto
tamaño).*/
public class clase8tp1ej09 {
    public static int MAXFIL = 5;
    public static int MAXCOL = 10;
    private static int MAXP = 2;
    private static int MAXR = 5;
    public static void main(String[] args) {
        //char p[] = new char[MAXP];
        //char r[] = new char[MAXR];
        char p [] = {'g','u'};
        char r [] = {'a','a','a','a','a'};
        char matNxM[][] = {
                {' ','b','e',' ','h',' ',' ',' ','d',' '},
                {' ','v','f','h','a',' ','l','d','s',' '},
                {' ',' ','v','r','r','e','j',' ',' ',' '},
                {' ','f','r',' ','g','u',' ',' ',' ',' '},
                {' ','y','i','g','g',' ',' ',' ','d',' '},
        };
        imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL); //Usando objetos por primera vez que lo utilizo y la mejore para que funcione imprimiendo matices MxN
        //pedir_config_usuario(p,r); //modularizar la carga
        imPant.cad_chars("Ingrese los cararteres consecuticos a buscar");
       // cargarChars(p, MAXP);
        imPant.cad_chars("Ingrese los cararteres por los que los desea reemplazar");
        //cargarChars(r, MAXR);
        //procesar
        buscar_procesar_sec(matNxM, p, r);
        //1:buscar secuencia, 2:comparar por longitud, 3: comparar elementos, 4:remplezar arrgelos
        //imprimir resultados
        imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL);
    }

    private static void buscar_procesar_sec(char[][] matNxM, char[] p, char[] r) {
        int ini_sec, fin_sec;
        for (int i = 0; i < MAXFIL; i++) {
            ini_sec = 0;
            fin_sec = 0;
            while (ini_sec != -1 && fin_sec != -1) {
                ini_sec = buscar_pos_ini(matNxM, i, fin_sec+1);
                if (ini_sec != -1){
                    fin_sec = buscar_pos_fin(matNxM, i, ini_sec);
                }
                if (comprobar(matNxM, i, p, ini_sec, fin_sec)) {
                    cambiar_sec(matNxM, i, r, ini_sec);
                    fin_sec = ini_sec + MAXR-1;
                }
                ini_sec = buscar_pos_ini(matNxM, i, fin_sec+1);

            }
        }
    }

    private static boolean comprobar(char[][] matNxM, int fila, char[] p, int ini_sec, int fin_sec) {
        boolean identica = true;
        for (int i = 0; i < MAXP; i++) {
            if (matNxM[fila][i + ini_sec] != p[i]) identica = false;
        }
        return identica;
    }

    private static void cambiar_sec(char[][] matNxM, int fila, char[] r, int ini_sec) {

        for (int i = 0; i < MAXR; i++) {
            matNxM[fila][i + ini_sec] = r[i];
        }
    }


    private static int buscar_pos_fin(char[][] matNxM, int i, int ini_sec) {
        int fin = -1;
        while (fin == -1 && ini_sec < MAXCOL) {
            if (matNxM[i][ini_sec] == ' ') fin = ini_sec-1;
            ini_sec ++;
        }
        return fin;
    }

    private static int buscar_pos_ini(char[][] matNxM, int i, int pos) {
        int inicio = -1;
        while (inicio == -1 && pos < MAXCOL) {
            if (matNxM[i][pos] != ' ')
                inicio = pos;

            pos++;
        }
        return inicio;
    }

    public static void cargarChars(char[] letras, int cant) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char ingreso = ' ';
        for (int i = 0; i < cant; i++) {
            ingreso = ' ';
            while (ingreso < 'a' || ingreso > 'z') {
                try {
                    System.out.println("Ingrese una letra minúscula");
                    ingreso = new Character(entrada.readLine().charAt(0));
                } catch (Exception exc) {
                    System.out.println( exc );
                    ingreso = ' ';
                }
            }
            letras[i] = ingreso;
        }
    }


}
