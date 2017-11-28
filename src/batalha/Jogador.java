
package batalha;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import pokemon.Pokemon;

public abstract class Jogador {
    
    //ATRIBUTOS
    protected String identificador;
    private List<Pokemon> listaPokemons = new ArrayList<>();
    
    //CONSTRUTOR
    public void adicionarPokemon(Pokemon pokemon){
        listaPokemons.add(pokemon);
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    protected List<Pokemon> getListaPokemons(){
        return listaPokemons;
    }
    
    public boolean temPokemonUtilizavel() {        
        for( Pokemon p : listaPokemons )
            if(p.getStatus() != pokemon.Status.FAINTED)
                return true;
        return false;        
    }
    
    public Pokemon getProximoPokemon() {
        return listaPokemons.get(0);
    }
    
    //METODOS
    public void trocarPokemon(Pokemon pokemon){

        int posicao = listaPokemons.indexOf(pokemon); //Posicao em que esta o pokemon que vai para o inicio da lista
        
        Collections.swap(listaPokemons, 0, posicao); //Troca o pokmenon escolhido com o primeiro da lista

    }
        
    public abstract AcaoJogador escolherComando(Pokemon adversario);
    
    @Override
    public String toString() {
        
        String retorno = "";
        
        for(Pokemon p:listaPokemons) {
            retorno += "\n"+p.toString();
        }
        return retorno;
    }
}

