
package batalha;

import java.util.List;

import ataques.Ataque;

import java.util.ArrayList;
import java.util.Collections;
import pokemon.Pokemon;

public abstract class Jogador {
    
    //ATRIBUTOS
    protected String identificador;
    private List<Pokemon> listaPokemons = new ArrayList<>();
    private int id;
    
    public Jogador(int id) {
        this.id = id;
    }
    
    //METODOS
    protected int getId() {
        return id;
    }
    
    public void adicionarPokemon(Pokemon pokemon){
        listaPokemons.add(pokemon);
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
    
    public void trocarPokemon(Pokemon pokemon){

        int posicao = listaPokemons.indexOf(pokemon); //Posicao em que esta o pokemon que vai para o inicio da lista
        
        Collections.swap(listaPokemons, 0, posicao); //Troca o pokmenon escolhido com o primeiro da lista

    }
        
    protected Ataque retornaAtaquePokemon(int ataque) {
        
    	Ataque ataqueRetorno;
    	
    	switch(ataque) {
    	case 1: ataqueRetorno = getProximoPokemon().getAtaque1();break;
    	case 2: ataqueRetorno = getProximoPokemon().getAtaque1();break;
    	case 3: ataqueRetorno = getProximoPokemon().getAtaque1();break;
    	case 4: ataqueRetorno = getProximoPokemon().getAtaque1();break;
    	default: ataqueRetorno = null;
    	}
    	
    	return ataqueRetorno;
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

