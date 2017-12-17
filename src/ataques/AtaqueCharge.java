package ataques;

import pokemon.Pokemon;
import pokemon.Tipo;

public class AtaqueCharge extends Ataque {

    public AtaqueCharge(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
    }
    
    @Override
    public void efeito(Pokemon atacante, batalha.Jogador adversario, int player) {
		Ataque ataque = new Ataque(getId(), getNome(), 1, getPower(), getAccuracy(), getTipo());
        
        this.retorno = new batalha.AcaoUsarAtaque(atacante, adversario, ataque, player);
	}
    
    @Override
    public String message(Pokemon atacante, batalha.Jogador adversario) {
        return String.format("%s prepara %s contra %s.", atacante, this, adversario.getProximoPokemon());
    }
}
