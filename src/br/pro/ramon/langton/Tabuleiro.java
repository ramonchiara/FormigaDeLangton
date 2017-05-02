package br.pro.ramon.langton;

public class Tabuleiro {

    public static final String BRANCO = ".";
    public static final String PRETO = "#";

    private String[][] cores;

    public Tabuleiro(int linhas, int colunas) {
        cores = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cores[i][j] = BRANCO;
            }
        }
    }

    public void print(Formiga formiga) {
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                if (formiga.estaNaPosicao(i, j)) {
                    formiga.print();
                } else {
                    System.out.print(cores[i][j]);
                }
            }
            System.out.println();
        }
    }

    public String getCor(int linha, int coluna) {
        if (!isPosicaoValida(linha, coluna)) {
            return null;
        }

        return cores[linha][coluna];
    }

    public void flip(int linha, int coluna) {
        if (!isPosicaoValida(linha, coluna)) {
            return;
        }

        if (cores[linha][coluna].equals(BRANCO)) {
            cores[linha][coluna] = PRETO;
        } else {
            cores[linha][coluna] = BRANCO;
        }
    }

    boolean isPosicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < cores.length && coluna >= 0 && coluna < cores[linha].length;
    }

}
