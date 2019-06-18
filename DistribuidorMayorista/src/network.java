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
        central.startProd(0, 50, 20, 150);
        central.startProd(1, 120, 20, 150);
        central.startProd(2, 90, 20, 150);
        central.startProd(3, 74, 20, 150);
        central.startProd(4, 65, 20, 150);
        central.sellProd(0,3);
        central.sellProd(1,5);
        central.sellProd(2,1);
        central.sellProd(3,3);
        central.loadProduct(0, 10);
        central.loadProduct(1, 10);
        central.loadProduct(2, 10);
        central.loadProduct(3, 30);
        central.loadProduct(4, 20);
        central.printMatProd();
        central.loadProduct(2, 20);
        central.sellProd(2,42);
        central.printMatProd();
        branch uno = new branch("UNO");
        central.createBranch(uno);
        uno.startProd(1, 0, 20, 60);
        uno.loadProduct(1, 60);
//        uno.listProds();
        branch dos = new branch("DOS");
        central.createBranch(dos);
        dos.startProd(3, 18, 20, 50);
        dos.startProd(1, 16, 20, 60);
        dos.loadProduct(1, 20);
        dos.sellProd(3,15);
//        dos.listProds();

        branch tres = new branch("tres");
        central.createBranch(tres);
        tres.startProd(0, 4, 20, 60);
        tres.startProd(1, 3, 20, 60);
        tres.startProd(2, 2, 20, 60);
        tres.loadProduct(2, 15);

        branch cuatro = new branch("cuatro");
        central.createBranch(cuatro);
        cuatro.startProd(1, 32, 20, 60);
        cuatro.startProd(4, 12, 20, 60);
        cuatro.loadProduct(1, 10);
        cuatro.loadProduct(3, 45);
//        branch cinco = new branch("cinco");
//        elMayonesa.createBranch(cinco);
//        cinco.startProd(1, 0, 10, 30);
//        cinco.startProd(2, 0, 10, 30);
//        cinco.startProd(3, 0, 10, 30);
//
//        branch seis = new branch("seis");
//        elMayonesa.createBranch(seis);
//        seis.startProd(0, 0, 10, 30);
//        seis.startProd(1, 0, 10, 30);
//        seis.startProd(3, 0, 10, 30);
//        seis.startProd(4, 0, 10, 30);
//
//        branch siete = new branch("siete");
//        elMayonesa.createBranch(siete);
//        siete.startProd(1, 0, 10, 30);
//        siete.startProd(2, 0, 10, 30);
//        siete.addProducts(1, 8);
//
//
//        branch ocho = new branch("ocho");
//        elMayonesa.createBranch(ocho);
//        ocho.startProd(4, 0, 10, 20);
//        ocho.startProd(3, 0, 10, 20);
//
//
//        branch nueve = new branch("nueve");
//        elMayonesa.createBranch(nueve);
//        nueve.startProd(2, 0, 10, 30);
//        nueve.startProd(4, 0, 10, 30);
//        nueve.startProd(5, 0, 10, 30);
//
//
//        branch diez = new branch("diez");
//        elMayonesa.createBranch(diez);
//        diez.startProd(0, 0, 10, 30);
//        diez.startProd(3, 0, 10, 30);
//        diez.reload(3, 45);
//        branch once = new branch("once");
//        once.startProd(3, 0, 10, 20);

        cuatro.sellProd(1, 8);
        cuatro.sellProd(3, 18);
        central.maxLoadProd(1);
        central.listNetworkStatus();
        central.fullstockProd(1);
        central.loadProduct(1, 78);
        central.reloadbranches();
        central.listNetworkStatus();


    }
}
