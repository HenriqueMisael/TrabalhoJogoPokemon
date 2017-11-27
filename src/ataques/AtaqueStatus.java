package ataques;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;
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
    
    private int status;
	private int chance;	
	
	public AtaqueStatus(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo,
            int status, int chance) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.status = status;
        this.chance = chance;
    }

    @Override
	public void efeito( Pokemon atacante, Pokemon atacado ) {
	    super.efeito(atacante, atacado);
	    
	    if(Probabilidade.calcula(new Double(chance)))
	        aplicaStatus(atacado);
	}
	
	private void aplicaStatus(Pokemon atacado) {
	    
	    switch(this.status) {
    	    case INFLIGE_STATUS_BURN:
   	            atacado.setStatus(Status.BURN);
    	        break;
    	    case INFLIGE_STATUS_FROZEN:
    	        atacado.setStatus(Status.FROZEN);
                break;
    	    case INFLIGE_STATUS_PARALYSIS:
    	        atacado.setStatus(Status.PARALYSIS);
                break;    	    
    	    case INFLIGE_STATUS_POISON:   
    	        atacado.setStatus(Status.POISON);
                break;
    	    case INFLIGE_STATUS_SLEEP:    
    	        atacado.setStatus(Status.SLEEP);
                break;
    	    case INFLIGE_STATUS_FAINTED:  
    	        atacado.setStatus(Status.FAINTED);
                break;
    	    case INFLIGE_STATUS_CONFUSION:
    	        atacado.setConfusion(true);
                break;
    	    case INFLIGE_STATUS_FLINCH:
    	        atacado.setFlinch(true);
                break;
	    }
	}

}
