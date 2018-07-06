package ataques;

import batalha.Jogador;
import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;
import util.DefaultOutput;
import util.Probabilidade;

public class AtaqueStatus extends Ataque {

    private Status status;
	private int chance;	
	
	public AtaqueStatus(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo,
            Status status, int chance) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.status = status;
        this.chance = chance;
    }

    @Override
	public void efeito( Pokemon atacante, Jogador adversario, int player ) {
	    
        Pokemon atacado = adversario.getProximoPokemon();
        
        super.efeito(atacante, adversario, player);
	    
	    if(Probabilidade.calcula(new Double(chance))) {
	        atacado.setStatus(status);
	        DefaultOutput.message(String.format("%s infligiu %s em %s.", atacante, status, atacado));
	    }
	}
}
