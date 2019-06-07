public class network {
    //VARIABLES

    public static void main(String[] args) {
        central central = new central();
        central.printMatProd();
//        central.setMinOfProd(0,20);
//        central.setMaxOfProd(0,100);
//        central.setMinOfProd(1,20);
//        central.setMaxOfProd(1,100);
//        central.setMinOfProd(2,20);
//        central.setMaxOfProd(2,100);
//        central.setMinOfProd(3,20);
//        central.setMaxOfProd(3,100);
//        central.setMinOfProd(4,20);
//        central.setMaxOfProd(4,100);
        central.setAllMinMax(15,50);
        central.loadProduct(0, 50);
        central.loadProduct(2, 40);
        central.loadProduct(4, 80);
        central.printMatProd();
    }
}
