
public class branch {
    //VARIABLES
    int matProdSuc[][] = new int[central.MAXROW][central.MAXPRODUCTS];

    //METODOS GETTER
    public void printMatProd () {
        for (int i = 0; i < central.MAXROW; i++) {
            System.out.println("");
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                System.out.print(" "+ matProdSuc[i][j] + " ");
            }
        }
        System.out.println("");
    }
    public void printMatSuc () {
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                System.out.println(matProdSuc[i][j]);
            }
        }
    }

    //METODOS SETTER
    public void setMatProdSuc() {
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                matProdSuc[i][j] = -1;
            }
        }
    }

    public void addProducts(int [][] matProdSuc, int posProd, int reload) {
        matProdSuc[central.ROWPROD][posProd] += reload;
    }

}
