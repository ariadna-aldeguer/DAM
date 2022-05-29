/*
 * El meu exemple de Herencia: Mobles
 */
 
 /* La superclasse Moble
  * Un moble pot ser de colors diferents, i podrá estar net o brut,
  * aquestes serán propietats
  * Podrem embrutar i netejar el moble
  * Pintar el moble d'un altre color
  */
  
public class Moble {
    private String color;
    private String estat; 
    
    /* Quan creem el moble sense especificacions, será marró i estará net */
    
    public Moble(){
        this("marro");
    }
    
    /*Només podren canviar el color al iniciar el moble, sempre estará net quan neix*/
    public Moble(String color){
        this.color = color;
        estat = "net";
        System.out.println("S'ha creat un moble");
    }
    
    public void setColor(String color){
        if(this.color.equals(color)){
            this.color = "negre";
        }
        
        if(color.equals("negre") ||
           color.equals("blanc") ||
           color.equals("blau")  ||
           color.equals("marro")){
            this.color = color;
        } else {
            this.color = "negre";
        }      
    }
    
    /* Métode: pintar, per limitar una mica, només podren pintar de blanc, negre i blau
     * Si s'escogeix un altre tipo de color, acabará sent negre. 
     * Al pintar, el moble s'embrutara
     * Si el color escollit, es el que tenia, només s'embrutara.
     */
    public void pintar(String color){
        setColor(color);
        embruta();
    }
    
    /* Només es podra embrutar pintant. Si ja esta molt brut, no pasa res*/
    private void embruta(){
        if(estat.equals("net")){
            estat = "brut";
            System.out.println("Esta brut");
        } 
        if(estat.equals("brut")){
            estat = "molt brut";
            System.out.println("Esta molt brut");
        }
    }
    
    /* Si ja esta net, no pasa res*/
    public void neteja(){
        if(estat.equals("brut")){
            estat = "net";
            System.out.println("Ara està net");
        } 
        if(estat.equals("molt brut")){
            estat = "brut";
            System.out.println("Ara està brut");
        }
    }
   
}


/* Tindrem una subclase Armari, per exemplificar, 
 * aquest tindra clases per composar-lo, i 
 * accesoris per mostrar l'agregació
 * Un armari te estanteries, té dues portes (composició)
 * Pot tenir roba a dintre (agregació)
 */
 
class Armari extends Moble {
    private int[] estanteria;
    private Porta portaDreta;
    private Porta portaEsquerra;
    private Roba roba; 
    
    /* Un armari es crea amb les portes tancades, i 
     * per defecte, 4 estants */
     
    public Armari(){
        this(4);
    }
    
    /* Només podrem escollir quantes estanteries té, 
     * inicialment tindra les portes tancades
     */
    
    public Armari(int estanteria){
        this.estanteria = new int[estanteria];
        portaDreta = new Porta();
        portaEsquerra = new Porta();
        System.out.println("S'ha creat un armari");
    }
    
    public Porta getPortaDreta(){ 
        return portaDreta;
    }
    public Porta getPortaEsquerra(){ 
        return portaEsquerra;
    }
    
    public void afegirRoba(Roba roba){
        if(portaDreta.estaObert()){
            if(roba == null){   
                this.roba = roba;
                System.out.println("S'ha afegit la roba");
            } else {
                System.out.println("Ja té roba");
            }
         } else {
            System.out.println("Has d'obrir primer la porta");
        }
    }
            
}

class Porta{
    private boolean estat;
    
    public Porta(){
        estat = false;
    }
    
    /* Metodes: estaObert */
    public boolean estaObert(){
        return estat;
    }
    
    public void obrirPorta(Porta porta){
        if(!estat){
            estat = true;
            System.out.println("S'ha obert la porta");
        } else {
            System.out.println("Ja està oberta");
        }
    }
    
    public void tancar(){
        if(estat){
            estat = false;
            System.out.println("S'ha tancat la porta");
        } else {
            System.out.println("Ja està tancada");
        }
     }
}

class Roba{
    private String roba;
    
    /* Per crear roba, s'ha de dir el tipus. No pots crear roba sense especificacions.
     * Per no liar molt la cosa, no posaré limitacions.
     */
    public Roba(String roba){
        this.roba = roba;
        System.out.println("S'ha creat la roba");
    }       
    
}

/* Exemple de demostració
    public static void main (String[] args){
        Moble moble = new Moble();
        moble.pintar("blau");
        moble.pintar("blanc");
        moble.neteja();
        moble.neteja();
        
        Armari armari = new Armari(8);
        Roba samarreta = new Roba("Samarreta");
        armari.afegirRoba(samarreta);
        portaDreta.obrirPorta();
        armari.afegirRoba(samarreta);
        portaDreta.tancarPorta();  
    }

La sortida d'aixó seria semblant a:
    S'ha creat un moble
    Ara està brut
    Ara està molt brut
    Ara està brut
    Ara està net
    S'ha creat un moble
    S'ha creat un armari
    S'ha creat la roba
    Has d'obrir primer la porta
    S'ha obert la porta
    S'ha afegit la roba
    S'ha tancat la porta
*/ 
    

