package CamadaXadrez;

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
        PecaXadrez pecaCapturada = movimenta(origem2, destino2);
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

    private void validarPosicaoOrigem(Posicao posicao)
    {
        if (!tabuleiro.temPeca(posicao))
        {
            throw new XadrezException("Não tem nenhuma peça na posicao de origem");
        }
        if(JogadorAtual != (tabuleiro.peca(posicao)).getCor()){
            throw new XadrezException("A peça escolhida não é sua");
        }
        if(!tabuleiro.peca(posicao).possivelMovimento(posicao)){
            throw new XadrezException("Não existe movimentos possíveis para a peça selecionada");
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

    public void setJogadorAtual(Cor JogadorAtual)
    {
        this.JogadorAtual = JogadorAtual;
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
