package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Peao extends PecaXadrez implements Movimento {

    private PartidaXadrez partida;
    
<<<<<<< HEAD
    public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
        super(tabuleiro, cor);
        this.partida = partida;
=======
    public Peao(Tabuleiro tabuleiro, Cor cor , PartidaXadrez partida) {
        super(tabuleiro, cor);
        this.partida=partida;
>>>>>>> 7e0f63b01a58d093b28faf0831fb1edce1b44055
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
            //#movimento especial en passant peća branca
            if(posicao.getLinha() == 3)
            {
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna()-1);
                if(getTabuleiro().posicaoExiste(esquerda) && temPecaRival(esquerda) && getTabuleiro().peca(esquerda) == partida.getenPassantVulneravel())
                {
                    mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna()+1);
                if(getTabuleiro().posicaoExiste(direita) && temPecaRival(direita) && getTabuleiro().peca(direita) == partida.getenPassantVulneravel())
                {
                    mat[direita.getLinha() - 1][direita.getColuna()] = true;
                }
            }
            //condicoes para a cor pretabilisas
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
            //#movimento especial en passant peća preta
            if(posicao.getLinha() == 4)
            {
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna()-1);
                if(getTabuleiro().posicaoExiste(esquerda) && temPecaRival(esquerda) && getTabuleiro().peca(esquerda) == partida.getenPassantVulneravel())
                {
                    mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha()+1, posicao.getColuna());
                if(getTabuleiro().posicaoExiste(direita) && temPecaRival(direita) && getTabuleiro().peca(direita) == partida.getenPassantVulneravel())
                {
                    mat[direita.getLinha() + 1][direita.getColuna()] = true;
                }
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
