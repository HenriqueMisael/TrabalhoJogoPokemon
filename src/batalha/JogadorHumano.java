
package batalha;

import pokemon.Pokemon;

public class JogadorHumano extends Jogador{
    
    public JogadorHumano(String nome) {
        super.identificador = nome;
    }
    
    @Override
    public AcaoJogador escolherComando(Pokemon adversario){
        
        AcaoJogador acao;
        
        switch(pedeAcaoJogador(adversario)) {
            case 1: acao = new AcaoUsarAtaque(this.getProximoPokemon(),adversario);break;
            case 2: acao = new AcaoTrocarPokemon(this,escolheNovoPokemon());break;
            default: acao = null;
        }
        
        return acao;
    }
    
    private Pokemon escolheNovoPokemon() {
        
        int i, escolhido;
        
        System.out.printf("Escolha o pokémon para selecionar:");
        for(i = 1; i < getListaPokemons().size(); i++)
            System.out.printf("\n%i - %s", i, getListaPokemons().get(i).toString());
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
        return "humano:" + super.toString();
    }
}
