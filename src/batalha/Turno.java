package batalha;

import java.util.LinkedList;

import util.DefaultOutput;

public class Turno {

    private static AcaoJogador acaoJogador1;
    private static AcaoJogador acaoJogador2;
    
    public Turno( AcaoJogador acaoJogador1, AcaoJogador acaoJogador2 ) {
        this.setAcaoJogador1(acaoJogador1);
        this.setAcaoJogador2(acaoJogador2);
    }

    public Turno( AcaoJogador acaoJogador ) {
        if(this.getAcaoJogador1() == null)        
            this.setAcaoJogador1(acaoJogador);
        else
            this.setAcaoJogador2(acaoJogador);
    }
    
    public int carregado() {
        if(getAcaoJogador1() != null) {
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
        
        DefaultOutput.message(acao.message());
        AcaoJogador newAcaoJogador = acao.executa();
        
        if(acao.getPlayer() == 1)
            setAcaoJogador1(newAcaoJogador);
        else
            acaoJogador2 = newAcaoJogador;
    }
    
    private LinkedList<AcaoJogador> calculaOrdem(){
        
        LinkedList<AcaoJogador> ordem = new LinkedList<AcaoJogador>();
        
        if( getAcaoJogador1().getPriority() >= acaoJogador2.getPriority() ) {
            ordem.add(getAcaoJogador1());
            ordem.add(acaoJogador2);
        }else {
            ordem.add(acaoJogador2);
            ordem.add(getAcaoJogador1());
        }       
               
        return ordem;
    }

    public AcaoJogador getAcaoJogador1() {
        return acaoJogador1;
    }

    public AcaoJogador getAcaoJogador2() {
        return acaoJogador2;
    }

    public void setAcaoJogador1(AcaoJogador acaoJogador1) {
        Turno.acaoJogador1 = acaoJogador1;
    }
    
    public void setAcaoJogador2(AcaoJogador acaoJogador2) {
        Turno.acaoJogador2 = acaoJogador2;
    }
}
