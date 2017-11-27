package ataques;

import pokemon.Tipo;

public class AtaqueCharge extends Ataque {

    public AtaqueCharge(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
    }
    
    @Override
	public void efeito(pokemon.Pokemon atacante, pokemon.Pokemon atacado) {
		super.efeito(atacante, atacado);
	}
}
