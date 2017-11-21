package pokemon;

public enum Tipo {
    
    NONE("None"),
    BUG("Bug"),
    DRAGON("Dragon"),
    ELETRIC("Eletric "),
    FIGHTING("Fighting"),
    FIRE("Fire"),
    FLYING("Flying"),
    ICE("Ice"),
    GHOST("Ghost"),
    GRASS("Grass"),
    GROUND("Ground"),
    NORMAL("Normal"),
    POISON("Poison"),
    PSYCHIC("Psychic"),
    ROCK("Rock"),
    WATER("Water");
    
    Tipo(String descricao){
        this.descricao = descricao;
    }
    
    private String descricao;
    
    public double calculaBonus(Tipo obj) {
        /*
            TODO: receber um outro tipo e calcular o bônus de acordo com a tabela
        */
        return 0;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
