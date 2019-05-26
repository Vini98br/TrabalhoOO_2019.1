/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaXadrez.Enum.Cor;

/**
 *
 * @author vinic
 */
public class PecaXadrez extends Peca
{
    Cor cor;
    int contaMovimentos;
    
    PosicaoPeca getPosicaoPeca(){
        return null;
    }
    
    boolean temPecaRival(Posicao posicao){
        return false;
    }
    
    void incrementaContador(){
        
    }
    
    void decrementaContador(){
        
    }
}
