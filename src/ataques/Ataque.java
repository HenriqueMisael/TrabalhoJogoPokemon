package ataques;

import java.util.Random;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public abstract class Ataque {

    private int id;
    private String nome;
    private double maxPowerPoints;
    private double currentPowerPoints;
    private double power;
    private double accuracy;
    private Tipo tipo;
    
    public abstract void efeito();
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public boolean usaAtaque() {
        if(currentPowerPoints==0)
            return false;
        currentPowerPoints--;
        return true;
    }
    
    public void restauraAtaques() {
        currentPowerPoints = maxPowerPoints;
    }
    
    public boolean calculoAcerto(Pokemon atacante, Pokemon atacado) {
        
        Random r = new Random();
        double accuracy, evasion;
        double dice = 0 + ( 100-0 )*r.nextDouble();
        
        accuracy = retornaValorConformeModificador(atacante.getModifierAccuracy());
        evasion = retornaValorConformeModificador(atacado.getModifierEvasion());
        
        return (this.accuracy*(accuracy/evasion)) >= dice;
    }

    public double calculoDano(Pokemon atacante, Pokemon atacado) {
        
        Random r = new Random();
        double modificadorLevel, danoBase, attack, defense;
        
        modificadorLevel = atacante.getLevel();
        
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
            case ELETRIC:
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
            Se o ataque for crítico, o modificador de nível é dobrado
        */
        if(calculoCritico(atacante.getSpeed()))
            modificadorLevel *= 2;
        
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
    
        danoBase *= new Double((217+(255-217))*r.nextDouble())/255;
        
        return danoBase;
    }
    
    private boolean calculoCritico(double speed) {
        
        Random r = new Random();
        double dice = 0 + ( 100-0 )*r.nextDouble();
        
        return speed/512 >= dice;
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
}
