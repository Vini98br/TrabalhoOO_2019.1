package trabalhooo_2019_1;
import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.*;
import java.util.Scanner;

public class Xadrez{

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        
        while(true){
        PecaXadrez[][] mat= partida.getPecas();
            IU.imprimeTabuleiro(mat);
            System.out.println();
            System.out.print("Origem: ");
            PosicaoPeca origem = IU.lePosicaoPeca(teclado);
        
            System.out.println();
            System.out.print("Destino: ");
            PosicaoPeca destino = IU.lePosicaoPeca(teclado);
        
            PecaXadrez pecaCapturada = partida.fazMovimento(origem, destino);
            System.out.println("teste");
        }
    }
    
}
