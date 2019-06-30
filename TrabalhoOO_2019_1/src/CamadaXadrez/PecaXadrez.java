package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class PecaXadrez implements Movimento
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

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor)
    {
        this.cor = cor;
        this.tabuleiro = tabuleiro;
        this.posicao=null;
    }

    protected Tabuleiro getTabuleiro()
    {
        return tabuleiro;
    }
  
    public PecaXadrez(Cor cor, Posicao posicao)
    {
        this.cor = cor;
        this.posicao = posicao;
    }
        
    public PosicaoPeca getPosicaoPeca(){
        
        return PosicaoPeca.dePosicao(posicao);
        
    }
    
    public boolean temPecaRival(Posicao posicao){
        PecaXadrez p = getTabuleiro().peca(posicao);
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

    @Override
    public boolean[][] movimentosPossiveis()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean possivelMovimento(Posicao posicao)
    {
       return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()]; 
    }

    @Override
    public boolean temAlgumPossivelMovimento()//Roda a matriz em busca de ao menos um movimento possivel na matriz
    {
        boolean[][] mat = movimentosPossiveis();
        for(int i=0 ; i<mat.length; i++)
        {
            for(int j=0; j<mat.length;j++)
            {
                if(mat[i][j])//se achou alguma posiçao
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected boolean temPecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
    
}
