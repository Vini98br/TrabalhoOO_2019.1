package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

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
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;
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
    
}
