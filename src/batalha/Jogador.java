
package batalha;

import ataques.Ataque;
import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Jogador {

    //ATRIBUTOS
    protected String identificador;
    private final List<Pokemon> listaPokemons = new ArrayList<>();
    private final int id;

    Jogador(int id) {
        this.id = id;
    }

    //METODOS
    int getId() {
        return id;
    }

    public void adicionarPokemon(Pokemon pokemon) {
        listaPokemons.add(pokemon);
    }

    List<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    boolean temPokemonUtilizavel() {
        return quantidadePokemonsUtilizaveis() > 0;
    }

    int quantidadePokemonsUtilizaveis() {

        int quantidade = 0;

        for (Pokemon p : listaPokemons)
            if (!p.getStatus().contains(pokemon.StatusPrimario.FAINTED))
                quantidade++;

        return quantidade;
    }

    public Pokemon getProximoPokemon() {
        return listaPokemons.get(0);
    }

    public void trocarPokemon(Pokemon pokemon) {

        int posicao = listaPokemons.indexOf(pokemon); //Posicao em que esta o pokemon que vai para o inicio da lista

        Collections.swap(listaPokemons, 0, posicao); //Troca o pokmenon escolhido com o primeiro da lista
    }

    Ataque retornaAtaquePokemon(int ataque) {

        Ataque ataqueRetorno;

        switch (ataque) {
            case 1:
                ataqueRetorno = getProximoPokemon().getAtaque1();
                break;
            case 2:
                ataqueRetorno = getProximoPokemon().getAtaque2();
                break;
            case 3:
                ataqueRetorno = getProximoPokemon().getAtaque3();
                break;
            case 4:
                ataqueRetorno = getProximoPokemon().getAtaque4();
                break;
            default:
                ataqueRetorno = null;
        }

        return ataqueRetorno;
    }

    public abstract AcaoJogador escolherComando(Jogador adversario);

    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}

