
package batalha;

import ataques.Ataque;
import util.Probabilidade;

public class JogadorMaquina extends Jogador{
    
    public JogadorMaquina(int id) {
        super(id);
    }
    
    @Override
    public AcaoJogador escolherComando(Jogador adversario){
        
        return new AcaoUsarAtaque(getProximoPokemon(),adversario,retornaAtaquePokemon(),getId());
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
        return "Jogador Maquina " + super.toString();
    }
}
