package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaTabuleiro.Posicao;
import CamadaXadrez.Enum.Cor;

/**
 *
 * @author vinic
 */
public class PecaXadrez extends Peca
{
    private Cor cor;
    private int contaMovimentos;
    
    public PosicaoPeca getPosicaoPeca(){
        return null;
    }
    
    public boolean temPecaRival(Posicao posicao){
        return false;
    }
    
    public void incrementaContador(){
        
    }
    
    public void decrementaContador(){
        
    }
}
