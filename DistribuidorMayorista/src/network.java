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
        central.setAllMinMax(15,50);
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
        dos.startProd(3, 0, 20, 60);
        dos.startProd(1, 30, 20, 60);
        dos.addProducts(1, 60);
        central.createBranch(dos);
//        dos.listProds();
        central.listAllBranchesProds();
        /*
        branch tres = new branch();
        tres.startProd(1, 0, 20, 60);
        tres.addProducts(1, 60);
        central.createBranch(tres);
        tres.listProds();

        branch cuatro = new branch();
        cuatro.startProd(1, 0, 20, 60);
        cuatro.addProducts(1, 60);
        central.createBranch(cuatro);
        cuatro.listProds();

        branch cinco = new branch();
        cinco.startProd(1, 0, 20, 60);
        cinco.addProducts(1, 60);
                central.createBranch(cinco);
        cinco.listProds();

                       branch seis = new branch();
        seis.startProd(1, 0, 20, 60);
        seis.addProducts(1, 60);
                central.createBranch(seis);
        seis.listProds();

                        branch siete = new branch();
        siete.startProd(1, 0, 20, 60);
        siete.addProducts(1, 60);
                central.createBranch(siete);
        siete.listProds();

                       branch ocho = new branch();
        ocho.startProd(1, 0, 20, 60);
        ocho.addProducts(1, 60);
                central.createBranch(ocho);
        ocho.listProds();

                        branch nueve = new branch();
        nueve.startProd(1, 0, 20, 60);
        nueve.addProducts(1, 60);
                central.createBranch(nueve);
        nueve.listProds();

                        branch diez = new branch();
        diez.startProd(1, 0, 20, 60);
        diez.addProducts(1, 60);
                central.createBranch(diez);
        diez.listProds();

        branch once = new branch();
        once.startProd(1, 0, 20, 60);
        once.addProducts(1, 60);
        central.createBranch(once);
        once.listProds();*/
    }
}
