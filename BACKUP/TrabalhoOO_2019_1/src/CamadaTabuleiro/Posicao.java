/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaTabuleiro;

/**
 *
 * @author vinic
 */
public class Posicao
{
    private int coluna;
    private int linha;
    
    public Posicao(){
        
    }

    public Posicao(int coluna, int linha)
    {
        this.coluna = coluna;
        this.linha = linha;
    }
       
    void setValores(int linha,int coluna){
        this.linha=linha;
        this.coluna=coluna;
    }

    public int getColuna()
    {
        return coluna;
    }

    public void setColuna(int coluna)
    {
        this.coluna = coluna;
    }

    public int getLinha()
    {
        return linha;
    }

    public void setLinha(int linha)
    {
        this.linha = linha;
    }
    
    @Override
    public String toString(){
        return linha + ", "+coluna;
    }
}
