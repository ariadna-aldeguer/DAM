
public class Persona { //Primer creem la classe que utilitzarem per crear els objectes a emmagatzemar:
   private String nom;
   private String ciutat;
   public Persona(String nom, String ciutat){
       this.nom = nom;
       this.ciutat = ciutat;
   }
   public String getNom(){
       return nom;
   }
   public String getCiutat(){
      return ciutat;
   }
   public void setNom (String nom){
       this.nom=nom;
   }
   public void setCiutat (String ciutat){
       this.ciutat=ciutat;
   }
}
