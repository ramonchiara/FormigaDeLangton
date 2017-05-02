package br.pro.ramon.langton;

public class Formiga {

    private Tabuleiro tabuleiro;
    private int linha, coluna;
    private String direcao;

    public Formiga(Tabuleiro tabuleiro, int linha, int coluna, String direcao) {
        this.tabuleiro = tabuleiro;
        this.linha = linha;
        this.coluna = coluna;
        this.direcao = direcao;
    }

    public void print() {
        switch (direcao) {
            case "N":
                System.out.print("^");
                break;
            case "S":
                System.out.print("v");
                break;
            case "L":
                System.out.print(">");
                break;
            case "O":
                System.out.print("<");
                break;
        }
    }

    public boolean estaNaPosicao(int linha, int coluna) {
        return this.linha == linha && this.coluna == coluna;
    }

    public void movimenta() {
        String cor = tabuleiro.getCor(linha, coluna);
        switch (cor) {
            case Tabuleiro.BRANCO:
                viraParaDireita();
                tabuleiro.flip(linha, coluna);
                andaParaFrente();
                break;
            case Tabuleiro.PRETO:
                viraParaEsquerda();
                tabuleiro.flip(linha, coluna);
                andaParaFrente();
                break;
        }
    }

    public void viraParaDireita() {
        switch (direcao) {
            case "N":
                direcao = "L";
                break;
            case "S":
                direcao = "O";
                break;
            case "L":
                direcao = "S";
                break;
            case "O":
                direcao = "N";
                break;
        }
    }

    public void viraParaEsquerda() {
        switch (direcao) {
            case "N":
                direcao = "O";
                break;
            case "S":
                direcao = "L";
                break;
            case "L":
                direcao = "N";
                break;
            case "O":
                direcao = "S";
                break;
        }
    }

    public void andaParaFrente() {
        switch (direcao) {
            case "N":
                if (tabuleiro.isPosicaoValida(linha - 1, coluna)) {
                    linha--;
                }
                break;
            case "S":
                if (tabuleiro.isPosicaoValida(linha + 1, coluna)) {
                    linha++;
                }
                break;
            case "L":
                if (tabuleiro.isPosicaoValida(linha, coluna + 1)) {
                    coluna++;
                }
                break;
            case "O":
                if (tabuleiro.isPosicaoValida(linha, coluna - 1)) {
                    coluna--;
                }
                break;
        }
    }

}
