package batalha;

import java.util.LinkedList;

public class Turno {

    AcaoJogador acaoJogador1, acaoJogador2;
    
    public Turno( AcaoJogador acaoJogador1, AcaoJogador acaoJogador2 ) {
        this.acaoJogador1 = acaoJogador1;
        this.acaoJogador2 = acaoJogador2;
    }

    public Turno( AcaoJogador acaoJogador ) {
        if(this.acaoJogador1 == null)        
            this.acaoJogador1 = acaoJogador;
        else
            this.acaoJogador2 = acaoJogador;
    }
    
    public int carregado() {
        if(acaoJogador1 != null) {
            if( acaoJogador2 != null ) {
                return -1;
            }else return 1;
        }else if(acaoJogador2 != null)
            return 2;
        /*
            Ambos são null, então a classe não está corretamente instanciada
        */
        return 0;
    }
    
    public void executaAcoes() {
        
        LinkedList<AcaoJogador> ordem = calculaOrdem();
        
        executaAcao(ordem.remove());
        executaAcao(ordem.remove());
    }
    
    private void executaAcao(AcaoJogador acao) {
        
        AcaoJogador newAcaoJogador = acao.executa();
        
        if(acao.getPlayer() == 1)
            acaoJogador1 = newAcaoJogador;
        else
            acaoJogador2 = newAcaoJogador;
        
        System.out.println(acao.message());
    }
    
    private LinkedList<AcaoJogador> calculaOrdem(){
        
        LinkedList<AcaoJogador> ordem = new LinkedList<AcaoJogador>();
        
        ordem.add(acaoJogador1);
        ordem.add(acaoJogador2);
        
        return ordem;
    }
}
