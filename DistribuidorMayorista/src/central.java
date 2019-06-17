public class central {
    //VARIABLES

    final static int MAXPRODUCTS = 5; // Maximo de productos distintos o columnas de la matriz
    final static int MAXROW = 3; // Maximo de filas
    private final static int MAXBRANCH = 10; // Maximo de sucursales
    final static int ROWPROD = 0; // Fila de cantidad de productos
    final static int ROWMINPROD = 1; // Fila cantidad minima de productos
    final static int ROWMAXPROD = 2; // Fila cantidad maxima de productos
    private int matProd [][] = new int[MAXROW][MAXPRODUCTS];
    private branch branches [] = new branch[MAXBRANCH];
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

    public void listNetworkStatus() {
        printMatProd();
        for (int i = 0; i < branchesCount; i++) {
            branches[i].listProds();
        }
    }

//    public void listBranchUnstockProds() {
//        for (int i = 0; i < branchesCount; i++) {
//            branches[i].listUnstock();
//        }
//    }

    //METODOS SETTER
    public void reloadbranches() {
        int reload, prod;
        for (int i = 0; i < branchesCount; i++) {
            reload = 0;
            prod = branches[i].reloadIfPosibleProd();
            if (prod != -1) {
                reload = branches[i].prodToReload(prod);
                if (reload < matProd[ROWPROD][prod]) {
                    matProd[ROWPROD][prod] -= reload;
                    branches[i].reload(prod, reload);
                }
            }
        }
    }
    public void createBranch (branch suc) {
        if (branchesCount < MAXBRANCH) {
            branches[branchesCount] = suc;
            System.out.println("Sucursal "+branchesCount+" creada con exito");
            branchesCount ++;
        } else {
            System.out.println("No se pueden crear más sucursales");
        }
    }

    public void loadProduct(int posProd, int cantProd) {
        if (cantProd < 0 || (cantProd + matProd[ROWPROD][posProd]) > matProd[ROWMAXPROD][posProd]) {
            if (cantProd + matProd[ROWPROD][posProd] > matProd[ROWMAXPROD][posProd]) {
                System.out.println("La cantidad de productos supera el máximo establecido");
            } else {
                System.out.println("El mínimo de productos a cargar es uno");
            }
        } else {
            matProd[ROWPROD][posProd] += cantProd;
        }
    }

    public void setMinOfProd(int posProd, int min) {
        if (min > -1) {
            matProd[ROWMINPROD][posProd] = min;
        } else {
            System.out.println("El mínimo de productos debe ser mayor o igual a cero");
        }
    }

    public void setMaxOfProd(int posProd, int max) {

        if (posProd >= 0 && posProd < MAXPRODUCTS) {
            if (max > matProd[ROWMINPROD][posProd]) {
                matProd[ROWMAXPROD][posProd] = max;
            } else {
                System.out.println("El máximo de poductos debe ser mayor al mínimo");
            }
        } else {
            System.out.println("El número de producto ingresado esta fuera de los posibles");

        }
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

    /*-----------------------------------------------------------*/
    //Esta funcion me imprime cualquier cosa
    public void printMat (int mat[][]) {
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            System.out.println("Pruductos En "+ i );
            if (mat[central.ROWPROD][i] != -1) {
                System.out.print("Id producto -> " + i + " Cantidad -> " + mat[central.ROWPROD][i] + ", Mínimo -> "+ mat[central.ROWMINPROD][i] + ", Máximo -> "+ mat[central.ROWMAXPROD][i]);
                System.out.println("");
            }
        }
    }

    public void printBranchProd(){
        for (int i = 0; i<branchesCount; i++)
            System.out.println("En la sucursal "+i);
    }

}

