
public class branch {
    //VARIABLES
//    int matProdSuc[][] = new int[central.MAXROW][central.MAXPRODUCTS];
    private int matProdSuc[][];
    private String branchName;

    public branch (String name) {
        branchName = name;
        matProdSuc = new int[central.MAXROW][central.MAXPRODUCTS];
        inicMat(matProdSuc);
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

    private boolean evaluateProd(int prod) { //evalua si el producto lo opera la sucursal y esta por debajo del mínimo
        boolean valid = true;
        if (matProdSuc[central.ROWPROD][prod] == -1 || matProdSuc[central.ROWPROD][prod] > matProdSuc[central.ROWMINPROD][prod])
            valid = false;
        return valid;
    }


    //METODOS SETTER
    private void inicMat(int [][] mat) {
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                mat[i][j] = -1;
            }
        }
    }

    public void addProducts(int posProd, int reload) {

        if (matProdSuc[central.ROWPROD][posProd] != -1 && matProdSuc[central.ROWMINPROD][posProd] != -1) {
            if ((matProdSuc[central.ROWPROD][posProd] + reload) > matProdSuc[central.ROWMAXPROD][posProd]) {
                System.out.println("En la sucursal "+branchName+" No hay lugar para tantos productos\n");
            } else {
                matProdSuc[central.ROWPROD][posProd] += reload;
            }
        }
    }
    public void sellProd(int posProd, int selled) {
        if (matProdSuc[central.ROWPROD][posProd] != -1) {
            if (matProdSuc[central.ROWPROD][posProd] >= selled) {
                matProdSuc[central.ROWPROD][posProd] -= selled;
            } else {
                System.out.println("No hay suficientes productos para realizar la venta.\n" +
                        "Solo puede venderse " + matProdSuc[central.ROWPROD][posProd]+"\n");
            }
        } else {
            System.out.println("La sucursal "+ branchName + " no opera este producto\n");
        }
    }
    public void startProd (int posProd, int prods, int min, int max) {
        String error = "";
        if (prods <= max && posProd > -1 && posProd < central.MAXPRODUCTS) {
            matProdSuc[central.ROWPROD][posProd] = prods;
            matProdSuc[central.ROWMINPROD][posProd] = min;
            matProdSuc[central.ROWMAXPROD][posProd] = max;
        } else {
            if (prods > max) {
                error = "Los productos son más de los que se pueden almacenar\n";
            } else if (posProd < 0 || posProd >= central.MAXPRODUCTS){
                error = "El producto de la posición " + posProd + " no existe\n";
            }
            System.out.println("ERROR en la carga, mensaje de error: " + error);
        }
    }

    public int prodToReload(int prod) {
        int result = ((matProdSuc[central.ROWMINPROD][prod] + matProdSuc[central.ROWMAXPROD][prod]) / 2) - matProdSuc[central.ROWPROD][prod];
        return result;
    }

    public int reloadIfPosibleProd() {
        int AUX = -1;
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (AUX == -1 && evaluateProd(i)) {
                AUX = i;
            }
        }
        return AUX;
        /*CONSULTAR LA SIGUIENTE POSIBILIDAD

            for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (evaluateProd(i)) {
                return = i;
            }
        }
        return -1;
         */
    }


    public void reload(int prod, int reload) {
        if (reload + matProdSuc[central.ROWPROD][prod] < matProdSuc[central.ROWMAXPROD][prod]){
        matProdSuc[central.ROWPROD][prod] += reload;
        } else {
            System.out.println("La cantidad de productos supera el máximo que se puede stockear\n");
        }

    }

    public int maxReload(int prod) {
        int count = 0;
        count = matProdSuc[central.ROWMAXPROD][prod] - matProdSuc[central.ROWPROD][prod];
        return count;
    }
    public String branchName() { return branchName; }

}


/*  NUNCA USADAS

    public int [][] getMat() { return matProdSuc; }
    public void printMatSuc () {
        System.out.println("Matriz completa de la sucursal ");
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            System.out.print("Id producto -> " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
            System.out.println("");
        }
    }

        public void listUnstock() {
        int countReload;
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (evaluateProd(i)) {
                countReload = prodToReload(i);
                System.out.println("En la sucursal "+ branchName +" el producto "+ i +" Se necesita completar con "+ countReload);
            }
        }
    }


*/