package batalha;

import java.util.List;

import pokemon.Pokemon;
import pokemon.Status;

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
        
        System.out.println(String.format("Time 1 (%s): %s", time1, time1.getListaPokemons().toString()));
        System.out.println(String.format("Time 2 (%s): %s", time2, time2.getListaPokemons().toString()));
        
        while( vencedor == null ) {
            
            System.out.println("-------------------------------------------------");
            System.out.println(String.format("Início do turno %d.",numeroTurno++));
            switch(turno.carregado()) {
                case 0: turno = new Turno(time1.escolherComando(time2), time2.escolherComando(time1));break;
                case 1: turno = new Turno(time2.escolherComando(time1));break;
                case 2: turno = new Turno(time1.escolherComando(time2));break;
            }
            delay();
            turno.executaAcoes();
            delay();
            
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
        }
        
        System.out.println(String.format("Vencedor: %s", vencedor));
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
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
