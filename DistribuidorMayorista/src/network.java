public class network {
    //VARIABLES

    public static void main(String[] args) {
        central central = new central();
        central elMayonesa = new central();
        elMayonesa.setAllMinMax(100, 500);

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
        central.loadProduct(0, 150);
        central.loadProduct(1, 10);
        central.loadProduct(2, 150);
        central.loadProduct(3, 150);
        central.loadProduct(4, 160);
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
        central.createBranch(dos);
        dos.startProd(3, 18, 20, 50);
        dos.startProd(1, 16, 20, 60);
        dos.addProducts(1, 20);
        dos.sellProd(3,15);
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
        elMayonesa.createBranch(cinco);
        cinco.startProd(1, 0, 10, 30);
        cinco.startProd(2, 0, 10, 30);
        cinco.startProd(3, 0, 10, 30);

        branch seis = new branch("seis");
        elMayonesa.createBranch(seis);
        seis.startProd(0, 0, 10, 30);
        seis.startProd(3, 0, 10, 30);
        seis.startProd(4, 0, 10, 30);

        branch siete = new branch("siete");
        elMayonesa.createBranch(siete);
        siete.startProd(1, 0, 10, 30);
        siete.startProd(2, 0, 10, 30);
        siete.addProducts(1, 8);


        branch ocho = new branch("ocho");
        elMayonesa.createBranch(ocho);
        ocho.startProd(4, 0, 10, 20);
        ocho.startProd(3, 0, 10, 20);


        branch nueve = new branch("nueve");
        elMayonesa.createBranch(nueve);
        nueve.startProd(2, 0, 10, 30);
        nueve.startProd(4, 0, 10, 30);
        nueve.startProd(5, 0, 10, 30);


        branch diez = new branch("diez");
        elMayonesa.createBranch(diez);
        diez.startProd(0, 0, 10, 30);
        diez.startProd(3, 0, 10, 30);
        diez.reload(3, 45);

        ocho.sellProd(2, 63);

        branch once = new branch("once");
        elMayonesa.createBranch(once);
        once.startProd(3, 0, 10, 20);
        central.loadProduct(1, 78);
        central.listNetworkStatus();
        central.reloadbranches();
        central.listNetworkStatus();
        central.getMaxCountProd(1);
        elMayonesa.loadProduct(0,300);
        elMayonesa.loadProduct(1,300);
        elMayonesa.loadProduct(2,300);
        elMayonesa.loadProduct(3,300);
        elMayonesa.loadProduct(4,300);
        elMayonesa.reloadbranches();
        elMayonesa.listNetworkStatus();

    }
}
