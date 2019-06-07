package batalha;

import pokemon.Pokemon;

public class AcaoTrocarPokemon implements AcaoJogador {

    private final Jogador agente;
    private final Pokemon novoPokemon;
    
    public AcaoTrocarPokemon(Jogador agente, Pokemon novoPokemon) {
        this.agente = agente;
        this.novoPokemon = novoPokemon;
    }

    @Override
    public String message() {
        return agente.toString() + " trocou o pokémon " + novoPokemon.getEspecie().toString() + " para o início da fila.";
    }
    
    @Override
    public AcaoJogador executa() {
        this.agente.trocarPokemon(novoPokemon);
        return null;
    }

    @Override
    public int getPlayer() {
        return agente.getId();
    }
    
    @Override
    public double getPriority() {        
        return 999.999;        
    }
}
