package application;

import CamadaXadrez.Enum.Cor;
import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.PosicaoPeca;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IU
{

    //variaveis para colocar cor no terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    
    public IU()
    {
    }
    
    public static void clearScreen()
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void imprimePartida(PartidaXadrez partida, List<PecaXadrez> capturadas)
    {
        imprimeTabuleiro(partida.getPecas());
        System.out.println();
        ImprimePecasCapturadas(capturadas);
        System.out.println();
        System.out.println("Jogador da vez : " + partida.getTurn());
        if(!partida.isCheckmate()){
        System.out.println("Esperando jogador: " + partida.getJogadorAtual());
        if(partida.isCheck())
        {
            System.out.println("CHECK!");
        }
        }
        else
        {
            System.out.println("CHECKMATE!");
            System.out.println("Vencedor: " + partida.getJogadorAtual());
        }
    }


    public static PosicaoPeca lePosicaoPeca(Scanner sc)
    {
        try
        {
            String s = sc.nextLine();
            char coluna = s.charAt(0);
            int linha = Integer.parseInt(s.substring(1));
            return new PosicaoPeca(linha, coluna);
        } catch (RuntimeException e)
        {
            throw new InputMismatchException("Erro na leitura da Posição da peça:valores valido são de a1 a h8!");
        }
    }

    public static void imprimeTabuleiro(PecaXadrez[][] pecas)
    {        
        for (int i = 0; i < pecas.length; i++)
        {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++)
            {
                imprimePeca(pecas[i][j],false);
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h");
    }

    public static void imprimeTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis)
    {
        for (int i = 0; i < pecas.length; i++)
        {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++)
            {
                imprimePeca(pecas[i][j],movimentosPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h");
    }

    private static void imprimePeca(PecaXadrez peca, boolean fundo)
    {
        if (fundo)
        {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null)
        {
            System.out.print("-" + ANSI_RESET);
        }
        else
        {
            if (peca.getCor() == Cor.BRANCA)
            {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else
            {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void ImprimePecasCapturadas(List<PecaXadrez> capturadas)
    {
        List<PecaXadrez> branca = capturadas.stream().filter(x -> x.getCor() == Cor.BRANCA).collect(Collectors.toList());
        List<PecaXadrez> preta = capturadas.stream().filter(x -> x.getCor() == Cor.PRETA).collect(Collectors.toList());
        System.out.println("Peças capturadas");
        System.out.print("Brancas: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(branca.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Pretas: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(preta.toArray()));
        System.out.print(ANSI_RESET);
    }
}
