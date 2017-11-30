package batalha;

import ataques.Ataque;
import pokemon.Pokemon;

public class AcaoUsarAtaque implements AcaoJogador {

    private Pokemon atacante, alvo;
    private Ataque ataque;
    
    public AcaoUsarAtaque(Pokemon atacante, Pokemon alvo, Ataque ataque) {
        this.atacante = atacante;
        this.alvo = alvo;
        this.ataque = ataque;
    }

    @Override
    public String message() {
        return atacante.getEspecie().toString() + " usou " + ataque.toString() + " em " + alvo.getEspecie().toString() + ".";
    }
    
    @Override
    public void executa() {
        ataque.efeito(atacante, alvo);
    }

}
