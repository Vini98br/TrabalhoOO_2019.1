package CamadaXadrez;

import CamadaTabuleiro.Posicao;

public class Bispo extends PecaXadrez implements Movimento{

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
