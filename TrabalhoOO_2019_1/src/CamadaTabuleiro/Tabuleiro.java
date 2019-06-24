package CamadaTabuleiro;

import CamadaTabuleiro.Exception.TabuleiroException;
import CamadaXadrez.PecaXadrez;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro
{
    private int coluna;
    private int linha;
    private PecaXadrez[][] pecas;

    public Tabuleiro(){
      
    }

    public Tabuleiro(int linha,int coluna)
    {
        this.coluna = coluna;
        this.linha = linha;
        pecas = new PecaXadrez[linha][coluna];
    }
        
    public PecaXadrez peca(int linha ,int coluna)//retorna uma peça dada uma linha e uma coluna
    { 
        return pecas[linha][coluna];
    }
    
    public PecaXadrez peca(Posicao posicao)//sobrecarga da funçao acima, retorna uma peça dada uma posiçao
    {
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    
    public void posicionaPeca(PecaXadrez peca, Posicao posicao){
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
        
    }
    
    public PecaXadrez removePeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não encontrada");
        }
        if(peca(posicao) == null){
            return null;
        }
        PecaXadrez aux = new PecaXadrez(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
    
    public boolean posicaoExiste(Posicao posica){
        return false;
    }
    
    public boolean temPeca(Posicao posicao){
        return false;
    }

    public int getColuna()
    {
        return coluna;
    }

    public void setColuna(int coluna)
    {
        this.coluna = coluna;
    }

    public int getLinha()
    {
        return linha;
    }

    public void setLinha(int linha)
    {
        this.linha = linha;
    }
    
    
}
