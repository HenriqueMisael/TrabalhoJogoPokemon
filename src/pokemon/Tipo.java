package pokemon;

public enum Tipo {
    
    NONE("NONE"),
    BUG("BUG"),
    DRAGON("DRAGON"),
    ELETRIC("ELETRIC "),
    FIGHTING("FIGHTING"),
    FIRE("FIRE"),
    FLYING("FLYING"),
    ICE("ICE"),
    GHOST("GHOST"),
    GRASS("GRASS"),
    GROUND("GROUND"),
    NORMAL("NORMAL"),
    POISON("POISON"),
    PSYCHIC("PSYCHIC"),
    ROCK("ROCK"),
    WATER("WATER");
    
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
