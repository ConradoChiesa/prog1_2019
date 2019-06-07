
public class sucursal {
    //VARIABLES
    int matProdSuc[][] = new int[casaCentral.MAXROW][casaCentral.MAXPRODUCTS];

    //METODOS GETTER
    public sucursal() {
        setMatProdSuc(matProdSuc);

    }
    public void printMatSuc (int[][] matProdSuc) {
        for (int i = 0; i < casaCentral.MAXROW; i++) {
            for (int j = 0; j < casaCentral.MAXPRODUCTS; j++) {
                System.out.println(matProdSuc[i][j]);
            }
        }
    }

    //METODOS SETTER
    public void setMatProdSuc(int[][] matProdSuc) {
        for (int i = 0; i < casaCentral.MAXROW; i++) {
            for (int j = 0; j < casaCentral.MAXPRODUCTS; j++) {
                matProdSuc[i][j] = -1;
            }
        }
    }

    public void addProducts(int [][] matProdSuc, int posProd, int reload) {
        matProdSuc[casaCentral.ROWPROD][posProd] += reload;
    }

}
