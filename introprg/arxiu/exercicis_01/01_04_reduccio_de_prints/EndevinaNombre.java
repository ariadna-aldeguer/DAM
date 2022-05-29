 /*
     *  Compacta les crides a System.out.print() fent servir la notació que hem vist System.out.println("El número és " + numero):.
     */

    public class EndevinaNombre {

        public static void main(String[] args) {


            // pensa un número
            int numeroPensat = Integer.parseInt(args[0]);
            System.out.println("El número pensat és " + numeroPensat);

            // Multiplica'l per 3
            int numero = numeroPensat * 3;  // Faltava el int, declarar la variable
            System.out.println("Quan el multipliques per 3 obtens " + numero);

            // Suma-li 6
            numero = numero + 6;
            System.out.println("Quan li sumes 6 arriba a " + numero);

            // divideix-ho tot per 3
            numero = numero / 3;
            System.out.println("Un cop dividit per 3 queda " + numero);
            // resta-li el número pensat
            numero = numero - numeroPensat;
            System.out.println("Finalment, en restar-li el valor inicial, queda " + numero);

            // compara el resultat
            System.out.println("A que el resultat és 2?");
        }
    }
    
                // Encara més compacte 

