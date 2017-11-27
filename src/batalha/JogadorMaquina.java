
package batalha;


public class JogadorMaquina extends Jogador{
    
    public JogadorMaquina() {
        
    }    
    
    @Override
    public AcaoJogador escolherComando(){
    		return null;
    }
    
    @Override
    public String toString() {
        return "maquina:" + super.toString();
    }
}
