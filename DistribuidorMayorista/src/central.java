public class central {
    //VARIABLES

    final static int MAXPRODUCTS = 5;
    final static int MAXROW = 3;
    final static int MAXSUC = 10;
    final static int ROWPROD = 0;
    final static int ROWMINPROD = 1;
    final static int ROWMAXPROD = 2;
    int [][] matProd = new int[MAXROW][MAXPRODUCTS];
    int [] cantSuc = new int[MAXSUC];

    //METODOS GETTER

    public void printMatProd () {
//        for (int i = 0; i < central.MAXROW; i++) {
//            System.out.println("");
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                System.out.print("Id producto: " + j + " cantidad: " + matProd[ROWPROD][j] + ", mínimo :"+ matProd[ROWMINPROD][j] + ", máximo :"+ matProd[ROWMAXPROD][j]);
        System.out.println("");
            }
//        }
    }

    public void createBranch () {
        
    }


    //METODOS SETTER

    public void loadProduct(int posProd, int cantProd) {
        matProd[ROWPROD][posProd] += cantProd;
    }

    public void setMinOfProd (int posProd, int min) {
        matProd[ROWMINPROD][posProd] = min;
    }

    public void setMaxOfProd (int posProd, int max) {
        matProd[ROWMAXPROD][posProd] = max;
    }

    public void setAllMinMax (int min, int max) {
        for (int i = 0; i < MAXPRODUCTS; i++) {
            matProd[ROWMINPROD][i] = min;
            matProd[ROWMAXPROD][i] = max;
        }
    }
    public void sellProd(int posProd, int selled) { matProd[ROWPROD][posProd] -= selled; }
}
