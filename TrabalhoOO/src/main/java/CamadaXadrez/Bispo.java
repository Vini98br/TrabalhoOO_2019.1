package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Bispo extends PecaXadrez{

    public Bispo(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString()
    {
        return "B";
    }
    
    @Override
    public boolean[][] movimentosPossiveis()
    {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);
        
        //NOROESTE
        p.setValor(posicao.getLinha() - 1, posicao.getColuna()-1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() - 1);
            p.setColuna(posicao.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //NORDESTE
        p.setValor(posicao.getLinha()-1, posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() + 1);
            p.setLinha(posicao.getLinha() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //SUDESTE
        p.setValor(posicao.getLinha()+1, posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() + 1);
            p.setLinha(posicao.getLinha() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //SUDOESTE
        p.setValor(posicao.getLinha() + 1, posicao.getColuna()-1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() + 1);
            p.setColuna(posicao.getColuna() + -1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
