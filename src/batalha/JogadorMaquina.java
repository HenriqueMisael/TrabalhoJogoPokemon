
package batalha;

import pokemon.Pokemon;

public class JogadorMaquina extends Jogador{
    
    public JogadorMaquina() {
        super.identificador = "Máquina";
    }    
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        return new AcaoUsarAtaque(this.getProximoPokemon(),adversario);
    }
    
    @Override
    public String toString() {
        return "maquina:" + super.toString();
    }
}
