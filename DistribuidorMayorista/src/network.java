public class network {
    //VARIABLES

    public static void main(String[] args) {
        central central = new central();
//        central.printMatProd();
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
        central.setAllMinMax(50,250);
        central.loadProduct(0, 50);
        central.loadProduct(2, 50);
        central.loadProduct(4, 60);
        central.printMatProd();
        central.loadProduct(2, 20);
        central.sellProd(2,42);
        central.printMatProd();
        branch uno = new branch("UNO");
        uno.startProd(1, 0, 20, 60);
        uno.addProducts(1, 60);
        central.createBranch(uno);
//        uno.listProds();
        branch dos = new branch("DOS");
        dos.startProd(3, 30, 20, 50);
        dos.startProd(1, 16, 20, 60);
        dos.addProducts(1, 20);
        central.createBranch(dos);
        dos.sellProd(3,5);
//        dos.listProds();

        branch tres = new branch("tres");
        central.createBranch(tres);
        tres.startProd(1, 0, 20, 60);
        tres.addProducts(2, 50);

        branch cuatro = new branch("cuatro");
        central.createBranch(cuatro);
        cuatro.startProd(1, 0, 20, 60);
        cuatro.addProducts(1, 10);

        branch cinco = new branch("cinco");
        central.createBranch(cinco);
        cinco.startProd(1, 0, 20, 60);
        cinco.addProducts(1, 60);

        branch seis = new branch("seis");
        central.createBranch(seis);
        seis.startProd(1, 0, 20, 60);
        seis.addProducts(1, 60);

        branch siete = new branch("siete");
        central.createBranch(siete);
        siete.startProd(1, 0, 20, 60);
        siete.addProducts(1, 60);


        branch ocho = new branch("ocho");
        central.createBranch(ocho);
        ocho.startProd(1, 0, 20, 60);
        ocho.addProducts(1, 60);


        branch nueve = new branch("nueve");
        central.createBranch(nueve);
        nueve.startProd(1, 0, 20, 60);
        nueve.addProducts(1, 60);


        branch diez = new branch("diez");
        central.createBranch(diez);
        diez.startProd(1, 0, 20, 60);
        diez.addProducts(1, 60);

        branch once = new branch("once");
        central.createBranch(once);
        once.startProd(1, 0, 20, 60);
        once.addProducts(1, 60);
        central.listNetworkStatus();
        central.listBranchUnstockProds();
    }
}
