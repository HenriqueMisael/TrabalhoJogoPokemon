package ataques;

import batalha.AcaoJogador;
import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;
import util.Probabilidade;

public class Ataque {

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

    public void efeito(Pokemon atacante, Pokemon atacado, int player) {
    	
        double modificadorLevel;
        
        if( currentPowerPoints > 0 ) {
            reduzPP();
            
          	if( calculoAcerto(atacante, atacado) ) {
          	    modificadorLevel = atacante.getLevel();
          	    
                /*
                    Se o ataque for crítico, o modificador de nível é dobrado
                */
                if(calculoCritico(atacante.getSpeed()))
                    modificadorLevel *= 2;
                
        		atacado.reduzHp(calculoDano( atacante, atacado, modificadorLevel ));
        	}
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
        
        double accuracy, evasion;
        
        accuracy = retornaValorConformeModificador(atacante.getModifierAccuracy());
        evasion = retornaValorConformeModificador(atacado.getModifierEvasion());
        
        return util.Probabilidade.calcula(this.accuracy*(accuracy/evasion));
    }

    protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {
        
        double danoBase, attack, defense;
        
        switch(tipo) {
            case NORMAL:
            case FIGHTING:
            case FLYING:
            case POISON:
            case GROUND:
            case ROCK:
            case BUG:
            case GHOST:
                attack = atacante.getAttack();
                defense = atacado.getDefense();
                break;
            case FIRE:
            case WATER:
            case ELECTRIC:
            case GRASS:
            case ICE:
            case PSYCHIC:
            case DRAGON:
                attack = atacante.getSpecial();
                defense = atacado.getSpecial();
                break;
        default:
                attack = 0;
                defense = 0;                
            break;                
        }
        
        /*
            Se o usuário estiver afetado por BURNED, seu ataque é dividido pela metade
        */
        if(atacante.getStatus() == Status.BURN)
            attack /= 2;
        
        /*
            Corrige os valores máximos e mínimmos
        */
        attack = Double.max(Double.min(attack, 255),0);
        defense = Double.max(Double.min(defense, 255),0);
        
        /*
            Calcula o dano base
        */
        danoBase = modificadorLevel * attack * power / defense / 50 + 2;
        
        if(tipo == atacante.getEspecie().getTipo1() || tipo == atacante.getEspecie().getTipo2())
            danoBase *= 1.5;
        
        danoBase *= tipo.calculaBonus(atacado.getEspecie().getTipo1());
        danoBase *= tipo.calculaBonus(atacado.getEspecie().getTipo2());
    
        return danoBase * util.Probabilidade.getRandom(217, 255)/255;
    }
    
    protected boolean calculoCritico(double speed) {
        return Probabilidade.calcula(speed/512);
    }
    
    private double retornaValorConformeModificador(int modifier) {
        switch(modifier) {
            case -6: return 0.33;
            case -5: return 0.37;
            case -4: return 0.43;
            case -3: return 0.50;
            case -2: return 0.60;
            case -1: return 0.75;
            case  0: return 1.00;
            case  1: return 1.33;
            case  2: return 1.66;
            case  3: return 2.00;
            case  4: return 2.33;
            case  5: return 2.66;
            case  6: return 3.00;        
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome;
    }

    public AcaoJogador getRetorno() {
        return retorno;
    }
    
}
