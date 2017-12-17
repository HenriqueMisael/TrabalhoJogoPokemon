
package batalha;

import ataques.Ataque;
import pokemon.Pokemon;
import pokemon.Status;
import util.DefaultOutput;

import java.util.Scanner;

public class JogadorHumano extends Jogador{
    
    private int opcao = 0;
    private Scanner entrada = new Scanner(System.in);
    
    public JogadorHumano(int id) {
        super(id);
    }
    
    @Override
    public AcaoJogador escolherComando(Jogador adversario){
        
        AcaoJogador acao;
        int acaoEscolhida;
        
        if(quantidadePokemonsUtilizaveis() > 1)
            acaoEscolhida = pedeAcaoJogador(adversario);
        else {
            DefaultOutput.showMessage(String.format("Apenas %s está disponível para uso, ação escolhida automaticamente: Atacar.", this.getProximoPokemon()));
            acaoEscolhida = 1;
        }
        
        switch(acaoEscolhida) {
            case 1: acao = new AcaoUsarAtaque(this.getProximoPokemon(),adversario,escolheAtaqueUsar(), getId());break;
            case 2: acao = new AcaoTrocarPokemon(this ,escolheNovoPokemon());break;
            default: acao = null;
        }
        
        return acao;
    }
    
    private Ataque escolheAtaqueUsar() {
        
        String opcoes = "";
        
        opcoes += "\nEscolha o ataque para selecionar:";
        
        opcoes += String.format("\n1-%s", getProximoPokemon().getAtaque1().toString());
        if(getProximoPokemon().getAtaque2() != null) {
            opcoes += String.format("\n2-%s", getProximoPokemon().getAtaque2().toString());
        	if(getProximoPokemon().getAtaque3() != null) {
        	    opcoes += String.format("\n3-%s", getProximoPokemon().getAtaque3().toString());
        	    if(getProximoPokemon().getAtaque4() != null)
        	        opcoes += String.format("\n4-%s", getProximoPokemon().getAtaque4().toString());
        	}
        }
        opcoes += "\n";
        DefaultOutput.showMessage(opcoes);
        
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
        
        String opcoes = "";
        int i, escolhido;
        
        opcoes += String.format("\nEscolha o pokémon para selecionar:");
        for(i = 1; i < getListaPokemons().size(); i++) {
            if( getListaPokemons().get(i).getStatus() != Status.FAINTED ) {
                opcoes += String.format("\n%d - %s", i, getListaPokemons().get(i).toString());
            }
        }    
        
        DefaultOutput.showMessage(opcoes);
        escolhido = entrada.nextInt();
        
        if(escolhido > getListaPokemons().size()) {
            DefaultOutput.showMessage("Número de pokémon inválido");
            escolhido = 0;
        }

        if(getListaPokemons().get(escolhido).getStatus() == Status.FAINTED) {
            int novoEscolhido = -1;
            
            DefaultOutput.showMessage(String.format("Pokémon %s está morto, o próximo vivo será escolhido.",getListaPokemons().get(escolhido)));
            
            for(i = 1; i < getListaPokemons().size(); i++) {
                if( getListaPokemons().get(i).getStatus() != Status.FAINTED )
                    novoEscolhido = i;
            }
            
            if(novoEscolhido == -1)
                escolhido = 0;
            else
                escolhido = novoEscolhido;
        }

        return this.getListaPokemons().get(escolhido);
    }

    private int pedeAcaoJogador(Jogador adversario) {
        
        DefaultOutput.showMessage("\nAdversario " + adversario.toString() + " com o pokémon " + adversario.getProximoPokemon().toString() + " posicionado. O que deseja fazer?\n1-Atacar com " + getProximoPokemon().toString() + "\n2-Trocar pokémon ativo");
        opcao = entrada.nextInt();
        if(opcao==1) return 1;
        return 2;
    }

    @Override
    public String toString() {
        return "Jogador " + super.toString();
    }
}
