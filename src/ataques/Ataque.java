package ataques;

import batalha.AcaoJogador;
import batalha.Jogador;
import pokemon.Pokemon;
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

    public void efeito(Pokemon atacante, Jogador adversario, int player) {
    	
        double modificadorLevel;
        Pokemon atacado = adversario.getProximoPokemon();
        
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
        
        AttackHit hit = new AttackHit();
        
        hit.attackAccuracy = this.accuracy;
        hit.accuracy = retornaValorConformeModificador(atacante.getModifierAccuracy());
        hit.evasion = retornaValorConformeModificador(atacado.getModifierEvasion());
        
        atacante.getStatus().aplicaEfeitoAcerto(hit);
        
        return hit.calculate();
    }

    protected double calculoDano(Pokemon atacante, Pokemon atacado, double modificadorLevel) {
        
        AttackDamage instanciaAtual = new AttackDamage();
        
        switch(tipo) {
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
            Se o usuário estiver afetado por BURNED, seu ataque é dividido pela metade
        */
        atacante.getStatus().aplicaEfeitoDano(instanciaAtual);
        
        /*
            Corrige os valores máximos e mínimmos
        */
        instanciaAtual.attack = Double.max(Double.min(instanciaAtual.attack, 255),0);
        instanciaAtual.defense = Double.max(Double.min(instanciaAtual.defense, 255),0);
        
        /*
            Calcula o dano base
        */
        instanciaAtual.damage = modificadorLevel * instanciaAtual.attack * power / instanciaAtual.defense / 50 + 2;
        
        if(tipo == atacante.getEspecie().getTipo1() || tipo == atacante.getEspecie().getTipo2())
            instanciaAtual.damage*= 1.5;
        
        instanciaAtual.damage *= tipo.calculaBonus(atacado.getEspecie().getTipo1());
        instanciaAtual.damage *= tipo.calculaBonus(atacado.getEspecie().getTipo2());
    
        return instanciaAtual.damage * util.Probabilidade.getRandom(217, 255)/255;
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

    public String message(Pokemon atacante, Jogador adversario) {
        return String.format("%s usa %s em %s.", atacante, this, adversario.getProximoPokemon());
    }
    
}
