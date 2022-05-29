/* Afegirem tots els métodes útils per utilitzar a Zoo.
 * mostraCategories();
 */

import java.util.List;
import java.util.LinkedList;

public class ZooUtils {
    public static void mostraCategories(List<Categoria> categories){
        
        if (categories.isEmpty()){
            System.out.println("Cap categoria");
            return;
        }
        System.out.printf("Nombre de categories: %d%n", categories.size());
        for(Categoria categoria : categories){
            System.out.printf("\t%s%n",categoria.toString());
        }

    }
}