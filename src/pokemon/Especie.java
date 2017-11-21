package pokemon;

public class Especie {
    
    private int id;
    private String nome;
    private double baseHp;
    private double baseAttack;
    private double baseDefense;
    private double baseSpecial;
    private double baseSpeed;
    private Tipo tipo1, tipo2;
    
    public int getId() {
        return id;
    }
    
    public Especie(int id, String nome, Tipo tipo1, Tipo tipo2, double baseHp, double baseAttack, double baseDefense, double baseSpecial,
            double baseSpeed) {
        super();
        this.id = id;
        this.nome = nome;
        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpecial = baseSpecial;
        this.baseSpeed = baseSpeed;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    double calculaHpMax(int level) {
        return 110 + level;
    }

    double calculaHpAtual(int level) {
        return  calculaAtributo( level, baseHp );
    }

    double calculaAttack(int level) {
        return calculaAtributo( level, baseAttack ); 
    }
    
    double calculaDefense(int level) {
        return calculaAtributo( level, baseDefense ); 
    }

    double calculaSpecial(int level) {
        return calculaAtributo( level, baseSpecial ); 
    }
    
    double calculaSpeed(int level) {
        return calculaAtributo( level, baseSpeed ); 
    }
    
    public Tipo getTipo1() {
        return tipo1;
    }
    
    public Tipo getTipo2() {
        return tipo2;
    }
    
    private double calculaAtributo(int level, double base) {
        return  2 * base * level / 105; 
    }
    
    @Override
    public String toString() {
        return String.format("%s", nome);
    }
}
