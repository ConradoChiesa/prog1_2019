public class casaCentral {
    //VARIABLES
    final static int MAXPRODUCTS = 5;
    final static int MAXROW = 3;
    final static int MAXSUC = 10;
    final static int ROWPROD = 0;
    final static int ROWMINPROD = 1;
    final static int ROWMAXPROD = 2;
    int [][] matProd = new int[MAXROW][MAXPRODUCTS];

    //METODOS GETTER

    public void printMat () {
        for (int i = 0; i < casaCentral.MAXROW; i++) {
            System.out.println("");
            for (int j = 0; j < casaCentral.MAXPRODUCTS; j++) {
                System.out.print(matProd[i][j]);
            }
        }
    }

    public void getSucursales () {
        
    }


    //METODOS SETTER

}
