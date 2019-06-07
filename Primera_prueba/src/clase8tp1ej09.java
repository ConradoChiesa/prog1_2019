import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Dada una matriz de m × n de caracteres con filas que tienen
secuencias de caracteres separadas por uno o más espacios ‘ ’,
realizar un programa que reemplace todas las ocurrencias de una
secuencia patrón dada en un arreglo P, por la secuencia contenida
en el arreglo R (Las secuencias en P y R pueden tener distinto
tamaño).*/
public class clase8tp1oj09 {
    public static int MAXFIL = 5;
    public static int MAXCOL = 10;
    public static int MAXP = 2;
    public static int MAXR = 5;
    public static void main(String[] args) {
        char p[] = new char[MAXP];
        char r[] = new char[MAXR];
        char matNxM[][] = {
                {' ','b','e',' ','h',' ',' ',' ','d',' '},
                {' ','v','f','h','a',' ','l','d','s',' '},
                {' ',' ','v','r','r','e','j',' ',' ',' '},
                {' ','f','r',' ','g','u','e',' ',' ',' '},
                {' ','y','i','g','g',' ',' ',' ','d',' '},
        };
        imPant.imprimir_matriz_chars(matNxM, MAXFIL, MAXCOL); //Usando objetos por primera vez que lo utilizo y la mejore para que funcione imprimiendo matices MxN
        //pedir_config_usuario(p,r); //modularizar la carga
        imPant.cad_chars("Ingrese los cararteres consecuticos a buscar");
        cargarChars(p, MAXP);
        imPant.cad_chars("Ingrese los cararteres por los que los desea reemplazar");
        cargarChars(r, MAXR);
        //procesar
        //1:buscar secuencia, 2:comparar por longitud, 3: comparar elementos, 4:remplezar arrgelos
        //imprimir resultados
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
