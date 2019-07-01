package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Cavalo extends PecaXadrez {

    public Cavalo(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    
    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public String toString()
    {
        return "C";
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);

        p.setLinha(posicao.getLinha() - 1);
        p.setColuna(posicao.getColuna()-2);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha() - 2);
        p.setColuna(posicao.getColuna()-1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha()-2);
        p.setColuna(posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha()-1);
        p.setColuna(posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha() + 1);
        p.setColuna(posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha() + 2);
        p.setColuna(posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha() + 2);
        p.setColuna(posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setLinha(posicao.getLinha() + 1);
        p.setColuna(posicao.getColuna() - 2);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }
}
