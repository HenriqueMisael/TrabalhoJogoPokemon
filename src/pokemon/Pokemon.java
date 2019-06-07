
package pokemon;

import ataques.Ataque;
import main.dto.PokemonDto;
import util.DefaultOutput;

public class Pokemon {

    //ATRIBUTOS
    private final Especie especie;
    private final int level;
    private double hpAtual;
    private double hpMax;
    private double attack;
    private double defense;
    private double special;
    private double speed;
    private int modifierAccuracy;
    private int modifierEvasion;
    private int modifierAtk;
    private int modifierDef;
    private int modifierSpe;
    private int modifierSpd;
    private final StatusController status;
    private final Ataque ataque1;
    private final Ataque ataque2;
    private final Ataque ataque3;
    private final Ataque ataque4;

    public static Pokemon fromDto(PokemonDto dto) {
        return new Pokemon(Especie.get(dto.especie), dto.nivel, Ataque.get(dto.ataqueUm), Ataque.get(dto.ataqueDois), Ataque.get(dto.ataqueTres), Ataque.get(dto.ataqueQuatro));
    }

    private Pokemon(Especie especie, int level, Ataque ataque1, Ataque ataque2, Ataque ataque3, Ataque ataque4) {
        this.especie = especie;
        this.level = level;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
        this.ataque4 = ataque4;

        calculaAtributos();
        this.modifierAccuracy = 0;
        this.modifierEvasion = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierSpe = 0;
        this.modifierSpd = 0;

        this.status = new StatusController();
    }

    private void calculaAtributos() {
        hpMax = especie.calculaHpMax(level);
        hpAtual = hpMax;
        attack = especie.calculaAttack(level);
        defense = especie.calculaDefense(level);
        special = especie.calculaSpecial(level);
        speed = especie.calculaSpeed(level);
    }

    public StatusController getStatus() {
        return status;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public int getLevel() {
        return level;
    }

    public double getHpMax() {
        return hpMax;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpecial() {
        return special;
    }

    public double getSpeed() {
        return speed;
    }

    public Ataque getAtaque1() {
        return ataque1;
    }

    public Ataque getAtaque2() {
        return ataque2;
    }

    public Ataque getAtaque3() {
        return ataque3;
    }

    public Ataque getAtaque4() {
        return ataque4;
    }

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public int getModifierEvasion() {
        return modifierEvasion;
    }

    public int getModifierAtk() {
        return modifierAtk;
    }

    public int getModifierDef() {
        return modifierDef;
    }

    public int getModifierSpe() {
        return modifierSpe;
    }

    public int getModifierSpd() {
        return modifierSpd;
    }

    public void modifyModifierAccuracy(int amount) {
        modifierAccuracy += amount;
        modifierAccuracy = Integer.min(Integer.max(modifierAccuracy, -6), 6); //Limite de modifica��e [-6, 6]
    }

    public void modifyModifierEvasion(int amount) {
        modifierEvasion += amount;
        modifierEvasion = Integer.min(Integer.max(modifierEvasion, -6), 6);
    }

    public void modifyModifierAtk(int amount) {
        modifierAtk += amount;
        modifierAtk = Integer.min(Integer.max(modifierAtk, -6), 6);
    }

    public void modifyModifierDef(int amount) {
        modifierDef += amount;
        modifierDef = Integer.min(Integer.max(modifierDef, -6), 6);
    }

    public void modifyModifierSpe(int amount) {
        modifierSpe += amount;
        modifierSpe = Integer.min(Integer.max(modifierSpe, -6), 6);
    }

    public void modifyModifierSpd(int amount) {
        modifierSpd += amount;
        modifierSpd = Integer.min(Integer.max(modifierSpd, -6), 6);
    }

    @Override
    public String toString() {
        return String.format("%s", getEspecie());
    }

    public Especie getEspecie() {
        return especie;
    }

    public void reduzHp(double dano) {
        hpAtual = Double.max(hpAtual - dano, 0);

        if (hpAtual == 0) {
            setStatus(StatusPrimario.FAINTED);
            DefaultOutput.message(String.format("%s sofreu %.2f de dano e morreu.", this, dano));
        } else {
            DefaultOutput.message(String.format("%s sofreu %.2f de dano.", this, dano));
        }
    }

    public void setStatus(Status status) {
        if (status instanceof StatusPrimario) {
            setStatus((StatusPrimario) status);
        } else if (status instanceof StatusSecundario) {
            setStatus((StatusSecundario) status);
        }
    }

    private void setStatus(StatusPrimario status) {
        this.status.setStatusPrimario(status);
    }

    private void setStatus(StatusSecundario status) {
        this.status.addStatusSecundario(status);
    }

    public void curaHp(double cura) {
        hpAtual = Double.min(hpAtual + cura, hpMax);
    }
}
