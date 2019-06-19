
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
    public void listProds(){ // Lista los productos que posee la sucursal
        System.out.println("Pruductos En sucursal " + branchName);
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (matProdSuc[central.ROWPROD][i] != -1) {
                System.out.print("Id producto -> " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
                System.out.println("");
            }
        }
    }

    private boolean evaluateProd(int prod) { // Evalua si el producto lo opera la sucursal y esta por debajo del mínimo
        boolean valid = true;
        if (matProdSuc[central.ROWPROD][prod] == -1 || matProdSuc[central.ROWPROD][prod] > matProdSuc[central.ROWMINPROD][prod])
            valid = false;
        return valid;
    }

    public int maxReload(int prod) { //Devuelve el máximo a recargar de un producto
        int count = 0;
        count = matProdSuc[central.ROWMAXPROD][prod] - matProdSuc[central.ROWPROD][prod];
        return count;
    }

    public String branchName() { return branchName; } // Devuelve el nombre de la sucursal


    //METODOS SETTER

    private void inicMat(int [][] mat) { // Setea la matriz inicial
        for (int i = 0; i < central.MAXROW; i++) {
            for (int j = 0; j < central.MAXPRODUCTS; j++) {
                mat[i][j] = -1;
            }
        }
    }

    public void loadProduct(int posProd, int reload) { // Agrega productos
        if (matProdSuc[central.ROWPROD][posProd] != -1 && matProdSuc[central.ROWMINPROD][posProd] != -1) {
            if ((matProdSuc[central.ROWPROD][posProd] + reload) > matProdSuc[central.ROWMAXPROD][posProd]) {
                System.out.println("En la sucursal "+branchName+" No hay lugar para tantos productos\n");
            } else {
                matProdSuc[central.ROWPROD][posProd] += reload;
                System.out.println("En la sucursal "+branchName+" se recargaron "+reload+" del ID_producto-> "+posProd+"\n");

            }
        }
    }

    public void sellProd(int posProd, int selled) { // Vende productos
        if (matProdSuc[central.ROWPROD][posProd] != -1) {
            sell(posProd, selled);
        } else {
            System.out.println("La sucursal "+ branchName + " no opera este producto\n");
        }
    }

    private void sell(int posProd, int selled) {
        if (matProdSuc[central.ROWPROD][posProd] >= selled) {
            matProdSuc[central.ROWPROD][posProd] -= selled;
            System.out.println("La sucursal "+ branchName + " se vendieron "+selled+ " del ID_producto-> "+ posProd+ "\n");
        } else {
            System.out.println("No hay suficientes productos para realizar la venta.\n" +
                    "Solo puede venderse " + matProdSuc[central.ROWPROD][posProd]+"\n");
        }
    }

    public void startProd (int posProd, int prods, int min, int max) { // Inicia un producto
        String error = "";
        if (prods <= max && posProd > -1 && posProd < central.MAXPRODUCTS) {
            setMaxOfProd(posProd, max);
            setMinOfProd(posProd, min);
            matProdSuc[central.ROWPROD][posProd] = 0; //tuve que forzar esto o no iniciaba el producto por el if de la funcion loadProduct
            loadProduct(posProd, prods);
            System.out.println("En la sucursal "+ branchName + " se inicializo el ID_producto-> "+posProd+" con éxito" + "\n");
        } else {
            if (prods > max) {
                error = "Los productos son más de los que se pueden almacenar\n";
            } else if (posProd < 0 || posProd >= central.MAXPRODUCTS){
                error = "El producto de la posición " + posProd + " no existe\n";
            }
            System.out.println("ERROR en la carga, mensaje de error: " + error);
        }
    }

    public int cantProdToReload(int prod) { // Devuelve la cantidad de productos a stockear
        int result = ((matProdSuc[central.ROWMINPROD][prod] + matProdSuc[central.ROWMAXPROD][prod]) / 2) - matProdSuc[central.ROWPROD][prod];
        return result;
    }

    public int reloadIfPosibleProd() { // Devuelve la posición del producto que necesita ser stockeado
        int posProd = 0;
        while (posProd < central.MAXPRODUCTS) {
            if (evaluateProd(posProd)) {
                return posProd;
            }
            posProd++;
        }
        return -1;
    }

    private void setMaxOfProd(int posProd, int max) {

        if (posProd >= 0 && posProd < central.MAXPRODUCTS) {
            if (max > matProdSuc[central.ROWMINPROD][posProd]) {
                matProdSuc[central.ROWMAXPROD][posProd] = max;
            } else {
                System.out.println("El máximo de poductos debe ser mayor al mínimo\n");
            }
        } else {
            System.out.println("El número de producto ingresado esta fuera de los posibles\n");
        }
    }

    private void setMinOfProd(int posProd, int min) {
        if (min > -1 && min < matProdSuc[central.ROWMAXPROD][posProd]) {
            matProdSuc[central.ROWMINPROD][posProd] = min;
        } else {
            if (min < 0) {
                System.out.println("El mínimo de productos debe ser mayor o igual a cero\n");
            } else {
                System.out.println("El mínimo debe ser menor al máximo\n");
            }
        }
    }
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