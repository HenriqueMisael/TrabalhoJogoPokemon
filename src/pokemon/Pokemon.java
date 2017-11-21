
package pokemon;

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
    private int ataque1, ataque2, ataque3, ataque4;

    public Pokemon(Especie especie, int level, int ataque1, int ataque2, int ataque3, int ataque4) {
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

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public void setModifierAccuracy(int modifierAccuracy) {
        this.modifierAccuracy = modifierAccuracy;
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

    public int getAtaque1() {
        return ataque1;
    }

    public int getAtaque2() {
        return ataque2;
    }

    public int getAtaque3() {
        return ataque3;
    }

    public int getAtaque4() {
        return ataque4;
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

    @Override
    public String toString() {
        
        String retorno = "";
        
        retorno += String.format("\nEspécie %s, nível %d.", especie.toString(), level);
        retorno += String.format("\nAtaques:\n1-%d\n2-%d\n3-%d\n4-%d",ataque1, ataque2, ataque3, ataque4);
        retorno += String.format("\nHP: %.2f/%.2f",hpAtual, hpMax);
        retorno += String.format("\nAtributos:\natk: %.2f\ndef: %.2f\nspe: %.2f\nspd: %.2f",attack, defense, special, speed);
        
        return retorno;
    }

    public Especie getEspecie() {
        return especie;
    }
}
