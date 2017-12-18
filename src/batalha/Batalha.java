package batalha;

import java.util.List;

import pokemon.Pokemon;
import pokemon.Status;
import util.DefaultOutput;

public class Batalha {

	//ATRIBUTOS
    Jogador time1, time2;
    
    //CONSTRUTOR
    public Batalha(Jogador p1, Jogador p2) {
        time1 = p1;
        time2 = p2;      
    }
    
    //METODOS
    public void start() {

        Jogador vencedor = null;
        int numeroTurno = 1;
        Turno turno = new Turno(null,null);
        
        DefaultOutput.message(String.format("Time 1 (%s): %s", time1, time1.getListaPokemons().toString()));
        DefaultOutput.message(String.format("Time 2 (%s): %s", time2, time2.getListaPokemons().toString()));
        
        while( vencedor == null ) {
            
            DefaultOutput.message("-------------------------------------------------");
            DefaultOutput.message(String.format("Início do turno %d.",numeroTurno++));
            DefaultOutput.emptyQueue();
            switch(turno.carregado()) {
                case 0: turno = new Turno(time1.escolherComando(time2), time2.escolherComando(time1));break;
                case 1: turno = new Turno(time2.escolherComando(time1));break;
                case 2: turno = new Turno(time1.escolherComando(time2));break;
            }
            
            turno.executaAcoes();
            
            executaEfeitosStatus(time1.getListaPokemons());
            executaEfeitosStatus(time2.getListaPokemons());
            
            /*
                Verifica se algum dos pokémons ficou inabilitado a lutar
            */
            trocaPokemonSeFainted(time1);    
            trocaPokemonSeFainted(time2);    
            
            /*
                Verifica vitória
            */
            if( !time1.temPokemonUtilizavel() )
                vencedor = time2;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = time1;
            DefaultOutput.emptyQueue();
        }
        
        DefaultOutput.message(String.format("Vencedor: %s", vencedor));
        DefaultOutput.emptyQueue();
    }

    private void executaEfeitosStatus(List<Pokemon> listaPokemons) {
        for(Pokemon p:listaPokemons)
            p.getStatus().aplicaEfeitoPosTurno(p);
    }

    private void trocaPokemonSeFainted(Jogador time) {
        
        if(time.getProximoPokemon().getStatus() == Status.FAINTED) {
            int i = 0;
            List<Pokemon> lista = time.getListaPokemons();
            
            do {
                i++;
            }while(i < lista.size() && lista.get(i).getStatus() == Status.FAINTED);
            
            if(i < lista.size())
                time.trocarPokemon(lista.get(i));
        }
    }   
}
