package CamadaXadrez;

import CamadaTabuleiro.Posicao;

public class PosicaoPeca {
    private char coluna;
    private int linha;
    
    PosicaoPeca(){
    
    }
    
    PosicaoPeca(char coluna, int linha){
        this.coluna = coluna;
        this.linha = linha;
    }
    
    public Posicao paraPosicao(){
        return null;
    }
    
    public PosicaoPeca dePosicao(Posicao posicao){
        PosicaoPeca p = new PosicaoPeca(coluna, linha);
        return p;
    }
}
