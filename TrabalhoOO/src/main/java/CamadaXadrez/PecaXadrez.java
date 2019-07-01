package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public abstract class PecaXadrez extends Peca
{
    private Cor cor;
    private int contaMovimentos;
    //public Posicao posicao;
    
    
    
    public PecaXadrez(Tabuleiro tabuleiro, Cor cor)
    {
        super(tabuleiro);
        this.cor = cor;
        //this.posicao=null;
    }

    public PosicaoPeca getPosicaoPeca(){
        
        return PosicaoPeca.dePosicao(posicao);
        
    }
    
    public boolean temPecaRival(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
    
    public void incrementaContador(){
        this.contaMovimentos++;
    }
    
    public void decrementaContador(){
        this.contaMovimentos--;
    }

    public Cor getCor()
    {
        return cor;
    }

    public int getContaMovimentos()
    {
        return contaMovimentos;
    }

    public Posicao getPosicao()
    {
        return posicao;
    }

    public void setPosicao(Posicao posicao)
    {
        this.posicao = posicao;
    }
            
}
