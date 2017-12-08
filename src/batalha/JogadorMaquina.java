
package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import util.Probabilidade;

public class JogadorMaquina extends Jogador{
    
    public JogadorMaquina() {
        super.identificador = "Máquina";
    }    
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        return new AcaoUsarAtaque(getProximoPokemon(),adversario,retornaAtaquePokemon());
    }
    
    private Ataque retornaAtaquePokemon() {

        int ataque = 1;
        if(getProximoPokemon().getAtaque2() != null) {
        	ataque++;
        	if(getProximoPokemon().getAtaque3() != null) {
        		ataque++;
        	    if(getProximoPokemon().getAtaque4() != null)
        	    	ataque++;
        	}
        }
    	
		return retornaAtaquePokemon((int) Probabilidade.getRandom(1, ataque));
	}

	@Override
    public String toString() {
        return "maquina:" + super.toString();
    }
}
