package ataques;

import batalha.Jogador;
import pokemon.Pokemon;
import pokemon.Tipo;
import util.DefaultOutput;

public class AtaqueModifier extends Ataque {

	private int modifierAfetado;
	private int valor;
	private int chance;
	
	public AtaqueModifier(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo,
            String modifierAfetado, int valor, int chance) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.modifierAfetado = modifierAfetado_FromString_ToInt(modifierAfetado);
        this.valor = valor;
        this.chance = chance;
    }

    private int modifierAfetado_FromString_ToInt(String modifierAfetado) {
        
        if(modifierAfetado.equals("Accuracy"))
            return 1;
        else if(modifierAfetado.equals("Evasion"))
            return 2;
        else if(modifierAfetado.equals("ATK"))
            return 3;
        else if(modifierAfetado.equals("DEF"))
            return 4;
        else if(modifierAfetado.equals("SPE"))
            return 5;
        else if(modifierAfetado.equals("SPD"))
            return 6;
        
        return 0;
    }

    @Override
	public void efeito(Pokemon atacante, Jogador adversario, int player) {
		
        Pokemon atacado = adversario.getProximoPokemon();
        
        super.efeito(atacante, adversario, player);
        
        if(valor<0) {      
    		if(util.Probabilidade.calcula(chance)) {
    			switch(modifierAfetado) {
    				case 1: atacado.modifyModifierAccuracy(valor);break;
    				case 2: atacado.modifyModifierEvasion(valor);break;
    				case 3: atacado.modifyModifierAtk(valor);break;
    				case 4: atacado.modifyModifierDef(valor);break;
    				case 5: atacado.modifyModifierSpe(valor);break;
    				case 6: atacado.modifyModifierSpd(valor);break;				
    			}
    		}
        }
        else {
            if(util.Probabilidade.calcula(chance)) {
                switch(modifierAfetado) {
                    case 1: atacante.modifyModifierAccuracy(valor);break;
                    case 2: atacante.modifyModifierEvasion(valor);break;
                    case 3: atacante.modifyModifierAtk(valor);break;
                    case 4: atacante.modifyModifierDef(valor);break;
                    case 5: atacante.modifyModifierSpe(valor);break;
                    case 6: atacante.modifyModifierSpd(valor);break;             
                }
            }
        }
	}
}
