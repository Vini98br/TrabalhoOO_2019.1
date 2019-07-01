package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Peao extends PecaXadrez implements Movimento {

    private PartidaXadrez partida;
    
    public Peao(Tabuleiro tabuleiro, Cor cor , PartidaXadrez partida) {
        super(tabuleiro, cor);
        this.partida=partida;
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);

        if (getCor() == Cor.BRANCA) {
            p.setLinha(posicao.getLinha() - 1);
            p.setColuna(posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;

            }
            //condicao para andar 2 no inicio
            p.setLinha(posicao.getLinha() - 2);
            p.setColuna(posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p) && getContaMovimentos() == 0 && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().temPeca(p2)) {
                mat[p.getLinha()][p.getColuna()] = true;

            }
            //condicao para comer a peca na diagonal
            p.setLinha(posicao.getLinha() - 1);
            p.setColuna(posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && temPecaRival(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            //condicao para comer a peca na outra diagonal
            p.setLinha(posicao.getLinha() - 1);
            p.setColuna(posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && temPecaRival(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            //condicoes para a cor preta
        } else {
            p.setLinha(posicao.getLinha() + 1);
            p.setColuna(posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;

            }
            //condicao para andar 2 no inicio
            p.setLinha(posicao.getLinha() + 2);
            p.setColuna(posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p) && getContaMovimentos() == 0 && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().temPeca(p2)) {
                mat[p.getLinha()][p.getColuna()] = true;

            }
            //condicao para comer a peca na diagonal
            p.setLinha(posicao.getLinha() + 1);
            p.setColuna(posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && temPecaRival(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            //condicao para comer a peca na outra diagonal
            p.setLinha(posicao.getLinha() + 1);
            p.setColuna(posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && temPecaRival(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

        }
        return mat;
    }
    @Override
    public String toString(){
        //manda retorna letra p do peao
        return "P";
    }

    @Override
    public boolean possivelMovimento(Posicao posicao) {
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    @Override
    public boolean temAlgumPossivelMovimento()//Roda a matriz em busca de ao menos um movimento possivel na matriz
    {
        boolean[][] mat = movimentosPossiveis();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j])//se achou alguma posiçao
                {
                    return true;
                }
            }
        }
        return false;
    }
}
