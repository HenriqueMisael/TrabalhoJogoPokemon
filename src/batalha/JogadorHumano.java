
package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import pokemon.Status;

import java.util.Scanner;

public class JogadorHumano extends Jogador{
    
    private int opcao = 0;
    private Scanner entrada = new Scanner(System.in);
    
    public JogadorHumano(int id) {
        super(id);
    }
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        AcaoJogador acao;
        
        switch(pedeAcaoJogador(adversario)) {
            case 1: acao = new AcaoUsarAtaque(this.getProximoPokemon(),adversario,escolheAtaqueUsar(), getId());break;
            case 2: acao = new AcaoTrocarPokemon(this ,escolheNovoPokemon(), getId());break;
            default: acao = null;
        }
        
        return acao;
    }
    
    private Ataque escolheAtaqueUsar() {
        System.out.printf("\nEscolha o ataque para selecionar:");
        System.out.printf("\n1-%s", getProximoPokemon().getAtaque1().toString());
        if(getProximoPokemon().getAtaque2() != null) {
        	System.out.printf("\n2-%s", getProximoPokemon().getAtaque2().toString());
        	if(getProximoPokemon().getAtaque3() != null) {
        	    System.out.printf("\n3-%s", getProximoPokemon().getAtaque3().toString());
        	    if(getProximoPokemon().getAtaque4() != null)
        	    	System.out.printf("\n4-%s", getProximoPokemon().getAtaque4().toString());
        	}
        }
        System.out.printf("\n");
        opcao = entrada.nextInt();
        switch(opcao) {
        case 1: return getProximoPokemon().getAtaque1();
        case 2: return getProximoPokemon().getAtaque2();
        case 3: return getProximoPokemon().getAtaque3();
        case 4: return getProximoPokemon().getAtaque4();
        default: System.out.printf("Ataque escolhido invalido"); return getProximoPokemon().getAtaque1();
        }      
    }

    private Pokemon escolheNovoPokemon() {
        
        int i, escolhido;
        
        System.out.printf("Escolha o pokémon para selecionar:");
        for(i = 1; i < getListaPokemons().size(); i++) {
            if( getListaPokemons().get(i).getStatus() != Status.FAINTED )
                System.out.printf("\n%i - %s", i, getListaPokemons().get(i).toString());
        }
        /*
            Implementar leitura da entrada do usuário
        */
        escolhido = 1;

        return this.getListaPokemons().get(escolhido);
    }

    private int pedeAcaoJogador(Pokemon adversario) {
        
        System.out.printf("Adversario com o pokémon " + adversario.toString() + " posicionado. O que deseja fazer?\n1-Atacar\n2-Trocar pokémon ativo");
        opcao = entrada.nextInt();
        if(opcao==1) return 1;
        return 2;
    }

    @Override
    public String toString() {
        return "Jogador Humano:" + super.toString();
    }
}
