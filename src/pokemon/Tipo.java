package pokemon;

public enum Tipo {
    
    NONE(     "None"    , 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
    BUG(      "Bug"     , 1, 0.5, 0.5,   2,   1,   1,   1, 0.5, 0.5,   1,   2,   1,   2,   1,   1),
    DRAGON(   "Dragon"  , 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   2),
    ELECTRIC( "Eletric" , 1,   1,   2,   1,   0,   1,   1,   1,   1,   2, 0.5, 0.5,   1,   1, 0.5),
    FIGHTING( "Fighting", 2,   1, 0.5, 0.5,   1,   2, 0.5,   0,   1,   1,   1,   1, 0.5,   2,   1),
    FIRE(     "Fire"    , 1,   1,   1,   1,   1, 0.5,   2,   1, 0.5, 0.5,   2,   1,   1,   2, 0.5),
    FLYING(   "Flying"  , 1,   2,   1,   1,   1, 0.5,   2,   1,   1,   1,   2, 0.5,   1,   1,   1),
    ICE(      "Ice"     , 1,   1,   2,   1,   2,   1,   1,   1,   1, 0.5,   2,   1,   1, 0.5,   2),
    GHOST(    "Ghost"   , 0,   1,   1,   1,   1,   1,   1,   2,   1,   1,   1,   1,   0,   1,   1),
    GRASS(    "Grass"   , 1,   1, 0.5, 0.5,   2,   2, 0.5,   1, 0.5,   2, 0.5,   1,   1,   1, 0.5),
    GROUND(   "Ground"  , 1,   1,   0,   2,   1,   2, 0.5,   1,   2,   1, 0.5,   2,   1,   1,   1),
    NORMAL(   "Normal"  , 1,   1,   1,   1,   1, 0.5,   1,   0,   1,   1,   1,   1,   1,   1,   1),
    POISON(   "Poison"  , 1,   1,   1, 0.5, 0.5, 0.5,   2, 0.5,   1,   1,   2,   1,   1,   1,   1),
    PSYCHIC(  "Psychic" , 1,   2,   1,   2,   1,   1,   1,   1,   1,   1,   1,   1, 0.5,   1,   1),
    ROCK(     "Rock"    , 1, 0.5,   2,   1, 0.5,   1,   2,   1,   2,   1,   1,   1,   1,   2,   1),
    WATER(    "Water"   , 1,   1,   1,   1,   2,   2,   1,   1,   2, 0.5, 0.5,   1,   1,   1, 0.5);
    
    private Tipo(String descricao, double bonusNormal, double bonusFighting, double bonusFlying, double bonusPoison,
            double bonusGround, double bonusRock, double bonusBug, double bonusGhost, double bonusFire,
            double bonusWater, double bonusGrass, double bonusElectric, double bonusPsychic, double bonusIce,
            double bonusDragon) {
        this.descricao = descricao;
        this.bonusNormal = bonusNormal;
        this.bonusFighting = bonusFighting;
        this.bonusFlying = bonusFlying;
        this.bonusPoison = bonusPoison;
        this.bonusGround = bonusGround;
        this.bonusRock = bonusRock;
        this.bonusBug = bonusBug;
        this.bonusGhost = bonusGhost;
        this.bonusFire = bonusFire;
        this.bonusWater = bonusWater;
        this.bonusGrass = bonusGrass;
        this.bonusElectric = bonusElectric;
        this.bonusPsychic = bonusPsychic;
        this.bonusIce = bonusIce;
        this.bonusDragon = bonusDragon;
    }

    private String descricao;
    private double bonusNormal, bonusFighting, bonusFlying, bonusPoison, bonusGround, bonusRock, bonusBug, bonusGhost;
    private double bonusFire, bonusWater, bonusGrass, bonusElectric, bonusPsychic, bonusIce, bonusDragon;
    
    public double calculaBonus(Tipo obj) {
        
        switch(obj) {
            case NORMAL  : return bonusNormal;
            case FIGHTING: return bonusFighting;
            case FLYING  : return bonusFlying;
            case POISON  : return bonusPoison;
            case GROUND  : return bonusGround;
            case ROCK    : return bonusRock;
            case BUG     : return bonusBug;
            case GHOST   : return bonusGhost;
            case FIRE    : return bonusFire;
            case WATER   : return bonusWater;
            case GRASS   : return bonusGrass;
            case ELECTRIC: return bonusElectric;
            case PSYCHIC : return bonusPsychic;
            case ICE     : return bonusIce;
            case DRAGON  : return bonusDragon;
            case NONE    : return 1;
        }
        
        return 1;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
