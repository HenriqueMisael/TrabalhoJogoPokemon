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
        
        System.out.println(acao.message());
        AcaoJogador newAcaoJogador = acao.executa();
        
        if(acao.getPlayer() == 1)
            acaoJogador1 = newAcaoJogador;
        else
            acaoJogador2 = newAcaoJogador;
    }
    
    private LinkedList<AcaoJogador> calculaOrdem(){
        
        LinkedList<AcaoJogador> ordem = new LinkedList<AcaoJogador>();
        
        if( acaoJogador1.getPriority() >= acaoJogador2.getPriority() ) {
            ordem.add(acaoJogador1);
            ordem.add(acaoJogador2);
        }else {
            ordem.add(acaoJogador2);
            ordem.add(acaoJogador1);
        }       
               
        return ordem;
    }
}
