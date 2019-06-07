package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Tabela {

    final String[][] tabela;
    private final int linhas;

    Tabela(int linhas, int colunas) {
        this.linhas = linhas;
        this.tabela = new String[linhas][colunas];
    }

    void carregar(String caminho) {

        try {
            BufferedReader conteudo = new BufferedReader(new FileReader(caminho));
            for (int i = 0; i < this.linhas; i++) {
                int j = 0;
                String linha = conteudo.readLine();
                String[] camposLidos = linha.split("\t");
                for (String s : camposLidos) {
                    tabela[i][j] = s;
                    j++;
                }
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
}
