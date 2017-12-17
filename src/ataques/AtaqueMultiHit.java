package ataques;

import pokemon.Pokemon;
import pokemon.Tipo;
import util.Probabilidade;

public class AtaqueMultiHit extends Ataque {

	private int min;
	private int max;
	
	public AtaqueMultiHit(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo, int min,
            int max) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.min = min;
        this.max = max;
    }

    @Override
	public void efeito(Pokemon atacante, batalha.Jogador adversario, int player) {
        
        Pokemon atacado = adversario.getProximoPokemon();
	    double modificadorLevel;
	    int numeroAtaques;
        
        super.reduzPP();
        
        if( calculoAcerto(atacante, atacado) ) {
            modificadorLevel = atacante.getLevel();
            
            /*
                Se o ataque for crítico, o modificador de nível é dobrado
            */
            if(calculoCritico(atacante.getSpeed()))
                modificadorLevel *= 2;
            
            numeroAtaques = (int) Probabilidade.getRandom(min, max);
            
            while((numeroAtaques--) > 0)
                atacado.reduzHp(calculoDano( atacante, atacado, modificadorLevel ));
        }
	}
}
