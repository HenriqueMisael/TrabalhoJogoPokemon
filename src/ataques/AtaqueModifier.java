package ataques;

import batalha.Jogador;
import pokemon.Pokemon;
import pokemon.Tipo;

public class AtaqueModifier extends Ataque {

    private final int modifierAfetado;
    private final int valor;
    private final int chance;

    public AtaqueModifier(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo,
                          String modifierAfetado, int valor, int chance) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.modifierAfetado = modifierAfetado_FromString_ToInt(modifierAfetado);
        this.valor = valor;
        this.chance = chance;
    }

    private int modifierAfetado_FromString_ToInt(String modifierAfetado) {

        switch (modifierAfetado) {
            case "Accuracy":
                return 1;
            case "Evasion":
                return 2;
            case "ATK":
                return 3;
            case "DEF":
                return 4;
            case "SPE":
                return 5;
            case "SPD":
                return 6;
        }

        return 0;
    }

    @Override
    public void efeito(Pokemon atacante, Jogador adversario, int player) {

        Pokemon atacado = adversario.getProximoPokemon();

        super.efeito(atacante, adversario, player);

        if (util.Probabilidade.calcula(chance)) {
            switch (modifierAfetado) {
                case 1:
                    atacado.modifyModifierAccuracy(valor);
                    break;
                case 2:
                    atacado.modifyModifierEvasion(valor);
                    break;
                case 3:
                    atacado.modifyModifierAtk(valor);
                    break;
                case 4:
                    atacado.modifyModifierDef(valor);
                    break;
                case 5:
                    atacado.modifyModifierSpe(valor);
                    break;
                case 6:
                    atacado.modifyModifierSpd(valor);
                    break;
            }
        }
    }
}
