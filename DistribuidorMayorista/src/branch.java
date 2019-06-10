
public class branch {
    //VARIABLES
    int matProdSuc[][] = new int[central.MAXROW][central.MAXPRODUCTS];
//    private String BranchName = " ";


    //METODOS GETTER
    public void listProds(){
        System.out.println("Pruductos En sucursal ");
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            if (matProdSuc[central.ROWPROD][i] != -1) {
                System.out.print("Id producto: " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
                System.out.println("");
            }
        }
    }

    public void printMatSuc () {
        System.out.println("Matriz completa de la sucursal ");
        for (int i = 0; i < central.MAXPRODUCTS; i++) {
            System.out.print("Id producto: " + i + " Cantidad -> " + matProdSuc[central.ROWPROD][i] + ", Mínimo -> "+ matProdSuc[central.ROWMINPROD][i] + ", Máximo -> "+ matProdSuc[central.ROWMAXPROD][i]);
            System.out.println("");
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

    public void addProducts(int posProd, int reload) {
        if (matProdSuc[central.ROWPROD][posProd] != -1 && matProdSuc[central.ROWMINPROD][posProd] != -1) {
            matProdSuc[central.ROWPROD][posProd] += reload;
        } else {
            System.out.println("EL producto no esta inicializado");
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
}
