
package batalha;

import pokemon.Pokemon;

public class JogadorMaquina extends Jogador{
    
    public JogadorMaquina() {
        super.identificador = "Máquina";
    }    
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        return new AcaoUsarAtaque(getProximoPokemon(),adversario,getProximoPokemon().getAtaque1());
    }
    
    @Override
    public String toString() {
        return "maquina:" + super.toString();
    }
}
