package batalha;

import java.util.LinkedList;
import java.util.Queue;

public class Batalha {

	//ATRIBUTOS
    Jogador time1, time2;
    
    //CONSTRUTOR
    public Batalha(Jogador p1, Jogador p2) {
        time1 = p1;
        time2 = p2;      
        
        System.out.println("");
        System.out.println(time1.toString());
        System.out.println("------------------------------");
        System.out.println(time2.toString());
    }
    
    //METODOS
    public void start() {

        int vencedor = 0;
        Turno turno;
        
        while( vencedor == 0 ) {
            
            turno = new Turno(time1.escolherComando(time2.getProximoPokemon()), time2.escolherComando(time1.getProximoPokemon()));
            
            /*
                Verifica vit�ria
            */
            if( !time1.temPokemonUtilizavel() )
                vencedor = 1;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = 2;            
        }
    }
}
