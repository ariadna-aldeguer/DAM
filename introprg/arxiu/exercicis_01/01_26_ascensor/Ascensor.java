//* Programa Ascensor
public class Ascensor {
    public static void main(String[] args) {
        System.out.println("pis?");
        String planta = Entrada.readLine();
        System.out.println("botó?");
        String boto = Entrada.readLine();
       
        if (planta.equals("planta baixa")){
             if(boto.equals("pujar un")) {
                System.out.println("primer pis");
            } else if (boto.equals("pujar dos")) {
                System.out.println("segon pis");
            } else {
                System.out.println("error");
            }       
        } else if (planta.equals("primer pis")) {
             if (boto.equals("pujar un")) {
                System.out.println("segon pis");
            } else if (boto.equals("baixar un")) {
                 System.out.println("planta baixa");
            } else {
                System.out.println("error");
            }
        } else if (planta.equals("segon pis")) {
            if (boto.equals("baixar dos")) {
             System.out.println("planta baixa");
            } else if (boto.equals("baixar un")) {
            System.out.println("primer pis");
            } else {
            System.out.println("error");
            }
        } else {
        System.out.println("error");
        }
    }
}
