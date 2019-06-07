public class imPant {

    public static void chars(char cararter){
        System.out.println(cararter);
    }
    public static void numero(int num){
        System.out.println(num);
    }
    public static void cad_chars(String texto){
        System.out.println(texto);
    }
//    public static void entero(int num){
//        System.out.println(num);
//    }
//    public static void entero(int num){
//        System.out.println(num);
//    }
    public static void imprimir_matriz_chars(char[][] mat, int topeFila, int topeColum) {
        System.out.print("   ");
        for (int i = 0; i < topeColum; i++) {
            System.out.print("  "+i+" ");
        }
        System.out.println("");
        for (int i = 0 ; i < topeFila; i++){
            System.out.print(i + ":] ");
            for (int j = 0 ; j < topeColum; j++)
                System.out.print("["+mat[i][j]+"] ");
            System.out.println("");
        }
    }
    public static void imprimir_matriz_enteros(int[][] mat, int fila, int col) {
        for (int i = 0 ; i < fila; i++){
            System.out.print(i + ": ");
            for (int j = 0 ; j < col; j++)
                System.out.print(j+": ["+mat[i][j]+"] ");
            System.out.println("");
        }
    }
}
