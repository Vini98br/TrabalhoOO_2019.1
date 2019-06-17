package CamadaTabuleiro;

import CamadaXadrez.PecaXadrez;
import java.util.ArrayList;

public class Tabuleiro
{
    private int coluna;
    private int linha;
    ArrayList<PecaXadrez> pecas = new ArrayList<>();

    public Tabuleiro() {
        for(int i = 0; i < 32; i++){
                
        }
    }
    
    
    
    public PecaXadrez peca(int linha ,int coluna){
        return null;
    }
    
    public PecaXadrez peca(Posicao posicao){
        return null;
    }
    
    public void posicionaPeca(PecaXadrez peca, Posicao posicao){
        
    }
    
    public PecaXadrez removePeca(Posicao posicao){
        return null;
    }
    
    public boolean posicaoExiste(Posicao posica){
        return false;
    }
    
    public boolean temPeca(Posicao posicao){
        return false;
    }
}
