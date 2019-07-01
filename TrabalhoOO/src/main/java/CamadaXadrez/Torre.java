package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString(){
        return "T";
    }
    
  @Override
    public boolean[][] movimentosPossiveis()
    {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);
        
        //acima
        p.setValor(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //direita
        p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //abaixo
        p.setValor(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaRival(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
