//* Programa que demana un text i retorna un triangle amb el text

public class TriangleLletresInvertit{ 
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(text.isBlank()){return;}
        
        
        dibuixaTriangle(text);
        
    }    
        
    public static void dibuixaTriangle(String text){

        for(int linia = text.length()-1; linia >= 0; linia--){
            
            dibuixaLinia(text, linia);
            System.out.println();
        }
    }        
    
    public static void dibuixaLinia(String text, int linia){
    
        for(int a = linia; a >= 0; a--){
                 
            if(a == 0){
                System.out.print(text.charAt(a));
            } else {
                System.out.print(text.charAt(a) + ", ");
            }
        }
    }
}
