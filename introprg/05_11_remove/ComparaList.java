/*
    Comparació de l'operació remove() en ArrayList i LinkedList
    eliminant per l'inici, pel final i pel mig.

    Els resultats obtinguts han estat:

    Primera execució:
    =================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:            153
test remove(0) ArrayList:             168

Comparació quan eliminem sempre del final
test remove(últim) LinkedList:        125
test remove(últim) ArrayList:         168

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:          150
test remove(mig) ArrayList:           162

        Segona execució:
        ================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:            152
test remove(0) ArrayList:             138

Comparació quan eliminem sempre del final
test remove(últim) LinkedList:        128
test remove(últim) ArrayList:         220

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:          189
test remove(mig) ArrayList:           193

        Tercera execució:
        =================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:            164
test remove(0) ArrayList:             145

Comparació quan eliminem sempre del final
test remove(últim) LinkedList:        132
test remove(últim) ArrayList:         126

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:          181
test remove(mig) ArrayList:           137

        Resultats
        =========

========== ================== ================== ======================================================
**prova**  **linkedList**      **ArrayList**      **resultat**
---------- ------------------ ------------------ ------------------------------------------------------
inici       156 --              150                1,04
final       128                 171 --             1,34
mig         173 --              164                1,06
========== ================== ================== ======================================================

    Per calcular cada columna:

    * la cel·la (1, 1) correspon al temps mig de la implementació LinkedList eliminant des de l'inici
      Es calcula sumant els valors obtinguts a les tres execucions i dividint-los per 3

    * el resultat per la fila inici indica quantes vegades és més ràpid un que l'altre. Per fer-ho, dividim
      el valor més petit pel més gran i arrodonim a l'enter.

    Conclusions
    ===========

    En vistes als resultats, en cas que hagi de fer servir una List per eliminar molts valors, escolliré linkedList,
    ja que mostra més eficiencia al borrar pel mig i al inici.  

     */


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class ComparaList {
    private static final int LONGITUD = 100000;
    private static List<Integer> emplena(List<Integer> llista) {
        // XXX codi que emplena la llista amb enters del 0 a LONGITUD - 1
        return llista;
    }
    private static long testRemove0(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // XXX codi que elimina un a un tots els elements de la llista per la posició 0
        return System.nanoTime() - tempsInicial;
    }
    private static long testRemove(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // XXX codi que elimina un a un tots els elements de la llista per la darrera posició
        return System.nanoTime() - tempsInicial;
    }
    private static long testRemoveMig(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // XXX codi que elimina un a un tots els elements de la llista per la posició mig
        return System.nanoTime() - tempsInicial;
    }
    public static void main(String[] args) {
        System.out.println("Comparant l'eficiència de les llistes");
        System.out.println();

        System.out.println("Comparació quan eliminem sempre de l'inici");
        System.out.printf("test remove(0) LinkedList:     %10d%n", testRemove0(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(0) ArrayList:      %10d%n", testRemove0(emplena(new ArrayList<Integer>())));
        System.out.println();

        System.out.println("Comparació quan eliminem sempre del final");
        System.out.printf("test remove(últim) LinkedList: %10d%n", testRemove(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(últim) ArrayList:  %10d%n", testRemove(emplena(new ArrayList<Integer>())));
        System.out.println();

        System.out.println("Comparació quan eliminem sempre del mig");
        System.out.printf("test remove(mig) LinkedList:   %10d%n", testRemoveMig(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(mig) ArrayList:    %10d%n", testRemoveMig(emplena(new ArrayList<Integer>())));
        System.out.println();
    }
}