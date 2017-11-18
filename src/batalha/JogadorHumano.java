
package batalha;


public class JogadorHumano extends Jogador{
    
    public JogadorHumano() {
        
    }
    
    @Override
    public AcaoJogador escolherComando(){
        return null;
    }
    
    @Override
    public String toString() {
        return "humano\n" + super.toString();
    }
}
