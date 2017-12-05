
package pokemon;

import ataques.Ataque;

public class Pokemon {

    //ATRIBUTOS
    private Especie especie;
    private int level;
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
    private boolean confusion;
    private boolean flinch;
    
    private Status status;    
    private Ataque ataque1, ataque2, ataque3, ataque4;

    public Pokemon(Especie especie, int level, Ataque ataque1, Ataque ataque2, Ataque ataque3, Ataque ataque4) {
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
    }
    
    private void calculaAtributos() {
        hpMax = especie.calculaHpMax(level);
        hpAtual = especie.calculaHpAtual(level);
        attack = especie.calculaAttack(level);
        defense = especie.calculaDefense(level);
        special = especie.calculaSpecial(level);
        speed = especie.calculaSpeed(level);
    }

    public Status getStatus() {
        return status;
    }
    
    public double getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public boolean isConfusion() {
        return confusion;
    }

    public void setConfusion(boolean confusion) {
        this.confusion = confusion;
    }

    public boolean isFlinch() {
        return flinch;
    }

    public void setFlinch(boolean flinch) {
        this.flinch = flinch;
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
    }

    public void modifyModifierEvasion(int amount) {
    	modifierEvasion += amount;
    }

    public void modifyModifierAtk(int amount) {
    	modifierAtk += amount;
    }

    public void modifyModifierDef(int amount) {
    	modifierDef += amount;
    }

    public void modifyModifierSpe(int amount) {
    	modifierSpe += amount;
    }

    public void modifyModifierSpd(int amount) {
    	modifierSpd += amount;
    }
    
    @Override
    public String toString() {
        return getEspecie().toString();
    }

    public Especie getEspecie() {
        return especie;
    }

    public void reduzHp(double dano) {
        hpAtual = Double.max(hpAtual-dano,0);
        
        if(hpAtual == 0)
            setStatus(Status.FAINTED);        
    }

    public void setStatus(Status status) {
        this.status = status;        
    }

    public void curaHp(double cura) {
        hpAtual = Double.min(hpAtual+cura,hpMax);
    }
}
