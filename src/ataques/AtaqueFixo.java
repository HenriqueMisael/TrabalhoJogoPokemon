package ataques;

import pokemon.Pokemon;
import pokemon.Tipo;

public class AtaqueFixo extends Ataque {

    public static final int DANO_CONFORME_NIVEL = 0;
    
    private int val;
	
    public AtaqueFixo(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo, int val) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.val = val;
    }

    protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {
	    
	    if( val == DANO_CONFORME_NIVEL )
	        return new Double( atacante.getLevel() );
	    
	    return new Double( val );
	}
}
