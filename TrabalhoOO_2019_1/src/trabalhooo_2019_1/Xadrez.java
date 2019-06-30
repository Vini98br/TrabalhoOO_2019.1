package trabalhooo_2019_1;

import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.*;
import CamadaXadrez.Exception.XadrezException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Xadrez
{

    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();

        while (true)
        {
            try
            {
                
                PecaXadrez[][] mat = partida.getPecas();
                IU.clearScreen();
                IU.imprimePartida(partida,capturadas);
                IU.imprimeTabuleiro(mat);
                System.out.println();
                System.out.print("Origem: ");
                PosicaoPeca origem = IU.lePosicaoPeca(teclado);

                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
                IU.clearScreen();
                IU.imprimeTabuleiro(partida.getPecas(), movimentosPossiveis);
                
                
                System.out.println();
                System.out.print("Destino: ");
                PosicaoPeca destino = IU.lePosicaoPeca(teclado);

                PecaXadrez pecaCapturada = partida.fazMovimento(origem, destino);
                if(pecaCapturada != null)
                {
                    capturadas.add(pecaCapturada);
                }
                
                
                
            } catch (XadrezException e)
            {
                System.out.println(e.getMessage());
                teclado.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(e.getMessage());
                teclado.nextLine();
            }
        }
    }

}
