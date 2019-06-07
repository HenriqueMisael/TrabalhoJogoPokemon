package main;

import pokemon.Tipo;

public class TabelaDeEspecies extends Tabela {

    public TabelaDeEspecies(String caminho) {
        super(151, 9);
        carregar(caminho);
    }

    public String getEspecie(int id) {
        return tabela[id - 1][1];
    }

    public Tipo getTipo1(int id) {
        return Tipo.valueOf(tabela[id - 1][2].toUpperCase());
    }

    public Tipo getTipo2(int id) {

        String tipoString = tabela[id - 1][3].toUpperCase();

        if (tipoString.isEmpty())
            tipoString = "NONE";

        return Tipo.valueOf(tipoString);
    }

    public int getBaseHP(int id) {
        return Integer.parseInt(tabela[id - 1][4]);
    }

    public int getBaseATK(int id) {
        return Integer.parseInt(tabela[id - 1][5]);
    }

    public int getBaseDEF(int id) {
        return Integer.parseInt(tabela[id - 1][6]);
    }

    public int getBaseSPE(int id) {
        return Integer.parseInt(tabela[id - 1][7]);
    }

    public int getBaseSPD(int id) {
        return Integer.parseInt(tabela[id - 1][8]);
    }
}
