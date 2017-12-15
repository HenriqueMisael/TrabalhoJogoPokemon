package batalha;

import pokemon.Pokemon;

public class AcaoTrocarPokemon implements AcaoJogador {

    private Jogador agente;
    private Pokemon novoPokemon;
    private int player;
    
    public AcaoTrocarPokemon(Jogador agente, Pokemon novoPokemon, int player) {
        this.agente = agente;
        this.novoPokemon = novoPokemon;
        this.player = player;
    }

    @Override
    public String message() {
        return agente.getId() + " trocou o pokémon " + novoPokemon.getEspecie().toString() + " para o início da fila.";
    }
    
    @Override
    public AcaoJogador executa() {
        this.agente.trocarPokemon(novoPokemon);
        return null;
    }

    @Override
    public int getPlayer() {
        return player;
    }
}
