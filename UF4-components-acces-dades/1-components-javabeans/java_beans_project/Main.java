public class Main {
    public static void main(String[] args) {
        Empleat empleat = new Empleat("324234", "Ariadna");
        PanellEmpleat panell = new PanellEmpleat();

        empleat.addPropertyChangeListener (panell);
        empleat.setCarrec("Junior");

        System.out.println(empleat.getCarrec());
        //empleat.setCarrec("hola"); //error

        //empleat.setSou(500);
       // empleat.setSou(5000000); // error
        

    }
}
