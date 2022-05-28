import java.io.*;

public class DesaiRecuperaEstat{

    public DesaiRecuperaEstat(){
    }

    public void desarEstat(EstatPartida game){
        File fitxer = new File ("game.dat");
        FileOutputStream fileout;
        try {
            fileout = new FileOutputStream (fitxer);
            ObjectOutputStream dataOS = new ObjectOutputStream (fileout);
            dataOS.writeObject(game) ;
            dataOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public EstatPartida recuperarEstat(){
        EstatPartida game;
        File fitxer = new File ("game.dat");

        try {
            FileInputStream filein = new FileInputStream (fitxer);
            ObjectInputStream dataIS = new ObjectInputStream (filein) ;
            while (true) {
                game = (EstatPartida) dataIS.readObject();
                dataIS.close();
                return game;
            }
        } catch (EOFException eo) {
        } catch (FileNotFoundException e) {
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {}
        
        return null;
    }
}