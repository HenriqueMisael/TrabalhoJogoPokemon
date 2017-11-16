
package batalha;

import java.util.ArrayList;
import java.util.List;


public class Pokemon {

	//ATRIBUTOS
    private int especie;
	private int level;
    private double hpAtual;
    private double hpMax;
    private double atk;
    private double def;
    private double spe;
    private double spd;
    private int modifierAccuracy;
    private int modifierEvasion;
    private int modifierAtk;
    private int modifierDef;
    private int modifierSpe;
    private int modifierSpd;
    private boolean confusion;
    private boolean flinch;
    
    private int ataque1, ataque2, ataque3, ataque4;

    public Pokemon(int especie, int level, int ataque1, int ataque2, int ataque3, int ataque4) {
    	this.especie = especie;
    	this.level = level;
    	this.ataque1 = ataque1;
    	this.ataque2 = ataque2;
    	this.ataque3 = ataque3;
    	this.ataque4 = ataque4;
	}
    
    @Override
    public String toString() {
    	
    	String retorno = "";
    	
    	retorno += String.format("Espécie %d, nível %d.\n", especie, level);
    	retorno += String.format("Ataques:\n1-%d\n2-%d\n3-%d\n4-%d",ataque1, ataque2, ataque3, ataque4);
    	
    	return retorno;
    }
}
