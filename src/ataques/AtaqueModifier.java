package ataques;

public class AtaqueModifier extends Ataque {

	private int modifierAfetado;
	private int valor;
	private int chance;
	
	@Override
	public void efeito(pokemon.Pokemon atacante, pokemon.Pokemon atacado) {
		super.efeito(atacante, atacado);
		if(util.Probabilidade.calcula(chance))
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
