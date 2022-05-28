public class Main {
    public static void main(String[] args) {
        Empleat empleat = new Empleat("324234", "Ariadna");
        PanellEmpleat panell = new PanellEmpleat();

        empleat.addPropertyChangeListener (panell);
        empleat.setCarrec("Junior");
        //empleat.setCarrec("hola"); //error

        empleat.setSou(5000000);
        

    }
}
