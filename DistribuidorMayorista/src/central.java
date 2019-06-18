public class central {
    //VARIABLES

    final static int MAXPRODUCTS = 5; // Maximo de productos distintos o columnas de la matriz
    final static int MAXROW = 3; // Maximo de filas
    final static int ROWPROD = 0; // Fila de cantidad de productos
    final static int ROWMINPROD = 1; // Fila cantidad minima de productos
    final static int ROWMAXPROD = 2; // Fila cantidad maxima de productos
    private final static int MAXBRANCH = 10; // Maximo de sucursales
    private int matProd [][] = new int[MAXROW][MAXPRODUCTS];
    private branch branches [] = new branch[MAXBRANCH];
    private int branchesCount = 0;

    //METODOS GETTER
    public central () {
        setInicMat(matProd);
    }


    public void printMatProd () { // Muestra el estado de la matriz o productos
        System.out.println("Pruductos En Central");
        for (int j = 0; j < central.MAXPRODUCTS; j++) {
            System.out.print("Id producto: " + j + " Cantidad -> " + matProd[ROWPROD][j] + ", Mínimo -> "+ matProd[ROWMINPROD][j] + ", Máximo -> "+ matProd[ROWMAXPROD][j]);
            System.out.println("");
        }
    }

    public void listNetworkStatus() { // Lista el estado de toda la red
        printMatProd();
        for (int i = 0; i < branchesCount; i++) {
            branches[i].listProds();
        }
    }

    public void getMaxCountProd(int prod) { // Devuelve cuanto se puede stockear como máximo de un producto en toda la red
        int maxToReload = matProd[ROWMAXPROD][prod] - matProd[ROWPROD][prod];
        for (int i = 0; i < branchesCount; i++) {
            maxToReload += branches[i].maxReload(prod);
        }
        System.out.println("Se pueden stokear del producto "+ prod + " " + maxToReload);
//        offerReload(prod, maxToReload);
    }

    //METODOS SETTER

    public void reloadbranches() { // Recarga todas las sucursales con productos
        int reload, posProd;
        for (int i = 0; i < branchesCount; i++) {
            posProd = branches[i].reloadIfPosibleProd();
            while (posProd != -1) {
                reload = branches[i].cantProdToReload(posProd);
                if (reload < matProd[ROWPROD][posProd]) {
                    matProd[ROWPROD][posProd] -= reload;
                    branches[i].loadProduct(posProd, reload);
                } else {
                    System.out.println("La central no dispone de tantos productos, ID prod = "+ posProd);
                }
                posProd = branches[i].reloadIfPosibleProd();
            }
        }
    }

    public void createBranch (branch suc) { // Instancia una sucursal
        String branchName;
        if (branchesCount < MAXBRANCH) {
            branches[branchesCount] = suc;
            branchName = branches[branchesCount].branchName();

            System.out.println("Sucursal "+branchesCount+" creada con exito con el nombre "+branchName+"\n");
            branchesCount ++;
        } else {
            System.out.println("No se pueden crear más sucursales\n");
        }
    }

    public void loadProduct(int posProd, int cantProd) { // Carga un producto
        if (cantProd < 0 || (cantProd + matProd[ROWPROD][posProd]) > matProd[ROWMAXPROD][posProd]) {
            if (cantProd + matProd[ROWPROD][posProd] > matProd[ROWMAXPROD][posProd]) {
                System.out.println("La cantidad de productos supera el máximo establecido\n");
            } else {
                System.out.println("El mínimo de productos a cargar es uno\n");
            }
        } else {
            matProd[ROWPROD][posProd] += cantProd;
        }
    }

    private void setMinOfProd(int posProd, int min) {
        if (min > -1 && min < matProd[ROWMAXPROD][posProd]) {
            matProd[ROWMINPROD][posProd] = min;
        } else {
            if (min < 0) {
                System.out.println("El mínimo de productos debe ser mayor o igual a cero\n");
            } else {
                System.out.println("El mínimo debe ser menor al máximo\n");
            }
        }
    }

    private void setMaxOfProd(int posProd, int max) {

        if (posProd >= 0 && posProd < MAXPRODUCTS) {
            if (max > matProd[ROWMINPROD][posProd]) {
                matProd[ROWMAXPROD][posProd] = max;
            } else {
                System.out.println("El máximo de poductos debe ser mayor al mínimo\n");
            }
        } else {
            System.out.println("El número de producto ingresado esta fuera de los posibles\n");
        }
    }

//    public void setAllMinMax (int min, int max) {
//        for (int i = 0; i < MAXPRODUCTS; i++) {
//            setMinOfProd(i, min);
//            setMaxOfProd(i, max);
//        }
//    }

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

    public void startProd (int posProd, int prods, int min, int max) { // Inicia un producto
        String error = "";
        if (prods <= max && posProd > -1 && posProd < MAXPRODUCTS) {
            setMaxOfProd(posProd, max);
            setMinOfProd(posProd, min);
            loadProduct(posProd, prods);
        } else {
            if (prods > max) {
                error = "Los productos son más de los que se pueden almacenar\n";
            } else if (posProd < 0 || posProd >= central.MAXPRODUCTS){
                error = "El producto de la posición " + posProd + " no existe\n";
            }
            System.out.println("ERROR en la carga, mensaje de error: " + error);
        }
    }


//    private void offerReload(int prod, int maxToReload) {
//        if (buyAndComplete()) {
//            matProd[RO]
//
//        }
//    }
//
//    private boolean buyAndComplete() {
//        boolean valid = false;
//            while ()
//        return valid;
//    }
}


//    public void listBranchUnstockProds() {
//        for (int i = 0; i < branchesCount; i++) {
//            branches[i].listUnstock();
//        }
//    }