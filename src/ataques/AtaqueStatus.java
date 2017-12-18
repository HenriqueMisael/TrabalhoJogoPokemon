package ataques;

import batalha.Jogador;
import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;
import util.DefaultOutput;
import util.Probabilidade;

public class AtaqueStatus extends Ataque {

    public static final int INFLIGE_STATUS_BURN      = 1;
    public static final int INFLIGE_STATUS_FROZEN    = 2;
    public static final int INFLIGE_STATUS_PARALYSIS = 3;
    public static final int INFLIGE_STATUS_POISON    = 4;
    public static final int INFLIGE_STATUS_SLEEP     = 5;
    public static final int INFLIGE_STATUS_FAINTED   = 6;
    public static final int INFLIGE_STATUS_CONFUSION = 7;
    public static final int INFLIGE_STATUS_FLINCH    = 8;
    
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
