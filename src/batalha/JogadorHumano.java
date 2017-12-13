
package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import pokemon.Status;

public class JogadorHumano extends Jogador{
    
    public JogadorHumano(String nome) {
        super.identificador = nome;
    }
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        AcaoJogador acao;
        
        switch(pedeAcaoJogador(adversario)) {
            case 1: acao = new AcaoUsarAtaque(this.getProximoPokemon(),adversario,escolheAtaqueUsar());break;
            case 2: acao = new AcaoTrocarPokemon(this,escolheNovoPokemon());break;
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
        
        /*
            Implementar seleção de ataques
        */        
        
        return retornaAtaquePokemon(1);
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
        /*
            Implementar leitura da entrada do usuário
        */
        return 1;
    }

    @Override
    public String toString() {
        return "Jogador Humano:" + super.toString();
    }
}
