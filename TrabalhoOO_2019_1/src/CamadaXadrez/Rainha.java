package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;

public class Rainha extends PecaXadrez implements Movimento{

    public Rainha(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString(){
        return "Q";
    }
    
  @Override
    public boolean[][] movimentosPossiveis()
    {
        boolean[][] mat = movimentosPossiveis();
        Posicao p = new Posicao(0, 0);
        
        //acima
        p.setValor(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //abaixo
        p.setValor(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //NOROESTE
        p.setValor(posicao.getLinha() - 1, posicao.getColuna()-1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() - 1);
            p.setColuna(posicao.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //NORDESTE
        p.setValor(posicao.getLinha()-1, posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() + 1);
            p.setLinha(posicao.getLinha() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //SUDESTE
        p.setValor(posicao.getLinha()+1, posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(posicao.getColuna() + 1);
            p.setLinha(posicao.getLinha() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //SUDOESTE
        p.setValor(posicao.getLinha() + 1, posicao.getColuna()-1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(posicao.getLinha() + 1);
            p.setColuna(posicao.getColuna() + -1);
        }
        if(getTabuleiro().posicaoExiste(p) && temPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
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