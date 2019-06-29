package CamadaXadrez;

import CamadaTabuleiro.Posicao;

public class Peao extends PecaXadrez implements Movimento
{

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
}
