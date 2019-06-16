
public class branch {
    //VARIABLES
//    int matProdSuc[][] = new int[central.MAXROW][central.MAXPRODUCTS];
    private int matProdSuc[][];
    private String branchName;

    public branch (String name) {
        branchName = name;
        matProdSuc = new int[central.MAXROW][central.MAXPRODUCTS];
        inticMat(matProdSuc);
    }

    //METODOS GETTER
    public void listProds(){
        System.out.println("Pruductos En sucursal " + branchName);
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (matProdSuc[central.ROWPROD][i] != -1) {
                System.out.print("Id producto -> " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
                System.out.println("");
            }
        }
    }

//    public int [][] getMat() { return matProdSuc; }
//    public void printMatSuc () {
//        System.out.println("Matriz completa de la sucursal ");
//        for (int i = 0; i < central.MAXPRODUCTS; i++) {
//            System.out.print("Id producto -> " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
//            System.out.println("");
//        }
//    }

    //METODOS SETTER
    public void inticMat(int [][] mat) {
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                mat[i][j] = -1;
            }
        }
    }

    public void addProducts(int posProd, int reload) {

        if (matProdSuc[central.ROWPROD][posProd] != -1 && matProdSuc[central.ROWMINPROD][posProd] != -1) {
            if ((matProdSuc[central.ROWPROD][posProd] + reload) > matProdSuc[central.ROWMAXPROD][posProd]) {
                System.out.println("En la sucursal "+branchName+" No hay lugar para tantos productos");
            } else {
                matProdSuc[central.ROWPROD][posProd] += reload;
            }
        }

/*        if (matProdSuc[central.ROWPROD][posProd] != -1 && matProdSuc[central.ROWMINPROD][posProd] != -1) {
            if ((matProdSuc[central.ROWPROD][posProd] += reload) > matProdSuc[central.ROWMAXPROD][posProd]) {
                matProdSuc[central.ROWPROD][posProd] += reload;
            } else {
                System.out.println("No hay lugar para tantos productos");
            }
        } else {
            System.out.println("EL producto no esta inicializado");
        }   */
    }
    public void sellProd(int posProd, int selled) {
        if (matProdSuc[central.ROWPROD][posProd] != -1) {
            if (matProdSuc[central.ROWPROD][posProd] >= selled) {
                matProdSuc[central.ROWPROD][posProd] -= selled;
            } else {
                System.out.println("No hay suficientes productos para realizar la venta.\n" +
                        "Solo puede venderse " + matProdSuc[central.ROWPROD][posProd]);
            }
        } else {
            System.out.println("La sucursal "+ branchName + " no opera este producto");
        }
    }
    public void startProd (int posProd, int prods, int min, int max) {
        matProdSuc[central.ROWPROD][posProd] = prods;
        matProdSuc[central.ROWMINPROD][posProd] = min;
        matProdSuc[central.ROWMAXPROD][posProd] = max;
    }

    public String branchName(String branchName) {
        return branchName;
    }

    public void listUnstock() {
        int countReload;
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (evaluateProd(i)) {
                countReload = ProdToReload(i);

                System.out.println("En la sucursal "+ branchName +" el producto "+ i +" Se necesita completar con "+ countReload);
            }
        }
    }

    private int ProdToReload(int prod) {
        int result = ((matProdSuc[central.ROWMINPROD][prod] + matProdSuc[central.ROWMAXPROD][prod]) / 2) - matProdSuc[central.ROWPROD][prod];
        return result;
    }

    public void reloadIfPosible() {
        int countReload;
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (evaluateProd(i)) {
                countReload = ProdToReload(i);
                System.out.println("En la sucursal "+ branchName +" el producto "+ i +" Se necesita completar con "+ countReload);
            }
        }
    }
    private boolean evaluateProd(int prod) { //evalua si el producto esta po debajo del mínimo
        boolean valid = true;
            if (matProdSuc[central.ROWPROD][prod] == -1 || matProdSuc[central.ROWPROD][prod] > matProdSuc[central.ROWMINPROD][prod])
                valid = false;
        return valid;
    }
}
