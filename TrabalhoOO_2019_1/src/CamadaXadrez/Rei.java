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
    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p=new Posicao(0,0);
        
        //acima
        p.setLinha(posicao.getLinha()-1);
        p.setColuna(posicao.getColuna());
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        
        //abaixo
        p.setLinha(posicao.getLinha()+1);
        p.setColuna(posicao.getColuna());
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        
        //esquerda
        p.setLinha(posicao.getLinha());
        p.setColuna(posicao.getColuna()-1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        
        //direita
        p.setLinha(posicao.getLinha());
        p.setColuna(posicao.getColuna()+1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        //DIAGONAL NOROESTE
        p.setLinha(posicao.getLinha()-1);
        p.setColuna(posicao.getColuna()-1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        //DIAGONAL NORDESTE
        p.setLinha(posicao.getLinha()-1);
        p.setColuna(posicao.getColuna()+1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        //DIAGONAL SUDOESTE
        p.setLinha(posicao.getLinha()+1);
        p.setColuna(posicao.getColuna()-1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
        }
        //DIAGONAL SUDESTE
        p.setLinha(posicao.getLinha()+1);
        p.setColuna(posicao.getColuna()+1);
        if(getTabuleiro().posicaoExiste(p)&& podeMover(p))
        {
            mat[p.getLinha()][p.getColuna()]=true;
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
