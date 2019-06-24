package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class PecaXadrez 
{
    private Cor cor;
    private int contaMovimentos;
    public Posicao posicao;
    
    private Tabuleiro tabuleiro;
    
    public PecaXadrez(){
        
    }
    
    public PecaXadrez(Posicao posicao){
        this.posicao=posicao;
    }

    public PecaXadrez(Tabuleiro tabuleiro)
    {
        this.tabuleiro = tabuleiro;
        this.posicao=null;
    }

    protected Tabuleiro getTabuleiro()
    {
        return tabuleiro;
    }
  
    public PecaXadrez(Cor cor, int contaMovimentos, Posicao posicao)
    {
        this.cor = cor;
        this.contaMovimentos = contaMovimentos;
        this.posicao = posicao;
    }
        
    public PosicaoPeca getPosicaoPeca(){
        return null;
    }
    
    public boolean temPecaRival(Posicao posicao){
        return false;
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
