package CamadaXadrez;

import CamadaXadrez.Enum.Cor;

public class PartidaXadrez
{
    private int turn;
    private Cor JogadorAtual;
    private boolean check;
    private boolean checkmate;
    private PecaXadrez promocao;
    private PecaXadrez enPassantVulnerabilidade;
    
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
}
