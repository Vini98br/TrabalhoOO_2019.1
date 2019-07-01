package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaTabuleiro.Tabuleiro;
import CamadaTabuleiro.Posicao;
import CamadaXadrez.Enum.Cor;
import CamadaXadrez.Exception.XadrezException;
import CamadaTabuleiro.Posicao;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.Rei;
import CamadaXadrez.Torre;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartidaXadrez
{

    private int turn;
    private Cor JogadorAtual;
    private boolean check;
    private boolean checkmate;
    private PecaXadrez promocao;
    private PecaXadrez enPassantVulnerabilidade;

    private Tabuleiro tabuleiro;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();
    
    private PecaXadrez enPassantVulneravel;

    public PartidaXadrez()
    {
        tabuleiro = new Tabuleiro(8, 8);
        turn = 1;
        JogadorAtual = Cor.BRANCA;
        check = false;
        setUpInicial();
    }

    public PartidaXadrez(int turn, Cor JogadorAtual, boolean check, boolean checkmate, PecaXadrez promocao, PecaXadrez enPassantVulnerabilidade)
    {
        this.turn = turn;
        this.JogadorAtual = JogadorAtual;
        this.check = check;
        this.checkmate = checkmate;
        this.promocao = promocao;
        this.enPassantVulnerabilidade = enPassantVulnerabilidade;
        tabuleiro = new Tabuleiro(8, 8);
        setUpInicial();
    }

    public PecaXadrez[][] getPecas()//retorna matriz de peças da partida de xadrez
    {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        mat[1][1]=new Torre(tabuleiro,Cor.BRANCA);
        for (int i = 0; i < tabuleiro.getLinhas(); i++)
        {
            for (int j = 0; j <
                    tabuleiro.getColunas(); j++)
            {
                mat[i][j] = (PecaXadrez)tabuleiro.peca(i, j);
//                System.out.println(i+"  "+ j);
//                System.out.println(mat[i][j]);
                
            }
        }
        return mat;
    }
    
    private void nextTurn()
    {
        turn++;
        JogadorAtual = (JogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }
    
    public PecaXadrez fazMovimento(PosicaoPeca origem, PosicaoPeca destino)
    {
        Posicao origem2 = origem.paraPosicao();
        Posicao destino2 = destino.paraPosicao();
        validarPosicaoOrigem(origem2);
        validarPosicaoDestino(origem2,destino2);
        Peca pecaCapturada = movimenta(origem2, destino2);
        
        if(testaCheck(JogadorAtual))
        {
            desfazMovimento(origem2, destino2, pecaCapturada);
            throw new XadrezException("Não é possivel se colocar em check");
        }
        
        PecaXadrez pecaMovida = (PecaXadrez)tabuleiro.peca(destino2);
        
        check = (testaCheck(oponente(JogadorAtual))) ? true : false;
        
      
        if(testaCheckMate(oponente(JogadorAtual)))
        {
            checkmate=true;
        }
        else
        {
            nextTurn();
        }
        
        //movimento especial en passant
         if(pecaMovida instanceof Peao && (destino.getLinha() == origem.getLinha()-2 || destino.getLinha() == origem.getLinha()))
         {
            enPassantVulneravel = pecaMovida;
         }
         else
         {
            enPassantVulneravel = null;
         }
        
         
        return (PecaXadrez)pecaCapturada;
    }

    private Peca movimenta(Posicao origem, Posicao destino)
    {
        PecaXadrez p = (PecaXadrez)tabuleiro.removePeca(origem);
        p.incrementaContador();
        Peca capturada = tabuleiro.removePeca(destino);
        tabuleiro.posicionaPeca(p, destino);
        
        if(capturada != null)
        {
            pecasNoTabuleiro.remove(capturada);
            pecasCapturadas.add(capturada);
        }
        
        //#movimento especial: roque pequeno
        if(p instanceof Rei && destino.getColuna() == origem.getColuna()+2)
        {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna()+3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna()+1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removePeca(origemT);
            tabuleiro.posicionaPeca(torre, destinoT);
            torre.incrementaContador();
        }
        
        //#movimento especial: roque grande
        if(p instanceof Rei && destino.getColuna() == origem.getColuna()-2)
        {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna()-4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna()-1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removePeca(origemT);
            tabuleiro.posicionaPeca(torre, destinoT);
            torre.incrementaContador();
        }
        
        //#movimento especial en passant
         if(p instanceof Peao)
         {
             if(origem.getColuna()!=destino.getColuna() && capturada == null)
             {
                 Posicao pPeao;
                 if(p.getCor() == Cor.BRANCA)
                 {
                     pPeao = new Posicao(destino.getLinha() + 1, destino.getColuna());
                 }
                 else
                 {
                     pPeao = new Posicao(destino.getLinha() - 1, destino.getColuna());
                 }
                 capturada = tabuleiro.removePeca(pPeao);
                 pecasCapturadas.add(capturada);
                 pecasNoTabuleiro.remove(capturada);
             }
         }
        
        return capturada;
    }

     
    private void desfazMovimento(Posicao origem, Posicao alvo, Peca pecaCapturada)
    {
        PecaXadrez p = (PecaXadrez)tabuleiro.removePeca(alvo);
        p.decrementaContador();
        tabuleiro.posicionaPeca(p, origem);
        
        if(pecaCapturada != null)
        {
            tabuleiro.posicionaPeca(pecaCapturada, alvo);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
        
        //#movimento especial: roque pequeno
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna()+2)
        {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna()+3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna()+1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removePeca(destinoT);
            tabuleiro.posicionaPeca(torre, origemT);
            torre.decrementaContador();
        }
        
        //#movimento especial: roque grande
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna()-2)
        {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna()-4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna()-1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removePeca(destinoT);
            tabuleiro.posicionaPeca(torre, origemT);
            torre.decrementaContador();
        }
        
        //#movimento especial en passant
         if(p instanceof Peao)
         {
             if(origem.getColuna()!=alvo.getColuna() && pecaCapturada == enPassantVulneravel)
             {
                 PecaXadrez peao = (PecaXadrez)tabuleiro.removePeca(alvo);
                 Posicao pPeao;
                 if(p.getCor() == Cor.BRANCA)
                 {
                     pPeao = new Posicao(3, alvo.getColuna());
                 }
                 else
                 {
                     pPeao = new Posicao(4, alvo.getColuna());
                 }
                 tabuleiro.posicionaPeca(peao, pPeao);
             }
         }
    }
    
    private void validarPosicaoOrigem(Posicao posicao)
    {
        if (!tabuleiro.temPeca(posicao))
        {
            throw new XadrezException("Não tem nenhuma peça na posicao de origem");
        }
        if(JogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()){
            throw new XadrezException("A peça escolhida não é sua");
        }
        if(!tabuleiro.peca(posicao).temAlgumPossivelMovimento()){
            throw new XadrezException("Não existe movimentos possíveis para a peça selecionada");
        }
    }
    
    private void validarPosicaoDestino(Posicao origem, Posicao destino)
    {
        if(!tabuleiro.peca(origem).possiveisMovimentos(destino)){
            throw new XadrezException("A peça escolhida não pode ir pra posição de destino");
        }
    }

    public boolean[][] movimentosPossiveis(PosicaoPeca posicaoInicial)
    {
        Posicao posicao = posicaoInicial.paraPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    private Cor oponente(Cor cor)
    {
        return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }
    
    private PecaXadrez rei(Cor cor)
    {
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
        for(Peca p : list)
        {
            if(p instanceof Rei)
            {
                return (PecaXadrez)p;
            }
        }
        throw new IllegalStateException("Não tem" + "rei no tabuleiro");
    }
    
    private boolean testaCheck(Cor cor)
    {
        Posicao posicaoRei=rei(cor).getPosicaoPeca().paraPosicao();
        List<Peca> pecasOponentes =  pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
        for(Peca p : pecasOponentes)
        {
            boolean[][] mat = p.movimentosPossiveis();
            if(mat[posicaoRei.getLinha()][posicaoRei.getColuna()])
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean testaCheckMate(Cor cor)
    {
       if(!testaCheck(cor))
       {
           return false;
       }
       List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
       for(Peca p : list){
           boolean[][] mat=p.movimentosPossiveis();
           for(int i=0 ; i<tabuleiro.getLinhas();i++)
           {
               for(int j=0; j<tabuleiro.getColunas();j++)
               {
                   if(mat[i][j])
                   {
                       Posicao origem = ((PecaXadrez)p).getPosicaoPeca().paraPosicao();
                       Posicao destino = new Posicao(i,j);
                       Peca pecaCapturada = movimenta(origem, destino);
                       boolean testCheck = testaCheck(cor);
                       desfazMovimento(origem, destino, pecaCapturada);
                       if(!testCheck){
                           return false;
                       }
                   }
               }
           }
       }
       return true;
    }
    
    private void posicionaNovaPeca(char coluna, int linha , PecaXadrez peca)
    {
        tabuleiro.posicionaPeca(peca,new PosicaoPeca(linha, coluna).paraPosicao());
        pecasNoTabuleiro.add(peca);
    }
    
    private void setUpInicial()
    {

        posicionaNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('d', 1, new Rainha(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCA));
        posicionaNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCA, this));
        posicionaNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCA, this));

        posicionaNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('d', 8, new Rainha(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETA));
        posicionaNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETA));
       posicionaNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETA, this));
        posicionaNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETA, this));


    }

    public PosicaoPeca movimento(PosicaoPeca posicaoInicial, PosicaoPeca posicaoAlvo)
    {
        return null;
    }

    public PecaXadrez trocaPromocao(String tipo)
    {
        return null;
    }

    public PecaXadrez getenPassantVulneravel(){
        return enPassantVulneravel;
    }
    
    public int getTurn()
    {
        return turn;
    }

    public void setTurn(int turn)
    {
        this.turn = turn;
    }

    public Cor getJogadorAtual()
    {
        return JogadorAtual;
    }
    
    public boolean isCheck()
    {
        return check;
    }

    public void setCheck(boolean check)
    {
        this.check = check;
    }

    public boolean isCheckmate()
    {
        return checkmate;
    }

    public void setCheckmate(boolean checkmate)
    {
        this.checkmate = checkmate;
    }

    public PecaXadrez getPromocao()
    {
        return promocao;
    }

    public void setPromocao(PecaXadrez promocao)
    {
        this.promocao = promocao;
    }

    public PecaXadrez getEnPassantVulnerabilidade()
    {
        return enPassantVulnerabilidade;
    }

    public void setEnPassantVulnerabilidade(PecaXadrez enPassantVulnerabilidade)
    {
        this.enPassantVulnerabilidade = enPassantVulnerabilidade;
    }

}
