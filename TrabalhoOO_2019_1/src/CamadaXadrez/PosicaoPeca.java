package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaXadrez.Exception.XadrezException;

public class PosicaoPeca {
    
    private char coluna;
    private int linha;
    
    PosicaoPeca(){
    }
    
    public PosicaoPeca(int linha, char coluna){
        if(coluna <'a' || coluna >'h' || linha < 1 || linha >8)//evitando erros de entrada
        {
            throw new XadrezException("Posiçao Invalida!");
        }
        this.coluna = coluna;
        this.linha = linha;
    }
    
    protected Posicao paraPosicao()//funcao que retorna a posicao da matriz com base posicaoPeca do xadrez
    {
        return new Posicao(8 - linha , coluna - 'a');
               
    }
    
    protected static PosicaoPeca dePosicao(Posicao posicao)//funcao que retorna a posicaoPeca com base na posicao da matriz
    {
        return new PosicaoPeca( 8 - posicao.getLinha() , (char)('a' - posicao.getColuna()) );
    }

    public char getColuna()
    {
        return coluna;
    }

    public int getLinha()
    {
        return linha;
    }

    @Override
    public String toString()
    {
        return "PosicaoPeca{" + "coluna=" + coluna + ", linha=" + linha + '}';
    }
    
    
}
