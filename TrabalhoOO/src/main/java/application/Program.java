package application;

import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.*;
import CamadaXadrez.Exception.XadrezException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program
{

    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();

        while (!partida.isCheckmate())
        {
            try
            {
                IU.clearScreen();
                IU.imprimePartida(partida, capturadas);
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
                
                if (pecaCapturada != null)
                {
                    capturadas.add(pecaCapturada);
                }
                
                if(partida.getPromocao() != null)
                {
                    System.out.print("digite a peça para ser promovida (B/C/T/Q)");
                    String tipo = teclado.nextLine();
                    partida.substituiPecaPromovida(tipo);
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
        IU.clearScreen();
        IU.imprimePartida(partida, capturadas);
    }
}
