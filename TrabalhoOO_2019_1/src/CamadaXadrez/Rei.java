package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.Enum.Cor;
import CamadaXadrez.PecaXadrez;

public class Rei extends PecaXadrez implements Movimento{


    private PartidaXadrez partida; 
    
    public Rei(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida){
        super(tabuleiro, cor);
        this.partida=partida;
    }
    
    @Override
    public String toString(){
        return "K";
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
        
        //#movimentoEspecial Roque
        if(getContaMovimentos() == 0 && !partida.isCheck())
        {
            //movimento especial roque pequeno
            Posicao posicaoDaTorre1 = new Posicao(posicao.getLinha(), posicao.getColuna()+3);
            if(testeTorreRoque(posicaoDaTorre1))
            {
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna()+1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna()+2);
                if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null)
                {
                    mat[posicao.getLinha()][posicao.getColuna()+2] = true;
                }
            }
            //movimento especial roque grande
            Posicao posicaoDaTorre2 = new Posicao(posicao.getLinha(), posicao.getColuna()-4);
            if(testeTorreRoque(posicaoDaTorre2))
            {
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna()-1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna()-2);
                Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna()-3);
                if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null)
                {
                    mat[posicao.getLinha()][posicao.getColuna()-2] = true;
                }
            }
        }
        
        return mat;
    }
    
    private boolean testeTorreRoque(Posicao posicao){
        PecaXadrez p = getTabuleiro().peca(posicao);
        return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContaMovimentos() == 0;
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
