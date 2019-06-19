package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaXadrez.Enum.Cor;

public class PecaXadrez 
{
    private Cor cor;
    private int contaMovimentos;
    private Posicao posicao;
    
    public PecaXadrez(){
        
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

    public void setCor(Cor cor)
    {
        this.cor = cor;
    }

    public int getContaMovimentos()
    {
        return contaMovimentos;
    }

    public void setContaMovimentos(int contaMovimentos)
    {
        this.contaMovimentos = contaMovimentos;
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
