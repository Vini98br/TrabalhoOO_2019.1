package CamadaXadrez;

import CamadaTabuleiro.Tabuleiro;
import CamadaTabuleiro.Posicao;
import CamadaXadrez.Enum.Cor;
import CamadaXadrez.Exception.XadrezException;
import CamadaTabuleiro.Posicao;
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

    private List<PecaXadrez> pecasNoTabuleiro = new ArrayList<>();
    private List<PecaXadrez> pecasCapturadas = new ArrayList<>();

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
        for (int i = 0; i <= tabuleiro.getLinhas(); i++)
        {
            for (int j = 0; i <= tabuleiro.getColunas(); j++)
            {
                mat[i][j] = tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    public PecaXadrez fazMovimento(PosicaoPeca origem, PosicaoPeca destino)
    {
        Posicao origem2 = origem.paraPosicao();
        Posicao destino2 = destino.paraPosicao();
        validarPosicaoOrigem(origem2);
        //validarPosicaoDestino(origem2,destino2);
        PecaXadrez pecaCapturada = movimenta(origem2, destino2);
        
        if(testaCheck(JogadorAtual))
        {
            desfazMovimento(origem2, destino2, pecaCapturada);
            throw new XadrezException("Não é possivel se colocar em check");
        }
        
        check = (testaCheck(oponente(JogadorAtual))) ? true : false;
        
        nextTurn();
        return pecaCapturada;
    }

    private PecaXadrez movimenta(Posicao origem, Posicao destino)
    {
        PecaXadrez p = tabuleiro.removePeca(origem);
        PecaXadrez capturada = tabuleiro.removePeca(destino);
        tabuleiro.posicionaPeca(p, destino);
        
        if(capturada != null)
        {
            pecasNoTabuleiro.remove(capturada);
            pecasCapturadas.add(capturada);
        }
        
        return capturada;
    }

     
    private void desfazMovimento(Posicao origem, Posicao alvo, PecaXadrez pecaCapturada)
    {
        PecaXadrez p = tabuleiro.removePeca(alvo);
        tabuleiro.posicionaPeca(p, origem);
        
        if(pecaCapturada != null)
        {
            tabuleiro.posicionaPeca(pecaCapturada, alvo);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
    }
    
    private void validarPosicaoOrigem(Posicao posicao)
    {
        if (!tabuleiro.temPeca(posicao))
        {
            throw new XadrezException("Não tem nenhuma peça na posicao de origem");
        }
    }
    
    private void validarPosicaoDestino(Posicao origem, Posicao destino)
    {
        if(!tabuleiro.peca(origem).possivelMovimento(destino)){
            throw new XadrezException("A peça escolhida não pode ir pra posição de destino");
        }
    }
    

    public boolean[][] movimentosPossiveis(PosicaoPeca posicaoInicial)
    {
        Posicao posicao = posicaoInicial.paraPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    private void nextTurn()
    {
        turn++;
        JogadorAtual = (JogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }
    
    private Cor oponente(Cor cor)
    {
        return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }
    
    private PecaXadrez rei(Cor cor)
    {
        List<PecaXadrez> list = (List<PecaXadrez>) pecasNoTabuleiro.stream().filter(x -> x.getCor() == cor).collect(Collectors.toList());
        for(PecaXadrez p : list)
        {
            if(p instanceof Rei)
            {
                return p;
            }
        }
        throw new IllegalStateException("Não tem" + "rei no tabuleiro");
    }
    
    private boolean testaCheck(Cor cor)
    {
        Posicao posicaoRei=rei(cor).getPosicaoPeca().paraPosicao();
        List<PecaXadrez> pecasOponentes = (List<PecaXadrez>) pecasNoTabuleiro.stream().filter(x -> x.getCor() == oponente(cor)).collect(Collectors.toList());
        for(PecaXadrez p : pecasOponentes)
        {
            boolean[][] mat = p.movimentosPossiveis();
            if(mat[posicaoRei.getLinha()][posicaoRei.getColuna()])
            {
                return true;
            }
        }
        return false;
    }
    
    private void posicionaNovaPeca(char coluna, int linha , PecaXadrez peca)
    {
        tabuleiro.posicionaPeca(peca,new PosicaoPeca(linha, coluna).paraPosicao());
        pecasNoTabuleiro.add(peca);
    }
    
    private void setUpInicial()
    {
        tabuleiro.posicionaPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(2, 1));
        tabuleiro.posicionaPeca(new Rei(tabuleiro, Cor.PRETA), new Posicao(3, 1));

    }

    public PosicaoPeca movimento(PosicaoPeca posicaoInicial, PosicaoPeca posicaoAlvo)
    {
        return null;
    }

    public PecaXadrez trocaPromocao(String tipo)
    {
        return null;
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
