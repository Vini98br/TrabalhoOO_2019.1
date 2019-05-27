/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaTabuleiro.Posicao;
import CamadaXadrez.Enum.Cor;

/**
 *
 * @author vinic
 */
public class PecaXadrez extends Peca
{
    private Cor cor;
    private int contaMovimentos;
    
    public PosicaoPeca getPosicaoPeca(){
        return null;
    }
    
    public boolean temPecaRival(Posicao posicao){
        return false;
    }
    
    public void incrementaContador(){
        
    }
    
    public void decrementaContador(){
        
    }
}
