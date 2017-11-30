package batalha;

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
            
            System.out.println(""/*String.format("In�cio do turno %d.",numeroTurno++)*/);
            turno = new Turno(time1.escolherComando(time2.getProximoPokemon()), time2.escolherComando(time1.getProximoPokemon()));
            delay();
            turno.executaAcoes();
            delay();
            
            /*
                Verifica se algum dos pok�mons ficou inabilitado a lutar
            */
            trocaPokemonSeFainted(time1);    
            trocaPokemonSeFainted(time2);    
            
            /*
                Verifica vit�ria
            */
            if( !time1.temPokemonUtilizavel() )
                vencedor = 1;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = 2;            
        }
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
            while(time.getListaPokemons().get(++i).getStatus() == Status.FAINTED && i < time.getListaPokemons().size());
            
            System.out.println(String.format("Pok�mon %s exaurido. Foi automaticamente trocado pelo pok�mon %s.", time.getProximoPokemon().getEspecie().toString(), time.getListaPokemons().get(i).getEspecie().toString()));
            
            time.trocarPokemon(time.getListaPokemons().get(i));
        }
    }   
}
