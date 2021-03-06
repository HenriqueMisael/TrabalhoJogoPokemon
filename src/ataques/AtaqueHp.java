package ataques;

import batalha.Jogador;
import pokemon.Pokemon;
import pokemon.Tipo;
import util.DefaultOutput;

public class AtaqueHp extends Ataque {

    private static final int CURA_CONFORME_DANO = 1;
    private static final int CURA_CONFORME_VIDA = 2;
    
	private final int valor;
	private final double porcentagem;
	
	public AtaqueHp(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo, String tipoRecuperacao,
            double porcentagem) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.valor = tipoRecuperacao_FromString_ToInt(tipoRecuperacao.toLowerCase());
        this.porcentagem = porcentagem;
    }

    private int tipoRecuperacao_FromString_ToInt(String tipoRecuperacao) {
        
        if(tipoRecuperacao.equals("dano"))
            return CURA_CONFORME_DANO;
        else if(tipoRecuperacao.equals("max_hp"))
            return CURA_CONFORME_VIDA;
        
        return 0;
    }

    @Override
	public void efeito(Pokemon atacante, Jogador adversario, int player) {
        double modificadorLevel, dano, cura;
        Pokemon atacado = adversario.getProximoPokemon();
        
        super.reduzPP();
        
        if( calculoAcerto(atacante, atacado) ) {
            modificadorLevel = atacante.getLevel();
            
            /*
                Se o ataque for crítico, o modificador de nível � dobrado
            */
            if(calculoCritico(atacante.getSpeed()))
                modificadorLevel *= 2;
            
            dano = calculoDano( atacante, atacado, modificadorLevel );
            
            switch(valor) {
                case CURA_CONFORME_DANO: cura = dano*porcentagem;break;
                case CURA_CONFORME_VIDA: cura = atacante.getHpMax()*porcentagem;break;
                default: cura = 0;
            }
            
            atacado.reduzHp(dano);
            atacante.curaHp(cura);
        }else DefaultOutput.message(String.format("%s errou o ataque.", atacante));
	}

}
