/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaTabuleiro;

/**
 *
 * @author vinic
 */
public abstract class Peca
{

    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro)
    {
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    protected Tabuleiro getTabuleiro()
    {
        return tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean possiveisMovimentos(Posicao position)
    {
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean temAlgumPossivelMovimento()
    {
        boolean[][] mat = movimentosPossiveis();
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                if (mat[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
