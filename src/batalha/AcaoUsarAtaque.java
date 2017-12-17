package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import pokemon.Status;

public class AcaoUsarAtaque implements AcaoJogador {

    private Jogador adversario;
    private Pokemon atacante;
    private Ataque ataque;
    private int player;
    
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
       
        if(atacante.getStatus()==Status.FAINTED) {
            System.out.println("(" + atacante.getEspecie() + " morreu e não pode atacar.)");
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
