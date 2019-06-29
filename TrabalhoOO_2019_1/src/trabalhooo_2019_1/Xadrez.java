package trabalhooo_2019_1;
import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;

public class Xadrez{

    public static void main(String[] args){
    
        
        
        PartidaXadrez partida = new PartidaXadrez();
        PecaXadrez[][] mat= partida.getPecas();
        IU.imprimeTabuleiro(mat);
        
        
        
        
        System.out.println("teste");
    }
    
}
