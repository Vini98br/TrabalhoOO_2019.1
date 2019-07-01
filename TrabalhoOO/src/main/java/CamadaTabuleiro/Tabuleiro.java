package CamadaTabuleiro;

import CamadaTabuleiro.Exception.TabuleiroException;
import CamadaXadrez.PecaXadrez;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro
{
    private int colunas;
    private int linhas;
    private Peca[][] pecas;

    public Tabuleiro(){
      
    }

    public Tabuleiro(int linhas,int colunas)
    {
        if(linhas < 1 || colunas < 1)
        {
            throw new TabuleiroException("Erro criando tabuleiro: tem que haver ao menos 1 linha e 1 colina");
        }
        this.colunas = colunas;
        this.linhas = linhas;
        pecas = new Peca[linhas][colunas];
    }
        
    public Peca peca(int lin ,int col)//retorna uma peça dada uma linha e uma coluna
    { 
        if(!posicaoExiste(lin, col))
        {
            throw new TabuleiroException("Posição não existe no tabuleiro!");
        }
        return pecas[lin][col];
    }
    
    public Peca peca(Posicao posicao)//sobrecarga da funçao acima, retorna uma peça dada uma posiçao
    {
        if(!posicaoExiste(posicao))
        {
            throw new TabuleiroException("Posição não existe no tabuleiro!");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    
    public void posicionaPeca(Peca peca, Posicao posicao)
    {
        if(temPeca(posicao))
        {
            throw new TabuleiroException("Já tem uma peça na posição (" + posicao + ")");
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
        
    }
    
    public Peca removePeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não encontrada!");
        }
        if(peca(posicao) == null){
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
    
    private boolean posicaoExiste(int linha, int coluna)//funcao auxilixar que verifica se uma posicao existe por meio de uma linha e uma coluna
    {                                           
        return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
    }
    
    public boolean posicaoExiste(Posicao posicao)//funcao que verifica a existencia de uma posicao por meio de uma posicao 
    {
        return posicaoExiste(posicao.getLinha(),posicao.getColuna());
    }
    
    public boolean temPeca(Posicao posicao)//funcao que verifica se tem alguma peca na posicao informadom por parametro
    {
         if(!posicaoExiste(posicao))
        {
            throw new TabuleiroException("Posição não existe no tabuleiro!");
        }
        return peca(posicao) != null;
    }

    public int getColunas()
    {
        return colunas;
    }

    public int getLinhas()
    {
        return linhas;
    }

    
    
}
