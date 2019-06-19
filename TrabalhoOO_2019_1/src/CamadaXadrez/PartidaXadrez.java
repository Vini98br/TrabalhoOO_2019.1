package CamadaXadrez;

import CamadaXadrez.Enum.Cor;
import CamadaXadrez.Exception.XadrezException;

public class PartidaXadrez
{
    private int turn;
    private Cor JogadorAtual;
    private boolean check;
    private boolean checkmate;
    private PecaXadrez promocao;
    private PecaXadrez enPassantVulnerabilidade;
    
    public PartidaXadrez(){
        
    }

    public PartidaXadrez(int turn, Cor JogadorAtual, boolean check, boolean checkmate, PecaXadrez promocao, PecaXadrez enPassantVulnerabilidade)
    {
        this.turn = turn;
        this.JogadorAtual = JogadorAtual;
        this.check = check;
        this.checkmate = checkmate;
        this.promocao = promocao;
        this.enPassantVulnerabilidade = enPassantVulnerabilidade;
    }
    
    public PecaXadrez[][] getPecas(){
        return null;
    }
    
    public boolean[][] movimentosPossiveis(PosicaoPeca posicaoInicial){
        return null;
    }
    
    public PosicaoPeca movimento(PosicaoPeca posicaoInicial, PosicaoPeca posicaoAlvo){
        return null;
    }
    
    public PecaXadrez trocaPromocao(String tipo){
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
