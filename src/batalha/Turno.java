package batalha;

import java.util.LinkedList;

public class Turno {

    AcaoJogador jogador1, jogador2;
    
    public Turno( AcaoJogador acaoJogador1, AcaoJogador acaoJogador2 ) {
        jogador1 = acaoJogador1;
        jogador2 = acaoJogador2;
    }

    public void executaAcoes() {
        calculaOrdem();
    }
    
    private LinkedList<AcaoJogador> calculaOrdem(){
        
        LinkedList<AcaoJogador> ordem = new LinkedList<AcaoJogador>();
        
        return ordem;
    }
}
