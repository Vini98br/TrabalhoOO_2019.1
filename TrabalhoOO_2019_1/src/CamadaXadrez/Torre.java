package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Torre extends PecaXadrez implements Movimento{

    public Torre(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString(){
        return "T";
    }
    
    @Override
    public boolean[][] movimentosPossiveis()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean possivelMovimento(Posicao posicao)
    {
        return false;
    }

    @Override
    public boolean temAlgumPossivelMovimento()
    {
        return false;
    }
    
}
