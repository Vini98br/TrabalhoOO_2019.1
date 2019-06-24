package CamadaXadrez;

import CamadaTabuleiro.Posicao;

public class Rei extends PecaXadrez implements Movimento{

    public Rei(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString(){
        return "k";
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
