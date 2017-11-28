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
        return agente.getIdentificador() + " trocou o pok�mon " + novoPokemon.getEspecie().toString() + " para o in�cio da fila.";
    }
    
    @Override
    public void executa() {
        this.agente.trocarPokemon(novoPokemon);
    }

}
