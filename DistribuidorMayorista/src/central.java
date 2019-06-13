public class central {
    //VARIABLES

    final static int MAXPRODUCTS = 5; // Maximo de productos distintos o columnas de la matriz
    final static int MAXROW = 3; // Maximo de filas
    final static int MAXSUC = 10; // Maximo de sucursales
    final static int ROWPROD = 0; // Fila de cantidad de productos
    final static int ROWMINPROD = 1; // Fila cantidad minima de productos
    final static int ROWMAXPROD = 2; // Fila cantidad maxima de productos
    private int matProd [][] = new int[MAXROW][MAXPRODUCTS];
    private branch branches [] = new branch[MAXSUC];
    private int branchesCount = 0;

    //METODOS GETTER
    public central () {
        setInicMat(matProd);
    }

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

    public void createBranch (branch suc) {
        if (branchesCount < MAXSUC-1) {
            branches[branchesCount] = suc;
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
        }
    }
    public void sellProd(int posProd, int selled) {
        if (matProd[ROWPROD][posProd] >= selled) {
            matProd[ROWPROD][posProd] -= selled;
        } else {
            System.out.println("No hay suficientes productos para realizar la venta.\n" +
                    "Solo puede venderse " + matProd[ROWPROD][posProd]);
        }
    }

    private void setInicMat(int [][] mat) {
        for (int i = 0; i < MAXROW; i++) {
            for (int j = 0; j < MAXPRODUCTS; j++) {
                mat[i][j] = 0;
            }
        }
    }
}
