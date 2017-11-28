package batalha;

import java.util.LinkedList;

public class Turno {

    AcaoJogador acaoJogador1, acaoJogador2;
    
    public Turno( AcaoJogador acaoJogador1, AcaoJogador acaoJogador2 ) {
        this.acaoJogador1 = acaoJogador1;
        this.acaoJogador2 = acaoJogador2;
    }

    public void executaAcoes() {
        
        LinkedList<AcaoJogador> ordem = calculaOrdem();
        
        executaAcao(ordem.remove());
        executaAcao(ordem.remove());
    }
    
    private void executaAcao(AcaoJogador acao) {
        acao.executa();
        System.out.println(acao.message());
    }
    
    private LinkedList<AcaoJogador> calculaOrdem(){
        
        LinkedList<AcaoJogador> ordem = new LinkedList<AcaoJogador>();
        
        ordem.add(acaoJogador1);
        ordem.add(acaoJogador2);
        
        return ordem;
    }
}
