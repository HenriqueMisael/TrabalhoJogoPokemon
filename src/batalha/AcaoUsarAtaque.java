package batalha;

import ataques.Ataque;
import pokemon.Pokemon;

public class AcaoUsarAtaque implements AcaoJogador {

    private Pokemon atacante, alvo;
    private Ataque ataque;
    private int player;
    
    public AcaoUsarAtaque(Pokemon atacante, Pokemon alvo, Ataque ataque, int player) {
        this.atacante = atacante;
        this.alvo = alvo;
        this.ataque = ataque;
        this.player = player;
    }

    @Override
    public String message() {
        return atacante.getEspecie().toString() + " usou " + ataque.toString() + " em " + alvo.getEspecie().toString() + ".";
    }
    
    @Override
    public AcaoJogador executa() {
        ataque.efeito(atacante, alvo, getPlayer());
        return ataque.getRetorno();
    }

    @Override
    public int getPlayer() {
        return player;
    }
}
