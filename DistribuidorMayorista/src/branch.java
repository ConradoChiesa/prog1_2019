
public class branch {
    //VARIABLES
    int matProdSuc[][] = new int[central.MAXROW][central.MAXPRODUCTS];

    //METODOS GETTER
    public branch() {
        setMatProdSuc(matProdSuc);

    }
    public void printMatSuc (int[][] matProdSuc) {
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                System.out.println(matProdSuc[i][j]);
            }
        }
    }

    //METODOS SETTER
    public void setMatProdSuc(int[][] matProdSuc) {
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
