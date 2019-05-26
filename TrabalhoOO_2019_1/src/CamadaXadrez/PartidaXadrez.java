/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaXadrez;

import CamadaXadrez.Enum.Cor;

/**
 *
 * @author vinic
 */
public class PartidaXadrez
{
    int turn;
    Cor JogadorAtual;
    boolean check;
    boolean checkmate;
    PecaXadrez promocao;
    PecaXadrez enPassantVulnerabilidade;
    
    PecaXadrez[][] getPecas(){
        return null;
    }
    
    boolean[][] movimentosPossiveis(PosicaoPeca posicaoInicial){
        return null;
    }
    
    PosicaoPeca movimento(PosicaoPeca posicaoInicial, PosicaoPeca posicaoAlvo){
        return null;
    }
    
    PecaXadrez trocaPromocao(String tipo){
        return null;
    }
}
