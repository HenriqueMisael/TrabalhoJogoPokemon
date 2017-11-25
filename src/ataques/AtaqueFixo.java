package ataques;

import pokemon.Pokemon;

public class AtaqueFixo extends Ataque {

    public static final int DANO_CONFORME_NIVEL = 0;
    
    private int val;
	
	protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {
	    
	    if( val == DANO_CONFORME_NIVEL )
	        return new Double( atacante.getLevel() );
	    
	    return new Double( val );
	}
}
