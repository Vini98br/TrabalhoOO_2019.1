package CamadaTabuleiro;

public class Posicao
{
    private int coluna;
    private int linha;
    
    public Posicao(){
        
    }

    public Posicao(int linha, int coluna)
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
        return linha + ", " + coluna;
    }
    
    public void setValor(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
}