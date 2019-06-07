package ataques;

import batalha.AcaoJogador;
import batalha.Jogador;
import main.TabelaDeAtaques;
import pokemon.*;
import util.DefaultOutput;
import util.Probabilidade;

public class Ataque {

    private static TabelaDeAtaques tabelaAtaques = new TabelaDeAtaques("Tabela_Ataques.txt");
    private int id;
    private String nome;
    private double maxPowerPoints;
    private double currentPowerPoints;
    private double power;
    private double accuracy;
    private Tipo tipo;
    protected AcaoJogador retorno;

    public Ataque(int id, String nome, double maxPowerPoints, double power, double accuracy, Tipo tipo) {
        super();
        this.id = id;
        this.nome = nome;
        this.maxPowerPoints = maxPowerPoints;
        this.power = power;
        this.accuracy = accuracy;
        this.tipo = tipo;
        this.retorno = null;

        restauraAtaques();
    }

    public static Ataque get(int id) {
        Ataque ataque;
        String[] modificadores;
        String tipo;

        if (id == 0)
            return null;

        modificadores = tabelaAtaques.getParametros(id);
        tipo = tabelaAtaques.getClasse(id);

        if (tipo.equals("charge")) {
            ataque = new AtaqueCharge(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id));
        } else if (tipo.equals("fixo")) {
            ataque = new AtaqueFixo(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id),
                    Integer.parseInt(modificadores[0]));
        } else if (tipo.equals("hp")) {
            ataque = new AtaqueHp(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id),
                    modificadores[0],
                    Double.parseDouble(modificadores[1]));
        } else if (tipo.equals("modifier")) {
            ataque = new AtaqueModifier(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id),
                    modificadores[0],
                    Integer.parseInt(modificadores[1]),
                    Integer.parseInt(modificadores[2]));
        } else if (tipo.equals("multihit")) {
            ataque = new AtaqueMultiHit(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id),
                    Integer.parseInt(modificadores[0]),
                    Integer.parseInt(modificadores[1]));
        } else if (tipo.equals("status")) {

            Status status;

            try {
                status = StatusPrimario.valueOf(modificadores[0].toUpperCase());
            } catch (Exception e) {
                try {
                    status = StatusSecundario.valueOf(modificadores[0].toUpperCase());
                } catch (Exception x) {
                    System.err.printf("Tipo de status não previsto",
                            x.getMessage());
                    status = null;
                }
            }

            ataque = new AtaqueStatus(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id),
                    status,
                    Integer.parseInt(modificadores[1]));
        } else {
            ataque = new Ataque(id, tabelaAtaques.getNome(id),
                    tabelaAtaques.getPP(id),
                    tabelaAtaques.getPower(id),
                    tabelaAtaques.getAccuracy(id),
                    tabelaAtaques.getType(id));
        }

        return ataque;
    }

    public void efeito(Pokemon atacante, Jogador adversario, int player) {

        double modificadorLevel;
        Pokemon atacado = adversario.getProximoPokemon();

        if (currentPowerPoints > 0) {
            reduzPP();

            if (calculoAcerto(atacante, atacado)) {
                modificadorLevel = atacante.getLevel();
          	    
                /*
                    Se o ataque for cr�tico, o modificador de n�vel � dobrado
                */
                if (calculoCritico(atacante.getSpeed()))
                    modificadorLevel *= 2;

                atacado.reduzHp(calculoDano(atacante, atacado, modificadorLevel));
            } else
                DefaultOutput.message(String.format("%s errou o ataque.", atacante));
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    protected double getPower() {
        return power;
    }

    protected double getAccuracy() {
        return accuracy;
    }

    protected Tipo getTipo() {
        return tipo;
    }

    public void restauraAtaques() {
        currentPowerPoints = maxPowerPoints;
    }

    protected void reduzPP() {
        currentPowerPoints--;
    }

    protected boolean calculoAcerto(Pokemon atacante, Pokemon atacado) {

        AttackHit hit = new AttackHit();

        hit.attackAccuracy = this.accuracy;
        hit.accuracy = retornaValorConformeModificador(atacante.getModifierAccuracy());
        hit.evasion = retornaValorConformeModificador(atacado.getModifierEvasion());

        atacante.getStatus().aplicaEfeitoAcerto(hit);

        return hit.calculate();
    }

    protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {

        AttackDamage instanciaAtual = new AttackDamage();

        switch (tipo) {
            case NORMAL:
            case FIGHTING:
            case FLYING:
            case POISON:
            case GROUND:
            case ROCK:
            case BUG:
            case GHOST:
                instanciaAtual.attack = atacante.getAttack();
                instanciaAtual.defense = atacado.getDefense();
                break;
            case FIRE:
            case WATER:
            case ELECTRIC:
            case GRASS:
            case ICE:
            case PSYCHIC:
            case DRAGON:
                instanciaAtual.attack = atacante.getSpecial();
                instanciaAtual.defense = atacado.getSpecial();
                break;
            default:
                instanciaAtual.attack = 0;
                instanciaAtual.defense = 0;
                break;
        }
        
        /*
            Se o usu�rio estiver afetado por BURNED, seu ataque � dividido pela metade
        */
        atacante.getStatus().aplicaEfeitoDano(instanciaAtual);
        
        /*
            Corrige os valores m�ximos e m�nimmos
        */
        instanciaAtual.attack = Double.max(Double.min(instanciaAtual.attack, 255), 0);
        instanciaAtual.defense = Double.max(Double.min(instanciaAtual.defense, 255), 0);
        
        /*
            Calcula o dano base
        */
        instanciaAtual.damage = modificadorLevel * instanciaAtual.attack * power / instanciaAtual.defense / 50 + 2;

        if (tipo == atacante.getEspecie().getTipo1() || tipo == atacante.getEspecie().getTipo2())
            instanciaAtual.damage *= 1.5;

        instanciaAtual.damage *= tipo.calculaBonus(atacado.getEspecie().getTipo1());
        instanciaAtual.damage *= tipo.calculaBonus(atacado.getEspecie().getTipo2());

        return instanciaAtual.damage * util.Probabilidade.getRandom(217, 255) / 255;
    }

    protected boolean calculoCritico(double speed) {
        return Probabilidade.calcula(speed / 512);
    }

    private double retornaValorConformeModificador(int modifier) {
        switch (modifier) {
            case -6:
                return 0.33;
            case -5:
                return 0.37;
            case -4:
                return 0.43;
            case -3:
                return 0.50;
            case -2:
                return 0.60;
            case -1:
                return 0.75;
            case 0:
                return 1.00;
            case 1:
                return 1.33;
            case 2:
                return 1.66;
            case 3:
                return 2.00;
            case 4:
                return 2.33;
            case 5:
                return 2.66;
            case 6:
                return 3.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        return nome.trim();
    }

    public AcaoJogador getRetorno() {
        return retorno;
    }

    public String message(Pokemon atacante, Jogador adversario) {
        return String.format("%s usa %s em %s.", atacante, this, adversario.getProximoPokemon());
    }
}
