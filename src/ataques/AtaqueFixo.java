package ataques;

import pokemon.Pokemon;
import pokemon.Tipo;

class AtaqueFixo extends Ataque {

    private static final int DANO_CONFORME_NIVEL = 0;
    private final int val;

    AtaqueFixo(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo, int val) {
        super(id, nome, maxPowerPoints, power, accuracy, tipo);
        this.val = val;
    }

    protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {

        if (val == DANO_CONFORME_NIVEL)
            return (double) atacante.getLevel();

        return (double) val;
    }
}
