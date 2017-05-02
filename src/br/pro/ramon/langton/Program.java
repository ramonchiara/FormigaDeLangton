package br.pro.ramon.langton;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Linhas: ");
        int linhas = Integer.parseInt(console.nextLine());
        System.out.print("Colunas: ");
        int colunas = Integer.parseInt(console.nextLine());
        System.out.print("Linha inicial: ");
        int linha = Integer.parseInt(console.nextLine());
        System.out.print("Coluna inicial: ");
        int coluna = Integer.parseInt(console.nextLine());
        System.out.print("Direção inicial (N, S, L, O): ");
        String direcao = console.nextLine();

        Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas);
        Formiga formiga = new Formiga(tabuleiro, linha, coluna, direcao);

        boolean sair = false;
        do {
            tabuleiro.print(formiga);
            System.out.print("Quer continuar? ");
            String continua = console.nextLine();
            if (continua.equalsIgnoreCase("n")) {
                sair = true;
            } else {
                formiga.movimenta();
            }
        } while (!sair);

    }

}
