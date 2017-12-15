package ataques;

import pokemon.Pokemon;
import pokemon.Tipo;

public class AtaqueHp extends Ataque {

    public static final int CURA_CONFORME_DANO = 1;
    public static final int CURA_CONFORME_VIDA = 2;
    
	private int valor;
	private double porcentagem;
	
	public AtaqueHp(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo, int valor,
            double porcentagem) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }


    @Override
	public void efeito(Pokemon atacante, Pokemon atacado, int player) {
        double modificadorLevel, dano, cura;
        
        super.reduzPP();
        
        if( calculoAcerto(atacante, atacado) ) {
            modificadorLevel = atacante.getLevel();
            
            /*
                Se o ataque for crítico, o modificador de nível é dobrado
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
        }
	}

}
