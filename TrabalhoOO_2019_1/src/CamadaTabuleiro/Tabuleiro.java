package CamadaTabuleiro;

import CamadaXadrez.PecaXadrez;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro
{
    private int coluna;
    private int linha;
    List<PecaXadrez> pecas = new ArrayList<>();

    public Tabuleiro(){
      
    }

    public Tabuleiro(int coluna, int linha)
    {
        this.coluna = coluna;
        this.linha = linha;
    }
        
    public PecaXadrez peca(int linha ,int coluna){
        return null;
    }
    
    public PecaXadrez peca(Posicao posicao){
        return null;
    }
    
    public void posicionaPeca(PecaXadrez peca, Posicao posicao){
        
    }
    
    public PecaXadrez removePeca(Posicao posicao){
        return null;
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
