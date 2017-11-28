package batalha;

import pokemon.Pokemon;

public class AcaoTrocarPokemon implements AcaoJogador {

    private Jogador agente;
    private Pokemon novoPokemon;
    
    public AcaoTrocarPokemon(Jogador agente, Pokemon novoPokemon) {
        this.agente = agente;
        this.novoPokemon = novoPokemon;
    }

    @Override
    public String message() {
        return agente.getIdentificador() + " trocou o pokémon " + novoPokemon.getEspecie().toString() + " para o início da fila.";
    }
    
    @Override
    public void executa() {
        this.agente.trocarPokemon(novoPokemon);
    }

}
