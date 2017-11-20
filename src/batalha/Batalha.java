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
    }
    
    //METODOS
    public void start() {

        int vencedor = 0;
        Queue<Turno> turnos = new LinkedList<Turno>();
        
        while( vencedor == 0 ) {
            
            turnos.add(new Turno(time1.escolherComando(), time2.escolherComando()));
            
            /*
                Verifica vitória
            */
            if( !time1.temPokemonUtilizavel() )
                vencedor = 1;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = 2;            
        }
        
    }

}
