package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import pokemon.StatusPrimario;
import util.DefaultOutput;

public class AcaoUsarAtaque implements AcaoJogador {

    private final Jogador adversario;
    private final Pokemon atacante;
    private final Ataque ataque;
    private final int player;
    
    public AcaoUsarAtaque(Pokemon atacante, Jogador adversario, Ataque ataque, int player) {
        this.atacante = atacante;
        this.adversario = adversario;
        this.ataque = ataque;
        this.player = player;
    }

    @Override
    public String message() {
        return ataque.message(atacante, adversario);
    }
    
    @Override
    public AcaoJogador executa() {
       
        if(atacante.getStatus().contains(StatusPrimario.FAINTED)) {
            DefaultOutput.message("(" + atacante.getEspecie() + " morreu e não pode atacar.)");
        }else{     
            ataque.efeito(atacante, adversario, getPlayer());            
        }
        return ataque.getRetorno();
    }

    @Override
    public int getPlayer() {
        return player;
    }
    
    @Override
    public double getPriority() {        
        return atacante.getSpeed();        
    }
}
