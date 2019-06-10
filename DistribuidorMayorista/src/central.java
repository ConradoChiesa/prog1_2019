public class central {
    //VARIABLES

    final static int MAXPRODUCTS = 5;
    final static int MAXROW = 3;
    final static int MAXSUC = 10;
    final static int ROWPROD = 0;
    final static int ROWMINPROD = 1;
    final static int ROWMAXPROD = 2;
    private int [][] matProd = new int[MAXROW][MAXPRODUCTS];
    private branch[] branches = new branch[MAXSUC];
    private int branchesCount = 0;

    //METODOS GETTER

    public void printMatProd () {
        System.out.println("Pruductos En Central");
        for (int j = 0; j < central.MAXPRODUCTS; j++) {
            System.out.print("Id producto: " + j + " Cantidad -> " + matProd[ROWPROD][j] + ", Mínimo -> "+ matProd[ROWMINPROD][j] + ", Máximo -> "+ matProd[ROWMAXPROD][j]);
            System.out.println("");
        }
    }
    public void printBranchProd(){
        for (int i = 0; i<branchesCount; i++)
            System.out.println("En la sucursal "+i);
    }
    //METODOS SETTER

    public void createBranch (branch num) {
        if (branchesCount < MAXSUC-1) {
            branches[branchesCount] = num;
            branchesCount ++;
        } else {
            System.out.println("No se pueden crear más sucursales");
        }
    }

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
            setMinOfProd(i, min);
            setMaxOfProd(i, max);
//            matProd[ROWMINPROD][i] = min;
//            matProd[ROWMAXPROD][i] = max;
        }
    }
    public void sellProd(int posProd, int selled) {
        if (matProd[ROWPROD][posProd] >= selled) {
            matProd[ROWPROD][posProd] -= selled;
        } else {
            System.out.println("No hay suficientes productos para realizar la venta.\n" +
                    "Solo puede vnderse " + matProd[ROWPROD][posProd]);
        }
    }
}
