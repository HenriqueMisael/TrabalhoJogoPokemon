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
/*        
        System.out.println("");
        System.out.println(time1.toString());
        System.out.println("------------------------------");
        System.out.println(time2.toString());
*/    }
    
    //METODOS
    public void start() {

        int vencedor = 0, numeroTurno = 1;
        Turno turno;
        
        while( vencedor == 0 ) {
            
            System.out.println(String.format("Início do turno %d.",numeroTurno++));
            turno = new Turno(time1.escolherComando(time2.getProximoPokemon()), time2.escolherComando(time1.getProximoPokemon()));
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
                vencedor = 2;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = 1;
        }
        
        System.out.println(String.format("Vencedor: jogador %d", vencedor));
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
            int i;
            List<Pokemon> lista = time.getListaPokemons();
            
            for(i = 0; i < lista.size(); i++)
                if(lista.get(i).getStatus() != Status.FAINTED)
                    break;
            
            if(i < lista.size())
                time.trocarPokemon(lista.get(i));
        }
    }   
}
