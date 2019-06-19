package CamadaXadrez;

import CamadaTabuleiro.Posicao;

public interface Movimento
{
    boolean[][] movimentosPossiveis();
    boolean possivelMovimento(Posicao posicao);
    boolean temAlgumPossivelMovimento();
}
