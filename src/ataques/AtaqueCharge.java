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
    
    public String message(Pokemon atacante) {
        return atacante.getEspecie().toString() + " prepara " + this.toString() + ".";
    }
    
    @Override
    public String toString() {
        return "charge"+super.toString();
    }
}
