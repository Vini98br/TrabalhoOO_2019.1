package trabalhooo_2019_1;
import CamadaXadrez.PecaXadrez;

public class UI{

    public static void imprimeTabuleiro(PecaXadrez[][] pecas){
        for(int i = 0; i<pecas.lenght(); i++){
            System.out.print((8-i) + " ");
            for(int j = 0; j<pecas.lenght(); j++){
                imprimePeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h");
    }
    
    private static void imprimePeca(PecaXadrez peca){
        
        if(peca == NULL){
            System.out.print("-");
            
        }
        else
            System.out.print(peca);
        
        System.out.print(" ");
    }
}
