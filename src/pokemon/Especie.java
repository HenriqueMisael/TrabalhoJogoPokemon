package pokemon;

import main.TabelaDeEspecies;

public class Especie {

    private static final TabelaDeEspecies tabelaEspecies = new TabelaDeEspecies("Tabela_Especies.txt");
    private final int id;
    private final String nome;
    private final double baseHp;
    private final double baseAttack;
    private final double baseDefense;
    private final double baseSpecial;
    private final double baseSpeed;
    private final Tipo tipo1;
    private final Tipo tipo2;

    static Especie get(int id) {
        return new Especie(id, tabelaEspecies.getEspecie(id),
                tabelaEspecies.getTipo1(id),
                tabelaEspecies.getTipo2(id),
                tabelaEspecies.getBaseHP(id),
                tabelaEspecies.getBaseATK(id),
                tabelaEspecies.getBaseDEF(id),
                tabelaEspecies.getBaseSPE(id),
                tabelaEspecies.getBaseSPD(id));
    }

    public int getId() {
        return id;
    }

    private Especie(int id, String nome, Tipo tipo1, Tipo tipo2, double baseHp, double baseAttack, double baseDefense, double baseSpecial,
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
        return 2 * baseHp * level / 100 + level + 10;
    }

    double calculaAttack(int level) {
        return calculaAtributo(level, baseAttack);
    }

    double calculaDefense(int level) {
        return calculaAtributo(level, baseDefense);
    }

    double calculaSpecial(int level) {
        return calculaAtributo(level, baseSpecial);
    }

    double calculaSpeed(int level) {
        return calculaAtributo(level, baseSpeed);
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    private double calculaAtributo(int level, double base) {
        return 2 * base * level / 100 + 5;
    }

    @Override
    public String toString() {
        return String.format("%s", nome);
    }
}
