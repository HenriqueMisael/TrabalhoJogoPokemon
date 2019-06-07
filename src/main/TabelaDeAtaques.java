package main;

import pokemon.Tipo;

import java.util.StringTokenizer;

public class TabelaDeAtaques extends Tabela {

    public TabelaDeAtaques(String caminho) {
        super(165, 8);
        carregar(caminho);
    }

    public String getNome(int id) {
        return tabela[id - 1][1];
    }

    public Tipo getType(int id) {
        return pokemon.Tipo.valueOf(tabela[id - 1][2].toUpperCase());
    }

    public int getPP(int id) {
        return Integer.parseInt(tabela[id - 1][3]);
    }

    public int getPower(int id) {
        return Integer.parseInt(tabela[id - 1][4]);
    }

    public int getAccuracy(int id) {
        return Integer.parseInt(tabela[id - 1][5]);
    }

    public String getClasse(int id) {
        return tabela[id - 1][6];
    }

    public String[] getParametros(int id) {

        StringTokenizer st;
        String[] parametros;
        int i = 0;

        if (tabela[id - 1][7] == null)
            return null;

        st = new StringTokenizer(tabela[id - 1][7], ", ");
        parametros = new String[st.countTokens()];

        while (st.hasMoreTokens()) {
            parametros[i++] = st.nextToken();
        }

        return parametros;
    }
}
